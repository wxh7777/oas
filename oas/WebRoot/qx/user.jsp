<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<title>用户管理</title>
	<jsp:include page="/head.jsp" flush="true"></jsp:include>
</head>
<body onLoad="initUser()"> 
<nav class="breadcrumb"><i class="iconfont">&#xf012b;</i> 首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span> 用户管理 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="icon-refresh"></i></a></nav> 
<div class="pd-20 pb-100">
  <div class="cl pd-5 bg-1 bk-gray">
    <span class="l">
      <a class="btn btn-primary radius" href="javascript:;" onclick="addUser()"><i class="icon-plus"></i> 添加用户</a>
    </span>
  </div>
  <div  class="container">
  <table id="tableJg" class="table table-striped table-bordered table-condensed" cellspacing="0" width="100%">
	<thead class="text-c">
		<tr>
            <th >ID</th>
            <th width="100">用户名</th>
            <th width="100">登录账号</th>
            <th width="200">权限列表</th>
            <th >权限列表ID</th>
            <th width="200">备注</th>
            <th width="100">修改</th>
            <th width="100">删除</th>
		</tr>
	</thead>
    <tbody  class="text-c">
    </tbody>
  </table>
  </div>
</div>
<jsp:include page="/footer.jsp" flush="true"></jsp:include>
<script src="./js/user.js" type="text/javascript" charset="utf-8" ></script>
</body>
</html>