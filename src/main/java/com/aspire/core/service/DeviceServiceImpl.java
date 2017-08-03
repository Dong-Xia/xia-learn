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
	public List<Device> findDefault(DeviceQuery deviceQuery) {
		return deviceDao.findDefault(deviceQuery);
	}

	@Override
	public void changeStatus(String deviceId) {
		deviceDao.changStatus(deviceId);
	}

	@Override
	public List<Device> addDevice(Device device) {
		deviceDao.addDevice(device);
		int pageSize=5;    //每页大小
		int pageNumber=1;
		int pages=pageSize*(pageNumber-1);    //所在页的数据起始位置
		DeviceQuery deviceQuery=new DeviceQuery();
		deviceQuery.setStartRow(pages);
		deviceQuery.setPageSize(pageSize);
		deviceQuery.setDeviceId(null);
		deviceQuery.setDeviceName(null);
		deviceQuery.setDeviceStatus(null);
		deviceQuery.setDeviceVersion(null);
		deviceQuery.setStartTime(null);
		deviceQuery.setStartTime(null);
		return deviceDao.findDefault(deviceQuery);
	}

	@Override
	public List<Device> queryDeviceByPage(DeviceQuery deviceQuery) {
		List<Device> deviceList=deviceDao.queryDeviceByPage(deviceQuery);
		
		return deviceList;
	}

	@Override
	public int countPages(DeviceQuery deviceQuery) {
		int totalRecouds=deviceDao.getCountRecouds(deviceQuery);  //获取记录的总数
		Integer totalpages=totalRecouds%deviceQuery.getPageSize()==0?totalRecouds/deviceQuery.getPageSize():totalRecouds/deviceQuery.getPageSize()+1;   //计算总页数
		return totalpages;
	}

	@Override
	public List<Device> findDefault() {
		// TODO Auto-generated method stub
		return null;
	}
}
