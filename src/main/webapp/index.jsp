<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> -->
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <title>主页</title>
	<link rel="stylesheet" href="js/bootstrap/bootstrap.min.css">
	<!-- jQuery文件 -->
	<script src="js/jquery-3.2.1.min.js"></script>
	<!-- Bootstrap 核心 JavaScript 文件 -->
	<script src="js/bootstrap/bootstrap.min.js"></script>
</head>
<body>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<img  src="image/1.jpg" class="img-rounded" />
			</div>
		</div>
		<div class="row-fluid">
		<div class="panel panel-default col-md-2">
			<ul class="nav nav-list">
				<li class="nav-header">
					设备管理
				</li>
				<li class="active">
					<a href="device/queryTempDevice.do" target="main">临时设备管理</a>
				</li>
				<li>
					<a href="device/findDefault.do" target="main">正式设备管理</a>
				</li>
				<li class="nav-header">
					文件上传管理
				</li>
				<li class="active">
					<a href="fileUpload/findMainPage.do" target="main">音频上传</a>
				</li>
			</ul>
		</div>
		<div class="panel panel-default col-md-10" style="height:450px">
			<iframe frameborder=0 style="width:100%;height:100%;"   name="main"></iframe>
		</div>
	</div>
</div>
</body>
</html>
