package com.xatu.temperature.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "environment_info_curr")
public class EnvironmentInfoCurr {

    @Id
    @Column(name = "device_id")
    private String deviceId;
    @Column(name = "temper")
    private double temper;
    private double humidity;
    private double oxygen;
    @Column(name = "PM10")
    private double pm10;
    @Column(name = "PM2.5")
    private double pm2_5;
    @Column(name = "CO2")
    private double co2;
    @Column(name = "CH4")
    private double ch4;
    @Column(name = "CO")
    private double co;
    @Column(name = "CH2O")
    private double ch2O;
    @Column(name = "VOC")
    private double voc;
    @Column(name = "OZONE")
    private double ozone;
    @Column(name = "NOISE")
    private double noise;
    @Column(name = "update_time")
    private java.sql.Timestamp updateTime;


    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }


    public double getTemper() {
        return temper;
    }

    public void setTemper(double temper) {
        this.temper = temper;
    }


    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }


    public double getOxygen() {
        return oxygen;
    }

    public void setOxygen(double oxygen) {
        this.oxygen = oxygen;
    }


    public double getPm10() {
        return pm10;
    }

    public void setPm10(double pm10) {
        this.pm10 = pm10;
    }


    public double getPm2_5() {
        return pm2_5;
    }

    public void setPm2_5(double pm2_5) {
        this.pm2_5 = pm2_5;
    }


    public double getCo2() {
        return co2;
    }

    public void setCo2(double co2) {
        this.co2 = co2;
    }


    public double getCh4() {
        return ch4;
    }

    public void setCh4(double ch4) {
        this.ch4 = ch4;
    }


    public double getCo() {
        return co;
    }

    public void setCo(double co) {
        this.co = co;
    }


    public double getCh2O() {
        return ch2O;
    }

    public void setCh2O(double ch2O) {
        this.ch2O = ch2O;
    }


    public double getVoc() {
        return voc;
    }

    public void setVoc(double voc) {
        this.voc = voc;
    }


    public double getOzone() {
        return ozone;
    }

    public void setOzone(double ozone) {
        this.ozone = ozone;
    }


    public double getNoise() {
        return noise;
    }

    public void setNoise(double noise) {
        this.noise = noise;
    }


    public java.sql.Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(java.sql.Timestamp updateTime) {
        this.updateTime = updateTime;
    }

}
