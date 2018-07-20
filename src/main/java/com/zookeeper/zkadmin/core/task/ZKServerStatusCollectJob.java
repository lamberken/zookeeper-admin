package com.zookeeper.zkadmin.core.task;

import com.zookeeper.zkadmin.core.InitSystemManager;
import com.zookeeper.zkadmin.dao.ZooKeeperClusterDAO;
import com.zookeeper.zkadmin.dao.ZooKeeperServerDAO;
import com.zookeeper.zkadmin.entities.model.ZooKeeperCluster;
import com.zookeeper.zkadmin.entities.model.ZooKeeperServer;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * @author lamber-ken
 * @date 2017-01-05 19:49
 * @since JDK1.7
 */
public class ZKServerStatusCollectJob implements Runnable {

    @Override
    public void run() {

        try {


            ApplicationContext ac = InitSystemManager.getApplicationContext();

            ZooKeeperClusterDAO zooKeeperClusterDAO = ac.getBean(ZooKeeperClusterDAO.class);
            ZooKeeperServerDAO zooKeeperServerDAO =  ac.getBean(ZooKeeperServerDAO.class);

            List<ZooKeeperCluster> allZooKeeperClusters = zooKeeperClusterDAO.getAllZooKeeperClusters();

            for (ZooKeeperCluster zkc : allZooKeeperClusters) {

                List<ZooKeeperServer> allZKServers = zooKeeperServerDAO.getAllZooKeepersServersByClusterID(zkc.getClusterID());


                for (ZooKeeperServer zkServer : allZKServers) {

                    /** srvr */
                    // ThreadPoolManager.addZKServerStatusCollectorExecutor(new ZKServerSrvrTask(zkServer));

                    /** mntr */
                    // ThreadPoolManager.addZKServerStatusCollectorExecutor(new ZKServerMntrTask(zkServer));
                }

            }

        } catch (Throwable e) {
            e.printStackTrace();
        }

    }
}
