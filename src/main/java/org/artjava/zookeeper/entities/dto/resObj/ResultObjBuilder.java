package org.artjava.zookeeper.entities.dto.resObj;

public class ResultObjBuilder {

    public static ResultObj buildCommonAJ() {
        ResultObj ao = new ResultObj();
        ao.setResult(true);
        ao.setMsg("common");
        return ao;
    }

    public static ResultObj buildSuccessAJ() {
        ResultObj ao = new ResultObj();
        ao.setResult(true);
        ao.setMsg("success");
        return ao;
    }

    public static ResultObj buildFailAJ() {
        ResultObj ao = new ResultObj();
        ao.setResult(false);
        ao.setData(new String[]{});
        ao.setMsg("failure, please check or connect to administrator");
        return ao;
    }
}
