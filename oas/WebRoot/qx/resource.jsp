<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<title>功能列表</title>
	<jsp:include page="/head.jsp" flush="true"></jsp:include>
</head>
<body onLoad="initResource()"> 
<nav class="breadcrumb">
	<i class="iconfont">&#xf012b;</i> 首页 
	<span class="c-gray en">&gt;</span> 系统管理 
	<span class="c-gray en">&gt;</span> 功能列表
	<a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
		<i class="icon-refresh"></i>
	</a>
</nav> 
<div class="pd-20 pb-100">
  <table id="tableJg" class="table table-border table-bordered table-hover table-bg">
    <thead>
      <tr class="text-c">
        <th>ID</th>
        <th width="100">功能名称</th>
        <th width="200">页面路径</th>
        <th width="300">功能描述</th>
      </tr>
    </thead>
    <tbody class="text-c">
    </tbody>
  </table>
</div>
<jsp:include page="/footer.jsp" flush="true"></jsp:include>
<script src="./js/resource.js" type="text/javascript" charset="utf-8" ></script>
</body>
</html>