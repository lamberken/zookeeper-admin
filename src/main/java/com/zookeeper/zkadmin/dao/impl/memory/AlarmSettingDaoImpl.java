package com.zookeeper.zkadmin.dao.impl.memory;

import com.zookeeper.zkadmin.dao.AlarmSettingDao;
import com.zookeeper.zkadmin.entities.model.AlarmSetting;
import com.zookeeper.zkadmin.exception.DaoException;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * org.artjava.zookeeper.dao.impl
 *
 * @author lamber-ken
 * @date 2017-02-09 18:04
 * @since JDK1.7
 */
@Repository
public class AlarmSettingDaoImpl implements AlarmSettingDao {

    //private static CacheClientHA redisClient = RedisUtil.getCallRedisUtil();
    Map<String, AlarmSetting> alarms_map = new ConcurrentHashMap<>();

    @Override public void updateAlarmSetting(AlarmSetting alarmSetting) throws DaoException {
        alarms_map.put(alarmSetting.getClusterID(), alarmSetting);
    }

    @Override public AlarmSetting getAlarmSetting(String clusterId) throws DaoException {
        return alarms_map.get(clusterId);
    }

    @Override public boolean removeAlarmSetting(String clusterID) throws DaoException {

        alarms_map.remove(clusterID);
        return true;

    }
}
