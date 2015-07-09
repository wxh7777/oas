<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<title>收入合同</title>
	<jsp:include page="/head.jsp" flush="true"></jsp:include>
</head>
<body onLoad="initIncomeContractList()"> 
<nav class="breadcrumb"><i class="iconfont">&#xf012b;</i> 首页 <span class="c-gray en">&gt;</span> 收入合同 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="icon-refresh"></i></a></nav> 
<div class="pd-20  pb-100">
	<%
		//判断什么role才有添加的权限
	%>
 	<div class="cl pd-5 bg-1 bk-gray">
   		<span class="l">
     		<a class="btn btn-primary radius" href="javascript:;" onclick="addIncomeContract()"><i class="icon-plus"></i> 添加收入合同</a>
   		</span>
 	</div>
 	<%
 	%>
  	<div  class="container">
  	<table id="incomeContractListTable" class="table table-striped table-bordered table-condensed" cellspacing="0" width="100%">
		<thead class="text-c">
			<tr>
		        <th width="100">ID</th>
		        <th width="100">项目名称</th>
		        <th width="100">合同类别</th>
		        <th width="100">合同编号</th>
		        <th width="100">下载链接</th>
			</tr>
		</thead>
    	<tbody class="text-c">
    	</tbody>
  	</table>
  </div>
</div>
<jsp:include page="/footer.jsp" flush="true"></jsp:include>
<script src="./js/lrsrht.js" type="text/javascript" charset="utf-8" ></script>
</body>
</html>