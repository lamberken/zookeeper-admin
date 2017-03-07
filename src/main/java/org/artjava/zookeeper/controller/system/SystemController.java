package org.artjava.zookeeper.controller.system;

import org.artjava.zookeeper.entities.dto.resObj.ResultObj;
import org.artjava.zookeeper.entities.dto.resObj.ResultObjBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author artJava
 * @date 2017-01-05 19:49
 * @since JDK1.7
 */
@Controller
@RequestMapping("system")
public class SystemController {

    @ResponseBody
    @RequestMapping(value = "getMenus")
    public ResultObj system01() throws Exception {

        List<Map<String, Object>> menus = new LinkedList<>();

        Map<String, Object> menu = new HashMap<>();
        menu.put("text", "测试");
        menu.put("sref", "manager_cluster_nustatus.html");

        menus.add(menu);

        return ResultObjBuilder.buildSuccessAJ().setData(menus);
    }

    @ResponseBody
    @RequestMapping(value = "login")
    public ResultObj system02(@RequestParam("username") String _username)
            throws Exception {
        return ResultObjBuilder.buildSuccessAJ().setData("artJava");
    }

    /**
     */
    @ResponseBody
    @RequestMapping(value = "userQuery")
    public ResultObj system03(@RequestParam("jobNum") String _jobNum)
            throws Exception {

        List list = new LinkedList();

        Map<String, String> user = new HashMap<>();
        user.put("jobNum", "656360");
        user.put("jobName", "artJava");
        user.put("deptName", "大数据分布式研究组");
        list.add(user);


        return ResultObjBuilder.buildSuccessAJ().setData(list);

    }

    /**
     * web broswer ajax check sysc timely
     */
    @ResponseBody
    @RequestMapping(value = "checkOK")
    public ResultObj system04()
            throws Exception {

        return null;
    }


}
