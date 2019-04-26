package com.xatu.temperature.dao;

import com.xatu.temperature.entity.EnvironmentInfoCurrHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by 3 on 2018/9/29.
 */
@Repository
public interface EnvironmentInfoCurrHistoryRepository extends JpaRepository<EnvironmentInfoCurrHistoryEntity,String>{

    @Query(nativeQuery = true,value = "SELECT t1.time from environment_info_curr_history t1 GROUP BY t1.time")
    List<Timestamp> getAllTimes();
    @Query(nativeQuery = true,value = "SELECT * from environment_info_curr_history t1 where  t1.time <= from_unixtime(?1) && t1.time >= from_unixtime(?2)")
    List<EnvironmentInfoCurrHistoryEntity> getAllByTime(Long time1,Long time2);
}
