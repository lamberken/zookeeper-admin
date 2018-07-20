package com.zookeeper.zkadmin.core.parser.impl;


import com.zookeeper.zkadmin.core.parser.Parser;
import com.zookeeper.zkadmin.entities.model.metrics.impl.RuokMetrics;

/**
 * @author lamber-ken
 * @date 2017-01-05 19:49
 * @since JDK1.7
 */
public class RuokParser implements Parser {

    public static final String imok = "imok";


    public static RuokMetrics parser(String str) {

        RuokMetrics ruokMetrics = new RuokMetrics();

        if (str != null && str.equals(imok)){
            ruokMetrics.setOk(true);
        }else {
            ruokMetrics.setOk(false);
        }

        return ruokMetrics;
    }


}
