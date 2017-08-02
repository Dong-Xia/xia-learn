package com.aspire.core.service;

import java.util.List;

import com.aspire.core.bean.Device;

public interface DeviceService {
	public List<Device> findDefault();

	public void changeStatus(String deviceId);

	public List<Device> addDevice(Device device);

	public List<Device> queryDeviceByPage(Device device, String pageNo, String startTime, String endTime);


}
