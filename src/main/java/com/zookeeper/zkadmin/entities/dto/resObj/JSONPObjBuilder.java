package com.zookeeper.zkadmin.entities.dto.resObj;


import com.fasterxml.jackson.databind.util.JSONPObject;

/**
 * jsonp obj
 *
 * @author 38154
 * @date 2016-11-08 13:02
 * @since JDK1.7
 */
public class JSONPObjBuilder {

    /**
     * callback memthod  default --> _callback
     */
    public static JSONPObject buildFromResultObj(String callback, ResultObj resultObj) {
        return new JSONPObject(callback, resultObj);
    }

}
