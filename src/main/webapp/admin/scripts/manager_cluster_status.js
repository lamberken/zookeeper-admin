var status_charts = function () {

    // 流量图
    var chart03;
    var chart03_option = {
        title: {
            // text: '实时流量',
            x: 'left',
            textStyle: {
                fontSize: 18,
                fontWeight: 'bold',
                color: '#333'
            }
        },
        toolbox: {
            show: true,
            feature: {
                mark: {show: true},
                dataView: {readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                saveAsImage: {show: true}
            }
        },
        // tooltip: {
        //     trigger: 'item',
        //     formatter: '{a} <br/>{b} : {c}'
        // },

        tooltip: {
            trigger: 'axis'
        },

        legend: {
            left: 'center',
            data: ['发送', '接收'],
            selected: {
                '总共可预订': false
            }
        },
        dataZoom: {
            show: true,
            realtime: true,
            start: 20,
            end: 100
        },
        xAxis: {
            type: 'category',
            boundaryGap: true,
            data: []
        },
        yAxis: [
            {
                type: 'value',
                axisLabel: {
                    formatter: '{value} 个'
                }
            }
        ],
        series: [
            {
                name: '发送',
                type: 'line',
                data: []
            },
            {
                name: '接收',
                type: 'line',
                data: []
            }
        ]
    };

    // 事物处理
    var chart04;
    var chart04_option = {
        title: {
            // text: '事物处理',
            x: 'left',
            textStyle: {
                fontSize: 18,
                fontWeight: 'bold',
                color: '#333'
            }
        },
        grid: {
            bottom: 80
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                animation: false
            }
        },
        legend: {
            data: ['平均事物处理数量', '未处理的请求数量', '事物处理平均延时'],
        },
        dataZoom: [
            {
                show: true,
                realtime: true,
                start: 0,
                end: 85
            }
        ],
        xAxis: [
            {
                type: 'category',
                boundaryGap: false,
                axisLine: {onZero: false},
                data: []
            }
        ],
        yAxis: [
            {
                name: '个/s',
                type: 'value'
            },
            {
                name: 'ms',
                type: 'value'
            }

        ],
        series: [
            {
                name: '平均事物处理数量',
                type: 'line',
                data: []
            },
            {
                name: '未处理的请求数量',
                type: 'line',
                data: []
            },
            {
                name: '事物处理平均延时',
                type: 'line',
                yAxisIndex: 1,
                data: []
            }
        ]
    };

    return {
        init: function () {
            chart03 = echarts.init(document.getElementById('chart03'));
            chart03.setOption(chart03_option);

            chart04 = echarts.init(document.getElementById('chart04'));
            chart04.setOption(chart04_option);
        },

        getCharts: function () {
            return {
                chart03: chart03,
                chart04: chart04
            }
        }
    }

}()


$(function () {

})