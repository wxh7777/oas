<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<title>生成付款通知单</title>
	<jsp:include page="/head.jsp" flush="true"></jsp:include>
</head>
<body onLoad="init()"> 
<nav class="breadcrumb"><i class="iconfont">&#xf012b;</i> 首页  <span class="c-gray en">&gt;</span> 生成付款通知单 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="icon-refresh"></i></a></nav> 
<div class="pd-20">
	<div class="text-c pd-5">
		<form id="searchForm" method="POST">
		<table class="table">
            <tr>
            	<td ><div class="text-r">项目名称</div></td>
             	<td ><select class="select select-box" id="xmdm" name="xmdm" onchange="getHtList()" size="1"></select></td>
            	<td ><div class="text-r">合同编号</div></td>
             	<td ><select class="select select-box" id="selHtbh" name="htbh" size="1"></select></td>
			</tr>
			<tr>
				<td colspan="4" class="text-c">
            		<a  onclick="doSearch()" class="btn btn-success"><i class="icon-search"></i> 查询已授权的结算单</a>
				</td>
			</tr>
        </table>
        </form>
	</div>
	<div id="info"></div>
	<div id="tableDiv" class="pt-10">
	<table class="table table-border table-bordered table-hover table-bg table-sort"  id="tableJg">
		<thead>
			<tr class="text-c">
				<th>ID</th>
				<th>序号</th>
				<th>结算单编号</th>
				<th>金额</th>
				<th>授权金额</th>
				<th>处理状态</th>
				<th>处理状态代码</th>
				<th>生成付款通知单</th>
			</tr>
		</thead>
		<tbody class="text-c">
		</tbody>
	</table>
	</div>
</div>
<jsp:include page="/footer.jsp" flush="true"></jsp:include>
<script src="./js/scfktzd.js" type="text/javascript" charset="utf-8" ></script>
</body>
</html>