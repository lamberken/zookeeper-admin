package org.artjava.zookeeper.core;

import org.artjava.zookeeper.common.ZKAdminConstants;
import org.artjava.zookeeper.core.task.ZKServerAlarmCheckJob;
import org.artjava.zookeeper.core.task.ZKServerStatusCollectJob;

import java.util.concurrent.*;
/**
 * @author artJava
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
