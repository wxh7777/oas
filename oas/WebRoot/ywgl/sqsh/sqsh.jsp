<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<title>授权审核</title>
	<jsp:include page="/head.jsp" flush="true"></jsp:include>
</head>
<body onLoad="init()"> 
<nav class="breadcrumb"><i class="iconfont">&#xf012b;</i> 首页 <span class="c-gray en">&gt;</span> 授权审核 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="icon-refresh"></i></a></nav> 
<div class="pd-20">
	<div class="text-c pd-5">
		<form id="searchForm" method="POST">
		<table class="table table-border table-bordered">
            <tr>
            	<td ><div class="text-r">项目名称</div></td>
             	<td ><select class="select select-box" id="xmdm" name="xmdm" onchange="getHtList()" size="1"></select></td>
            	<td ><div class="text-r">合同编号</div></td>
             	<td ><select class="select select-box" id="selHtbh" name="htbh" size="1"></select></td>
			</tr>
			<tr>
				<td colspan="4" class="text-c">
            		<a  onclick="doSearch()" class="btn btn-success"><i class="icon-search"></i> 查询待审核的授权</a>
				</td>
			</tr>
        </table>
        </form>
	</div>
	<table id="tableJg" class="table table-border table-bordered table-striped">
       	<thead>
       		<tr class="text-c">
       			<th id="ID" display="none">授权ID</th>
       			<th id="SQXH">授权序号</th>
       			<th id="JSDBH">结算单编号</th>
       			<th id="JE">结算单金额</th>
       			<!--<th id="YSQJE">已授权金额</th>-->
       			<th id="YSQCS">已授权次数</th>
       			<th id="BCSQJE">本次授权金额</th>
       			<th id="SQLY">授权理由</th>
       			<th >审核结果</th>
       			<th >预授权标志</th>
       			<th id="SH">审核</th>
       			<th id="SH">拒绝</th>
       		</tr>
       	</thead>
       	<tbody class="text-c"></tbody>
	</table>
</div>
<jsp:include page="/footer.jsp" flush="true"></jsp:include>
<script src="./js/sqsh.js" type="text/javascript" charset="utf-8" ></script>
</body>
</html>