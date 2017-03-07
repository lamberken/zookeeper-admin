package org.artjava.zookeeper.controller.manager;

import org.apache.commons.lang.StringUtils;
import org.artjava.zookeeper.core.GlobalInstance;
import org.artjava.zookeeper.dao.ZooKeeperClusterDAO;
import org.artjava.zookeeper.dao.ZooKeeperServerDAO;
import org.artjava.zookeeper.entities.dto.resObj.ResultObj;
import org.artjava.zookeeper.entities.dto.resObj.ResultObjBuilder;
import org.artjava.zookeeper.entities.model.ZooKeeperCluster;
import org.artjava.zookeeper.entities.model.ZooKeeperServer;
import org.artjava.zookeeper.util.SystemUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author artJava
 * @date 2017-01-05 19:49
 * @since JDK1.7
 */
@Controller @RequestMapping("cluster") public class ClusterInfoController {

    private static final Logger logger = LoggerFactory.getLogger("SYSTEM_LOGGER");

    private GlobalInstance instance = GlobalInstance.getInstance();

    @Autowired private ZooKeeperClusterDAO clusterDAO;
    @Autowired private ZooKeeperServerDAO serverDAO;

    /**
     * TODO
     * 更新或添加 cluster
     * 一、检测 ip 及 port --> 只做 合理性检测, 无需ping通, 因为若 server 挂了, 确实无法ping 通
     * <p>
     * 二、添加
     * 1) 创建 curator client
     * 2) 为每一个 zooserver 创建 tcp 连接池 <-- 暂不做
     * <p>
     * <p>
     * 三、修改
     * 根据 clusterID 获取
     * 若 name 和 desc 修改, 则直接更改 cluster info
     * 若 zooServer 改动,
     * 1) 根据 ip 和 port 判断是否是同一个 zooserver
     * 2) 不同的则更改, 先停止监听任务
     * 3) 删除 key
     */
    @ResponseBody @RequestMapping(value = "addZKCluster", method = RequestMethod.POST) public ResultObj cluster01(
            @RequestParam("clusterID") String _clusterID, @RequestParam("clusterName") String _clusterName,
            @RequestParam("serverList") String _serverList, @RequestParam("description") String _description)
            throws Exception {

        logger.info("controller path:[/addZKCluster], serverList[{}]", _serverList);

        /**
         * TODO 检测 ip port 合理性
         *
         * serverList 一定是 xxx.xxx.xxx.xx:222,xxx.xxx.xxx.xx:222,且不重复 ★★★
         *
         */
        // TODO
        ZooKeeperCluster cluster;
        if (StringUtils.isNotBlank(_clusterID)) {
            cluster = clusterDAO.getZooKeeperCluster(_clusterID);
            // 删除 servers
            serverDAO.removeAllZooKeeperByClusterID(_clusterID);
        } else {
            cluster = new ZooKeeperCluster();
            cluster.setClusterID(SystemUtil.getSimpleUniqueIdByUUId());
        }

        String clusterID = cluster.getClusterID();
        cluster.setClusterName(_clusterName);
        cluster.setServerList(_serverList);
        cluster.setDescription(_description);

        clusterDAO.addZooKeeperCluster(cluster);

        // 新增
        String[] serversArr = _serverList.split(",");
        for (String server : serversArr) {

            String host = server.split(":")[0];
            int port = Integer.parseInt(server.split(":")[1]);

            ZooKeeperServer zks = new ZooKeeperServer();
            zks.setClusterID(clusterID);
            zks.setServerID(SystemUtil.getSimpleUniqueIdByUUId());
            zks.setHost(host);
            zks.setPort(port);
            serverDAO.addZooKeeperServer(zks);
        }

        instance.updateCuratorClient(cluster);

        return ResultObjBuilder.buildSuccessAJ().setData(null);

    }

    /**
     * list all
     */
    @ResponseBody @RequestMapping(value = "listZKClusters") public ResultObj cluster02() throws Exception {
        return ResultObjBuilder.buildSuccessAJ().setData(clusterDAO.getAllZooKeeperClusters());
    }

    /**
     * TODO
     * remove single
     * 1, 停止并删除 curator client
     */
    @ResponseBody @RequestMapping(value = "removeZKCluster", method = { RequestMethod.POST,
            RequestMethod.GET }) public ResultObj cluster03(@RequestParam("clusterID") String clusterID)
            throws Exception {

        instance.removeCuratorClient(clusterID);
        clusterDAO.removeZooKeeperCluster(clusterID);
        serverDAO.removeAllZooKeeperByClusterID(clusterID);

        return ResultObjBuilder.buildSuccessAJ().setData(true);

    }

}
