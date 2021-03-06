<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<title>上传合同</title>
	<jsp:include page="/head.jsp" flush="true"></jsp:include>
</head>
<body onLoad="init()"> 
<nav class="breadcrumb"><i class="iconfont">&#xf012b;</i> 首页 <span class="c-gray en">&gt;</span> 上传合同 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="icon-refresh"></i></a></nav> 
<div class="pd-20">
	<form id="filesForm" action=""  enctype="multipart/form-data" method="post">

		<table style="width:60%" align="center" id="tableData" class="table  table-bg table-sort">
          	<tr>
              <td width="15%"><span>选择项目:</span></td>
              <td width="40%">
          		<div class="btn-group">
		            <select class="select select-box" id="xmSel" name="xmid">
					</select>
	        	</div>
          	  </td>
          	  <td></td>
            </tr>
            <tr>
				<td colspan="3">
					 	<span>选择合同文件：</span>
				</td>
			</tr>
			<tr>
				<td colspan="3">
				     	<span class="btn-upload">
						  <input class="input-text upload-url radius" type="text" name="uploadfile-1" id="uploadfile-1" readonly>
						  <a href="javascript:void();" class="btn btn-primary radius"><i class="iconfont">&#xf0020;</i> 浏览</a>
						  <input type="file" multiple id="myFile1" name="myFile" class="input-file">
						</span>
				</td>
			</tr>
			<tr>
				<td colspan="3">
				     	<span class="btn-upload">
						  <input class="input-text upload-url radius" type="text" name="uploadfile-2" id="uploadfile-2" readonly>
						  <a href="javascript:void();" class="btn btn-primary radius"><i class="iconfont">&#xf0020;</i> 浏览</a>
						  <input type="file" multiple id="myFile2" name="myFile" class="input-file">
						</span>
				</td>
			</tr>
			<tr>
				<td colspan="3">
				     	<span class="btn-upload">
						  <input class="input-text upload-url radius" type="text" name="uploadfile-3" id="uploadfile-3" readonly>
						  <a href="javascript:void();" class="btn btn-primary radius"><i class="iconfont">&#xf0020;</i> 浏览</a>
						  <input type="file" multiple id="myFile3" name="myFile"class="input-file">
						</span>
				</td>
			</tr>
		</table>
		<table style="width:60%" align="center" class="table">
			<tr>
				<td>
					<a href="javascript:;" onclick="onAdd()" class="btn btn-primary"><i class="icon-plus"></i> 添加一个</a>
				</td>
			</tr>
			<tr class="text-c">
				<td>
					<a href="javascript:;" onclick="upload()" class="btn btn-success"><i class="icon-save"></i> 上传</a>
				</td>
			</tr>
			<tr>
				<td>
					<span style="font-size:20px" id="info"></span>
				</td>
			</tr>
		</table>
	</form>
</div>
<jsp:include page="/footer.jsp" flush="true"></jsp:include>
<script src="./js/scjsht.js" type="text/javascript" charset="utf-8" ></script>
</body>
</html>