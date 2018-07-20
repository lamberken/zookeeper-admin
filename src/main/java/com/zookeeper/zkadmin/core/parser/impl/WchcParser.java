package com.zookeeper.zkadmin.core.parser.impl;



import com.zookeeper.zkadmin.core.parser.Parser;
import com.zookeeper.zkadmin.entities.model.metrics.impl.WchcMetrics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lamber-ken
 * @date 2017-01-05 19:49
 * @since JDK1.7
 */
public class WchcParser implements Parser {


    public static WchcMetrics parser(String str) {
        if (str == null || str.equals("")) return null;

        Map<String, ArrayList<String>> mapSessionWatchPaths = new HashMap<>();

        String sline[] = str.split("\n");
        String key = null;
        String value = null;
        for (String l : sline) {
            if (l == null || l.equals("") || l.trim().equals("")) continue;
            String data = l.trim();
            if (!data.contains("/")) {
                key = data;
            } else {
                value = data;
                setData(mapSessionWatchPaths, key, value);
            }
        }

        WchcMetrics wm = new WchcMetrics();
        wm.setMapSessionWatchPaths(mapSessionWatchPaths);

        return wm;
    }


    private static void setData(Map<String, ArrayList<String>> mwp, String key, String value) {
        if (key == null || value == null || key.equals("") || value.equals("")) return;

        if (mwp.containsKey(key)) {
            ArrayList<String> valueList = mwp.get(key);
            if (valueList == null) {
                valueList = new ArrayList<String>();
            }
            valueList.add(value);
            mwp.put(key, valueList);
        } else {
            ArrayList<String> valueList = new ArrayList<String>();
            valueList.add(value);
            mwp.put(key, valueList);
        }

    }


}
