package com.zookeeper.zkadmin.entities.model.metrics.impl;

import com.zookeeper.zkadmin.entities.model.metrics.Metrics;
import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * @author lamber-ken
 * @date 2017-01-05 19:49
 * @since JDK1.7
 */
public class MntrMetrics implements Metrics,Serializable {

    private static final long serialVersionUID = 1L;

    private String clusterID;
    private String serverID;
    private String version;
    private long avgLatency;
    private long maxLatency;
    private long minLatency;
    private long packetsReceived;
    private long packetsSent;
    private long numAliveConnections;
    private long outstandingRequests;
    private String serverState;
    private long znodeCount;
    private long watchCount;
    private long ephemeralsCount;
    private long approximateDataSize;
    private long openFileDescriptorCount;
    private long followers;
    private long syncedFollowers;
    private long pendingSyncs;

    // extra obtain_timestamp
    private long obtainTimestamp;

    public MntrMetrics(){
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

    public long getAvgLatency() {
        return avgLatency;
    }

    public void setAvgLatency(long avgLatency) {
        this.avgLatency = avgLatency;
    }

    public long getMaxLatency() {
        return maxLatency;
    }

    public void setMaxLatency(long maxLatency) {
        this.maxLatency = maxLatency;
    }

    public long getMinLatency() {
        return minLatency;
    }

    public void setMinLatency(long minLatency) {
        this.minLatency = minLatency;
    }

    public long getPacketsReceived() {
        return packetsReceived;
    }

    public void setPacketsReceived(long packetsReceived) {
        this.packetsReceived = packetsReceived;
    }

    public long getPacketsSent() {
        return packetsSent;
    }

    public void setPacketsSent(long packetsSent) {
        this.packetsSent = packetsSent;
    }

    public long getNumAliveConnections() {
        return numAliveConnections;
    }

    public void setNumAliveConnections(long numAliveConnections) {
        this.numAliveConnections = numAliveConnections;
    }

    public long getOutstandingRequests() {
        return outstandingRequests;
    }

    public void setOutstandingRequests(long outstandingRequests) {
        this.outstandingRequests = outstandingRequests;
    }

    public String getServerState() {
        return serverState;
    }

    public void setServerState(String serverState) {
        this.serverState = serverState;
    }

    public long getZnodeCount() {
        return znodeCount;
    }

    public void setZnodeCount(long znodeCount) {
        this.znodeCount = znodeCount;
    }

    public long getWatchCount() {
        return watchCount;
    }

    public void setWatchCount(long watchCount) {
        this.watchCount = watchCount;
    }

    public long getEphemeralsCount() {
        return ephemeralsCount;
    }

    public void setEphemeralsCount(long ephemeralsCount) {
        this.ephemeralsCount = ephemeralsCount;
    }

    public long getApproximateDataSize() {
        return approximateDataSize;
    }

    public void setApproximateDataSize(long approximateDataSize) {
        this.approximateDataSize = approximateDataSize;
    }

    public long getOpenFileDescriptorCount() {
        return openFileDescriptorCount;
    }

    public void setOpenFileDescriptorCount(long openFileDescriptorCount) {
        this.openFileDescriptorCount = openFileDescriptorCount;
    }

    public long getFollowers() {
        return followers;
    }

    public void setFollowers(long followers) {
        this.followers = followers;
    }

    public long getSyncedFollowers() {
        return syncedFollowers;
    }

    public void setSyncedFollowers(long syncedFollowers) {
        this.syncedFollowers = syncedFollowers;
    }

    public long getPendingSyncs() {
        return pendingSyncs;
    }

    public void setPendingSyncs(long pendingSyncs) {
        this.pendingSyncs = pendingSyncs;
    }

    public long getObtainTimestamp() {
        return obtainTimestamp;
    }

    public void setObtainTimestamp(long obtainTimestamp) {
        this.obtainTimestamp = obtainTimestamp;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("version:" + version + "\n");
        sb.append("avgLatency:" + avgLatency + "\n");
        sb.append("maxLatency:" + maxLatency + "\n");
        sb.append("minLatency:" + minLatency + "\n");
        sb.append("packetsReceived:" + packetsReceived + "\n");
        sb.append("packetsSent:" + packetsSent + "\n");
        sb.append("numAliveConnections:" + numAliveConnections + "\n");
        sb.append("outstandingRequests:" + outstandingRequests + "\n");
        sb.append("serverState:" + serverState + "\n");
        sb.append("znodeCount:" + znodeCount + "\n");
        sb.append("watchCount:" + watchCount + "\n");
        sb.append("ephemeralsCount:" + ephemeralsCount + "\n");
        sb.append("approximateDataSize:" + approximateDataSize + "\n");
        sb.append("openFileDescriptorCount:" + openFileDescriptorCount + "\n");
        sb.append("followers:" + followers + "\n");
        sb.append("syncedFollowers:" + syncedFollowers + "\n");
        sb.append("pendingSyncs:" + pendingSyncs + "\n");
        return sb.toString();
    }
}
