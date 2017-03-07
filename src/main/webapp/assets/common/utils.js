/**
 * Created by artJava on 2017/1/30.
 */
var CommonUtil = {

    /**
     *
     * @param date
     * @param pattern
     *    yyyy
     *    MM
     *    dd
     *    S
     *
     */
    dateFormat: function (date, pattern) {
        var o = {
            "M+": date.getMonth() + 1, //month
            "d+": date.getDate(), //day
            "h+": date.getHours(), //hour
            "m+": date.getMinutes(), //minute
            "s+": date.getSeconds(), //second
            "q+": Math.floor((date.getMonth() + 3) / 3), //quarter
            "S": date.getMilliseconds() //millisecond
        }

        if (/(y+)/.test(pattern)) {
            pattern = pattern.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
        }

        for (var k in o) {
            if (new RegExp("(" + k + ")").test(pattern)) {
                pattern = pattern.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
            }
        }
        return pattern;
    },

    /**
     *  保留2位
     */
    retain2wei: function (data) {
        try {
            return Math.floor(data * 100) / 100
        } catch (e) {
            return 0;
        }

    },


    /**
     *  判断字符串是否为空
     */
    isStringNull: function (str) {
        if (str == null) return true;
        if (str == "") return true;
        if (str == undefined) return true;
        var regu = "^[ ]+$";
        var re = new RegExp(regu);
        return re.test(str);
    },


    /**
     *  读取 cookie
     */
    getValueInCookie: function (name) {
        var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
        if (arr = document.cookie.match(reg))
            return (arr[2]);
        else
            return null;
    },

    /**
     *  original ajax
     */

    createXMLHTTPRequest: function () {
        //1.创建XMLHttpRequest对象
        //这是XMLHttpReuquest对象无部使用中最复杂的一步
        //需要针对IE和其他类型的浏览器建立这个对象的不同方式写不同的代码
        var xmlHttpRequest;
        if (window.XMLHttpRequest) {
            //针对FireFox，Mozillar，Opera，Safari，IE7，IE8
            xmlHttpRequest = new XMLHttpRequest();
            //针对某些特定版本的mozillar浏览器的BUG进行修正
            if (xmlHttpRequest.overrideMimeType) {
                xmlHttpRequest.overrideMimeType("text/xml");
            }
        } else if (window.ActiveXObject) {
            //针对IE6，IE5.5，IE5
            //两个可以用于创建XMLHTTPRequest对象的控件名称，保存在一个js的数组中
            //排在前面的版本较新
            var activexName = ["MSXML2.XMLHTTP", "Microsoft.XMLHTTP"];
            for (var i = 0; i < activexName.length; i++) {
                try {
                    //取出一个控件名进行创建，如果创建成功就终止循环
                    //如果创建失败，回抛出异常，然后可以继续循环，继续尝试创建
                    xmlHttpRequest = new ActiveXObject(activexName[i]);
                    if (xmlHttpRequest) {
                        break;
                    }
                } catch (e) {
                }
            }
        }
        return xmlHttpRequest;
    }


}