package com.xatu.temperature.dao;

import com.xatu.temperature.entity.DeviceInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 3 on 2018/9/29.
 */
@Repository
public interface DeviceInfoRepository extends JpaRepository<DeviceInfo,Integer>{

}
