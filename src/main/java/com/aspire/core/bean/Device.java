package com.aspire.core.bean;

import java.util.Date;

/**
 * 设备持久化类
 * @author xia
 *
 */
public class Device {
	private String deviceId;
	private String deviceName;
	private String firmVersion;
	private Date recordDateTime;
	private Integer deviceStatus;
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getFirmVersion() {
		return firmVersion;
	}
	public void setFirmVersion(String firmVersion) {
		this.firmVersion = firmVersion;
	}
	public Date getRecordDateTime() {
		return recordDateTime;
	}
	public void setRecordDateTime(Date recordDateTime) {
		this.recordDateTime = recordDateTime;
	}
	public Integer getDeviceStatus() {
		return deviceStatus;
	}
	public void setDeviceStatus(Integer deviceStatus) {
		this.deviceStatus = deviceStatus;
	}
	
	
}
