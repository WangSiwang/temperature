package com.xatu.temperature.service;

import com.alibaba.fastjson.JSONArray;
import com.xatu.temperature.dao.DeviceInfoRepository;
import com.xatu.temperature.dao.EnvironmentInfoCurrRepository;
import com.xatu.temperature.dao.EnvironmentInfoHistoryRepository;
import com.xatu.temperature.entity.DeviceInfo;
import com.xatu.temperature.entity.EnvironmentInfoCurr;
import com.xatu.temperature.entity.EnvironmentInfoHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 3 on 2018/9/29.
 */
@Service
public class QueryPageService {

    @Autowired
    EnvironmentInfoCurrRepository environmentInfoCurrRepository;
    @Autowired
    EnvironmentInfoHistoryRepository environmentInfoHistoryRepository;
    @Autowired
    DeviceInfoRepository deviceInfoRepository;

//    @Autowired
//    QueryHistoryDao queryHistoryDao;

    public String getCurrInfo() {
        List<EnvironmentInfoCurr> all1 = environmentInfoCurrRepository.findAll();
        return JSONArray.toJSON(all1).toString();
    }

    public String getHistoryInfo() {
        List<EnvironmentInfoHistory> all = environmentInfoHistoryRepository.findAll();
        return JSONArray.toJSON(all).toString();
    }

    public String getDeviceInfo() {
        List<DeviceInfo> all = deviceInfoRepository.findAll();
        return JSONArray.toJSON(all).toString();
    }

    public String getCurrInfoByDeviceId(String device_id) {
        return null;
    }
}
