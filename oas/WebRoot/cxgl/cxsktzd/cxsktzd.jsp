<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<title>查询收款通知单</title>
	<jsp:include page="/head.jsp" flush="true"></jsp:include>
</head>
<body onLoad="init()"> 
<nav class="breadcrumb"><i class="iconfont">&#xf012b;</i> 首页 <span class="c-gray en">&gt;</span> 查询收款通知单 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="icon-refresh"></i></a></nav> 
<div class="pd-20">
	<div class="text-c">
		<table class="table table-border table-bordered table-striped">
          <tbody>
            <tr>
              <td><div class="text-r">合同编号</div></td>
              <td><input type="text" class="input-text"  id="htbh" name="htbh"  placeholder="合同编号"></td>
              <td><div class="text-r">业主名称</div></td>
              <td><input type="text" class="input-text"  id="yzmc" name="yzmc" placeholder="业主名称"></td>
            </tr>
            <tr>
              <td><div class="text-r">时间</div></td>
              <td><input type="text" class="input-text" onClick="WdatePicker()" readonly id="sj" name="sj" placeholder="时间"></td>
              <td><div class="text-r">工程类别</div></td>
              <td>
              	<span class="select-box">
				    <select class="select" id="lb" name="lb" size="1">
				        <option value="0">类别1</option>
				        <option value="1">类别2</option>
				    </select>
			    </span>
              </td>
            </tr>
            <tr class="text-c">
            <td  colspan="4">
            	<button  onclick="doSearch()" class="btn btn-success" id="" name=""><i class="icon-search"></i> 查询</button>
			</td>
			</tr>
          </tbody>
        </table>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> 
		<span class="r">
		<a href="javascript:;" onclick="exportJg()" class="btn btn-primary radius"><i class="icon-plus"></i> 导出</a>
		</span> 
	</div>
	<table class="table table-border table-bordered table-hover table-bg table-sort"  id="tableJg">
		<thead>
			<tr class="text-c">
				<th  style="width:50px;">序号</th>
				<th style="width:100px;">计量期数</th>
				<th style="width:100px;">计量日期</th>
				<th style="width:100px;">计量款</th>
				<th style="width:100px;">质保金</th>
				<th style="width:150px;">农民工工资保证金</th>
				<th style="width:100px;">其他扣款</th>
			</tr>
		</thead>
		<tbody id="tbBody">
		</tbody>
	</table>
</div>
<jsp:include page="/footer.jsp" flush="true"></jsp:include>
<script src="./js/cxsktzd.js" type="text/javascript" charset="utf-8" ></script>
</body>
</html>