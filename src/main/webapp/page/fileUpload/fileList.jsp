<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
	<!-- 引入进度条信息文件-->
	<script src="/ssmAspire/js/fileUpload/progrssBar.js"></script>
	<script src="/ssmAspire/js/fileUpload/duration.js"></script>
	<script src="/ssmAspire/js/fileUpload/fileupload.js"></script>
	<!-- 引入MD5计算 -->
	<script src="/ssmAspire/js/webUpload/MD5.js"></script>
	<script src="/ssmAspire/js/webUpload/spark-md5.js"></script>
	<link rel="stylesheet" type="text/css" href="/ssmAspire/css/webUpload/webuploader.css">
	<script type="text/javascript" src="/ssmAspire/js/webUpload/webuploader.js"></script>
	
	<script type="text/javascript">
	 $(function(){
		$('#numberSelect').change(function(){
			var numberSelect=$('#numberSelect option:selected').val();
			 var fileName=$("#fileName").attr("value");
			 var durationSelect=$('#durationSelect option:selected').val();
			 var duration=$("#duration").val();
			 var sizeSelect=$('#sizeSelect option:selected').val();
			 var size=$("#size").val();
			 var startTime=$("#startTime").val();
			 var endTime=$("#endTime").val();
			 var pageNo=$("#pageNo").val();
			location.href="queryPage.do?numberSelect="+numberSelect+"&durationSelect="+durationSelect+"&duration="+duration+"&sizeSelect="+sizeSelect+"&size="+size+"&startTime="+startTime+"&endTime="+endTime+"&fileName="+fileName+"&pageNo="+pageNo;
		});
	 })
	</script>
</head>
<body>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span6">
			<div class="row-fluid">
				<div class="span12">
					<form action="queryPage.do" method="post" id="formQuery">
						<fieldset>
							 <legend>文件管理</legend>
						<div class="form-group">
							<input id="pageNo" name="pageNo" value="${fileSelect.pageNo}" type="hidden" />
							 <label>文件名称</label> <input type="text" id="fileName"  value="${fileSelect.fileName}" name="fileName"/>
							 <label>持续时长</label>
								<select id="durationSelect" name="durationSelect">
									<option value=""></option>
									<option value="1" <c:if test="${fileSelect.durationSelect ==1}">selected="selected"</c:if>>大于</option>
									<option value="2" <c:if test="${fileSelect.durationSelect ==2}">selected="selected"</c:if>>小于</option>
									<option value="3" <c:if test="${fileSelect.durationSelect ==3}">selected="selected"</c:if>>等于</option>
								</select>
							 <input type="text" id="duration" name="duration" value="${fileSelect.duration }"/>
							 <label>文件大小</label>
							 	<select id="sizeSelect" name="sizeSelect">
									<option value=""></option>
									<option value="1" <c:if test="${fileSelect.sizeSelect ==1}">selected="selected"</c:if>>大于</option>
									<option value="2" <c:if test="${fileSelect.sizeSelect ==2}">selected="selected"</c:if>>小于</option>
									<option value="3" <c:if test="${fileSelect.sizeSelect ==3}">selected="selected"</c:if>>等于</option>
								</select>
							 <input type="text" id="size" name="size" value="${fileSelect.size}" />
						</div>
						<div class="form-group">
							 <label>上传时间</label><input type="date" id="startTime" value="${fileSelect.startTime}" name="startTime"/> 到   <input type="date" id="endTime" value="${fileSelect.endTime}" name="endTime"/>
							 <button type="submit" class="btn">查询</button>
						</div>
						</fieldset>
					</form>
					<table class="table">
						<thead>
							<tr>
							  <td>
				    			 <select id="numberSelect" name="numberSelect">
				    			 	<option value="">显示个数</option>
				    			 	<option value="6" <c:if test="${numberSelect ==6}">selected="selected"</c:if>>6</option>
				    			 	<option value="7" <c:if test="${numberSelect ==7}">selected="selected"</c:if>>7</option>
				    			 	<option value="8" <c:if test="${numberSelect ==8}">selected="selected"</c:if>>8</option>
				    			 	<option value="9" <c:if test="${numberSelect ==9}">selected="selected"</c:if>>9</option>
				    			 	<option value="10" <c:if test="${numberSelect ==10}">selected="selected"</c:if>>10</option>
				    			 </select>
				    		  </td>
							</tr>
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
				    			<td>${f.duration}秒</td>
				    			<td><fmt:formatDate value="${f.recordDateTime}"/><br></td>
	 			    			<td>${f.size}</td>
				    			<td>
				    				<a href="deleteFile.do?fileId=${f.id}">
				    					<input  type="button" value="删除" >
				    				</a>
				    			</td>
				    		</tr>
				    		</c:forEach>							
						</tbody>
					</table>
					<div class="pagination">
						<c:if test="${fileSelect.pageNo-1 !=0 }">
							<a href="queryPage.do?fileName=${fileSelect.fileName}&amp;durationSelect=${fileSelect.durationSelect}&amp;duration=${fileSelect.duration}&amp;sizeSelect=${fileSelect.sizeSelect}&amp;startTime=${startTime}&amp;endTime=${endTime}&amp;numberSelect=${numberSelect}&amp;pageNo=1"><font size="2" >首页</font></a>
						</c:if>                                                                                                                                                                                                                                       
						<c:if test="${fileSelect.pageNo-1 >0 }">                                                                                                                                                                                                      
							<a href="queryPage.do?fileName=${fileSelect.fileName}&amp;durationSelect=${fileSelect.durationSelect}&amp;duration=${fileSelect.duration}&amp;sizeSelect=${fileSelect.sizeSelect}&amp;startTime=${startTime}&amp;endTime=${endTime}&amp;numberSelect=${numberSelect}&amp;pageNo=${fileSelect.pageNo-1}"><font size="2">上一页</font></a>
						</c:if>                                                                                                                                                                                                                                     
							<a href="queryPage.do?fileName=${fileSelect.fileName}&amp;durationSelect=${fileSelect.durationSelect}&amp;duration=${fileSelect.duration}&amp;sizeSelect=${fileSelect.sizeSelect}&amp;startTime=${startTime}&amp;endTime=${endTime}&amp;numberSelect=${numberSelect}&amp;pageNo=${fileSelect.pageNo}"><strong>${fileSelect.pageNo}</strong></a>
						<c:if test="${fileSelect.pageNo+1 <=totalPages }">                                                                                                                                                                                           
							<a href="queryPage.do?fileName=${fileSelect.fileName}&amp;durationSelect=${fileSelect.durationSelect}&amp;duration=${fileSelect.duration}&amp;sizeSelect=${fileSelect.sizeSelect}&amp;startTime=${startTime}&amp;endTime=${endTime}&amp;numberSelect=${numberSelect}&amp;pageNo=${fileSelect.pageNo+1}">${fileSelect.pageNo+1}</a>
						</c:if>                                                                                                                                                                                                                                       
						<c:if test="${fileSelect.pageNo+2 <=totalPages }">                                                                                                                                                                                            
							<a href="queryPage.do?fileName=${fileSelect.fileName}&amp;durationSelect=${fileSelect.durationSelect}&amp;duration=${fileSelect.duration}&amp;sizeSelect=${fileSelect.sizeSelect}&amp;startTime=${startTime}&amp;endTime=${endTime}&amp;numberSelect=${numberSelect}&amp;pageNo=${fileSelect.pageNo+2}">${fileSelect.pageNo+2}</a>
						</c:if>                                                                                                                                                                                                                                       
						<c:if test="${fileSelect.pageNo+3 <=totalPages }">                                                                                                                                                                                            
							<a href="queryPage.do?fileName=${fileSelect.fileName}&amp;durationSelect=${fileSelect.durationSelect}&amp;duration=${fileSelect.duration}&amp;sizeSelect=${fileSelect.sizeSelect}&amp;startTime=${startTime}&amp;endTime=${endTime}&amp;numberSelect=${numberSelect}&amp;pageNo=${fileSelect.pageNo+3}">${fileSelect.pageNo+3}</a>
						</c:if>                                                                                                                                                                                                                                       
						<c:if test="${fileSelect.pageNo+1 <=totalPages }">                                                                                                                                                                                            
							<a href="queryPage.do?fileName=${fileSelect.fileName}&amp;durationSelect=${fileSelect.durationSelect}&amp;duration=${fileSelect.duration}&amp;sizeSelect=${fileSelect.sizeSelect}&amp;startTime=${startTime}&amp;endTime=${endTime}&amp;numberSelect=${numberSelect}&amp;pageNo=${fileSelect.pageNo+1}"><font size="2">下一页</font></a>
						</c:if>                                                                                                                                                                                                                                       
						<c:if test="${fileSelect.pageNo+1 <=totalPages }">                                                                                                                                                                                           
							<a href="queryPage.do?fileName=${fileSelect.fileName}&amp;durationSelect=${fileSelect.durationSelect}&amp;duration=${fileSelect.duration}&amp;sizeSelect=${fileSelect.sizeSelect}&amp;startTime=${startTime}&amp;endTime=${endTime}&amp;numberSelect=${numberSelect}&amp;pageNo=${totalPages}"><font size="2">尾页</font></a>
						</c:if>                                                                                                                                                                                                                                
						共<var>${totalPages}</var>页 
					   <form action="queryPage.do?fileName=${fileSelect.fileName}&amp;durationSelect=${fileSelect.durationSelect}&amp;duration=${fileSelect.duration}&amp;sizeSelect=${fileSelect.sizeSelect}&amp;startTime=${startTime}&amp;endTime=${endTime}&amp;numberSelect=${numberSelect}" method="post"  style="margin:0px;display:inline;">
						到第<input type="text" name="selectPage" value="${selectPage}" size="3"/>页 <input type="submit"  value="确定"  />
						</form>
					</div>
					<div id="fileUpload" class="row-fluid">
						<div class="span12">
							<form id="formFile" action="findUpload.do" method="post" enctype="multipart/form-data" >
								<fieldset>
									 <legend>文件上传</legend>
									<div class="form-group">
									  <div class="col-xs-11">
										 <input type="text"  value="" id="md5" hidden="true"  name="md5"/>
										<!--  <input type="text" value=""  id="filename" hidden="true"/> -->
										 <div id="wrapper">
										 	<input id="file" type="file" class="file" name="f1" accept="audio/mp3" style="display: inline;"/>
										 </div>
									  </div>
<!-- 									  <div class="col-xs-9">
										 <div id="filePicker">计算文件MD5</div>
									 </div> -->

									   <div class="col-xs-1">
										 <input id="uploadButton" type="button" hidden="true" onclick="formSubmit()" value="上传"/>
										</div>
									 </div>
								</fieldset>
							</form>
							<div class="col-xs-12" id="media">
							</div>
							<div id="status" class="col-xs-12"> </div>
							<div class="col-xs-12" style="width:100%">
								<div class="progress">
						           <div id="progressBar" style="background:#0ff;height:26px;width:0%;">  
						    		<span id="percent"></span>
						    		</div>
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


</html>