package com.xatu.temperature.service;

import com.alibaba.fastjson.JSONArray;
import com.xatu.temperature.common.HttpUtil;
import com.xatu.temperature.dao.DeviceInfoRepository;
import com.xatu.temperature.dao.EnvironmentInfoCurrHistoryRepository;
import com.xatu.temperature.dao.EnvironmentInfoCurrRepository;
import com.xatu.temperature.dao.EnvironmentInfoHistoryRepository;
import com.xatu.temperature.entity.DeviceInfo;
import com.xatu.temperature.entity.EnvironmentInfoCurr;
import com.xatu.temperature.entity.EnvironmentInfoCurrHistoryEntity;
import com.xatu.temperature.entity.EnvironmentInfoHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    EnvironmentInfoCurrHistoryRepository environmentInfoCurrHistoryRepository;

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



    public String getTimeType() {
        List<String> allTimes = environmentInfoCurrHistoryRepository.getAllTimes();
        return JSONArray.toJSONString(allTimes);
    }


    public String getTimeTypeForPM2_5(String time) {
        List<EnvironmentInfoCurrHistoryEntity> allTimes = environmentInfoCurrHistoryRepository.getAllByTime(Long.parseLong(time)/1000,Long.parseLong(time)/1000);
        List<Map> list = new ArrayList();
        for (EnvironmentInfoCurrHistoryEntity allTime : allTimes) {
            Map map = new HashMap();
            map.put("pm25",allTime.getPm25());
            map.put("deviceId",allTime.getDeviceId());
            map.put("deviceName",allTime.getDeviceName());
            map.put("deviceLocation",allTime.getDeviceLocation());
            list.add(map);
        }
        return JSONArray.toJSONString(list);
    }

    public String getTimeTypeForPM10(String time) {
        List<EnvironmentInfoCurrHistoryEntity> allTimes = environmentInfoCurrHistoryRepository.getAllByTime(Long.parseLong(time)/1000,Long.parseLong(time)/1000);
        List<Map> list = new ArrayList();
        for (EnvironmentInfoCurrHistoryEntity allTime : allTimes) {
            Map map = new HashMap();
            map.put("pm10",allTime.getPm25());
            map.put("deviceId",allTime.getDeviceId());
            map.put("deviceName",allTime.getDeviceName());
            map.put("deviceLocation",allTime.getDeviceLocation());
            list.add(map);
        }
        return JSONArray.toJSONString(list);
    }
}
