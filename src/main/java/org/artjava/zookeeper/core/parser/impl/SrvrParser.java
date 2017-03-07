package org.artjava.zookeeper.core.parser.impl;


import org.apache.commons.lang.StringUtils;
import org.artjava.zookeeper.common.ZKAdminConstants;
import org.artjava.zookeeper.core.parser.Parser;
import org.artjava.zookeeper.entities.model.metrics.impl.SrvrMetrics;

/**
 * @author artJava
 * @date 2017-01-05 19:49
 * @since JDK1.7
 */
public class SrvrParser implements Parser {
    private static final String Zookeeper_version = "Zookeeper version";
    private static final String Latency = "Latency min/avg/max";
    private static final String Received = "Received";
    private static final String Sent = "Sent";
    private static final String Connections = "Connections";
    private static final String Outstanding = "Outstanding";
    private static final String Zxid = "Zxid";
    private static final String Mode = "Mode";
    private static final String Node_count = "Node count";

    public static SrvrMetrics parser(String str) {
        if (str == null || str.equals("")) return null;
        SrvrMetrics sm = new SrvrMetrics();
        String sline[] = str.split("\n");
        for (String l : sline) {
            if (l == null || l.equals("") || l.trim().equals("")) continue;
            String kv[] = l.split(ZKAdminConstants.srvr_split);
            if (kv.length == 2) {
                String key = kv[0];
                String value = kv[1].trim();
                setData(sm, key, value);
            }
        }
        return sm;
    }

    private static void setData(SrvrMetrics sm, String key, String value) {
        if (key == null || value == null || key.equals("") || value.equals("")) return;
        value = value.trim();
        key = key.trim();
        if (key.equals(Zookeeper_version)) {
            sm.setVersion(value);
        } else if (key.equals(Latency)) {
            String ss[] = value.split("/");
            sm.setMinLatency(Long.valueOf(ss[0].trim()));
            sm.setAvgLatency(Long.valueOf(ss[1].trim()));
            sm.setMaxLatency(Long.valueOf(ss[2].trim()));

        } else if (key.equals(Received)) {
            sm.setReceived(Long.valueOf(value));
        } else if (key.equals(Sent)) {
            sm.setSent(Long.valueOf(value));
        } else if (key.equals(Connections)) {
            sm.setConnections(Long.valueOf(value));
        } else if (key.equals(Outstanding)) {
            sm.setOutstanding(Long.valueOf(value));
        } else if (key.equals(Zxid)) {
            // 0x12312231
            sm.setZxid(Long.parseLong(StringUtils.substring(value, 2), 16));

        } else if (key.equals(Mode)) {
            sm.setMode(value);
        } else if (key.equals(Node_count)) {
            sm.setNodeCount(Long.valueOf(value));
        } else {
            //nothing
        }
    }

}
