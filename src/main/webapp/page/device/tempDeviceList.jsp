<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>设备信息页</title>

	<!-- Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet" href="/ssmAspire/js/bootstrap/bootstrap.min.css">
	<!-- jQuery文件 -->
	<script src="/ssmAspire/js/jquery-3.2.1.min.js"></script>
	<!-- Bootstrap 核心 JavaScript 文件 -->
	<script src="/ssmAspire/js/bootstrap/bootstrap.min.js"></script>
</head>
<body>
	<div id="queryData">
		<form action="queryTempDeviceByPage.do" method="post" role="form">
			<input type="hidden" value="1" name="pageNumber"/>
				设备名称: <input type="text"  value="${deviceName}" name="deviceName"/>
				设备编码: <input type="text"  value="${deviceId}" name="deviceId"/>
					<select  name="deviceVersion" >
						<option value="">设备版本</option>
						<option value="DTSK3" <c:if test="${deviceVersion =='DTSK3'}">selected="selected"</c:if>>DTSK3</option>
						<option value="DTSK4" <c:if test="${deviceVersion =='DTSK4'}">selected="selected"</c:if>>DTSK4</option>
						<option value="DTSK5" <c:if test="${deviceVersion =='DTSK5'}">selected="selected"</c:if>>DTSK5</option>
						<option value="DTSK3A" <c:if test="${deviceVersion =='DTSK3A'}">selected="selected"</c:if>>DTSK3A</option>
						
					</select>
					<select  name="deviceStatus">
						<option value="">设备状态</option>
						<option value="1" <c:if test="${deviceStatus ==1}">selected="selected"</c:if>>在线</option>
						<option value="2" <c:if test="${deviceStatus ==2}">selected="selected"</c:if>>离线</option>
					</select>
				入库时间：<!-- <input  name="recordStartTime"/> -->
					<input type="date" value="${startTime}" name="startTime"/> 到   <input type="date" value="${endTime}" name="endTime"/> 
					<input type="submit" class="query" value="查询"/>
		</form>
	</div>
	<div id="showData">
		<table border="1" class="table">
			<tr>
				<a href="/ssmAspire/device/addDeviceJap.do">
    				<input  type="button" value="添加设备" />
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
    				<a href="/ssmAspire/device/activationDevice.do?deviceId=${d.deviceId}">
    					<input  type="button" value="激活" >
    				</a>
    			</td>
    		</tr>	
    		</c:forEach> 
		</table>
		
	<div class="page">
		<c:if test="${pageNumber-1 !=0 }">
			<a href="queryTempDeviceByPage.do?deviceName=${deviceName}&amp;deviceId=${deviceId}&amp;deviceVersion=${deviceVersion}&amp;deviceStatus=${deviceStatus}&amp;startTime=${startTime}&amp;endTime=${endTime}&amp;pageNumber=1"><font size="2" >首页</font></a>
		</c:if>
		<c:if test="${pageNumber-1 >0 }">
			<a href="queryTempDeviceByPage.do?deviceName=${deviceName}&amp;deviceId=${deviceId}&amp;deviceVersion=${deviceVersion}&amp;deviceStatus=${deviceStatus}&amp;startTime=${startTime}&amp;endTime=${endTime}&amp;pageNumber=${pageNumber-1}"><font size="2">上一页</font></a>
		</c:if>
		<a href="queryTempDeviceByPagee.do?deviceName=${deviceName}&amp;deviceId=${deviceId}&amp;deviceVersion=${deviceVersion}&amp;deviceStatus=${deviceStatus}&amp;startTime=${startTime}&amp;endTime=${endTime}&amp;pageNumber=${pageNumber}"><strong>${pageNumber}</strong></a>
		<c:if test="${pageNumber+1 <=countPages }">
				<a href="queryTempDeviceByPage.do?deviceName=${deviceName}&amp;deviceId=${deviceId}&amp;deviceVersion=${deviceVersion}&amp;deviceStatus=${deviceStatus}&amp;startTime=${startTime}&amp;endTime=${endTime}&amp;pageNumber=${pageNumber+1}">${pageNumber+1}</a>
		</c:if>
		<c:if test="${pageNumber+2 <=countPages }">
				<a href="queryTempDeviceByPage.do?deviceName=${deviceName}&amp;deviceId=${deviceId}&amp;deviceVersion=${deviceVersion}&amp;deviceStatus=${deviceStatus}&amp;startTime=${startTime}&amp;endTime=${endTime}&amp;pageNumber=${pageNumber+2}">${pageNumber+2}</a>
		</c:if>
		<c:if test="${pageNumber+3 <=countPages }">
				<a href="queryTempDeviceByPage.do?deviceName=${deviceName}&amp;deviceId=${deviceId}&amp;deviceVersion=${deviceVersion}&amp;deviceStatus=${deviceStatus}&amp;startTime=${startTime}&amp;endTime=${endTime}&amp;pageNumber=${pageNumber+3}">${pageNumber+3}</a>
		</c:if>
		<c:if test="${pageNumber+1 <=countPages }">
			<a href="queryTempDeviceByPage.do?deviceName=${deviceName}&amp;deviceId=${deviceId}&amp;deviceVersion=${deviceVersion}&amp;deviceStatus=${deviceStatus}&amp;startTime=${startTime}&amp;endTime=${endTime}&amp;pageNumber=${pageNumber+1}"><font size="2">下一页</font></a>
		</c:if>
		<c:if test="${pageNumber+1 <=countPages }">
			<a href="queryTempDeviceByPage.do?deviceName=${deviceName}&amp;deviceId=${deviceId}&amp;deviceVersion=${deviceVersion}&amp;deviceStatus=${deviceStatus}&amp;startTime=${startTime}&amp;endTime=${endTime}&amp;pageNumber=${countPages}"><font size="2">尾页</font></a>
		</c:if>
		共<var>${countPages}</var>页 
		<form action="queryTempDeviceByPage.do?deviceName=${deviceName}&amp;deviceId=${deviceId}&amp;deviceVersion=${deviceVersion}&amp;deviceStatus=${deviceStatus}&amp;startTime=${startTime}&amp;endTime=${endTime}" method="post"  style="margin:0px;display:inline;">
		到第<input type="text" name="selectPage" value="${selectPage}" size="3"/>页 <input type="submit"  value="确定"  />
		</form>
	</div>
    </div>
    <div></div>
</body>
</html>