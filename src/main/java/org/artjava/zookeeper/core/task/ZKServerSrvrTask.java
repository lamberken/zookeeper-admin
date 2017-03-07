package org.artjava.zookeeper.core.task;

import org.artjava.zookeeper.common.ZKAdminConstants;
import org.artjava.zookeeper.core.parser.impl.SrvrParser;
import org.artjava.zookeeper.entities.model.ZooKeeperServer;
import org.artjava.zookeeper.entities.model.metrics.impl.SrvrMetrics;
import org.artjava.zookeeper.util.SocketUtil;
import org.joda.time.DateTime;

/**
 * @author artJava
 * @date 2017-01-05 19:49
 * @since JDK1.7
 */
public class ZKServerSrvrTask implements Runnable {

    ZooKeeperServer zkServer;

    public ZKServerSrvrTask(ZooKeeperServer _zkServer) {
        this.zkServer = _zkServer;
    }

    @Override
    public void run() {

        try {

            System.out.println("正在收集 srvr 信息");
            String resp = SocketUtil.getRespByCMD(zkServer.getHost(), zkServer.getPort(), ZKAdminConstants.srvr);
            SrvrMetrics sm = SrvrParser.parser(resp);
            String date = DateTime.now().toString("yyyyMMdd");

            // redisClient.List().rpushBit(ZKAdminConstants.ZK_SERVER_DATE_SRVR_KEY_PREFIX + "_" + date + "_"  + zkServer.getServerID() + "_" + "SRVR", SerializationUtils.serialize(sm));

        } catch (Throwable e) {
            e.printStackTrace();
        }

    }
}
