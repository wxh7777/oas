<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<title>预授权付款</title>
	<jsp:include page="/head.jsp" flush="true"></jsp:include>
</head>
<body onLoad="init()"> 
<nav class="breadcrumb"><i class="iconfont">&#xf012b;</i> 首页 <span class="c-gray en">&gt;</span> 预授权付款 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="icon-refresh"></i></a></nav> 
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
            		<a  onclick="doSearch()" class="btn btn-success"><i class="icon-search"></i> 查询可授权结算单</a>
				</td>
			</tr>
        </table>
        </form>
	</div>

	<div id="ysqxx" class="pt-10">
	<table  class="table table-border table-bordered table-hover table-bg table-sort" >
		<tr>
	      <td><div class="text-r">预授权金额</div></td>
	      <td><input type="text" class="input-text"  id="skdw" name="skdw"  placeholder="预授权金额"></td>
	      <td><div class="text-r">授权理由</div></td>
	      <td><input type="text" class="input-text"  id="sqly" name="sqly"  placeholder="授权理由"></td>
	    </tr>
		<tr class="text-c">
			<td  colspan="4">
				<a href="javascript:;" onclick="doQdsq()" class="btn btn-success"><i class="icon-save"></i> 确定授权</a>
			</td>
		</tr>
	  </table>
	  </div>
</div>
<jsp:include page="/footer.jsp" flush="true"></jsp:include>
<script src="./js/sqfk.js" type="text/javascript" charset="utf-8" ></script>
</body>
</html>