package org.artjava.zookeeper.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author artJava
 * @date 2017-01-05 19:49
 * @since JDK1.7
 */
public class ZKAdminConstants {

    /** task intervals */
    public static final long intervalTime = 5 * 1000;


    /** redis keys */
    public static final String ZK_CLUSTER_LIST_KEY_PREFIX = "ZK_CLUSTER_LIST_KEY_PREFIX";
    public static final String ZK_SERVER_LIST_KEY_PREFIX = "ZK_SERVER_LIST_KEY_PREFIX";
    public static final String ZK_ALARMSETTING_LIST_KEY_PREFIX = "ZK_ALARMSETTING_LIST_KEY_PREFIX";
    public static final String ZK_SERVER_DATE_STAT_KEY_PREFIX = "ZK_SERVER_DATE_STAT_KEY_PREFIX";
    public static final String ZK_SERVER_DATE_SRVR_KEY_PREFIX = "ZK_SERVER_DATE_SRVR_KEY_PREFIX";
    public static final String ZK_SERVER_DATE_MNTR_KEY_PREFIX = "ZK_SERVER_DATE_MNTR_KEY_PREFIX";


    /** zk node data & stat */
    public static final String NODE_DATA = "NODE_DATA";
    public static final String NODE_STAT_ACL_VERSION = "NODE_STAT_ACL_VERSION";
    public static final String NODE_STAT_C_TIME = "NODE_STAT_C_TIME";
    public static final String NODE_STAT_C_VERSION = "NODE_STAT_C_VERSION";
    public static final String NODE_STAT_CZXID = "NODE_STAT_CZXID";
    public static final String NODE_STAT_DATA_LENGTH = "NODE_STAT_DATA_LENGTH";
    public static final String NODE_STAT_EPHEMERAL_OWNER = "NODE_STAT_EPHEMERAL_OWNER";
    public static final String NODE_STAT_M_TIME = "NODE_STAT_M_TIME";
    public static final String NODE_STAT_MZXID = "NODE_STAT_MZXID";
    public static final String NODE_STAT_NUM_CHILDREN = "NODE_STAT_NUM_CHILDREN";
    public static final String NODE_STAT_PZXID = "NODE_STAT_PZXID";
    public static final String NODE_STAT_DATA_VERSION = "NODE_STAT_DATA_VERSION";


    /** four letter commands */
    public static final String conf = "conf";
    public static final String cons = "cons";
    public static final String crst = "crst";
    public static final String dump = "dump";
    public static final String envi = "envi";
    public static final String ruok = "ruok";
    public static final String srst = "srst";
    public static final String srvr = "srvr";
    public static final String stat = "stat";
    public static final String wchs = "wchs";
    public static final String wchc = "wchc";
    public static final String wchp = "wchp";
    public static final String mntr = "mntr";

    public static final List<String> four_letter_cmds = new ArrayList<String>();
    static {
        four_letter_cmds.add(conf);
        four_letter_cmds.add(cons);
        four_letter_cmds.add(crst);
        four_letter_cmds.add(dump);
        four_letter_cmds.add(envi);
        four_letter_cmds.add(ruok);
        four_letter_cmds.add(srst);
        four_letter_cmds.add(srvr);
        four_letter_cmds.add(stat);
        four_letter_cmds.add(wchs);
        four_letter_cmds.add(wchc);
        four_letter_cmds.add(wchp);
        four_letter_cmds.add(mntr);
    }

    /** metrics resp split*/
    public static final String conf_split = "=";
    public static final String cons_split = "";
    public static final String crst_split = "";
    public static final String dump_split = "";
    public static final String envi_split = "=";
    public static final String ruok_split = "";
    public static final String srst_split = "";
    public static final String srvr_split = ": ";
    public static final String stat_split = "";
    public static final String wchs_split = "";
    public static final String mntr_split = "\t";


    public static final String split_t = "\t";
    public static final String split_eq = "=";

    /** message channels */
    public static final String MESSAGE_WEIXIN = "weixin";
    public static final String MESSAGE_DUANXIN = "duanxin";
    public static final String MESSAGE_YOUJIAN = "youjian";
    public static final String MESSAGE_DIANHUA = "dianhua";



}
