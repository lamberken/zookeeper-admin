package com.zookeeper.zkadmin.controller.manager;

import com.zookeeper.zkadmin.common.ZKAdminConstants;
import com.zookeeper.zkadmin.core.parser.impl.ConsParser;
import com.zookeeper.zkadmin.core.parser.impl.MntrParser;
import com.zookeeper.zkadmin.core.parser.impl.RuokParser;
import com.zookeeper.zkadmin.core.parser.impl.WchcParser;
import com.zookeeper.zkadmin.dao.ZooKeeperClusterDAO;
import com.zookeeper.zkadmin.dao.ZooKeeperServerDAO;
import com.zookeeper.zkadmin.entities.dto.ZooServerConnStatus;
import com.zookeeper.zkadmin.entities.dto.ZooServerStatus;
import com.zookeeper.zkadmin.entities.dto.resObj.ResultObj;
import com.zookeeper.zkadmin.entities.dto.resObj.ResultObjBuilder;
import com.zookeeper.zkadmin.entities.model.ZooKeeperServer;
import com.zookeeper.zkadmin.entities.model.metrics.impl.*;
import com.zookeeper.zkadmin.util.SocketUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
/**
 * @author lamber-ken
 * @date 2017-01-05 19:49
 * @since JDK1.7
 */
@Controller
@RequestMapping("cluster/status")
public class ClusterStatusController {

    private static final Logger logger = LoggerFactory.getLogger("SYSTEM_LOGGER");

    @Autowired
    private ZooKeeperClusterDAO clusterDAO;

    @Autowired
    private ZooKeeperServerDAO serverDAO;

    /**
     * clusters's stauts
     */
    @ResponseBody
    @RequestMapping(value = "cluster", method = RequestMethod.GET)
    public ResultObj cluster01(
            @RequestParam("clusterID") String clusterID) throws Exception {

        List<ZooServerStatus> allZkStatuss = new LinkedList<>();

        ZooServerStatus zkStatus;

        List<ZooKeeperServer> allZKServers = serverDAO.getAllZooKeepersServersByClusterID(clusterID);
        for (ZooKeeperServer zkServer : allZKServers) {

            zkStatus = new ZooServerStatus();
            zkStatus.setServerID(zkServer.getServerID());
            zkStatus.setHost(zkServer.getHost());
            zkStatus.setPort(zkServer.getPort());

            String resp = SocketUtil.getRespByCMD(zkServer.getHost(), zkServer.getPort(), ZKAdminConstants.mntr);
            MntrMetrics mm = MntrParser.parser(resp);

            resp = SocketUtil.getRespByCMD(zkServer.getHost(), zkServer.getPort(), ZKAdminConstants.ruok);
            RuokMetrics rm = RuokParser.parser(resp);

            zkStatus.buildFromMetrics(mm, rm);

            if (zkStatus.getMode().equals("leader"))
                allZkStatuss.add(0,zkStatus);
            else
                allZkStatuss.add(zkStatus);
        }
        return ResultObjBuilder.buildSuccessAJ().setData(allZkStatuss);
    }

    /**
     * the server‘s network flow
     * http://localhost:8080/cluster/status/network?serverID=1000000885901913
     */
    @ResponseBody
    @RequestMapping(value = "network", method = RequestMethod.GET)
    public ResultObj cluster02(
            @RequestParam("serverID") String serverID) throws Exception {

        TreeSet<ZooServerStatus> allZkStatuss = new TreeSet<>();

//        CacheClientHA redisClient = RedisUtil.getCallRedisUtil();
//        String date = DateUtil.getDateStr("yyyyMMdd");
//        String rKey = RedisUtil
//                .buildKeyWithSeparator("_", ZKAdminConstants.ZK_SERVER_DATE_SRVR_KEY_PREFIX, date, serverID, "SRVR");
//
//        List<byte[]> bytes = redisClient.List().lrangeBit(rKey, 0, -1);
//        for (byte[] by : bytes) {
//            ZooServerStatus zss = new ZooServerStatus();
//            zss.buildFromSrvrMetrics((SrvrMetrics) SerializationUtils.deserialize(by));
//            allZkStatuss.add(zss);
//        }

        return ResultObjBuilder.buildSuccessAJ().setData(allZkStatuss);
    }

    /**
     * the server‘s network flow
     * http://localhost:8080/cluster/status/conns?clusterID=1000001146206914&serverID=1000000604834747
     */
    @ResponseBody
    @RequestMapping(value = "conns")
    public ResultObj cluster03(
            @RequestParam("clusterID") String clusterID, @RequestParam("serverID") String serverID) throws Exception {
        List<ZooServerConnStatus> zscs = new LinkedList<>();

        ZooKeeperServer zooServer = serverDAO.getZooKeeperServer(clusterID, serverID);
        String resp = SocketUtil.getRespByCMD(zooServer.getHost(), zooServer.getPort(), ZKAdminConstants.cons);
        ConsMetrics cm = ConsParser.parser(resp);

        for (ConsMetrics.ConnDetail cc : cm.getConnList()) {
            ZooServerConnStatus zcs = new ZooServerConnStatus();
            zcs.buildFromConsMetrics(cc);
            zscs.add(zcs);
        }

        return ResultObjBuilder.buildSuccessAJ().setData(zscs);
    }

    /**
     * the server‘s connWchs flow
     * http://localhost:8080/cluster/status/connWchs?clusterID=AYYfE1ubsROYR8D9&serverID=AP23uzu8IQDtXxyd
     */
    @ResponseBody
    @RequestMapping(value = "connWchs")
    public ResultObj cluster04(
            @RequestParam("clusterID") String clusterID, @RequestParam("serverID") String serverID) throws Exception {

        ZooKeeperServer zooServer = serverDAO.getZooKeeperServer(clusterID, serverID);
        Map<String, String> sidAdress = new HashMap<>();
        Map<String, List<String>> connWchs = new HashMap<>();

        String resp = SocketUtil.getRespByCMD(zooServer.getHost(), zooServer.getPort(), ZKAdminConstants.cons);
        ConsMetrics cm = ConsParser.parser(resp);

        List<ConsMetrics.ConnDetail> connList = cm.getConnList();
        for (ConsMetrics.ConnDetail cmc : connList) {
            sidAdress.put(cmc.getSid(), cmc.getAddress() + ":" + cmc.getPort());
        }

        resp = SocketUtil.getRespByCMD(zooServer.getHost(), zooServer.getPort(), ZKAdminConstants.wchc);
        WchcMetrics wm = WchcParser.parser(resp);

        // Set<String> strings = wm.getMapSessionWatchPaths().keySet();
        for (String sid : wm.getMapSessionWatchPaths().keySet()) {
            String adress = sidAdress.get(sid);
            if (StringUtils.isNotBlank(adress)) {
                connWchs.put(adress, wm.getMapSessionWatchPaths().get(sid));
            }
        }

        return ResultObjBuilder.buildSuccessAJ().setData(connWchs);
    }

    /**
     * four letter cmd
     */
    @ResponseBody
    @RequestMapping(value = "fourLetterCmd")
    public ResultObj cluster05(@RequestParam("clusterID") String clusterID,
            @RequestParam("serverID") String serverID, @RequestParam("cmd") String cmd) throws Exception {
        ZooKeeperServer zooServer = serverDAO.getZooKeeperServer(clusterID, serverID);
        String resp = SocketUtil.getRespByCMD(zooServer.getHost(), zooServer.getPort(), cmd);
        return ResultObjBuilder.buildSuccessAJ().setData(resp);
    }

}

