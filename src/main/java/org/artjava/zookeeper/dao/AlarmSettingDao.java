package org.artjava.zookeeper.dao;

import org.artjava.zookeeper.entities.model.AlarmSetting;
import org.artjava.zookeeper.exception.DaoException;

/**
 * @author artJava
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
