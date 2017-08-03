package com.aspire.core.dao;

import java.util.List;

import com.aspire.core.bean.Device;
import com.aspire.core.bean.DeviceQuery;

public interface DeviceDao {
	public List<Device> findDefault(DeviceQuery deviceQuery);

	public void changStatus(String deviceId);

	public void addDevice(Device device);

	public int getCountRecouds(DeviceQuery deviceQuery);

	public List<Device> queryDeviceByPage(DeviceQuery deviceQuery);

}
