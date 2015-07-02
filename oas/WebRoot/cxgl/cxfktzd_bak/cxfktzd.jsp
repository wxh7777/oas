<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<title>查询付款通知单</title>
	<jsp:include page="/head.jsp" flush="true"></jsp:include>
</head>
<body onLoad="init()">
<nav class="breadcrumb"><i class="iconfont">&#xf012b;</i> 首页  <span class="c-gray en">&gt;</span> 查询付款通知单 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="icon-refresh"></i></a></nav> 
<div class="pd-20">
	<div class="text-c">
	<form id="searchForm" method="POST">
		<table class="table table-border table-bordered table-striped">
          <tbody>
            <tr>
              <td><div class="text-r">项目名称</div></td>
          	  <td>
          			<select class="select select-box" id="xmmc" name="xmmc" size="1" ></select>
          	  </td>
             <td><div class="text-r">合同编号</div></td>
              <td><select class="select select-box" id="selHtbh" name="htbh"  size="1"></select></td>
            </tr>
            <tr>
              <td><div class="text-r">收款单位</div></td>
              <td><input type="text" class="input-text"  id="skdw" name="skdw"  placeholder="收款单位"></td>
              <td><div class="text-r">日期</div></td>
              <td><input type="text" class="input-text" onClick="WdatePicker()" readonly id="rq" name="rq" placeholder="日期"></td>
            </tr>
            <tr>
              <td><div class="text-r">经办人</div></td>
              <td><input type="text" class="input-text"  id="jbr" name="jbr"  placeholder="经办人"></td>
              <td><div class="text-r">供应商</div></td>
              <td><input type="text" class="input-text"  id="gys" name="gys" placeholder="供应商"></td>
            </tr>
            <tr>
              <td><div class="text-r">控制人</div></td>
              <td><input type="text" class="input-text"  id="kzr" name="kzr"  placeholder="控制人"></td>
            </tr>
            <tr class="text-c">
            <td  colspan="4">
            	<button  onclick="doSearch()" class="btn btn-success" id="" name=""><i class="icon-search"></i> 查询</button>
			</td>
			</tr>
          </tbody>
        </table>
       </form>
	</div>
	<table class="table table-border table-bordered table-hover table-bg table-sort"  id="tableJg">
		<thead>
			<tr class="text-c">
				<th>ID</th>
				<th>序号</th>
				<th>项目名称</th>
				<th>类别</th>
				<th>结算单编号</th>
				<th>合同编号</th>
				<th>金额</th>
				<th>审核时间</th>
				<th>付款单金额</th>
				<th>已付款金额</th>
				<th>已授权金额</th>
				<th>结算日期</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody id="tbBody">
		</tbody>
	</table>
</div>
<jsp:include page="/footer.jsp" flush="true"></jsp:include>
<script src="./js/cxfktzd.js" type="text/javascript" charset="utf-8" ></script>
</body>
</html>