package org.artjava.zookeeper.dao.impl.memory;

import org.artjava.zookeeper.exception.DaoException;
import org.artjava.zookeeper.dao.AlarmSettingDao;
import org.artjava.zookeeper.entities.model.AlarmSetting;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * org.artjava.zookeeper.dao.impl
 *
 * @author artJava
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
