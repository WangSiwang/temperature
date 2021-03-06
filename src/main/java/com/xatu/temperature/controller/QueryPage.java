package com.xatu.temperature.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xatu.temperature.service.QueryPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/getCurrReLiInfo")
    @ResponseBody
    public  String getCurrReLiInfo(){
        String s = "[{\"lng\":109.004393,\"lat\":34.386154,\"count\":180},{\"lng\":109.010058,\"lat\":34.378221,\"count\":203},{\"lng\":109.013147,\"lat\":34.380842,\"count\":181},{\"lng\":109.012032,\"lat\":34.374962,\"count\":179},{\"lng\":109.013662,\"lat\":34.364123,\"count\":176},{\"lng\":108.998728,\"lat\":34.386296,\"count\":184},{\"lng\":108.997526,\"lat\":34.378716,\"count\":173},{\"lng\":108.995295,\"lat\":34.368444,\"count\":186},{\"lng\":108.983278,\"lat\":34.385162,\"count\":177},{\"lng\":108.981819,\"lat\":34.380275,\"count\":172},{\"lng\":108.982163,\"lat\":34.371987,\"count\":187},{\"lng\":108.981304,\"lat\":34.369578,\"count\":181},{\"lng\":108.975296,\"lat\":34.386012,\"count\":176},{\"lng\":108.972464,\"lat\":34.379141,\"count\":179},{\"lng\":108.972464,\"lat\":34.374891,\"count\":176},{\"lng\":108.971691,\"lat\":34.371278,\"count\":184},{\"lng\":108.972635,\"lat\":34.368373,\"count\":184},{\"lng\":108.98654,\"lat\":34.379496,\"count\":189},{\"lng\":108.983879,\"lat\":34.381833,\"count\":184},{\"lng\":108.974695,\"lat\":34.378929,\"count\":176}]";
        JSONArray parse = (JSONArray) JSONObject.parse(s);
        return parse.toJSONString();
    }


    @GetMapping("/getCity_24AQI")
    @ResponseBody
    public  String getCity_24AQI(){
        return queryPageService.getCity_24AQI();
    }

    @GetMapping("/getCity_7DayAQI")
    @ResponseBody
    public  String getCity_7DayAQI(){
        return queryPageService.getCity_7DayAQI();
    }

    @GetMapping("/getDistrict_24Nd")
    @ResponseBody
    public  String getDistrict_24Nd(){
        return queryPageService.getDistrict_24Nd();
    }

    @GetMapping("/getDistrict_24IAQI")
    @ResponseBody
    public  String getDistrict_24IAQI(){
        return queryPageService.getDistrict_24IAQI();
    }


    @GetMapping("/getNumberType")
    @ResponseBody
    public  String getNumberType(){
        String time = queryPageService.getNumberType();
        return time;
    }

    @GetMapping("/getTimeTypeForPM2_5")
    @ResponseBody
    public  String getTimeTypeForPM2_5(@RequestParam String number){
        String data = queryPageService.getTimeTypeForPM2_5(number);
        return data;
    }

    @GetMapping("/getTimeTypeForPM10")
    @ResponseBody
    public  String getTimeTypeForPM10(@RequestParam  String number){
        String data = queryPageService.getTimeTypeForPM10(number);
        return data;
    }

}
