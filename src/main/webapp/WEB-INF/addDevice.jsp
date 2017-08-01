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
<div class="body-box">
	<form id="addDevice" action="addDevice" method="post">
		<table  width="100%" border="0">
			<tbody id="tab_device">
				<tr>
					<td width="10%">
						设备名称:</td><td>
								<select id="deviceName" name="deviceName">
									<option value="">请选择</option>
									<option value="联想">联想</option>
									<option value="华为">华为</option>
									<option value="华硕">华硕</option>
									<option value="小米">小米</option>
									<option value="苹果">苹果</option>
									<option value="vivo">vivo</option>
								</select>
					</td>
				</tr>
				<tr>
					<td width="10%">
						硬件版本:</td><td>
								<select id="firmVersion" name="firmVersion">
									<option value="">请选择</option>
									<option value="DTSK3">DTSK3</option>
									<option value="DTSK4">DTSK4</option>
									<option value="DTSK5">DTSK5</option>
									<option value="DTSK3A">DTSK3A</option>
									<option value="DTSK3B">DTSK3B</option>
								</select>
					</td>
				</tr>
				<tr>
					<td width="10%">
						设备状态:</td><td>
						<select id="deviceStatus" name="deviceStatus">
							<option value="">请选择品牌</option>
							<option value="1">激活</option>
							<option value="2">未激活</option>
						</select>
					</td>
				</tr>
				<tr>
					<td width="10%">
						<input  type="submit" value="添加设备"/>
					</td>
				</tr>
		</table>
	</form>
</div>
</body>
</html>