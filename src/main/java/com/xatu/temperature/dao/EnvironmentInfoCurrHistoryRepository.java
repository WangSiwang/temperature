package com.xatu.temperature.dao;

import com.xatu.temperature.entity.EnvironmentInfoCurrHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 3 on 2018/9/29.
 */
@Repository
public interface EnvironmentInfoCurrHistoryRepository extends JpaRepository<EnvironmentInfoCurrHistoryEntity,String>{

    @Query(nativeQuery = true,value = "SELECT t1.number FROM environment_info_curr_history t1 GROUP BY t1.number ORDER BY t1.number")
    List<Integer> getAllTimes();
    @Query(nativeQuery = true,value = "SELECT * FROM environment_info_curr_history t1 where t1.number = ?1")
    List<EnvironmentInfoCurrHistoryEntity> getAllByTime(Integer number);
}
