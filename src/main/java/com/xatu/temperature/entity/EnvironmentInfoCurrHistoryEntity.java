package com.xatu.temperature.entity;

import javax.persistence.*;

@Entity
@Table(name = "environment_info_curr_history", schema = "hjjkdb", catalog = "")
public class EnvironmentInfoCurrHistoryEntity {
    private String deviceId;
    private Integer number;
    private Double pm25;
    private Double pm10;
    private Double temper;
    private Double humidity;
    private String deviceLocation;
    private int id;

    @Basic
    @Column(name = "device_id", nullable = false, length = 255)
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Basic
    @Column(name = "number", nullable = true)
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Basic
    @Column(name = "pm2_5", nullable = true, precision = 0)
    public Double getPm25() {
        return pm25;
    }

    public void setPm25(Double pm25) {
        this.pm25 = pm25;
    }

    @Basic
    @Column(name = "pm10", nullable = true, precision = 0)
    public Double getPm10() {
        return pm10;
    }

    public void setPm10(Double pm10) {
        this.pm10 = pm10;
    }

    @Basic
    @Column(name = "temper", nullable = true, precision = 0)
    public Double getTemper() {
        return temper;
    }

    public void setTemper(Double temper) {
        this.temper = temper;
    }

    @Basic
    @Column(name = "humidity", nullable = true, precision = 0)
    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    @Basic
    @Column(name = "device_location", nullable = true, length = 255)
    public String getDeviceLocation() {
        return deviceLocation;
    }

    public void setDeviceLocation(String deviceLocation) {
        this.deviceLocation = deviceLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EnvironmentInfoCurrHistoryEntity that = (EnvironmentInfoCurrHistoryEntity) o;

        if (deviceId != null ? !deviceId.equals(that.deviceId) : that.deviceId != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (pm25 != null ? !pm25.equals(that.pm25) : that.pm25 != null) return false;
        if (pm10 != null ? !pm10.equals(that.pm10) : that.pm10 != null) return false;
        if (temper != null ? !temper.equals(that.temper) : that.temper != null) return false;
        if (humidity != null ? !humidity.equals(that.humidity) : that.humidity != null) return false;
        if (deviceLocation != null ? !deviceLocation.equals(that.deviceLocation) : that.deviceLocation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deviceId != null ? deviceId.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (pm25 != null ? pm25.hashCode() : 0);
        result = 31 * result + (pm10 != null ? pm10.hashCode() : 0);
        result = 31 * result + (temper != null ? temper.hashCode() : 0);
        result = 31 * result + (humidity != null ? humidity.hashCode() : 0);
        result = 31 * result + (deviceLocation != null ? deviceLocation.hashCode() : 0);
        return result;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
