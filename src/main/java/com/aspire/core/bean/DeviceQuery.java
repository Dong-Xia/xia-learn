package com.aspire.core.bean;

/**
 * 设备查询持久化类
 *
 * @author xia
 *
 */
public class DeviceQuery {
	//定义常量 每页数
	public final static int DEFAULT_SIZE = 5;
	//每页数
	protected int pageSize = DEFAULT_SIZE;
	//起始行
	protected int startRow;//起始行
	//页码
	protected int pageNo = 1;
	
	
	private String deviceName;
	private String deviceId;
	private String deviceVersion;
	private Integer deviceStatus;
	private String startTime;
	private String endTime;
	
	
	public Integer getDeviceStatus() {
		return deviceStatus;
	}
	public void setDeviceStatus(Integer deviceStatus) {
		this.deviceStatus = deviceStatus;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceVersion() {
		return deviceVersion;
	}
	public void setDeviceVersion(String deviceVersion) {
		this.deviceVersion = deviceVersion;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public static int getDefaultSize() {
		return DEFAULT_SIZE;
	}
	
	
}
