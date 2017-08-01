package com.aspire.core.controller;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aspire.core.bean.Device;
import com.aspire.core.service.DeviceService;

import net.sf.json.JSONObject;

@Controller
public class CenerController {
	
	@Autowired
	private DeviceService deviceService;
	//首页默认查询控制
	@RequestMapping(value="/device/findDefault")
	public String findDefault(Model model){
		
		List<Device> deviceList=deviceService.findDefault();
		model.addAttribute("deviceList",deviceList);
		return "/deviceList";
	}
	
	//激活设备控制
	@RequestMapping(value="/device/changeStatus")
	public String changeStatus(HttpServletRequest request,
			Model model){
		String deviceId=request.getParameter("deviceId");
		deviceService.changeStatus(deviceId);
		List<Device> deviceList=deviceService.findDefault();
		model.addAttribute("deviceList",deviceList);
		return "/deviceList";
	}
	
	//跳转添加设备页面
	@RequestMapping(value="/device/addDeviceJap")
	public String addDeviceJap(HttpServletRequest request,
			Model model){
		return "/addDevice";
	}
	
	//添加设备
	@RequestMapping(value="/device/addDevice")
	public String addDevice(HttpServletRequest request,HttpServletResponse response,
			Model model) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String deviceName=request.getParameter("deviceName");
		String firmVersion=request.getParameter("firmVersion");
		String deviceStatus=request.getParameter("deviceStatus");
		
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
		String date = dateFormat.format(new Date());
		
		//生成deviceId
		String[] datesplit=date.split(" ");
		String[] timesplit=datesplit[1].split(":");
		
		String deviceId=datesplit[0]+timesplit[0]+UUID.randomUUID().toString().replaceAll("-", "");
		
		Device device=new Device();
		device.setDeviceName(deviceName);
		device.setDeviceStatus(Integer.valueOf(deviceStatus));
		device.setFirmVersion(firmVersion);
		device.setDeviceId(deviceId);
		device.setRecordDateTime(new Date());
		
		//增加设备
	    List<Device> deviceList=deviceService.addDevice(device);
		model.addAttribute("deviceList",deviceList);
		
		return "/deviceList";
	}
}
