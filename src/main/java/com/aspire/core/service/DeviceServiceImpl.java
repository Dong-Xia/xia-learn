package com.aspire.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aspire.core.bean.Device;
import com.aspire.core.dao.DeviceDao;

@Service
public class DeviceServiceImpl implements DeviceService {

	@Resource
	private DeviceDao deviceDao;
	
	@Override
	public List<Device> findDefault() {
		return deviceDao.findDefault();
	}

	@Override
	public void changeStatus(String deviceId) {
		deviceDao.changStatus(deviceId);
	}

	@Override
	public List<Device> addDevice(Device device) {
		deviceDao.addDevice(device);
		return deviceDao.findDefault();
	}
}
