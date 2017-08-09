package com.aspire.core.bean;

import java.util.Date;

/**
 * 音频文件持久化类
 * @author xia
 *
 */
public class FileQuery {
	//定义常量 每页数
	public final static int DEFAULT_SIZE = 5;
	//每页数
	protected int pageSize = DEFAULT_SIZE;
	//起始行
	protected int startRow;//起始位置
	//页码
	protected int pageNo=1;
	
	private String fileName;
	private String durationSelect;
	private String duration;
	private String sizeSelect;
	private String size;
	private String startTime;
	private String endTime;
	
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStartRow() {
		return pageSize*(pageNo-1);
	}

	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public static int getDefaultSize() {
		return DEFAULT_SIZE;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getDurationSelect() {
		return durationSelect;
	}
	public void setDurationSelect(String durationSelect) {
		this.durationSelect = durationSelect;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getSizeSelect() {
		return sizeSelect;
	}
	public void setSizeSelect(String sizeSelect) {
		this.sizeSelect = sizeSelect;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	
}
