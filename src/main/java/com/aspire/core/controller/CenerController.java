package com.aspire.core.controller;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
import com.aspire.core.bean.TempDevice;
import com.aspire.core.service.DeviceService;
import com.aspire.core.service.TempDeviceService;


@Controller
public class CenerController {
	
	@Autowired
	private DeviceService deviceService;
	@Autowired
	private TempDeviceService tempDeviceService;
	//首页默认查询控制
	@RequestMapping(value="/device/findDefault.do")
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
		return "/page/device/deviceList";
	}
	
	//激活设备控制
	@RequestMapping(value="/device/changeStatus.do")
	public String changeStatus(HttpServletRequest request,
			Model model){
		String deviceId=request.getParameter("deviceId");
		deviceService.changeStatus(deviceId);
		List<Device> deviceList=deviceService.findDefault();
		model.addAttribute("deviceList",deviceList);
		return "/page/message/message";
	}
	//将临时表数据激活到正式表中
	@RequestMapping(value="/device/activationDevice.do")
	public String activationDevice(HttpServletRequest request,
			Model model){
		String deviceId=request.getParameter("deviceId");
		TempDevice tempDevice=tempDeviceService.changeStatus(deviceId);
		List<Device> deviceList=deviceService.findDefault();
		model.addAttribute("deviceList",deviceList);
		return "/page/message/message";
	}
	
	//跳转添加设备页面
	@RequestMapping(value="/device/addDeviceJap.do")
	public String addDeviceJap(HttpServletRequest request,
			Model model){
		String deviceName = request.getParameter("deviceName");
		String deviceId = request.getParameter("deviceId");
		String deviceVersion = request.getParameter("deviceVersion");
		String deviceStatus = request.getParameter("deviceStatus");
		String pageNo = request.getParameter("pageNumber");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		model.addAttribute("pageNumber",pageNo);
		model.addAttribute("startTime",startTime);
		model.addAttribute("endTime",endTime);
		model.addAttribute("deviceName",deviceName);
		model.addAttribute("deviceId",deviceId);
		model.addAttribute("deviceVersion",deviceVersion);
		model.addAttribute("deviceStatus",deviceStatus);
		
		return "/page/device/addDevice";
		
	}
	
	//添加设备
	@RequestMapping(value="/device/addDevice.do")
	public String addDevice(HttpServletRequest request,HttpServletResponse response,
			Model model) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String deviceName=request.getParameter("deviceName");
		String firmVersion=request.getParameter("firmVersion");
		String deviceStatus=request.getParameter("deviceStatus");
		
		
		//增加设备
	    List<Device> deviceList=tempDeviceService.addDevice(deviceName,firmVersion,deviceStatus);
	    
		return "/page/message/message";
	}
	
	//分页查询设备
	@RequestMapping(value="/device/queryDevice.do")
	public String queryDevice(HttpServletRequest request,HttpServletResponse response,
			Model model) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String deviceName = new String(request.getParameter("deviceName").getBytes("ISO-8859-1"),"utf-8");
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
		
		return "/page/device/deviceList";
	}
	
	
	@RequestMapping(value="/device/queryTempDevice.do")
	public String queryTempDevice(HttpServletRequest request,HttpServletResponse response,Model model) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		Map<String,Object> tempDeviceList=tempDeviceService.queryTempList();
		DeviceQuery deviceQuery=(DeviceQuery) tempDeviceList.get("tempDeviceQuery");
		int countPages=tempDeviceService.countPages(deviceQuery);
		model.addAttribute("countPages",countPages);
		model.addAttribute("deviceList",tempDeviceList.get("tempList"));
		model.addAttribute("pageNumber",1);
		return "/page/device/tempDeviceList";
	}
	
	
	@RequestMapping(value="/device/queryTempDeviceByPage.do")
	public String queryTempDeviceByPage(HttpServletRequest request,HttpServletResponse response,
			Model model) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String deviceName = new String(request.getParameter("deviceName").getBytes("ISO-8859-1"),"utf-8");
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
		
		int countPages=tempDeviceService.countPages(deviceQuery);
		model.addAttribute("countPages",countPages);
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("selectPage",selectPage);
		model.addAttribute("startTime",startTime);
		model.addAttribute("endTime",endTime);
		
		List<TempDevice> deviceList=tempDeviceService.queryDeviceByPage(deviceQuery);
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
		return "/page/device/tempDeviceList";
	}
}
