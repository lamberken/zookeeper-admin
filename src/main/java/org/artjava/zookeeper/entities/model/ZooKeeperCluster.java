package org.artjava.zookeeper.entities.model;

import java.io.Serializable;

/**
 * @author artJava
 * @date 2017-01-05 19:49
 * @since JDK1.7
 */
public class ZooKeeperCluster implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 集群唯一标识 */
    private String clusterID;
    private String clusterName;
    private String serverList;
    private String description;
    private boolean isValid;

    private String empName;
    private String empNumber;
    private String createTimestamp;
    private String modifyTimestamp;

    // status : running 需要检测

    public String getClusterID() {
        return clusterID;
    }

    public void setClusterID(String clusterID) {
        this.clusterID = clusterID;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public String getServerList() {
        return serverList;
    }

    public void setServerList(String serverList) {
        this.serverList = serverList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getModifyTimestamp() {
        return modifyTimestamp;
    }

    public void setModifyTimestamp(String modifyTimestamp) {
        this.modifyTimestamp = modifyTimestamp;
    }

    @Override
    public String toString() {
        return "ZooKeeperCluster{" +
                "clusterID='" + clusterID + '\'' +
                ", clusterName='" + clusterName + '\'' +
                ", serverList='" + serverList + '\'' +
                ", description='" + description + '\'' +
                ", isValid=" + isValid +
                ", empName='" + empName + '\'' +
                ", empNumber='" + empNumber + '\'' +
                ", createTimestamp='" + createTimestamp + '\'' +
                ", modifyTimestamp='" + modifyTimestamp + '\'' +
                '}';
    }
}
