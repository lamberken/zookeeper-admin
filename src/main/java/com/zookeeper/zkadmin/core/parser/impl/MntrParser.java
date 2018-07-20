package com.zookeeper.zkadmin.core.parser.impl;

import com.zookeeper.zkadmin.core.parser.Parser;
import com.zookeeper.zkadmin.entities.model.metrics.impl.MntrMetrics;
import com.zookeeper.zkadmin.util.SystemUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lamber-ken
 * @date 2017-01-05 19:49
 * @since JDK1.7
 */
public class MntrParser implements Parser {

    private static final Logger logger = LoggerFactory.getLogger("SYSTEM_LOGGER");
    public static final String zk_version = "zk_version";
    public static final String zk_avg_latency = "zk_avg_latency";
    public static final String zk_max_latency = "zk_max_latency";
    public static final String zk_min_latency = "zk_min_latency";
    public static final String zk_packets_received = "zk_packets_received";
    public static final String zk_packets_sent = "zk_packets_sent";
    public static final String zk_num_alive_connections = "zk_num_alive_connections";
    public static final String zk_outstanding_requests = "zk_outstanding_requests";
    public static final String zk_server_state = "zk_server_state";
    public static final String zk_znode_count = "zk_znode_count";
    public static final String zk_watch_count = "zk_watch_count";
    public static final String zk_ephemerals_count = "zk_ephemerals_count";
    public static final String zk_approximate_data_size = "zk_approximate_data_size";
    public static final String zk_open_file_descriptor_count = "zk_open_file_descriptor_count";
    public static final String zk_max_file_descriptor_count = "zk_max_file_descriptor_count";
    public static final String zk_followers = "zk_followers";
    public static final String zk_synced_followers = "zk_synced_followers";
    public static final String zk_pending_syncs = "zk_pending_syncs";

    public static MntrMetrics parser(String str) {

        if (str == null || str.equals(""))
            return null;
        MntrMetrics mm = new MntrMetrics();

        String sline[] = str.split("\n");
        for (String l : sline) {

            if (l == null || l.equals("") || l.trim().equals(""))
                continue;
            String kv[] = SystemUtil.splitL(l);
            if (kv != null) {
                String key = kv[0].trim();
                String value = kv[1].trim();
                setData(mm, key, value);
            }
        }

        return mm;
    }

    private static void setData(MntrMetrics mm, String key, String value) {
        if (key == null || value == null || key.equals("") || value.equals(""))
            return;
        if (key.equals(zk_version)) {
            mm.setVersion(value);
        } else if (key.equals(zk_avg_latency)) {
            mm.setAvgLatency(Long.valueOf(value));
        } else if (key.equals(zk_max_latency)) {
            mm.setMaxLatency(Long.valueOf(value));
        } else if (key.equals(zk_min_latency)) {
            mm.setMinLatency(Long.valueOf(value));
        } else if (key.equals(zk_packets_received)) {
            mm.setPacketsReceived(Long.valueOf(value));
        } else if (key.equals(zk_packets_sent)) {
            mm.setPacketsSent(Long.valueOf(value));
        } else if (key.equals(zk_num_alive_connections)) {
            mm.setNumAliveConnections(Long.valueOf(value));
        } else if (key.equals(zk_outstanding_requests)) {
            mm.setOutstandingRequests(Long.valueOf(value));
        } else if (key.equals(zk_server_state)) {
            mm.setServerState(value);
        } else if (key.equals(zk_znode_count)) {
            mm.setZnodeCount(Long.valueOf(value));
        } else if (key.equals(zk_watch_count)) {
            mm.setWatchCount(Long.valueOf(value));
        } else if (key.equals(zk_ephemerals_count)) {
            mm.setEphemeralsCount(Long.valueOf(value));
        } else if (key.equals(zk_approximate_data_size)) {
            mm.setApproximateDataSize(Long.valueOf(value));
        } else if (key.equals(zk_open_file_descriptor_count)) {
            mm.setOpenFileDescriptorCount(Long.valueOf(value));
        } else if (key.equals(zk_max_file_descriptor_count)) {
            // mm.set
        } else if (key.equals(zk_followers)) {
            mm.setFollowers(Long.valueOf(value));
        } else if (key.equals(zk_synced_followers)) {
            mm.setSyncedFollowers(Long.valueOf(value));
        } else if (key.equals(zk_pending_syncs)) {
            mm.setPendingSyncs(Long.valueOf(value));
        } else {
            //nothing
        }
    }

}
