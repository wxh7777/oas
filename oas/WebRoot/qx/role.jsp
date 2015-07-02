<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<title>角色管理</title>
	<jsp:include page="/head.jsp" flush="true"></jsp:include>
</head>
<body onLoad="init()"> 
<nav class="breadcrumb"><i class="iconfont">&#xf012b;</i> 首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span> 角色管理 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="icon-refresh"></i></a></nav> 
<div class="pd-20 pb-100">
  <div class="cl pd-5 bg-1 bk-gray">
    <span class="l">
      <a class="btn btn-primary radius" href="javascript:;" onclick="admin_role_add('750','','添加角色','role-add.jsp')"><i class="icon-plus"></i> 添加角色</a>
    </span>
  </div>
  <table class="table table-border table-bordered table-hover table-bg">
    <thead>
      <tr>
        <th scope="col" colspan="6">角色管理</th>
      </tr>
      <tr class="text-c">
        <th width="40">ID</th>
        <th width="100">角色名</th>
        <th width="150">用户列表</th>
        <th width="300">描述</th>
        <th width="70">修改</th>
        <th width="70">删除</th>
      </tr>
    </thead>
    <tbody>
      <tr class="text-c">
        <td>1</td>
        <td>超级管理员</td>
        <td><a href="#">admin</a></td>
        <td>拥有至高无上的权利</td>
        <td class="f-14">
        	<a title="修改" href="javascript:;" onclick="admin_role_edit('1','750','','角色编辑','admin-role-add.html')" style="text-decoration:none"><i class="icon-edit"></i></a> 
        </td>
        <td class="f-14">
        	<a title="删除" href="javascript:;" onclick="admin_role_del(this,'1')" class="ml-5" style="text-decoration:none"><i class="icon-trash"></i></a>
        </td>
      </tr>
    </tbody>
  </table>
</div>
<jsp:include page="/footer.jsp" flush="true"></jsp:include>
<script src="./js/projects.js" type="text/javascript" charset="utf-8" ></script>
</body>
</html>