package com.aspire.core.service;

import java.util.List;

import com.aspire.core.bean.Device;
import com.aspire.core.bean.DeviceQuery;

public interface DeviceService {
	public List<Device> findDefault(DeviceQuery deviceQuery);

	public void changeStatus(String deviceId);

	public List<Device> addDevice(Device device);

	public List<Device> queryDeviceByPage(DeviceQuery deviceQuery);

	public int countPages(DeviceQuery deviceQuery);

	List<Device> findDefault();


}
