package com.zookeeper.zkadmin.core.parser.impl;



import com.zookeeper.zkadmin.core.parser.Parser;
import com.zookeeper.zkadmin.entities.model.metrics.impl.ConsMetrics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lamber-ken
 * @date 2017-01-05 19:49
 * @since JDK1.7
 */
public class ConsParser implements Parser {

    private static final String queuedCon = "queued";
    private static final String recvedCon = "recved";
    private static final String sentCon = "sent";
    private static final String sidCon = "sid";
    private static final String lopCon = "lop";
    private static final String estCon = "est";
    private static final String toCon = "to";
    private static final String lcxidCon = "lcxid";
    private static final String lzxidCon = "lzxid";
    private static final String lrespCon = "lresp";
    private static final String llatCon = "llat";
    private static final String minlatCon = "minlat";
    private static final String avglatCon = "avglat";
    private static final String maxlatCon = "maxlat";

    private static List<String> keyCons = new ArrayList<String>();

    static {
        keyCons.add(queuedCon);
        keyCons.add(recvedCon);
        keyCons.add(sentCon);
        keyCons.add(sidCon);
        keyCons.add(lopCon);
        keyCons.add(estCon);
        keyCons.add(toCon);
        keyCons.add(lcxidCon);
        keyCons.add(lzxidCon);
        keyCons.add(lrespCon);
        keyCons.add(llatCon);
        keyCons.add(minlatCon);
        keyCons.add(avglatCon);
        keyCons.add(maxlatCon);
    }


    public static ConsMetrics parser(String str) {
        if (str == null || str.equals("")) return null;
        ConsMetrics mm = new ConsMetrics();

        List<ConsMetrics.ConnDetail> connList = new ArrayList<ConsMetrics.ConnDetail>();

        try {

            String sline[] = str.split("\n");
            for (String l : sline) {
                ConsMetrics.ConnDetail connDetail = parseConn(l);
                if (connDetail != null)
                    connList.add(connDetail);
            }

            mm.setConnList(connList);

        } catch (Exception e) {
//            String sline[] = str.split("\r\n");
//            for (String l : sline) {
//                if (l == null || l.equals("") || l.trim().equals("")) continue;
//                String kv[] = l.split(ZKAdminConstants.mntr_split);
//                if (kv.length == 2) {
//                    String key = kv[0];
//                    String value = kv[1];
//                    setData(mm, key, value);
//                }
//            }
        }

        return mm;
    }


    private static ConsMetrics.ConnDetail parseConn(String str) {
        if (str == null || str.equals("") || !str.contains("/")) return null;
        ConsMetrics.ConnDetail conn = new ConsMetrics.ConnDetail();
        String ss[] = str.split("\\(");
        if (ss.length == 2) {
            String s1 = ss[0].trim();
            String s2 = ss[1].trim();
            //deal s1
            conn.setAddress(s1.substring(s1.indexOf("/") + 1, s1.indexOf(":")));
            conn.setPort(Integer.valueOf(s1.substring(s1.indexOf(":") + 1, s1.indexOf("["))));
            conn.setIndex(Integer.valueOf(s1.substring(s1.indexOf("[") + 1, s1.indexOf("]"))));
            //deal s2
            s2 = s2.substring(0, s2.indexOf(")"));
            String datas[] = s2.split(",");
            for (String data : datas) {
                String kv[] = data.split("=");
                if (kv.length == 2) {
                    String key = kv[0].trim();
                    String value = kv[1].trim();
                    setData(conn, key, value);
                }
            }
        } else {
            conn = null;
        }

        return conn;
    }

    private static void setData(ConsMetrics.ConnDetail conn, String key, String value) {
        if (key == null || value == null || key.equals("") || value.equals("")) return;
        key = key.trim();
        value = value.trim();
        if (key.equals(queuedCon)) {
            conn.setQueued(Long.valueOf(value));
        } else if (key.equals(recvedCon)) {
            conn.setRecved(Long.valueOf(value));
        } else if (key.equals(sentCon)) {
            conn.setSent(Long.valueOf(value));
        } else if (key.equals(sidCon)) {
            conn.setSid(value);
        } else if (key.equals(lopCon)) {
            conn.setLop(value);
        } else if (key.equals(estCon)) {
            conn.setEst(Long.valueOf(value));
        } else if (key.equals(toCon)) {
            conn.setTo(Long.valueOf(value));
        } else if (key.equals(lcxidCon)) {
            conn.setLcxid(value);
        } else if (key.equals(lzxidCon)) {
            conn.setLzxid(value);
        } else if (key.equals(lrespCon)) {
            conn.setLresp(Long.valueOf(value));
        } else if (key.equals(llatCon)) {
            conn.setLlat(Long.valueOf(value));
        } else if (key.equals(minlatCon)) {
            conn.setMinlat(Long.valueOf(value));
        } else if (key.equals(avglatCon)) {
            conn.setAvglat(Long.valueOf(value));
        } else if (key.equals(maxlatCon)) {
            conn.setMaxlat(Long.valueOf(value));
        } else {
            //nothing
        }
    }


}
