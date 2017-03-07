package org.artjava.zookeeper.dao;


import org.artjava.zookeeper.exception.DaoException;
import org.artjava.zookeeper.entities.model.ZooKeeperCluster;

import java.util.List;

public interface ZooKeeperClusterDAO {

    /**
     * 添加一个zookeeper集群
     */
    void addZooKeeperCluster(ZooKeeperCluster zooKeeperCluster) throws DaoException;

    /**
     * 获取单个
     */
    ZooKeeperCluster getZooKeeperCluster(String clusterId) throws DaoException;

    /** 所有 */
    List<ZooKeeperCluster> getAllZooKeeperClusters() throws DaoException;


    boolean updateZooKeeperCluster(ZooKeeperCluster zooKeeperCluster) throws DaoException;

    /** 删除集群 */
    boolean removeZooKeeperCluster(String clusterID) throws DaoException;
    void removeAllZooKeeperCluster() throws DaoException;



}