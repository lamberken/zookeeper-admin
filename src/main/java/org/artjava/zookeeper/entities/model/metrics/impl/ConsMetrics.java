package org.artjava.zookeeper.entities.model.metrics.impl;

import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author artJava
 * @date 2017-01-05 19:49
 * @since JDK1.7
 */
public class ConsMetrics {

    private List<ConnDetail> connList = new ArrayList<ConnDetail>();
    // extra obtain_timestamp
    private long obtainTimestamp;

    public ConsMetrics(){
        this.obtainTimestamp = DateTime.now().toDate().getTime();
    }

    public long getObtainTimestamp() {
        return obtainTimestamp;
    }

    public void setObtainTimestamp(long obtainTimestamp) {
        this.obtainTimestamp = obtainTimestamp;
    }

    public List<ConnDetail> getConnList() {
        return connList;
    }

    public void setConnList(List<ConnDetail> connList) {
        this.connList = connList;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(ConnDetail conn : connList) {
            sb.append(conn.toString() + "\n\n");
        }

        return sb.toString();
    }

    public static class ConnDetail implements Serializable{
        private static final long serialVersionUID = 1L;

        private String address;
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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
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

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("address" + ":" + address + "\n");
            sb.append("port" + ":" + port + "\n");
            sb.append("index" + ":" + index + "\n");
            sb.append("queuedCon" + ":" + queued + "\n");
            sb.append("recvedCon" + ":" + recved + "\n");
            sb.append("sentCon" + ":" + sent + "\n");
            sb.append("sidCon" + ":" + sid + "\n");
            sb.append("lopCon" + ":" + lop + "\n");
            sb.append("estCon" + ":" + est + "\n");
            sb.append("toCon" + ":" + to + "\n");
            sb.append("lcxidCon" + ":" + lcxid + "\n");
            sb.append("lzxidCon" + ":" + lzxid + "\n");
            sb.append("lrespCon" + ":" + lresp + "\n");
            sb.append("llatCon" + ":" + llat + "\n");
            sb.append("minlatCon" + ":" + minlat + "\n");
            sb.append("avglatCon" + ":" + avglat + "\n");
            sb.append("maxlatCon" + ":" + maxlat + "\n");

            return sb.toString();
        }

    }

}
