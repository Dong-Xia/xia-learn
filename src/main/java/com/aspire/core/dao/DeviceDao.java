package com.aspire.core.dao;

import java.util.List;

import com.aspire.core.bean.Device;
import com.aspire.core.bean.TestTb;

public interface DeviceDao {
	public List<Device> findDefault();

	public void changStatus(String deviceId);

	public void addDevice(Device device);
}
