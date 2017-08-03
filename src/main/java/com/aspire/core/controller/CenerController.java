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
import org.springframework.web.bind.annotation.RequestMapping;

import com.aspire.core.bean.Device;
import com.aspire.core.bean.DeviceQuery;
import com.aspire.core.service.DeviceService;


@Controller
public class CenerController {
	
	@Autowired
	private DeviceService deviceService;
	//首页默认查询控制
	@RequestMapping(value="/device/findDefault")
	public String findDefault(HttpServletRequest request,HttpServletResponse response,Model model) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		int pageSize=5;    //每页大小
		int pageNumber=1;
		int pages=pageSize*(pageNumber-1);    //所在页的数据起始位置
		DeviceQuery deviceQuery=new DeviceQuery();
		deviceQuery.setStartRow(pages);
		deviceQuery.setPageSize(pageSize);
		deviceQuery.setDeviceId(null);
		deviceQuery.setDeviceName(null);
		deviceQuery.setDeviceStatus(2);
		deviceQuery.setDeviceVersion(null);
		deviceQuery.setStartTime(null);
		deviceQuery.setStartTime(null);
		List<Device> deviceList=deviceService.findDefault(deviceQuery);
		int countPages=deviceService.countPages(deviceQuery);
		model.addAttribute("countPages",countPages);
		model.addAttribute("deviceList",deviceList);
		model.addAttribute("pageNumber",pageNumber);
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
	
	//跳转添加设备页面
	@RequestMapping(value="/device/queryDevice")
	public String queryDevice(HttpServletRequest request,HttpServletResponse response,
			Model model) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String deviceName = request.getParameter("deviceName");
		String deviceId = request.getParameter("deviceId");
		String deviceVersion = request.getParameter("deviceVersion");
		String deviceStatus = request.getParameter("deviceStatus");
		String pageNo = request.getParameter("pageNumber");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String selectPage=request.getParameter("selectPage");
		
		Device device=new Device();
		device.setDeviceId(deviceId);
		device.setDeviceName(deviceName);
		if(deviceStatus!=null&&deviceStatus!=""){
			device.setDeviceStatus(Integer.valueOf(deviceStatus));
		}else{
			device.setDeviceStatus(2);
		}

		
		device.setFirmVersion(deviceVersion);
		
		int pageSize=5;    //每页大小
		int pageNumber;
		if(selectPage!=null){
			pageNumber=Integer.valueOf(selectPage);
		}else{
			pageNumber=Integer.valueOf(pageNo);
		}
		int pages=pageSize*(pageNumber-1);    //所在页的数据起始位置
		
		DeviceQuery deviceQuery=new DeviceQuery();
		deviceQuery.setStartRow(pages);
		deviceQuery.setPageSize(pageSize);
		deviceQuery.setDeviceId(device.getDeviceId());
		deviceQuery.setDeviceName(device.getDeviceName());
		deviceQuery.setDeviceStatus(device.getDeviceStatus());
		deviceQuery.setDeviceVersion(device.getFirmVersion());
		deviceQuery.setStartTime(startTime);
		deviceQuery.setEndTime(endTime);
		deviceQuery.setPageNo(pageNumber);
		
		int countPages=deviceService.countPages(deviceQuery);
		model.addAttribute("countPages",countPages);
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("selectPage",selectPage);
		model.addAttribute("startTime",startTime);
		model.addAttribute("endTime",endTime);
		
		List<Device> deviceList=deviceService.queryDeviceByPage(deviceQuery);
		model.addAttribute("deviceList",deviceList);
		
		//查询条件回显
		if(deviceName!=null){
			model.addAttribute("deviceName",deviceName);
		}
		
		if(deviceId!=null){
			model.addAttribute("deviceId",deviceId);
		}
		
		if(deviceVersion!=null){
			model.addAttribute("deviceVersion",deviceVersion);
		}
		
		if(deviceStatus!=null){
			model.addAttribute("deviceStatus",deviceStatus);
		}
		
		return "/deviceList";
	}
}
