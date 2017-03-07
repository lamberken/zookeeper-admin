package org.artjava.zookeeper.core;

import org.artjava.zookeeper.core.GlobalInstance;
import org.artjava.zookeeper.core.ThreadPoolManager;
import org.artjava.zookeeper.dao.AlarmSettingDao;
import org.artjava.zookeeper.dao.ZooKeeperClusterDAO;
import org.artjava.zookeeper.entities.model.ZooKeeperCluster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitSystemManager implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger logger = LoggerFactory.getLogger("SYSTEM_LOGGER");

    private GlobalInstance gInstance = GlobalInstance.getInstance();
    private static ApplicationContext applicationContext = null;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (applicationContext == null) {
            applicationContext = event.getApplicationContext();
            ZooKeeperClusterDAO zooKeeperClusterDAO = applicationContext.getBean(ZooKeeperClusterDAO.class);
            AlarmSettingDao alarmSettingDao =  applicationContext.getBean(AlarmSettingDao.class);

            // curator clients & alarms
            List<ZooKeeperCluster> clusters = zooKeeperClusterDAO.getAllZooKeeperClusters();
            for (ZooKeeperCluster zkc : clusters) {

                // alarms
                gInstance.addAlarmSetting(alarmSettingDao.getAlarmSetting(zkc.getClusterID()));

                // curator clients
                gInstance.startZooKeeperCluster(zkc);

            }

            // start collect job
            ThreadPoolManager.startZooKeeperStatusCollectJob();

            // start check job
            ThreadPoolManager.startZKServerAlarmCheckJob();

            //ThreadUtil.startThread( new CheckerJob( ) );
            logger.info("**************** Zookeeper Admin Startup Success ****************");

        }
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

}