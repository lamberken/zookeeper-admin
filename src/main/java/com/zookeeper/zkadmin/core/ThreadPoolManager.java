package com.zookeeper.zkadmin.core;

import com.zookeeper.zkadmin.common.ZKAdminConstants;
import com.zookeeper.zkadmin.core.task.ZKServerAlarmCheckJob;
import com.zookeeper.zkadmin.core.task.ZKServerStatusCollectJob;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * @author lamber-ken
 * @date 2017-01-05 19:49
 * @since JDK1.7
 */
public class ThreadPoolManager {

    /**
     * global executors
     */
    private static final ScheduledThreadPoolExecutor scheduledExecutor = (ScheduledThreadPoolExecutor) Executors
            .newScheduledThreadPool(3);

    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    /**
     * collect job
     */
    public static void startZooKeeperStatusCollectJob() {
        scheduledExecutor
                .scheduleAtFixedRate(new ZKServerStatusCollectJob(), 0, ZKAdminConstants.intervalTime,
                        TimeUnit.MILLISECONDS);
    }

    /**
     * collect task
     */
    public static void addZKServerStatusCollectorExecutor(Runnable command) {
        executorService.execute(command);
    }


    /**
     *  check job
     */
    public static void startZKServerAlarmCheckJob() {
        executorService.execute(new ZKServerAlarmCheckJob());
    }

    /**
     * send message
     */
    public static void addZKServerMessageExecutor(Runnable command) {
        executorService.execute(command);
    }



}
