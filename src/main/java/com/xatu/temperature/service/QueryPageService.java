package com.xatu.temperature.service;

import com.alibaba.fastjson.JSONArray;
import com.xatu.temperature.common.HttpUtil;
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

    static final String GET_CITY_24_AQI = "http://113.140.66.226:8024/sxAQIWeb/ashx/getCity_24AQI.ashx?cityName=610100";
    static final String GET_CITY_7_DAY_AQI = "http://113.140.66.226:8024/sxAQIWeb/ashx/getCity_7DayAQI.ashx?cityName=610100";
    static final String GET_DISTRICT_24_ND = "http://113.140.66.226:8024/sxAQIWeb/ashx/getDistrict_24Nd.ashx?cityCode=610100";
    static final String GET_DISTRICT_24_IAQI = "http://113.140.66.226:8024/sxAQIWeb/ashx/getDistrict_24IAQI.ashx?cityCode=610100";


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

    public String getCity_24AQI() {
        return HttpUtil.sendGet(GET_CITY_24_AQI);
    }

    public String getCity_7DayAQI() {
        return HttpUtil.sendGet(GET_CITY_7_DAY_AQI);
    }

    public String getDistrict_24Nd() {
        return HttpUtil.sendGet(GET_DISTRICT_24_ND);
    }

    public String getDistrict_24IAQI() {
        return HttpUtil.sendGet(GET_DISTRICT_24_IAQI);
    }


}
