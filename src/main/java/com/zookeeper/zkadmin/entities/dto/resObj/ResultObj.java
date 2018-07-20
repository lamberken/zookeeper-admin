package com.zookeeper.zkadmin.entities.dto.resObj;

import java.util.HashMap;

public class ResultObj extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public ResultObj setMsg(Object object) {
        this.put("msg", object);
        return this;
    }

    public void setResult(boolean result) {
        this.put("result", Boolean.valueOf(result));
    }

    public ResultObj setData(Object obj) {
        this.put("data", obj);
        return this;
    }

    public ResultObj setErrorInfo(Object obj) {
        this.put("error", obj);
        return this;
    }


    public ResultObj put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
