package com.aspire.core.bean;

/**
 * 进度条持久化类
 * @author xia
 *
 */
public class ProgressBar {
	private double readSize;
	private double totalSize;
	private double percent;
	public double getReadSize() {
		return readSize;
	}
	public void setReadSize(double readSize) {
		this.readSize = readSize;
	}
	public double getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(double totalSize) {
		this.totalSize = totalSize;
	}
	public double getPercent() {
		return percent;
	}
	public void setPercent(double percent) {
		this.percent = readSize/totalSize*100;
	}
	
}
