<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<title>查询管理</title>
	<jsp:include page="/head.jsp" flush="true"></jsp:include>
</head>
<body onLoad="initSearch()"> 
<nav class="breadcrumb"><i class="iconfont">&#xf012b;</i> 首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span> 查询管理 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="icon-refresh"></i></a></nav> 
<div class="pd-20 pb-100">
  <table class="table table-hover table-bg">
    <tbody>
      <tr>
        <td width="80"><div class="text-r">选择角色</div></td>
        <td width="160">
          <span class="select-box" >
          	<select class="select" id="selRole" size="1"  onchange="getRoleList()"></select>
          </span>
        </td>
        <td width="80"><div class="text-r">选择查询功能</div></td>
        <td width="160">
          <span class="select-box" >
          	<select class="select" id="selRes" size="1"  onchange="getSearchRes()"></select>
          </span>
        </td>
      </tr>
      <tr>
      	<td class="text-l" colspan="4">此查询功能包含以下列：</td>
      </tr>
      <tr>
  		<td class="text-r" width="80"><input type="checkbox" value="" name=""></td>
  		<td class="text-l" colspan="3">项目名称</td>
  	  </tr>
  	  <tr>
  		<td class="text-r" width="80"><input type="checkbox" value="" name=""></td>
  		<td class="text-l" colspan="3">项目名称</td>
  	  </tr>
  	  <tr>
  		<td class="text-r" width="80"><input type="checkbox" value="" name=""></td>
  		<td class="text-l" colspan="3">项目名称</td>
  	  </tr>
      <tr class="text-c">
		<td colspan="4">
			<a href="javascript:;" onclick="onSave()" class="btn btn-success"><i class="icon-save"></i> 保存</a>
			<span>(保存后该角色查询时看不到未勾选的列)</span>
		</td>
	  </tr>
    </tbody>
  </table>
</div>
<jsp:include page="/footer.jsp" flush="true"></jsp:include>
<script src="./js/search.js" type="text/javascript" charset="utf-8" ></script>
</body>
</html>