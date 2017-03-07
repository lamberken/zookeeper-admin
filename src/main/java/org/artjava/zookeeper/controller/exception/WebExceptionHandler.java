package org.artjava.zookeeper.controller.exception;

import org.artjava.zookeeper.entities.dto.resObj.JSONPObjBuilder;
import org.artjava.zookeeper.entities.dto.resObj.ResultObjBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
/**
 * @author artJava
 * @date 2017-01-05 19:49
 * @since JDK1.7
 */
@ControllerAdvice
public class WebExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger("SYSTEM_LOGGER");

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handleBizExp(@RequestParam(value = "_callback", required = false) String callback, HttpServletRequest request, Exception ex) throws Exception {

        Map<String, String[]> parameterMap = request.getParameterMap();

        if (parameterMap.keySet().contains("_callback")) {
            return null;
        } else
            return ResultObjBuilder.buildFailAJ().setErrorInfo(null);
    }

}