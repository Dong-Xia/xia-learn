package com.aspire.core.service;

import java.util.List;
import java.util.Map;

import com.aspire.core.bean.Device;
import com.aspire.core.bean.DeviceQuery;
import com.aspire.core.bean.TempDevice;


public interface TempDeviceService {

	Map<String,Object> queryTempList();

	int countPages(DeviceQuery deviceQuery);

	List<Device> addDevice(String deviceName, String firmVersion, String deviceStatus);

	List<TempDevice> queryDeviceByPage(DeviceQuery deviceQuery);

	TempDevice changeStatus(String deviceId);




}
