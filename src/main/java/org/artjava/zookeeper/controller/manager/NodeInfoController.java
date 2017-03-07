package org.artjava.zookeeper.controller.manager;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;
import org.artjava.zookeeper.core.GlobalInstance;
import org.artjava.zookeeper.dao.ZooKeeperClusterDAO;
import org.artjava.zookeeper.entities.dto.resObj.ResultObj;
import org.artjava.zookeeper.entities.dto.resObj.ResultObjBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

import static org.artjava.zookeeper.common.ZKAdminConstants.*;
/**
 * @author artJava
 * @date 2017-01-05 19:49
 * @since JDK1.7
 */
@Controller
@RequestMapping("node")
public class NodeInfoController {

    private static final Logger logger = LoggerFactory.getLogger("SYSTEM_LOGGER");

    @Autowired
    private ZooKeeperClusterDAO clusterDAO;

    private GlobalInstance globalInstance = GlobalInstance.getInstance();

    /** 获取节点父 , 子路径 */
    @ResponseBody
    @RequestMapping(value = "getNodePaths")
    public ResultObj cluster01(@RequestParam("clusterID") String clusterID, @RequestParam("pid") String pid) throws Exception {

        List<Map<String, Object>> res = new LinkedList<>();
        CuratorFramework client = globalInstance.getCuratorClient(clusterID);
        String path = pid.equals("/") ? pid : pid + "/";

        List<String> childs = client.getChildren().forPath(pid);

        Map<String, Object> r;
        Stat stat;
        for (String s : childs) {

            r = new HashMap<>();
            stat = new Stat();

            r.put("id", path + s);
            r.put("text", s);


            try {
                client.getChildren().storingStatIn(stat).forPath(path + s);
                if (stat.getNumChildren() > 0) {
                    r.put("children", true);
                } else {
                    r.put("children", false);
                    r.put("icon", "ace-icon glyphicon glyphicon-file bigger-120 fa-folder-yellow");
                }
            }catch (Exception e){

                // TODO 权限问题, 带权限
                r.put("children", false);
                r.put("icon", "ace-icon glyphicon glyphicon-file bigger-120 fa-folder-yellow");

            }

            res.add(r);
        }

        return ResultObjBuilder.buildSuccessAJ().setData(res);
    }


    /** 获取get node stat */
    @ResponseBody
    @RequestMapping(value = "getNodeStat")
    public ResultObj cluster02(@RequestParam("clusterID") String clusterID, @RequestParam("nodePath") String nodePath) throws Exception {

        CuratorFramework client = globalInstance.getCuratorClient(clusterID);

        // client.getACL().forPath("")

        Stat s = new Stat();
        client.getData().storingStatIn(s).forPath(nodePath);

        Map<String, Object> nodeMeta = new LinkedHashMap<String, Object>();
        if (s != null) {

            nodeMeta.put(NODE_STAT_ACL_VERSION, String.valueOf(s.getAversion()));

            nodeMeta.put(NODE_STAT_C_TIME, s.getCtime());
            nodeMeta.put(NODE_STAT_M_TIME, s.getMtime());

            nodeMeta.put(NODE_STAT_C_VERSION, String.valueOf(s.getCversion()));
            nodeMeta.put(NODE_STAT_CZXID, String.valueOf(s.getCzxid()));
            nodeMeta.put(NODE_STAT_DATA_LENGTH, String.valueOf(s.getDataLength()));
            nodeMeta.put(NODE_STAT_EPHEMERAL_OWNER, String.valueOf(s.getEphemeralOwner()));
            nodeMeta.put(NODE_STAT_MZXID, String.valueOf(s.getMzxid()));
            nodeMeta.put(NODE_STAT_NUM_CHILDREN, String.valueOf(s.getNumChildren()));
            nodeMeta.put(NODE_STAT_PZXID, String.valueOf(s.getPzxid()));
            nodeMeta.put(NODE_STAT_DATA_VERSION, String.valueOf(s.getVersion()));
        }
        return ResultObjBuilder.buildSuccessAJ().setData(nodeMeta);
    }

    /** 获取get node acls */
    @ResponseBody
    @RequestMapping(value = "getNodeACLs")
    public ResultObj cluster03(@RequestParam("clusterID") String clusterID, @RequestParam("nodePath") String nodePath) throws Exception {

        CuratorFramework client = globalInstance.getCuratorClient(clusterID);

        List<Map<String, String>> ACLs = new ArrayList<Map<String, String>>();
        List<ACL> acls = client.getACL().forPath(nodePath);
        for (ACL acl : acls) {
            Map<String, String> aclMap = new LinkedHashMap<String, String>();
            aclMap.put("ACL_SCHEME", acl.getId().getScheme());
            aclMap.put("ACL_ID", acl.getId().getId());
            StringBuilder sb = new StringBuilder();
            int perms = acl.getPerms();
            if ((perms & ZooDefs.Perms.READ) == ZooDefs.Perms.READ) {
                sb.append("Read");
                sb.append(" ");
            }
            if ((perms & ZooDefs.Perms.WRITE) == ZooDefs.Perms.WRITE) {
                sb.append("Write");
                sb.append(" ");
            }
            if ((perms & ZooDefs.Perms.CREATE) == ZooDefs.Perms.CREATE) {
                sb.append("Create");
                sb.append(" ");
            }
            if ((perms & ZooDefs.Perms.DELETE) == ZooDefs.Perms.DELETE) {
                sb.append("Delete");
                sb.append(" ");
            }
            if ((perms & ZooDefs.Perms.ADMIN) == ZooDefs.Perms.ADMIN) {
                sb.append("Admin");
            }
            aclMap.put("ACL_PERMS", sb.toString());

            ACLs.add(aclMap);
        }

        return ResultObjBuilder.buildSuccessAJ().setData(ACLs);
    }

    /** 获取get node data */
    @ResponseBody
    @RequestMapping(value = "getNodeData")
    public ResultObj cluster04(@RequestParam("clusterID") String clusterID, @RequestParam("nodePath") String nodePath) throws Exception {

        CuratorFramework client = globalInstance.getCuratorClient(clusterID);

        String data = new String(client.getData().forPath(nodePath));

        return ResultObjBuilder.buildSuccessAJ().setData(data);
    }


}
