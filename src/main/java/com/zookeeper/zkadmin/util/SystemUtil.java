package com.zookeeper.zkadmin.util;

import com.zookeeper.zkadmin.common.ZKAdminConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * @author lamber-ken
 * @date 2017-01-05 19:49
 * @since JDK1.7
 */
public class SystemUtil {

    private static final Logger logger = LoggerFactory.getLogger("SYSTEM_LOGGER");
    private static Random random = new Random();

    /**
     *  parser split
     *
     */
    public static String[] splitL (String str){
        String tmp[] = null;

        tmp = str.split(ZKAdminConstants.split_t);
        if (tmp.length == 2){
            return tmp;
        }
        tmp = str.split(ZKAdminConstants.split_eq);
        if (tmp.length == 2){
            return tmp;
        }

        return tmp;
    }


    private static char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
            'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
            'Z'};


    /**
     * 获取数值 UUID
     */
    public static String getSimpleUniqueIdByUUId() {

//
//        /**
//         *  %08d
//         *  0 代表前面补充0
//         *  4 代表长度为4
//         *  d 代表参数为正数型
//         */
//        return digits[random.nextInt(digits.length)] + String.format("%07d", random.nextInt(99999999)) + String.format("%08d", random.nextInt(99999999));


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            sb.append(digits[random.nextInt(digits.length)]);
        }

        return sb.toString();

    }


}
