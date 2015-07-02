<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<title>项目管理</title>
	<jsp:include page="/head.jsp" flush="true"></jsp:include>
</head>
<body onLoad="initProject()"> 
<nav class="breadcrumb"><i class="iconfont">&#xf012b;</i> 首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span> 项目管理 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="icon-refresh"></i></a></nav> 
<div class="pd-20  pb-100">
  <div class="cl pd-5 bg-1 bk-gray">
    <span class="l">
      <a class="btn btn-primary radius" href="javascript:;" onclick="addProject()"><i class="icon-plus"></i> 添加项目</a>
    </span>
  </div>
  <div  class="container">
  <table id="tableJg" class="table table-striped table-bordered table-condensed" cellspacing="0" width="100%">
	<thead class="text-c">
		<tr>
	        <th width="100">ID</th>
	        <th width="100">项目名称</th>
	        <th width="100">项目说明</th>
	        <th width="100">人员列表</th>
	        <th width="100">人员列表ID</th>
	        <th width="70">修改基本信息</th>
	        <th width="70">删除</th>
		</tr>
	</thead>
    <tbody  class="text-c">
    </tbody>
  </table>
  </div>
</div>
<jsp:include page="/footer.jsp" flush="true"></jsp:include>
<script src="./js/projects.js" type="text/javascript" charset="utf-8" ></script>
</body>
</html>