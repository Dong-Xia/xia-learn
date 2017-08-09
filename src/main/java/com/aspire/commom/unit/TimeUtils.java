package com.aspire.commom.unit;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 异步返回各种格式
 * json
 * xml
 * text
 * @author xia
 *
 */
public class TimeUtils {
	
	//按规则生成时间戳
	public static String getTimeFormat(){
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String date = dateFormat.format(new Date());
		return date;
	}
	
	//按格式处理时间显示 (date转字符串)
	public static String dateToString(Date time){
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
		String date = formatter.format(time);//格式化数据
		return date;
	}
	
	
/*	//按格式处理时间显示 (字符串转date)
	public static Date StringToDate(String time){
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
		Date date =  formatter.parse(time);
		return date;
	}*/
}
