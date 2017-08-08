package com.aspire.core.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aspire.commom.unit.StringAndNumberRandom;
import com.aspire.core.bean.Device;
import com.aspire.core.bean.DeviceQuery;
import com.aspire.core.bean.TempDevice;
import com.aspire.core.dao.DeviceDao;
import com.aspire.core.dao.TempDeviceDao;

@Service
public class TempDeviceServiceImpl implements TempDeviceService{

	@Resource
	private TempDeviceDao tempdeviceDao;
	@Resource
	private DeviceDao deviceDao;
	@Override
	public Map<String,Object> queryTempList() {
		int pageSize=5;    //每页大小
		int pageNumber=1;
		int pages=pageSize*(pageNumber-1);    //所在页的数据起始位置
		DeviceQuery tempDeviceQuery=new DeviceQuery();
		tempDeviceQuery.setStartRow(pages);
		tempDeviceQuery.setPageSize(pageSize);
		tempDeviceQuery.setDeviceId(null);
		tempDeviceQuery.setDeviceName(null);
		tempDeviceQuery.setDeviceStatus(2);
		tempDeviceQuery.setDeviceVersion(null);
		tempDeviceQuery.setStartTime(null);
		tempDeviceQuery.setStartTime(null);
		List<TempDevice> tempList=tempdeviceDao.queryTempList(tempDeviceQuery);
		
		Map<String,Object> tempMap=new HashMap<String,Object>();
		tempMap.put("tempDeviceQuery", tempDeviceQuery);
		tempMap.put("tempList", tempList);
		return tempMap;
	}
	@Override
	public int countPages(DeviceQuery deviceQuery) {
		int totalRecouds=tempdeviceDao.getCountRecouds(deviceQuery);  //获取记录的总数
		Integer totalpages=totalRecouds%deviceQuery.getPageSize()==0?totalRecouds/deviceQuery.getPageSize():totalRecouds/deviceQuery.getPageSize()+1;   //计算总页数
		return totalpages;
	}
	@Override
	public List<Device> addDevice(String deviceName, String firmVersion, String deviceStatus) {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = dateFormat.format(new Date());
		
		String deviceId=date+StringAndNumberRandom.getStringRandom(6);
		
		Device device=new Device();
		device.setDeviceName(deviceName);
		device.setFirmVersion(firmVersion);
		device.setDeviceId(deviceId);
		device.setRecordDateTime(new Date());
	
		tempdeviceDao.addDevice(device);
		return null;
	}
	@Override
	public List<TempDevice> queryDeviceByPage(DeviceQuery deviceQuery) {
		List<TempDevice> tempList=tempdeviceDao.queryDeviceByPage(deviceQuery);
		return tempList;
	}
	@Override
	public TempDevice changeStatus(String deviceId) {
		TempDevice activationDevice = tempdeviceDao.getActivationDevice(deviceId);
		Device device=new Device();
		device.setDeviceId(activationDevice.getDeviceId());
		device.setDeviceName(activationDevice.getDeviceName());
		device.setDeviceStatus(2);
		device.setFirmVersion(activationDevice.getFirmVersion());
		device.setRecordDateTime(new Date());
		deviceDao.addDevice(device);
		//删除临时表中数据
		tempdeviceDao.delete(deviceId);
		return null;
	}

}
