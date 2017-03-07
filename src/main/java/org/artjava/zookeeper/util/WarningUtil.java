package org.artjava.zookeeper.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * dzs-data-parent com.ly.dzs.data.common.util
 *
 * @author artJava
 * @date 2016-11-10 14:18
 * @since JDK1.7
 */
public class WarningUtil {

    private static final Logger logger = LoggerFactory.getLogger("SYSTEM_LOGGER");

    /**
     * 通过同程助手发送消息
     *
     * @param user    工号, 多个以逗号分割
     * @param tile    标题
     * @param content 内容
     *                {"touser": "xxxx","articles":[{ "title": "title1","description": "desc1"}]}
     */
    public static void sendMsg(String user, String tile, String content) {

        if (StringUtils.isEmpty(user) || StringUtils.isEmpty(tile) || StringUtils.isEmpty(content))
            return;

    }

    public static void main(String[] args) {

        sendMsg("xxx", "asa", "ddd");

    }

}
