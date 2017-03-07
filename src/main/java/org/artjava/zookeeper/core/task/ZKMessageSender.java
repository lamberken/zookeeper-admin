package org.artjava.zookeeper.core.task;

import org.apache.commons.lang.StringUtils;
import org.artjava.zookeeper.common.ZKAdminConstants;
import org.artjava.zookeeper.util.WarningUtil;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author artJava
 * @date 2017-01-05 19:49
 * @since JDK1.7
 */
public class ZKMessageSender implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger("SYSTEM_LOGGER");
    private String title;
    private String message;
    private String[] jobNumList;          // aa_bb_cc
    private List<String> routeChannelIDs;     // A_B_C_D  weixin duanxin youjian dianhua

    public ZKMessageSender(String title, String message, String[] jobNumList, String[] routeChannelIDs) {
        this.title = title;
        this.message = message;
        this.jobNumList = jobNumList;
        this.routeChannelIDs = Arrays.asList(routeChannelIDs);
    }

    @Override
    public void run() {

        if (routeChannelIDs.contains(ZKAdminConstants.MESSAGE_WEIXIN)) {
            logger.warn("发送微信预警信息,{} {}", title, message);
            WarningUtil.sendMsg(StringUtils.join(jobNumList, ","), title, message);
        }

        if (routeChannelIDs.contains(ZKAdminConstants.MESSAGE_YOUJIAN)) {
            logger.warn("发送邮件预警信息,{} {}", title, message);
            // WarningUtil.sendMsg(StringUtils.join(jobNumList, ","), title, message);
        }

        if (routeChannelIDs.contains(ZKAdminConstants.MESSAGE_DUANXIN)) {
            logger.warn("发送短信预警信息,{} {}", title, message);
            // WarningUtil.sendMsg(StringUtils.join(jobNumList, ","), title, message);
        }

        if (routeChannelIDs.contains(ZKAdminConstants.MESSAGE_DIANHUA)) {
            logger.warn("发送电话预警信息,{} {}", title, message);
            // WarningUtil.sendMsg(StringUtils.join(jobNumList, ","), title, message);
        }


    }

    public static void main(String[] args) {


        WarningUtil.sendMsg("38154", "test", DateTime.now().toString("yyyy-MM-dd HH:mm:ss.S") + "\n" + "fv发送电话预警信息fcontent"
                + "\n" + DateTime.now().toString("yyyy-MM-dd HH:mm:ss.SSS"));

    }

}
