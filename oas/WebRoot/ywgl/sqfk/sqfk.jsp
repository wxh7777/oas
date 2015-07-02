<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<title>授权付款</title>
	<jsp:include page="/head.jsp" flush="true"></jsp:include>
</head>
<body onLoad="init()"> 
<nav class="breadcrumb"><i class="iconfont">&#xf012b;</i> 首页 <span class="c-gray en">&gt;</span> 授权付款 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="icon-refresh"></i></a></nav> 
<div class="pd-20">
	<div class="text-c pd-5">
	<form id="searchForm" method="POST">
		<table class="table ">
            <tr>
            	<td ><div class="text-r">项目名称</div></td>
             	<td ><select class="select select-box" id="xmdm" name="xmdm" onchange="getHtList()" size="1"></select></td>
            	<td ><div class="text-r">合同编号</div></td>
             	<td ><select class="select select-box" id="selHtbh" name="htbh" size="1"></select></td>
			</tr>
            <tr>
          	  <td><div class="text-r">供应商</div></td>
              <td><input type="text" class="input-text" readonly id="gys" name="gys" ></td>
              <td colspan="2"></td>
			</tr>
			<tr>
				<td colspan="4" class="text-c">
            		<a  onclick="doSearch()" class="btn btn-success"><i class="icon-search"></i> 查询可授权结算单</a>
				</td>
			</tr>
        </table>
        </form>
	</div>
	<div id="tableDiv" class="pd-5" style="display:none">
	<table class="table table-border table-bordered"  id="tableJg">
		<thead>
			<tr class="text-c">
				<th>序号</th>
				<th>项目名称</th>
				<th>类别</th>
				<th>结算单编号</th>
				<th>合同编号</th>
				<th>金额</th>
				<th>已授权金额</th>
				<th>已授权次数</th>
			</tr>
		</thead>
		<tbody  class="text-c">
		</tbody>
	</table>
	</div>
	<div id="sqxx" class="pt-5 text-c " style="display:none">
	<table class="table table-border table-bordered" align="center" style="width:50%">
		<tr>
			<td class="text-r">已授权金额</td><td id="ysqje"></td>
		</tr>
		<tr>
			<td class="text-r">未授权金额</td><td id="wsqje"></td>
		</tr>
		<tr>
			<td class="text-r">本次授权金额</td><td><input type="text" id="bcsqje" onchange="jsye()" class="input-text"/></td>
		</tr>
		<tr>
			<td class="text-r">本次余额</td><td id="bcye"></td>
		</tr>
		<tr>
			<td colspan="2" class="text-c">
				<a onclick="qrsq()" class="btn btn-success"><i class="icon-search"></i> 授权</a>
			</td>
		</tr>
	</table>
	</div>
	
	<div id="ysqxx" class="radius pd-20 text-c"  style="display:none">
	<table  class="table table-border table-bordered" align="center" style="width:50%">
		<tr>
	      <td width="100"><div class="text-r">预授权金额</div></td>
	      <td width="400"><input type="text" class="input-text"  id="yusqje" name="yusqje"  placeholder="预授权金额"></td>
	      </tr>
	      <tr><td class="text-r va-t">授权理由</td>
	      <td><textarea class="textarea"  id="ysqly" name="ysqly"  placeholder="授权理由"></textarea></td>
	    </tr>
		<tr class="text-c ">
			<td  colspan="2">
				<a href="javascript:;" onclick="doYsq()" class="btn btn-success"><i class="icon-save"></i> 确定授权</a>
			</td>
		</tr>
	  </table>
	  </div>
</div>
<jsp:include page="/footer.jsp" flush="true"></jsp:include>
<script src="./js/sqfk.js" type="text/javascript" charset="utf-8" ></script>
</body>
</html>