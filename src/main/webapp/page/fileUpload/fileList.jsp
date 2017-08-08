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
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span6">
			<div class="row-fluid">
				<div class="span12">
					<form action="queryFile.do" method="post">
						<fieldset>
							 <legend>文件管理</legend>
							 <label>文件名称</label> <input type="text"  value="${fileName}" name="fileName"/>
							 <label>持续时长</label><input type="text" />
							 <label>文件大小</label><input type="text" />
							 <label>上传时间</label><input type="date" value="${startTime}" name="startTime"/> 到   <input type="date" value="${endTime}" name="endTime"/>
							 <button type="submit" class="btn">查询</button>
						</fieldset>
					</form>
					<table class="table">
						<thead>
							<tr>
								<th>
									文件名称
								</th>
								<th>
									持续时长
								</th>
								<th>
									上传时间
								</th>
								<th>
									文件大小
								</th>
								<th>
									操作
								</th>
							</tr>
						</thead>
						<tbody>
				    		<c:forEach items="${fileList}" var="f">
				    		<tr>
				    			<td>${f.name}</td>
				    			<td>${f.duration}</td>
				    			<td>${f.recordDateTime}</td>
				    			<td>${f.size}</td>
				    			<td>
				    				<a href="deleteFile.do?fileId=${f.fileId}">
				    					<input  type="button" value="删除" >
				    				</a>
				    			</td>
				    		</tr>
				    		</c:forEach>							
						</tbody>
					</table>
					<div class="pagination">
						<c:if test="${pageNumber-1 !=0 }">
							<a href="queryDevice.do?deviceName=${deviceName}&amp;deviceId=${deviceId}&amp;deviceVersion=${deviceVersion}&amp;deviceStatus=${deviceStatus}&amp;startTime=${startTime}&amp;endTime=${endTime}&amp;pageNumber=1"><font size="2" >首页</font></a>
						</c:if>
						<c:if test="${pageNumber-1 >0 }">
							<a href="queryDevice.do?deviceName=${deviceName}&amp;deviceId=${deviceId}&amp;deviceVersion=${deviceVersion}&amp;deviceStatus=${deviceStatus}&amp;startTime=${startTime}&amp;endTime=${endTime}&amp;pageNumber=${pageNumber-1}"><font size="2">上一页</font></a>
						</c:if>
						<a href="queryDevice.do?deviceName=${deviceName}&amp;deviceId=${deviceId}&amp;deviceVersion=${deviceVersion}&amp;deviceStatus=${deviceStatus}&amp;startTime=${startTime}&amp;endTime=${endTime}&amp;pageNumber=${pageNumber}"><strong>${pageNumber}</strong></a>
						<c:if test="${pageNumber+1 <=countPages }">
								<a href="queryDevice.do?deviceName=${deviceName}&amp;deviceId=${deviceId}&amp;deviceVersion=${deviceVersion}&amp;deviceStatus=${deviceStatus}&amp;startTime=${startTime}&amp;endTime=${endTime}&amp;pageNumber=${pageNumber+1}">${pageNumber+1}</a>
						</c:if>
						<c:if test="${pageNumber+2 <=countPages }">
								<a href="queryDevice.do?deviceName=${deviceName}&amp;deviceId=${deviceId}&amp;deviceVersion=${deviceVersion}&amp;deviceStatus=${deviceStatus}&amp;startTime=${startTime}&amp;endTime=${endTime}&amp;pageNumber=${pageNumber+2}">${pageNumber+2}</a>
						</c:if>
						<c:if test="${pageNumber+3 <=countPages }">
								<a href="queryDevice.do?deviceName=${deviceName}&amp;deviceId=${deviceId}&amp;deviceVersion=${deviceVersion}&amp;deviceStatus=${deviceStatus}&amp;startTime=${startTime}&amp;endTime=${endTime}&amp;pageNumber=${pageNumber+3}">${pageNumber+3}</a>
						</c:if>
						<c:if test="${pageNumber+1 <=countPages }">
							<a href="queryDevice.do?deviceName=${deviceName}&amp;deviceId=${deviceId}&amp;deviceVersion=${deviceVersion}&amp;deviceStatus=${deviceStatus}&amp;startTime=${startTime}&amp;endTime=${endTime}&amp;pageNumber=${pageNumber+1}"><font size="2">下一页</font></a>
						</c:if>
						<c:if test="${pageNumber+1 <=countPages }">
							<a href="queryDevice.do?deviceName=${deviceName}&amp;deviceId=${deviceId}&amp;deviceVersion=${deviceVersion}&amp;deviceStatus=${deviceStatus}&amp;startTime=${startTime}&amp;endTime=${endTime}&amp;pageNumber=${countPages}"><font size="2">尾页</font></a>
						</c:if>
						共<var>${countPages}</var>页 
						<form action="queryDevice.do?deviceName=${deviceName}&amp;deviceId=${deviceId}&amp;deviceVersion=${deviceVersion}&amp;deviceStatus=${deviceStatus}&amp;startTime=${startTime}&amp;endTime=${endTime}" method="post"  style="margin:0px;display:inline;">
						到第<input type="text" name="selectPage" value="${selectPage}" size="3"/>页 <input type="submit"  value="确定"  />
						</form>
					</div>
					<div id="fileUpload" class="row-fluid">
						<div class="span12">
							<form id="formFile" action="findUpload.do" method="post" enctype="multipart/form-data">
								<fieldset>
									 <legend>文件上传</legend> 
									 <span class="help-block">目前仅支持mp3音频格式</span> 
									 <input type="text" name="md5" hidden="true" />
									 <input type="file" name="f1"/>
									 <input type="button"  id="trigger" value="预览"/>
									 <input type="submit" id="fileUpload" value="上传"/>
								</fieldset>
							</form>
							<div class="media-body">
								<p><embed src="/ssmAspire/image/2.mp3"  autostart=true loop=true width="100%" hidden="true" id="media"></embed></p>
							</div>
							<div class="progress">
								<div id="bar" class="bar">
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
<script type="text/javascript">
	$("#trigger").click(function(){
		var form=new FormData(document.getElementById("formFile"));
		$.ajax({
			url:"${pageContext.request.contextPath}/fileUpload/generateMD5.do",
			type:"post",
			data:form,
			dataType:"json",
            processData:false,
            contentType:false,
            success:function(data){
            	alert(data);
            },
            error:function(e){
                alert("错误！！");
                window.clearInterval(timer);
            }
		});
		//计算MD5
		//浏览MP3，显示媒体播放区域
		$('#fileUpload').show();
		$("#media").show();

		//显示上传按钮
	})

</script>
</html>