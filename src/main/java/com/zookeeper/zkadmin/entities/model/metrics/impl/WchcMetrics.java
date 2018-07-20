package com.zookeeper.zkadmin.entities.model.metrics.impl;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author lamber-ken
 * @date 2017-01-05 19:49
 * @since JDK1.7
 */
public class WchcMetrics {


    private Map<String, ArrayList<String>> mapSessionWatchPaths;

    public Map<String, ArrayList<String>> getMapSessionWatchPaths() {
        return mapSessionWatchPaths;
    }

    public void setMapSessionWatchPaths(Map<String, ArrayList<String>> mapSessionWatchPaths) {
        this.mapSessionWatchPaths = mapSessionWatchPaths;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, ArrayList<String>> entry : mapSessionWatchPaths.entrySet()) {
            String key = entry.getKey();
            sb.append(key + ":");
            ArrayList<String> value = entry.getValue();
            int i = 0;
            for(String v : value) {
                if(i == 0) sb.append(v);
                else sb.append(", " + v);
                i++;
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
