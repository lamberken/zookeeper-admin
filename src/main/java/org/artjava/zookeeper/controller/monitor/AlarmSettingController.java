package org.artjava.zookeeper.controller.monitor;

import org.artjava.zookeeper.core.GlobalInstance;
import org.artjava.zookeeper.dao.AlarmSettingDao;
import org.artjava.zookeeper.entities.dto.resObj.ResultObj;
import org.artjava.zookeeper.entities.dto.resObj.ResultObjBuilder;
import org.artjava.zookeeper.entities.model.AlarmSetting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author artJava
 * @date 2017-01-05 19:49
 * @since JDK1.7
 */
@Controller
@RequestMapping("alarm")
public class AlarmSettingController {
    private static final Logger logger = LoggerFactory.getLogger("SYSTEM_LOGGER");

    @Autowired
    private AlarmSettingDao alarmSettingDao;

    GlobalInstance gInstance = GlobalInstance.getInstance();


    @ResponseBody
    @RequestMapping(value = "getAlarmSetting")
    public ResultObj alarm00(
            @RequestParam("clusterID") String _clusterID)
            throws Exception {

        AlarmSetting alarmSetting = alarmSettingDao.getAlarmSetting(_clusterID);
        if (alarmSetting != null) {
            return ResultObjBuilder.buildSuccessAJ().setData(alarmSetting);
        } else {
            return ResultObjBuilder.buildFailAJ();
        }
    }

    @ResponseBody
    @RequestMapping(value = "upAlarmSetting")
    public ResultObj alarm01(
            @RequestParam(value = "clusterID") String _clusterID,
            @RequestParam("maxCpuPCT") int _maxCpuPCT,
            @RequestParam("maxMemoryPCT") int _maxMemoryPCT,
            @RequestParam("maxDiskPCT") int _maxDiskPCT,
            @RequestParam("maxConnectionPerIp") int _maxConnectionPerIp,
            @RequestParam("maxWatchPerIp") int _maxWatchPerIp,
            @RequestParam("alarmJobNums") String[] _alarmJobNums,
            @RequestParam("routeChannelIDs") String[] _routeChannelIDs)
            throws Exception {

        AlarmSetting as = alarmSettingDao.getAlarmSetting(_clusterID);
        if (as == null) {
            as = new AlarmSetting();
        }
        as.setClusterID(_clusterID);
        as.setMaxCpuPCT(_maxCpuPCT);
        as.setMaxDiskPCT(_maxDiskPCT);
        as.setMaxMemoryPCT(_maxMemoryPCT);
        as.setMaxWatchPerIp(_maxWatchPerIp);
        as.setMaxConnectionPerIp(_maxConnectionPerIp);
        as.setJobNumList(_alarmJobNums);

        as.setRouteChannelIDs(_routeChannelIDs);

        alarmSettingDao.updateAlarmSetting(as);
        gInstance.addAlarmSetting(as);
        return ResultObjBuilder.buildSuccessAJ();
    }

    @ResponseBody
    @RequestMapping(value = "removeAlarmSetting")
    public ResultObj alarm02(
            @RequestParam("clusterID") String _clusterID)
            throws Exception {

        boolean b = alarmSettingDao.removeAlarmSetting(_clusterID);
        return ResultObjBuilder.buildSuccessAJ().setData(b);

    }


    private static String arrayJoin(String[] strs) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strs.length; i++) {

            sb.append(strs[i]);

            if (i != strs.length - 1) {
                sb.append("_");
            }
        }


        return sb.toString();
    }

    public static void main(String[] args) {

        String[] ss = {"aa,bb", "bb"};

        System.out.println(arrayJoin(ss));


    }

}
