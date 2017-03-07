package org.artjava.zookeeper.entities.model.metrics.impl;

import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * @author artJava
 * @date 2017-01-05 19:49
 * @since JDK1.7
 */
public class SrvrMetrics implements Serializable {

    private static final long serialVersionUID = 1L;

    private String clusterID;
    private String serverID;
    private String version;
    private long minLatency;
    private long maxLatency;
    private long avgLatency;
    private long received;
    private long sent;
    private long connections;
    private long outstanding;
    private long zxid;
    private String mode;
    private long nodeCount;

    // extra obtain_timestamp
    private long obtainTimestamp;

    public SrvrMetrics(){
        this.obtainTimestamp = DateTime.now().toDate().getTime();
    }

    public String getClusterID() {
        return clusterID;
    }

    public void setClusterID(String clusterID) {
        this.clusterID = clusterID;
    }

    public String getServerID() {
        return serverID;
    }

    public void setServerID(String serverID) {
        this.serverID = serverID;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public long getMinLatency() {
        return minLatency;
    }

    public void setMinLatency(long minLatency) {
        this.minLatency = minLatency;
    }

    public long getMaxLatency() {
        return maxLatency;
    }

    public void setMaxLatency(long maxLatency) {
        this.maxLatency = maxLatency;
    }

    public long getAvgLatency() {
        return avgLatency;
    }

    public void setAvgLatency(long avgLatency) {
        this.avgLatency = avgLatency;
    }

    public long getReceived() {
        return received;
    }

    public void setReceived(long received) {
        this.received = received;
    }

    public long getSent() {
        return sent;
    }

    public void setSent(long sent) {
        this.sent = sent;
    }

    public long getConnections() {
        return connections;
    }

    public void setConnections(long connections) {
        this.connections = connections;
    }

    public long getOutstanding() {
        return outstanding;
    }

    public void setOutstanding(long outstanding) {
        this.outstanding = outstanding;
    }

    public long getZxid() {
        return zxid;
    }

    public void setZxid(long zxid) {
        this.zxid = zxid;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public long getNodeCount() {
        return nodeCount;
    }

    public void setNodeCount(long nodeCount) {
        this.nodeCount = nodeCount;
    }

    public long getObtainTimestamp() {
        return obtainTimestamp;
    }

    public void setObtainTimestamp(long obtainTimestamp) {
        this.obtainTimestamp = obtainTimestamp;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Zookeeper_version" + " : " + version + "\n");
        sb.append("Latency" + " : " + minLatency + "#" + avgLatency + "#" + maxLatency + "\n");
        sb.append("Received" + " : " + received + "\n");
        sb.append("Sent" + " : " + sent + "\n");
        sb.append("Connections" + " : " + connections + "\n");
        sb.append("Outstanding" + " : " + outstanding + "\n");
        sb.append("Zxid" + " : " + zxid + "\n");
        sb.append("Mode" + " : " + mode + "\n");
        sb.append("Node_count" + " : " + nodeCount + "\n");
        sb.append("obtainTimestamp" + " : " + obtainTimestamp + "\n");

        return sb.toString();
    }

}
