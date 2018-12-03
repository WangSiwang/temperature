package com.xatu.temperature.controller;

import com.xatu.temperature.service.QueryPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 3 on 2018/9/29.
 */
@Controller
public class QueryPage {

    @Autowired
    QueryPageService queryPageService;

    @GetMapping("/getCurrInfo")
    @ResponseBody
    public String getCurrInfo(){
        String currInfo = queryPageService.getCurrInfo();
        return currInfo;
    }

    @GetMapping("/getHistoryInfo")
    @ResponseBody
    public String getHistoryInfo(){
        String currInfo = queryPageService.getHistoryInfo();
        return currInfo;
    }
    @GetMapping("/getDeviceInfo")
    @ResponseBody
    public  String getDeviceInfo(){
        String currInfo = queryPageService.getDeviceInfo();
        return currInfo;
    }

//    @GetMapping("/getCurrInfoByDeviceId")
//    @ResponseBody
//    public  String getCurrInfoByDeviceId(@RequestParam String device_id){
//        String currInfo = queryPageService.getCurrInfoByDeviceId(device_id);
//        return currInfo;
//    }
}
