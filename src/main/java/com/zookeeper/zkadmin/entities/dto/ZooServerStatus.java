package com.zookeeper.zkadmin.entities.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.zookeeper.zkadmin.entities.model.metrics.impl.MntrMetrics;
import com.zookeeper.zkadmin.entities.model.metrics.impl.RuokMetrics;
import com.zookeeper.zkadmin.entities.model.metrics.impl.SrvrMetrics;
import com.zookeeper.zkadmin.util.ZK_ZxidUtils;

/**
 * org.artjava.zookeeper.entities.resObj
 *
 * @author lamber-ken
 * @date 2017-01-22 17:10
 * @since JDK1.7
 */
@JsonInclude(JsonInclude.Include.NON_NULL) public class ZooServerStatus implements Comparable {

    private String serverID;
    /**
     * ip hostname
     */
    private String host;
    private int port;
    private String mode;
    /**
     * 连接数
     */
    private long connNum;
    /**
     * 节点数
     */
    private long nodeNum;
    /**
     * 临时节点
     */
    private long enodeNum;
    /**
     * watch 数
     */
    private long watchCount;
    /**
     * sent
     */
    private long sent;
    /**
     * received
     */
    private long received;
    /**
     * outstandings
     */
    private long outstands;
    /**
     * minLatency
     */
    public long minLatency;
    /**
     * maxLatency
     */
    public long maxLatency;
    /**
     * avgLatency
     */
    public long avgLatency;
    /**
     * followers
     */
    private long followers;
    /**
     * zk_approximate_data_size
     */
    private long dataSize;
    /**
     * version
     */
    private String zkVersion;
    /**
     * zxid
     */
    private long zxid;
    /**
     * zxid
     */
    private long zxidCount;

    /**
     * isOk
     */
    private boolean isOk;

    // extra obtain_timestamp
    private long obtainTimestamp;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getServerID() {
        return serverID;
    }

    public void setServerID(String serverID) {
        this.serverID = serverID;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public long getConnNum() {
        return connNum;
    }

    public void setConnNum(long connNum) {
        this.connNum = connNum;
    }

    public long getNodeNum() {
        return nodeNum;
    }

    public void setNodeNum(long nodeNum) {
        this.nodeNum = nodeNum;
    }

    public long getEnodeNum() {
        return enodeNum;
    }

    public void setEnodeNum(long enodeNum) {
        this.enodeNum = enodeNum;
    }

    public long getWatchCount() {
        return watchCount;
    }

    public void setWatchCount(long watchCount) {
        this.watchCount = watchCount;
    }

    public long getSent() {
        return sent;
    }

    public void setSent(long sent) {
        this.sent = sent;
    }

    public long getReceived() {
        return received;
    }

    public void setReceived(long received) {
        this.received = received;
    }

    public long getOutstands() {
        return outstands;
    }

    public void setOutstands(long outstands) {
        this.outstands = outstands;
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

    public long getFollowers() {
        return followers;
    }

    public void setFollowers(long followers) {
        this.followers = followers;
    }

    public long getDataSize() {
        return dataSize;
    }

    public void setDataSize(long dataSize) {
        this.dataSize = dataSize;
    }

    public String getZkVersion() {
        return zkVersion;
    }

    public void setZkVersion(String zkVersion) {
        this.zkVersion = zkVersion;
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

    public long getObtainTimestamp() {
        return obtainTimestamp;
    }

    public void setObtainTimestamp(long obtainTimestamp) {
        this.obtainTimestamp = obtainTimestamp;
    }

    public long getZxid() {
        return zxid;
    }

    public void setZxid(long zxid) {
        this.zxid = zxid;
    }

    public long getZxidCount() {
        return zxidCount;
    }

    public void buildFromMetrics(MntrMetrics mm, RuokMetrics rk) {

        this.connNum = mm.getNumAliveConnections();
        this.nodeNum = mm.getZnodeCount();
        this.watchCount = mm.getWatchCount();
        this.enodeNum = mm.getEphemeralsCount();
        this.followers = mm.getFollowers();
        this.dataSize = mm.getApproximateDataSize();
        this.mode = mm.getServerState();

        this.setOk(rk.isOk());

    }

    public void buildFromSrvrMetrics(SrvrMetrics mm) {

        this.maxLatency = mm.getMaxLatency();
        this.avgLatency = mm.getAvgLatency();
        this.minLatency = mm.getMinLatency();
        this.mode = mm.getMode();

        this.sent = mm.getSent();
        this.received = mm.getReceived();
        this.outstands = mm.getOutstanding();
        this.zxidCount = ZK_ZxidUtils.getCounterFromZxid(mm.getZxid());
        this.obtainTimestamp = mm.getObtainTimestamp();

    }

    @Override public String toString() {
        return "ZooKeeperServerStatus{" + "serverID='" + serverID + '\'' + ", host='" + host + '\'' + ", port=" + port
                + ", mode='" + mode + '\'' + ", connNum=" + connNum + ", nodeNum=" + nodeNum + ", enodeNum=" + enodeNum
                + ", watchCount=" + watchCount + ", sent=" + sent + ", received=" + received + ", outstands="
                + outstands + ", minLatency=" + minLatency + ", maxLatency=" + maxLatency + ", avgLatency=" + avgLatency
                + ", followers=" + followers + ", dataSize=" + dataSize + ", zkVersion='" + zkVersion + '\'' + ", zxid="
                + zxid + ", zxidCount=" + zxidCount + ", obtainTimestamp=" + obtainTimestamp + '}';
    }

    @Override public int compareTo(Object o) {
        long delta = this.obtainTimestamp - ((ZooServerStatus) o).obtainTimestamp;
        if (delta > 0)
            return 1;
        else if (delta < 0)
            return -1;
        else
            return 0;
    }
}
