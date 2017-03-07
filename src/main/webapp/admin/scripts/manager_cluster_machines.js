var machine_status_charts = function () {

    // data
    var chart03;
    var chart03_option = {
        title: {
            text: 'Data 数据',
            //subtext: '纯属虚构',
            x: 'left',
            textStyle: {
                fontSize: 15,
                fontWeight: 'bold',
                color: '#333'
            }
        },

        toolbox: {
            show: true,
            feature: {
                mark: {show: true},
                dataView: {readOnly: false},
                // magicType: {show: true, type: ['line', 'bar']},
                saveAsImage: {show: true}
            }
        },
        tooltip: {
            trigger: 'item',
            formatter: function (params) {

                console.log(params)

                var type = params.componentSubType;
                if (type == 'pie') {
                    var tip = params.seriesName + '<br>'
                    tip += '&nbsp;&nbsp;' + params.name + ": " + params.value + 'MB';

                    return tip
                }

                if (type == 'line') {
                    return params.seriesName + ": " + params.value + 'MB';
                }


            }
        },

        legend: {
            left: 'center',
            data: ['数据大小', , '当前数据'],
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
            data: [1, 2, 3, 4]
        },
        yAxis: [
            {
                type: 'value',
                axisLabel: {
                    formatter: '{value} MB'
                }
            }
        ],
        series: [
            {
                name: '数据大小',
                type: 'line',
                data: [25, 65]
            },
            {
                name: '当前数据',
                type: 'pie',
                center: ['75%', '35%'],
                radius: '28%',
                data: [
                    {value: 335, name: '已用空间'},
                    {value: 310, name: '剩余空间'}
                ]
            }
        ]
    };

    // 事物处理
    var chart04;
    var chart04_option = {
        title: {
            text: 'Data log 数据',
            //subtext: '纯属虚构',
            x: 'left',
            textStyle: {
                fontSize: 15,
                fontWeight: 'bold',
                color: '#333'
            }
        },

        toolbox: {
            show: true,
            feature: {
                mark: {show: true},
                dataView: {readOnly: false},
                // magicType: {show: true, type: ['line', 'bar']},
                saveAsImage: {show: true}
            }
        },
        tooltip: {
            trigger: 'item',
            formatter: function (params) {

                console.log(params)

                var type = params.componentSubType;
                if (type == 'pie') {
                    var tip = params.seriesName + '<br>'
                    tip += '&nbsp;&nbsp;' + params.name + ": " + params.value + 'MB';

                    return tip
                }

                if (type == 'line') {
                    return params.seriesName + ": " + params.value + 'MB';
                }


            }
        },

        legend: {
            left: 'center',
            data: ['数据大小', '当前数据'],
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
                    formatter: '{value} MB'
                }
            }
        ],
        series: [
            {
                name: '数据大小',
                type: 'line',
                data: []
            },
            {
                name: '当前数据',
                type: 'pie',
                center: ['75%', '35%'],
                radius: '28%',
                data: [
                    {value: 335, name: '已用空间'},
                    {value: 310, name: '剩余空间'}
                ]
            }
        ]
    };

    var chart05;
    var chart05_option = {
        title: {
            text: 'CPU 数据',
            //subtext: '纯属虚构',
            x: 'left',
            textStyle: {
                fontSize: 15,
                fontWeight: 'bold',
                color: '#333'
            }
        },

        toolbox: {
            show: true,
            feature: {
                mark: {show: true},
                dataView: {readOnly: false},
                // magicType: {show: true, type: ['line', 'bar']},
                saveAsImage: {show: true}
            }
        },
        tooltip: {
            trigger: 'item',
            formatter: function (params) {

                console.log(params)

                var type = params.componentSubType;
                if (type == 'pie') {
                    var tip = params.seriesName + '<br>'
                    tip += '&nbsp;&nbsp;' + params.name + ": " + params.value + 'MB';

                    return tip
                }

                if (type == 'line') {
                    return params.seriesName + ": " + params.value + 'MB';
                }


            }
        },

        legend: {
            left: 'center',
            data: ['使用率', '当前数据'],
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
                    formatter: '{value} %'
                }
            }
        ],
        series: [
            {
                name: '使用率',
                type: 'line',
                data: []
            },
            {
                name: '当前数据',
                type: 'pie',
                center: ['75%', '35%'],
                radius: '28%',
                data: [
                    {value: 335, name: '已用'},
                    {value: 310, name: '未用'}
                ]
            }
        ]
    };

    var chart06;
    var chart06_option = {
        title: {
            text: 'Memory 数据',
            //subtext: '纯属虚构',
            x: 'left',
            textStyle: {
                fontSize: 15,
                fontWeight: 'bold',
                color: '#333'
            }
        },

        toolbox: {
            show: true,
            feature: {
                mark: {show: true},
                dataView: {readOnly: false},
                // magicType: {show: true, type: ['line', 'bar']},
                saveAsImage: {show: true}
            }
        },
        tooltip: {
            trigger: 'item',
            formatter: function (params) {

                console.log(params)

                var type = params.componentSubType;
                if (type == 'pie') {
                    var tip = params.seriesName + '<br>'
                    tip += '&nbsp;&nbsp;' + params.name + ": " + params.value + 'MB';

                    return tip
                }

                if (type == 'line') {
                    return params.seriesName + ": " + params.value + 'MB';
                }


            }
        },

        legend: {
            left: 'center',
            data: ['使用率', '当前数据'],
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
                    formatter: '{value} %'
                }
            }
        ],
        series: [
            {
                name: '使用率',
                type: 'line',
                data: []
            },
            {
                name: '当前数据',
                type: 'pie',
                center: ['75%', '35%'],
                radius: '28%',
                data: [
                    {value: 335, name: '已用'},
                    {value: 310, name: '未用'}
                ]
            }
        ]
    };

    var chart07;
    var chart07_option = {
        title: {
            text: '网络IO 数据',
            //subtext: '纯属虚构',
            x: 'left',
            textStyle: {
                fontSize: 15,
                fontWeight: 'bold',
                color: '#333'
            }
        },

        toolbox: {
            show: true,
            feature: {
                mark: {show: true},
                dataView: {readOnly: false},
                // magicType: {show: true, type: ['line', 'bar']},
                saveAsImage: {show: true}
            }
        },
        tooltip: {},

        legend: {
            left: 'center',
            data: ['实时网络'],
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
                    formatter: '{value} MB'
                }
            }
        ],
        series: [
            {
                name: '实时网络',
                type: 'line',
                data: []
            }
        ]
    };

    var chart08;
    var chart08_option = {
        title: {
            text: '硬盘 数据',
            //subtext: '纯属虚构',
            x: 'left',
            textStyle: {
                fontSize: 15,
                fontWeight: 'bold',
                color: '#333'
            }
        },

        toolbox: {
            show: true,
            feature: {
                mark: {show: true},
                dataView: {readOnly: false},
                // magicType: {show: true, type: ['line', 'bar']},
                saveAsImage: {show: true}
            }
        },
        tooltip: {
            trigger: 'item',
            formatter: function (params) {

                console.log(params)

                var type = params.componentSubType;
                if (type == 'pie') {
                    var tip = params.seriesName + '<br>'
                    tip += '&nbsp;&nbsp;' + params.name + ": " + params.value + 'MB';

                    return tip
                }

                if (type == 'line') {
                    return params.seriesName + ": " + params.value + 'MB';
                }


            }
        },

        legend: {
            left: 'center',
            data: ['使用率', '当前数据'],
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
                    formatter: '{value} MB'
                }
            }
        ],
        series: [
            {
                name: '使用率',
                type: 'line',
                data: []
            },
            {
                name: '当前数据',
                type: 'pie',
                center: ['75%', '35%'],
                radius: '28%',
                data: [
                    {value: 335, name: '已用'},
                    {value: 310, name: '未用'}
                ]
            }
        ]
    };

    return {
        init: function () {
            chart03 = echarts.init(document.getElementById('chart03'));
            chart03.setOption(chart03_option);

            chart04 = echarts.init(document.getElementById('chart04'));
            chart04.setOption(chart04_option);

            chart05 = echarts.init(document.getElementById('chart05'));
            chart05.setOption(chart05_option);

            chart06 = echarts.init(document.getElementById('chart06'));
            chart06.setOption(chart06_option);

            chart07 = echarts.init(document.getElementById('chart07'));
            chart07.setOption(chart07_option);

            chart08 = echarts.init(document.getElementById('chart08'));
            chart08.setOption(chart08_option);


        },

        getCharts: function () {
            return {
                chart03: chart03,
                chart04: chart04
            }
        },

        clearChartData: function () {
            // chart03.setOption({series: [{data: []}]});
        }

    }

}()


$(function () {

})