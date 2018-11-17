
# 重点 zookeeper-admin 第二版本即将发布，敬请等待
- 去除tomcat，采用spring-boot或者jetty方式开发
- 默认采用leveldb进行存储
- 打通与 docker.io 的通道，一键即可运行

<br />
# ZooKeeper Admin
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)

### 简介
Hadoop、Storm、Kafka、Hbase等大数据集群组件使用越来越多，依赖Zookeeper进行工作，自然而然ZooKeeper的维护工作尤为重要！！而，针对Zookeeper集群的监控工具相对较少或者监控比较片面。

基于此，Zookeeper Admin 应运而生！！

### 功能特点
- **集群配置**  支持多Zookeeper集群配置，动态增减监控集群
- **节点信息**  方便查询znode的 meta信息、acl信息及data值
- **集群状态**  集群状态一目了然，可视化显示集群中各服务器的实时状态，以及事物处理量等
- **监控方面**  实时监控预警，针对集群，可自定义设置监控项目，配置预警级别

### 相关
QQ 2217232293

### 主界面
![主界面](https://raw.githubusercontent.com/artJava/artJava-zookeeper-admin/master/src/main/webapp/assets/images/intro/dashboard1.png)



