package com.xatu.temperature.common;


public class Conversion {
    public static Double pm2_5CcttsToAQI(Double data){
        if (data != null) {
            if(data<=0.100)
                return (50)/(0.100-0)*(data-0)+0;
            if(data<=0.160)
                return (100-50)/(0.160-0.100)*(data-0.100)+50;
            if(data<=0.215)
                return (150-100)/(0.215-0.160)*(data-0.160)+100;
            if(data<=0.800)
                return (200-150)/(0.800-0.215)*(data-0.215)+150;
        }
        return null;
    }
    public static Double pm2_5CAQIToctts(Double data){
        if (data != null) {
            if(data<=50)
                return (0.035-0)*(data-0)/(50)+0;
            if(data<=100)
                return (0.075-0.035)*(data-0.035)/(100-50)+0.035;
            if(data<=150)
                return (0.115-0.075)*(data-0.075)/(150-100)+0.075;
            if(data<=200)
                return (0.150-0.115)*(data-0.115)/(200-150)+0.115;
            if(data<=300)
                return (0.250-0.150)*(data-0.150)/(300-100)+0.150;
            if(data<=400)
                return (0.350-0.250)*(data-0.250)/(400-300)+0.250;
            if(data<=500)
                return (0.500-0.350)*( data-0.350)/(500-400)+0.350;
        }
        return null;
    }
    public static Double O3CcttsToAQI(Double data){
        if (data != null) {
            if(data<=0.100)
                return 50/(0.100-0)*(data-0)+0;
            if(data<=0.160)
                return (100-50)/(0.160-0.100)*(data-0.100)+50;
            if(data<=0.215)
                return (150-100)/(0.215-0.160)*(data-0.160)+100;
            if(data<=0.800)
                return (200-150)/(0.800-0.215)*(data-0.215)+150;
        }
        return null;
    }
    public static Double o3AQIToctts(Double data){
        if (data != null) {
            if(data<=50)
                return (0.100-0)*(data-0)/50+0;
            if(data<=100)
                return (0.160-0.100)*(data-0.100)/(100-50)+0.100;
            if(data<=150)
                return (0.215-0.160)*(data-0.160)/(200-150)+0.160;
            if(data<=0.800)
                return (0.800-0.215)*(data-0.215)/(300-200)+0.215;
        }
        return null;
    }
    public static Double coCcttsToAQI(Double data){
        if (data != null) {
            if(data<=2)
                return 50/2*(data-0)+0;
            if(data<=4)
                return (100-50)/(4-2)*(data-2)+50;
            if(data<=14)
                return (150-100)/(14-4)*(data-4)+100;
            if(data<=24)
                return (200-150)/(24-14)*(data-14)+150;
            if(data<=36)
                return (300-200)/(36-24)*(data-24)+200;
            if(data<=48)
                return (400-300)/(48-36)*(data-36)+300;
            if(data<=60)
                return (500-400)/(60-48)*(data-48)+400;

        }
        return null;
    }
    public static Double coCAQIToctts(Double data){
        if (data != null) {
            if(data<=50)
                return 2*(data-0)/50+0;
            if(data<=100)
                return (4-2)*(data-2)/(100-50)+2;
            if(data<=150)
                return (14-4)*(data-4)/(150-100)+4;
            if(data<=200)
                return (24-14)*(data-14)/(200-100)+14;
            if(data<=300)
                return (36-24)*(data-24)/(300-200)+24;
            if(data<=400)
                return (48-36)*(data-36)/(400-300)+36;
            if(data<=500)
                return (60-48)*(data-48)/(500-400)+48;
        }
        return null;
    }
    public static Double pm10CcttsToAQI(Double data){
        if (data != null) {
            if(data<=0.05)
                return 50/(0.05-0)*(data-0)+0;
            if(data<=0.15)
                return (100-50)/(0.15-0.05)*(data-0.05)+50;
            if(data<=0.25)
                return (150-100)/(0.25-0.15)*(data-0.15)+100;
            if(data<=0.35)
                return (200-150)/(0.35-0.25)*(data-0.25)+150;
            if(data<=0.42)
                return (300-200)/(0.42-0.35)*(data-0.35)+200;
            if(data<=0.50)
                return (400-300)/(0.50-0.42)*(data-0.42)+300;
            if(data<=0.60)
                return (500-400)/(0.60-0.50)*(data-0.50)+400;

        }
        return null;
    }
    public static Double pm10CAQIToctts(Double data){
        if (data != null) {
            if(data<=50)
                return (0.05-0)*(data-0)/50+0;
            if(data<=100)
                return (0.15-0.05)*(data-0.05)/(100-50)+0.050;
            if(data<=150)
                return (0.25-0.15)*(data-0.15)/(150-100)+0.150;
            if(data<=200)
                return (0.35-0.25)*(data-0.25)/(200-150)+0.250;
            if(data<=300)
                return (0.42-0.35)*(data-0.35)/(300-200)+0.350;
            if(data<=400)
                return (0.50-0.42)*(data-0.42)/(400-300)+0.420;
            if(data<=500)
                return (0.60-0.50)*( data-0.50)/(500-400)+0.500;

        }
        return null;
    }
    public static Double no2CcttsToAQI(Double data){
        if (data != null) {
            if(data<=0.04)
                return 50/(0.04-0)*(data-0)+0;
            if(data<=0.08)
                return (100-50)/(0.08-0.04)*(data-0.04)+50;
            if(data<=0.18)
                return (150-100)/(0.18-0.08)*(data-0.08)+100;
            if(data<=0.28)
                return (200-150)/(0.28-0.18)*(data-0.18)
                        +150;
            if(data<=0.565)
                return (300-200)/(0.565-0.28)*(data-0.28)+200;
            if(data<=0.75)
                return (400-300)/(0.75-0.565)*(data-0.565)+300;
            if(data<=0.94)
                return (500-400)/(0.94-0.75)*(data-0.75)+400;

        }
        return null;
    }
    public static Double no2CAQIToctts(Double data){
        if (data != null) {
            if(data<=50)
                return (0.04-0)*(data-0)/50+0;
            if(data<=100)
                return (0.08-0.04)*(data-0.04)/(100-50)+0.04;
            if(data<=150)
                return (0.18-0.08)*(data-0.08)/(150-100)+0.08;
            if(data<=200)
                return (0.28-0.18)*(data-0.18)/(200-150)+0.180;
            if(data<=300)
                return (0.565-0.28)*(data-0.28)/(300-200)+0.280;
            if(data<=400)
                return (0.75-0.565)*(data-0.565)/(400-300)+0.565;
            if(data<=500)
                return (0.94-0.75)*(data-0.75)/(500-400)+0.750;
        }
        return null;
    }
    public static Double so2CcttsToAQI(Double data){
        if (data != null) {
            if(data<=0.05)
                return 50/(0.05-0)*(data-0)+0;
            if(data<=0.15)
                return (100-50)/(0.15-0.05)*(data-0.05)+50;
            if(data<=0.475)
                return (150-100)/(0.475-0.150)*(data-0.150)+100;
            if(data<=0.8)
                return (200-150)/(0.8-0.475)*(data-0.475)+150;
            if(data<=1.6)
                return (300-200)/(1.6-0.8)*(data-1.6)+200;
            if(data<=2.1)
                return (400-300)/(2.1-1.6)*(data-1.6)+300;
            if(data<=2.62)
                return (500-400)/(2.62-2.1)*(data-2.1)+400;

        }
        return null;
    }
    public static Double so2CAQIToctts(Double data){
        if (data != null) {
            if(data<=50)
                return (0.05-0)*(data-0)/50+0;
            if(data<=100)
                return (0.15-0.05)*(data-0.05)/(100-50)+0.05;
            if(data<=150)
                return (0.475-0.150)*(data-0.150)/(150-100)+100;
            if(data<=200)
                return (0.8-0.475)*(data-0.475)/(200-150)+150;
            if(data<=300)
                return (1.6-0.8)*(data-1.6)/(300-200)+0.800;
            if(data<=400)
                return (2.1-1.6)*(data-1.6)/(400-300)+1.600;
            if(data<=500)
                return (2.62-2.1)*( data-2.1)/(500-400)+2.100;

        }
        return null;
    }


}
