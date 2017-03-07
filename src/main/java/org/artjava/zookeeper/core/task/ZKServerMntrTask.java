package org.artjava.zookeeper.core.task;

import org.artjava.zookeeper.common.ZKAdminConstants;
import org.artjava.zookeeper.core.GlobalInstance;
import org.artjava.zookeeper.core.parser.impl.MntrParser;
import org.artjava.zookeeper.entities.model.ZooKeeperServer;
import org.artjava.zookeeper.entities.model.metrics.impl.MntrMetrics;
import org.artjava.zookeeper.util.SocketUtil;
import org.joda.time.DateTime;

/**
 * @author artJava
 * @date 2017-01-05 19:49
 * @since JDK1.7
 */
public class ZKServerMntrTask implements Runnable {

    ZooKeeperServer zkServer;
    GlobalInstance gInstance = GlobalInstance.getInstance();

    public ZKServerMntrTask(ZooKeeperServer _zkServer) {
        this.zkServer = _zkServer;
    }

    @Override
    public void run() {

        try {
            System.out.println("正在收集 mntr 信息");


            String date = DateTime.now().toString("yyyyMMdd");
            String resp = SocketUtil.getRespByCMD(zkServer.getHost(), zkServer.getPort(), ZKAdminConstants.mntr);
            MntrMetrics mp = MntrParser.parser(resp);
            mp.setClusterID(zkServer.getClusterID());
            mp.setServerID(zkServer.getServerID());

            gInstance.addMetrics(mp);

            // redisClient.List().lpushBit(ZKAdminConstants.ZK_SERVER_DATE_MNTR_KEY_PREFIX + "_" + date + "_" + zkServer.getClusterID() + "_" + zkServer.getServerID() + "_" + "MNTR", SerializationUtils.serialize(mp));

        } catch (Throwable e) {
            e.printStackTrace();
        }

    }




}
