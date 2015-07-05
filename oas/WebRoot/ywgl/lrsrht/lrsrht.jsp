<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<title>录入收入合同</title>
	<jsp:include page="/head.jsp" flush="true"></jsp:include>
</head>
<body onLoad="init()"> 
<nav class="breadcrumb"><i class="iconfont">&#xf012b;</i> 首页 <span class="c-gray en">&gt;</span> 录入收入合同 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="icon-refresh"></i></a></nav> 
<div class="pd-20">
	<form id="incomeContractForm" action=""  enctype="multipart/form-data" method="post" onsubmit="validate()">
		<div class="text-c">
			<table class="table table-border table-bordered table-striped">
	          <tbody>
	            <tr>
	            	<td><div class="text-r">项目名称</div></td>
	            	<td>
						<select class="select select-box" id="selSrhtlb" name="xiangmuId">
							<option value="11111139763039816337">项目一</option>
							<option value="11111139763039816337">项目二</option>
						</select>
					 </td>
		             <td><div class="text-r">合同类别</div></td>
		             <td>
						<select class="select select-box" id="selSrhtlb" name="type">
							<option value="工程中标合同">工程中标合同</option>
							<option value="其他合同">其他合同</option>
						</select>
					 </td>
	              </tr>
	            <tr>
	            	<td><div class="text-r">合同编号</div></td>
	              	<td>
	              		<input type="text" class="input-text" required=true name="number" placeholder="合同编号">
	              	</td>
					<td><div class="text-r"> 选择合同文件：</div></td>
					<td>
						 <span class="btn-upload">
							  <input class="input-text upload-url radius" type="text" name="uploadfile-1" id="uploadfile-1" readonly>
							  <a href="javascript:void();" class="btn btn-primary radius"><i class="iconfont">&#xf0020;</i> 浏览</a>
							  <input type="file" multiple id="myFile1" name="myFile" class="input-file">
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="4" class="text-c">
						<a href="javascript:;" onclick="uploadIncomeContract()" class="btn btn-success"><i class="icon-save"></i> 上传</a>
					</td>
				</tr>
	          </tbody>
	        </table>
		</div>
	</form>
</div>
<jsp:include page="/footer.jsp" flush="true"></jsp:include>
<script src="./js/lrsrht.js" type="text/javascript" charset="utf-8" ></script>
</body>
</html>
