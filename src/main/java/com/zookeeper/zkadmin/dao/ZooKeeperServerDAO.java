package com.zookeeper.zkadmin.dao;


import com.zookeeper.zkadmin.entities.model.ZooKeeperCluster;
import com.zookeeper.zkadmin.entities.model.ZooKeeperServer;
import com.zookeeper.zkadmin.exception.DaoException;

import java.util.List;
/**
 * @author lamber-ken
 * @date 2017-01-05 19:49
 * @since JDK1.7
 */
public interface ZooKeeperServerDAO {

    /**
     * 添加一个zookeeper zkserver
     */
    void addZooKeeperServer(ZooKeeperServer ZooKeeperServer) throws DaoException;

    /**
     * 获取单个
     */
    ZooKeeperServer getZooKeeperServer(String clusterID, String serverId) throws DaoException;

    /**
     * 所有
     */
    List<ZooKeeperServer> getAllZooKeepersServersByClusterID(String clusterID) throws DaoException;

    boolean updateZooKeeperClusterByClusterId(ZooKeeperCluster zooKeeperCluster) throws DaoException;

    /**
     * 删除服务器
     */
    void removeZooKeeperServer(String clusterID, String serverID) throws DaoException;

    void removeAllZooKeeperByClusterID(String clusterID) throws DaoException;

}