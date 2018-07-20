package com.zookeeper.zkadmin.core;

import com.zookeeper.zkadmin.entities.model.AlarmSetting;
import com.zookeeper.zkadmin.entities.model.ZooKeeperCluster;
import com.zookeeper.zkadmin.entities.model.metrics.Metrics;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * org.artjava.zookeeper.compont
 *
 * @author lamber-ken
 * @date 2017-01-09 0:17
 * @since JDK1.7
 * <p>
 * TODO
 * <p>
 * 这个类的 init 方法放置 System init 中
 * <p>
 * 看看 spring mvc 有没有 关闭时 执行方法的配置
 * --> 执行 destory
 */
public class GlobalInstance {

    private static final Logger logger = LoggerFactory.getLogger("SYSTEM_LOGGER");
    private Object alarmLock = new Object();


    /**
     * zk alarmsettings
     */
    private Map<String, AlarmSetting> zkServerAlarmSettings = new ConcurrentHashMap<>();

    /**
     * zk metrics
     */
    private BlockingDeque<Metrics> m_queue = new LinkedBlockingDeque(1000);

    /**
     * zk curator clients
     */
    private Map<String, CuratorFramework> ZKClientConnMapOfCluster = new ConcurrentHashMap<>();


    /**
     * 添加 curator client
     * TODO : 这个策略需要改动, 尝试重连时 需要发出预警信息, 打印日志
     */
    public void startZooKeeperCluster(ZooKeeperCluster zkc) {

        String serverList = zkc.getServerList();
        String clusterID = zkc.getClusterID();

        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.builder().connectString(serverList).sessionTimeoutMs(5000)
                .connectionTimeoutMs(5000).retryPolicy(retryPolicy).build();
        client.start();
        ZKClientConnMapOfCluster.put(clusterID, client);
    }

    /**
     * 根据 clusterID 获取 curator
     */
    public CuratorFramework getCuratorClient(String clusterID) {
        return this.ZKClientConnMapOfCluster.get(clusterID);
    }

    /**
     * 根据 clusterID 停止并删除 curator client
     * TODO 这里有并发有问题, 因为有可能别人正在获取节点数据等, 那边需要处理好异常
     */
    public void removeCuratorClient(String clusterID) {

        CuratorFramework curatorClient = ZKClientConnMapOfCluster.get(clusterID);
        if (curatorClient != null)
            curatorClient.close();

        ZKClientConnMapOfCluster.remove(clusterID);
    }

    /**
     * 更新 curator client
     * TODO 这里有并发有问题, 因为有可能别人正在获取节点数据等, 那边需要处理好异常
     */
    public void updateCuratorClient(ZooKeeperCluster zkc) {

        // 停止并删除
        CuratorFramework curatorClient = ZKClientConnMapOfCluster.get(zkc.getClusterID());
        if (curatorClient != null)
            curatorClient.close();
        ZKClientConnMapOfCluster.remove(zkc.getClusterID());

        // 重新启动并放置池中
        startZooKeeperCluster(zkc);

    }

    /**
     * metrics queue
     */
    public BlockingDeque<Metrics> getMQueue() {
        return m_queue;
    }

    /**
     * add metrics
     */
    public void addMetrics(Metrics metrics) {

        try {
            m_queue.offer(metrics, 3, TimeUnit.SECONDS);
        } catch (Exception e) {
            logger.error("添加 metrics 失败, {}", metrics);
        }
    }

    /**
     * 加载 alarmsettings
     */
    public void addAlarmSetting(AlarmSetting alarmSetting) {
        if (alarmSetting != null) {
            synchronized (alarmLock) {
                zkServerAlarmSettings.put(alarmSetting.getClusterID(), alarmSetting);
            }
        }
    }

    public AlarmSetting getAlarmSetting(String clusterID) {
        if (clusterID != null) {
            synchronized (alarmLock) {
                return zkServerAlarmSettings.get(clusterID);
            }
        } else {
            return null;
        }
    }

    public static void main(String[] args) {


        Map a = new ConcurrentHashMap();
        //a.put(null, AAShapePipe);

        System.out.println(a.get(null));
    }


    /**
     * TODO 将目前状态输出
     * log 形式, 或者 rest 输出
     */
    public void dump() {
        System.out.println(ZKClientConnMapOfCluster);
    }


    private GlobalInstance() {
    }

    private static GlobalInstance single = null;

    public static GlobalInstance getInstance() {
        if (single == null) {
            single = new GlobalInstance();
        }
        return single;
    }

}
