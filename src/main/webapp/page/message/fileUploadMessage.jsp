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
	${message};
	<div class="btn-group">
		<button type="button" class="btn btn-default" id="fileUpload">返回</button>
	</div>
</body>

<script type="text/javascript">
		$("#fileUpload").click(function(){
			location.href = "/ssmAspire/fileUpload/findMainPage.do";
		})
</script>
</html>