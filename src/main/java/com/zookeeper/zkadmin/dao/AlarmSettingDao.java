package com.zookeeper.zkadmin.dao;


import com.zookeeper.zkadmin.entities.model.AlarmSetting;
import com.zookeeper.zkadmin.exception.DaoException;

/**
 * @author lamber-ken
 * @date 2017-01-05 19:49
 * @since JDK1.7
 */
public interface AlarmSettingDao {


    /**
     * 添加或更新一个AlarmSetting集群
     */
    void updateAlarmSetting(AlarmSetting alarmSetting) throws DaoException;

    /**
     * 获取单个
     */
    AlarmSetting getAlarmSetting(String clusterId) throws DaoException;

    /** 删除集群 */
    boolean removeAlarmSetting(String clusterID) throws DaoException;


}
