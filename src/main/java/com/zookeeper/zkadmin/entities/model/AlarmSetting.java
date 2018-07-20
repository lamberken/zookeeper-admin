package com.zookeeper.zkadmin.entities.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author lamber-ken
 * @date 2017-01-05 19:49
 * @since JDK1.7
 */
public class AlarmSetting implements Serializable {

    private static final long serialVersionUID = 1L;

    private String clusterID;
    private int maxCpuPCT;
    private int maxMemoryPCT;
    private int maxDiskPCT;
    private int maxConnectionPerIp;
    private int maxWatchPerIp;
    private String[] jobNumList;          // aa_bb_cc
    private String[] jobNameList;
    private String[] routeChannelIDs;       // A_B_C_D  weixin duanxin youjian dianhua

    public String getClusterID() {
        return clusterID;
    }

    public void setClusterID(String clusterID) {
        this.clusterID = clusterID;
    }

    public int getMaxCpuPCT() {
        return maxCpuPCT;
    }

    public void setMaxCpuPCT(int maxCpuPCT) {
        this.maxCpuPCT = maxCpuPCT;
    }

    public int getMaxMemoryPCT() {
        return maxMemoryPCT;
    }

    public void setMaxMemoryPCT(int maxMemoryPCT) {
        this.maxMemoryPCT = maxMemoryPCT;
    }

    public int getMaxDiskPCT() {
        return maxDiskPCT;
    }

    public void setMaxDiskPCT(int maxDiskPCT) {
        this.maxDiskPCT = maxDiskPCT;
    }

    public int getMaxConnectionPerIp() {
        return maxConnectionPerIp;
    }

    public void setMaxConnectionPerIp(int maxConnectionPerIp) {
        this.maxConnectionPerIp = maxConnectionPerIp;
    }

    public int getMaxWatchPerIp() {
        return maxWatchPerIp;
    }

    public void setMaxWatchPerIp(int maxWatchPerIp) {
        this.maxWatchPerIp = maxWatchPerIp;
    }

    public String[] getJobNumList() {
        return jobNumList;
    }

    public void setJobNumList(String[] jobNumList) {
        this.jobNumList = jobNumList;
    }

    public String[] getJobNameList() {
        return jobNameList;
    }

    public void setJobNameList(String[] jobNameList) {
        this.jobNameList = jobNameList;
    }

    public String[] getRouteChannelIDs() {
        return routeChannelIDs;
    }

    public void setRouteChannelIDs(String[] routeChannelIDs) {
        this.routeChannelIDs = routeChannelIDs;
    }


    @Override
    public String toString() {
        return "AlarmSetting{" +
                "clusterID='" + clusterID + '\'' +
                ", maxCpuPCT=" + maxCpuPCT +
                ", maxMemoryPCT=" + maxMemoryPCT +
                ", maxDiskPCT=" + maxDiskPCT +
                ", maxConnectionPerIp=" + maxConnectionPerIp +
                ", maxWatchPerIp=" + maxWatchPerIp +
                ", jobNumList=" + Arrays.toString(jobNumList) +
                ", jobNameList=" + Arrays.toString(jobNameList) +
                ", routeChannelIDs=" + Arrays.toString(routeChannelIDs) +
                '}';
    }
}
