package com.xatu.temperature.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "environment_info_curr_history", schema = "hjjkdb", catalog = "")
public class EnvironmentInfoCurrHistoryEntity {
    private String deviceId;
    private String deviceLocation;
    private String deviceName;
    private Date time;
    private Double temper;
    private Double humidity;
    private Double oxygen;
    private Double pm10;
    private Double co2;
    private Double ch4;
    private Double co;
    private Double ch2O;
    private Double voc;
    private Double ozone;
    private Double noise;
    private Double pm25;

    @Id
    @Column(name = "device_id")
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Basic
    @Column(name = "device_location")
    public String getDeviceLocation() {
        return deviceLocation;
    }

    public void setDeviceLocation(String deviceLocation) {
        this.deviceLocation = deviceLocation;
    }

    @Basic
    @Column(name = "device_name")
    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    @Basic
    @Column(name = "time")
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Basic
    @Column(name = "temper")
    public Double getTemper() {
        return temper;
    }

    public void setTemper(Double temper) {
        this.temper = temper;
    }

    @Basic
    @Column(name = "humidity")
    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    @Basic
    @Column(name = "oxygen")
    public Double getOxygen() {
        return oxygen;
    }

    public void setOxygen(Double oxygen) {
        this.oxygen = oxygen;
    }

    @Basic
    @Column(name = "PM10")
    public Double getPm10() {
        return pm10;
    }

    public void setPm10(Double pm10) {
        this.pm10 = pm10;
    }

    @Basic
    @Column(name = "CO2")
    public Double getCo2() {
        return co2;
    }

    public void setCo2(Double co2) {
        this.co2 = co2;
    }

    @Basic
    @Column(name = "CH4")
    public Double getCh4() {
        return ch4;
    }

    public void setCh4(Double ch4) {
        this.ch4 = ch4;
    }

    @Basic
    @Column(name = "CO")
    public Double getCo() {
        return co;
    }

    public void setCo(Double co) {
        this.co = co;
    }

    @Basic
    @Column(name = "CH2O")
    public Double getCh2O() {
        return ch2O;
    }

    public void setCh2O(Double ch2O) {
        this.ch2O = ch2O;
    }

    @Basic
    @Column(name = "VOC")
    public Double getVoc() {
        return voc;
    }

    public void setVoc(Double voc) {
        this.voc = voc;
    }

    @Basic
    @Column(name = "OZONE")
    public Double getOzone() {
        return ozone;
    }

    public void setOzone(Double ozone) {
        this.ozone = ozone;
    }

    @Basic
    @Column(name = "NOISE")
    public Double getNoise() {
        return noise;
    }

    public void setNoise(Double noise) {
        this.noise = noise;
    }

    @Basic
    @Column(name = "pm2_5")
    public Double getPm25() {
        return pm25;
    }

    public void setPm25(Double pm25) {
        this.pm25 = pm25;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnvironmentInfoCurrHistoryEntity that = (EnvironmentInfoCurrHistoryEntity) o;
        return Objects.equals(deviceId, that.deviceId) &&
                Objects.equals(deviceLocation, that.deviceLocation) &&
                Objects.equals(deviceName, that.deviceName) &&
                Objects.equals(time, that.time) &&
                Objects.equals(temper, that.temper) &&
                Objects.equals(humidity, that.humidity) &&
                Objects.equals(oxygen, that.oxygen) &&
                Objects.equals(pm10, that.pm10) &&
                Objects.equals(co2, that.co2) &&
                Objects.equals(ch4, that.ch4) &&
                Objects.equals(co, that.co) &&
                Objects.equals(ch2O, that.ch2O) &&
                Objects.equals(voc, that.voc) &&
                Objects.equals(ozone, that.ozone) &&
                Objects.equals(noise, that.noise) &&
                Objects.equals(pm25, that.pm25);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, deviceLocation, deviceName, time, temper, humidity, oxygen, pm10, co2, ch4, co, ch2O, voc, ozone, noise, pm25);
    }
}
