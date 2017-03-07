package org.artjava.zookeeper.entities.model;

import java.io.Serializable;

/**
 * org.artjava.zookeeper.entities.model
 *
 * @author artJava
 * @date 2017-01-03 19:49
 * @since JDK1.7
 */
public class ZooKeeperServer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * server 唯一标识
     */
    private String serverID;

    /**
     * cluster 唯一标识
     */
    private String clusterID;
    private String host;
    private int port;

    public String getServerID() {
        return serverID;
    }

    public void setServerID(String serverID) {
        this.serverID = serverID;
    }

    public String getClusterID() {
        return clusterID;
    }

    public void setClusterID(String clusterID) {
        this.clusterID = clusterID;
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

    @Override
    public boolean equals(Object _obj) {
        ZooKeeperServer obj = (ZooKeeperServer) _obj;
        if (this.getHost().equals(obj.getHost()) && this.getPort() == obj.getPort())
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {

        // 31是个神奇的数字，因为任何数n * 31就可以被JVM优化为 (n << 5) -n,移位和减法的操作效率要比乘法的操作效率高的多。
        int prime = 31;
        int hashcode = 17;

        hashcode = hashcode * prime + host.hashCode();
        hashcode = hashcode * prime + port;
        return hashcode;
    }

    @Override public String toString() {
        return "ZooKeeperServer{" + "serverID='" + serverID + '\'' + ", clusterID='" + clusterID + '\'' + ", host='"
                + host + '\'' + ", port=" + port + '}';
    }
}
