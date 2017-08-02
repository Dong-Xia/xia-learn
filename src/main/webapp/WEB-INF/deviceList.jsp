<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>deviceList</title>

<script type="text/javascript" >


</script>
</head>
<body>
	<div id="queryData">
		<form action="queryDevice" method="post" style="padding-top:5px;">
			<input type="hidden" value="1" name="pageNo"/>
				设备名称: <input type="text"  value="" name="deviceName"/>
				设备编码: <input type="text"  value="" name="devcieId"/>
					<select  name="deviceVersion">
						<option value="">设备版本</option>
						<option value="1">DTSK3</option>
						<option value="2">DTSK4</option>
						<option value="3">DTSK3A</option>
						
					</select>
					<select  name="deviceStatus">
						<option value="">设备状态</option>
						<option value="1">在线</option>
						<option value="2">离线</option>
					</select>
					<input type="submit" class="query" value="查询"/>
		</form>
	</div>
	<div id="showData">
		<table border="1">
			<tr>
				<a href="/ssmAspire/device/addDeviceJap">
    				<span><input  type="submit" value="添加设备" ></span>
    			</a>
			</tr>
			<tr>
				<th>设备ID</th>
				<th>版本</th>
				<th>名称</th>
				<th>操作</th>
			</tr>
    		<c:forEach items="${deviceList}" var="d">
    		<tr>
    			<td>${d.deviceId}</td>
    			<td>${d.firmVersion}</td>
    			<td>${d.deviceName}</td>
    			<td>
    				<a href="/ssmAspire/device/changeStatus?deviceId=${d.deviceId}">
    					<input  type="submit" value="激活" >
    				</a>
    				<a href="/ssmAspire/device/changeStatus?deviceId=${d.deviceId}">
    					<input  type="submit" value="删除" >
    				</a>
    				<a href="/ssmAspire/device/changeStatus?deviceId=${d.deviceId}">
    					<input  type="submit" value="日志" >
    				</a>
    			</td>
    		</tr>	
    		</c:forEach> 
		</table>
		
	<div class="page pb15"><span class="r inb_a page_b">
	
		<font size="2">首页</font>
	
		<font size="2">上一页</font>
	
		<strong>1</strong>
	
		<a href="queryDevice?&amp;isShow=0&amp;pageNo=2">2</a>
	
		<a href="queryDevice?&amp;isShow=0&amp;pageNo=3">3</a>
	
		<a href="queryDevice?&amp;isShow=0&amp;pageNo=4">4</a>
	
		<a href="queryDevice?&amp;isShow=0&amp;pageNo=5">5</a>
	
		<a href="queryDevice?&amp;isShow=0&amp;pageNo=2"><font size="2">下一页</font></a>
	
		<a href="queryDevice?&amp;isShow=0&amp;pageNo=5"><font size="2">尾页</font></a>
	
		共<var>5</var>页 到第<input type="text" size="3" id="PAGENO"/>页 <input type="button" onclick="javascript:window.location.href = 'queryDevice?&amp;isShow=0&amp;pageNo=' + $('#PAGENO').val() " value="确定" class="hand btn60x20" id="skip"/>
	
	</span></div>
    </div>
    <div></div>
</body>
</html>