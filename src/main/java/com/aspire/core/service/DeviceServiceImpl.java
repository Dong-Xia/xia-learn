package com.aspire.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aspire.core.bean.Device;
import com.aspire.core.bean.DeviceQuery;
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

	@Override
	public List<Device> queryDeviceByPage(Device device, String pageNo ,String startTime, String endTime) {
		int pageSize=5;    //每页大小
		int pageNumber=Integer.valueOf(pageNo);
		int pages=pageSize*(pageNumber-1);    //所在页的数据起始位置
		
		DeviceQuery deviceQuery=new DeviceQuery();
		deviceQuery.setStartRow(pages);
		deviceQuery.setPageSize(pageSize);
		deviceQuery.setDeviceId(device.getDeviceId());
		deviceQuery.setDeviceName(device.getDeviceName());
		deviceQuery.setDeviceStatus(device.getDeviceStatus());
		deviceQuery.setDeviceVersion(device.getFirmVersion());
		deviceQuery.setStartTime(startTime);
		deviceQuery.setStartTime(endTime);
		int totalRecouds=deviceDao.getCountRecouds(deviceQuery);  //获取记录的总数
		Integer totalpages=totalRecouds%pageSize==0?totalRecouds/pageSize:totalRecouds/pageSize+1;   //计算总页数
		List<Device> deviceList=deviceDao.queryDeviceByPage(deviceQuery);
		return deviceList;
	}
}
