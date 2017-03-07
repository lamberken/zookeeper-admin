package org.artjava.zookeeper.dao.impl.memory;

import org.artjava.zookeeper.exception.DaoException;
import org.artjava.zookeeper.dao.ZooKeeperServerDAO;
import org.artjava.zookeeper.entities.model.ZooKeeperCluster;
import org.artjava.zookeeper.entities.model.ZooKeeperServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ZooKeeperServerDAOImpl implements ZooKeeperServerDAO {
    private static final Logger logger = LoggerFactory.getLogger("SYSTEM_LOGGER");

    Map<String, ZooKeeperServer> zooServers_map = new ConcurrentHashMap<>();

    @Override public void addZooKeeperServer(ZooKeeperServer ZooKeeperServer) throws DaoException {

        zooServers_map.put(ZooKeeperServer.getClusterID() + "_" + ZooKeeperServer.getServerID(), ZooKeeperServer);

    }

    @Override public ZooKeeperServer getZooKeeperServer(String clusterID, String serverId)
            throws DaoException {
        return zooServers_map.get(clusterID + "_" + serverId);
    }

    @Override public List<ZooKeeperServer> getAllZooKeepersServersByClusterID(String clusterID) throws DaoException {

        List<ZooKeeperServer> zkss = new LinkedList<>();

        Set<String> keys = zooServers_map.keySet();

        for (String key : keys) {

            if (key.startsWith(clusterID)) {
                zkss.add(zooServers_map.get(key));
            }

        }

        return zkss;
    }

    @Override public boolean updateZooKeeperClusterByClusterId(ZooKeeperCluster zooKeeperCluster) throws DaoException {
        return false;
    }

    @Override public void removeZooKeeperServer(String clusterID, String serverID) throws DaoException {
        zooServers_map.remove(clusterID + "_" + serverID);
    }

    @Override public void removeAllZooKeeperByClusterID(String clusterID) throws DaoException {

        zooServers_map.clear();

    }

    public static void main(String[] args) {

    }

}
