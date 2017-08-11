package com.aspire.core.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aspire.commom.unit.ResponseUtils;
import com.aspire.core.bean.FileQuery;
import com.aspire.core.service.FileUploadService;



@Controller
public class FileController {
	
	@Autowired
	private FileUploadService fileUploadService;
	//首页默认查询控制
	@RequestMapping(value="/fileUpload/findMainPage.do")
	public String findMainPage(HttpServletRequest request,HttpServletResponse response) {
		
		FileQuery file=new FileQuery();
		file.setDuration(null);
		file.setDurationSelect(null);
		file.setEndTime(null);
		file.setFileName(null);
		file.setSize(null);
		file.setSizeSelect(null);
		file.setStartTime(null);
		 Map<String,Object> fileMap=fileUploadService.queryPage(file);
		 request.setAttribute("fileList", fileMap.get("fileList"));
		 request.setAttribute("fileSelect", file);
		 request.setAttribute("totalPages", fileMap.get("totalPages"));
		 request.setAttribute("selectPage", fileMap.get("selectPage"));
		
		return "/page/fileUpload/fileList";
	}
	
	//上传文件
	@RequestMapping(value="/fileUpload/findUpload.do")
	public String findUpload(HttpServletRequest request,HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String message=fileUploadService.upload(request,response);
		request.setAttribute("message", message);
		
		return "/page/message/fileUploadMessage";
	}
	
	
	//删除文件
	@RequestMapping(value="/fileUpload/deleteFile.do")
	public String deleteFile(HttpServletRequest request,HttpServletResponse response) throws IOException{
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			
			String fileId = request.getParameter("fileId");
			fileUploadService.deleteFile(fileId);
			
			return "redirect:/fileUpload/findMainPage.do";
	}
	
	@RequestMapping(value="/fileUpload/queryPage.do")
	public String generateMD5(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		String fileName = new String(request.getParameter("fileName").getBytes("ISO-8859-1"),"utf-8");
		String durationSelect = request.getParameter("durationSelect");
		String duration = request.getParameter("duration");
		String sizeSelect = request.getParameter("sizeSelect"); 
		String size = request.getParameter("size");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String pageNo = request.getParameter("pageNo");
		String selectPage = request.getParameter("selectPage");
		String numberSelect=request.getParameter("numberSelect");
		
		FileQuery file=new FileQuery();
		file.setDuration(duration);
		file.setDurationSelect(durationSelect);
		file.setEndTime(endTime);
		file.setFileName(fileName);
		file.setSize(size);
		file.setSizeSelect(sizeSelect);
		file.setStartTime(startTime);
		
		if(selectPage!=null&&!selectPage.equals("")){
			file.setPageNo(Integer.valueOf(selectPage));
		}else if(pageNo!=null&&!pageNo.equals("")){
			file.setPageNo(Integer.valueOf(pageNo));
		}
		
		if(numberSelect!=null&&!numberSelect.equals("")){
			file.setPageSize(Integer.valueOf(numberSelect));
		}
		 Map<String,Object> fileMap=fileUploadService.queryPage(file);
		 request.setAttribute("fileList", fileMap.get("fileList"));
		 request.setAttribute("fileSelect", file);
		 request.setAttribute("totalPages", fileMap.get("totalPages"));
		 request.setAttribute("selectPage", fileMap.get("selectPage"));
		 request.setAttribute("numberSelect", numberSelect);
		 
		return "/page/fileUpload/fileList";
	}
	
	
	//上传文件监听类
	@RequestMapping(value="/fileUpload/fileUploadStatus.do")
	public void fileUploadStatus(HttpServletRequest request,HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=utf-8");    
        
        HttpSession session=request.getSession();  
          
        Object status = session.getAttribute("key");//获取上传进度百分比   
        if(status==null) return;    
        PrintWriter out = response.getWriter();    
        out.write(status.toString());  
        out.flush();  
        out.close();
	}
}
