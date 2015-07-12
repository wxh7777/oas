<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<title>合同核备</title>
	<jsp:include page="/head.jsp" flush="true"></jsp:include>
</head>
<body onLoad="init()"> 
<nav class="breadcrumb"><i class="iconfont">&#xf012b;</i> 首页 <span class="c-gray en">&gt;</span> 合同核备 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="icon-refresh"></i></a></nav> 
<div class="pd-20">
	<table id="tableData" class="table table-border table-bordered table-striped">
       	<thead>
       		<tr class="text-c">
       			<th id="HTHBBH">合同核备编号</th>
       			<th id="SCWJSJ">上传时间</th>
       			<th id="HTWJLB">合同文件列表</th>
       			<th id="SHJYWD">审核意见文档</th>
       			<th id="SH">审核</th>
       		</tr>
       	</thead>
       	<tbody class="text-c"></tbody>
	</table>
</div>
<jsp:include page="/footer.jsp" flush="true"></jsp:include>
<script src="./js/jshthb.js" type="text/javascript" charset="utf-8" ></script>
</body>
</html>