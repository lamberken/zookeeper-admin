package com.zookeeper.zkadmin.entities.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.zookeeper.zkadmin.entities.model.metrics.impl.ConsMetrics;

/**
 * @author lamber-ken
 * @date 2017-01-05 19:49
 * @since JDK1.7
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ZooServerConnStatus {

    private String serverID;
    private String host;
    private int port;
    private int index;
    private long queued;
    private long recved;
    private long sent;
    private String sid;
    private String lop;
    private long est;//timestamp?
    private long to;
    private String lcxid;
    private String lzxid;
    private long lresp;
    private long llat;
    private long minlat;
    private long avglat;
    private long maxlat;

    // extra obtain_timestamp
    private long obtainTimestamp;

    public String getServerID() {
        return serverID;
    }

    public void setServerID(String serverID) {
        this.serverID = serverID;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public long getQueued() {
        return queued;
    }

    public void setQueued(long queued) {
        this.queued = queued;
    }

    public long getRecved() {
        return recved;
    }

    public void setRecved(long recved) {
        this.recved = recved;
    }

    public long getSent() {
        return sent;
    }

    public void setSent(long sent) {
        this.sent = sent;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public long getEst() {
        return est;
    }

    public void setEst(long est) {
        this.est = est;
    }

    public long getTo() {
        return to;
    }

    public void setTo(long to) {
        this.to = to;
    }

    public String getLcxid() {
        return lcxid;
    }

    public void setLcxid(String lcxid) {
        this.lcxid = lcxid;
    }

    public String getLzxid() {
        return lzxid;
    }

    public void setLzxid(String lzxid) {
        this.lzxid = lzxid;
    }

    public long getLresp() {
        return lresp;
    }

    public void setLresp(long lresp) {
        this.lresp = lresp;
    }

    public long getLlat() {
        return llat;
    }

    public void setLlat(long llat) {
        this.llat = llat;
    }

    public long getMinlat() {
        return minlat;
    }

    public void setMinlat(long minlat) {
        this.minlat = minlat;
    }

    public long getAvglat() {
        return avglat;
    }

    public void setAvglat(long avglat) {
        this.avglat = avglat;
    }

    public long getMaxlat() {
        return maxlat;
    }

    public void setMaxlat(long maxlat) {
        this.maxlat = maxlat;
    }

    public long getObtainTimestamp() {
        return obtainTimestamp;
    }

    public void setObtainTimestamp(long obtainTimestamp) {
        this.obtainTimestamp = obtainTimestamp;
    }

    public void buildFromConsMetrics(ConsMetrics.ConnDetail cd) {

        this.host = cd.getAddress();
        this.port = cd.getPort();
        this.recved = cd.getRecved();
        this.sent = cd.getSent();
        this.est = cd.getEst();
        this.lresp = cd.getLresp();
        this.maxlat = cd.getMaxlat();

    }

}
