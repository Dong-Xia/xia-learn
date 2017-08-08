package com.aspire.core.dao;

import java.util.List;

import com.aspire.core.bean.Device;
import com.aspire.core.bean.DeviceQuery;
import com.aspire.core.bean.TempDevice;

public interface TempDeviceDao {

		List<TempDevice> queryTempList(DeviceQuery deviceQuery);

		int getCountRecouds(Object object);

		void addDevice(Device device);

		List<TempDevice> queryDeviceByPage(DeviceQuery deviceQuery);

		TempDevice getActivationDevice(String deviceId);

		void delete(String deviceId);


}
