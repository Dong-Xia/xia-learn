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
    			</td>
    		</tr>	
    		</c:forEach> 
		</table>
    </div>
    <div></div>
</body>
</html>