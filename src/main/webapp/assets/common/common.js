/**
 * Created by xl38154 on 2017/1/5.
 */
/**
 *  modal
 */
$.fn.modal.Constructor.DEFAULTS.keyboard = false
$.fn.modal.Constructor.DEFAULTS.backdrop = 'static'

/**
 *  domain
 */
var ZOOKEEPER_WEB_ADMIN_CONFIG = {
    domain: 'http://localhost:8080/zookeeper-admin',
    environment : 'test',

    isLogin: true,
    unameKey: 'zkAdmin_unameKey'
}


/**
 *  检测是否登录
 */
var winHref = window.document.location.href;
if (winHref != ZOOKEEPER_WEB_ADMIN_CONFIG.domain && winHref != ZOOKEEPER_WEB_ADMIN_CONFIG.domain + '/') {
    var uname = $.cookie(ZOOKEEPER_WEB_ADMIN_CONFIG.unameKey)
    if (CommonUtil.isStringNull(uname)) {
        window.location.replace(ZOOKEEPER_WEB_ADMIN_CONFIG.domain);
        // window.document.location.href =
    }
}

var ajaxHttpRequest = CommonUtil.createXMLHTTPRequest();
if(ajaxHttpRequest){
    ajaxHttpRequest.open("GET", ZOOKEEPER_WEB_ADMIN_CONFIG.domain + "/system/checkOK", true);
    ajaxHttpRequest.onreadystatechange = function(){
        if(ajaxHttpRequest.readyState == 4){
            if(ajaxHttpRequest.status != 200 && ZOOKEEPER_WEB_ADMIN_CONFIG.environment != 'test'){
                window.location.replace(ZOOKEEPER_WEB_ADMIN_CONFIG.domain);
            }else{

            }
        }
    }
    ajaxHttpRequest.send(null);
}



$(function () {
    $("#loginUname").html($.cookie(ZOOKEEPER_WEB_ADMIN_CONFIG.unameKey));
    $("#exitSystemB").click(function () {
        //$.cookie(ZOOKEEPER_WEB_ADMIN_CONFIG.domain, '', {path: '/', expires: -1});
        $.cookie(ZOOKEEPER_WEB_ADMIN_CONFIG.unameKey, null, {path: '/', expires: new Date()});
        window.location.replace(ZOOKEEPER_WEB_ADMIN_CONFIG.domain);
    })


    /**
     *  vue filter
     */
    Vue.filter('timestamp',
        <!-- value 格式为13位unix时间戳 -->
        <!-- 10位unix时间戳可通过value*1000转换为13位格式 -->
        function (value) {


            // alert(value)

            if (CommonUtil.isStringNull(value)) {
                return ''
            }

            var date = new Date(value);
            y = date.getFullYear();
            M = date.getMonth() + 1;
            d = date.getDate();
            H = date.getHours();
            m = date.getMinutes();
            s = date.getSeconds();
            S = date.getMilliseconds();

            if (M < 10) {
                M = '0' + M;
            }
            if (d < 10) {
                d = '0' + d;
            }
            if (H < 10) {
                H = '0' + H;
            }
            if (m < 10) {
                m = '0' + m;
            }
            if (s < 10) {
                s = '0' + s;
            }
            <!-- 获取时间格式 2017-01-03 10:13:48   yyyyMMdd HHmmss.S-->
            // var t = Y+'-'+m+'-'+d+' '+H+':'+i+':'+s;
            <!-- 获取时间格式 2017-01-03 -->
            var t = y + '-' + M + '-' + d + ' ' + H + ':' + m + ':' + s + '.' + S;


            console.log(t)
            return t;
        });


})


/**
 *  global data
 */


/**
 *  TODO menus
 */
// $(function () {
//     var navListVue = new Vue({
//         el: '#nav-list',
//         data: {
//             navMenus: []
//         },
//         methods: {
//             showNavMenu: function () {
//                 var _self = this;
//
//                 $.ajax({
//                     type: "get",
//                     url: ZOOKEEPER_WEB_ADMIN_CONFIG.domain + "/system/getMenus",
//                     async: false,
//                     success: function (resObj) {
//                         var datas = resObj.data;
//                         _self.navMenus = datas;
//                     }
//                 });
//
//             }
//         }
//     })
//
//     navListVue.showNavMenu()
// })


























