<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<title>查询结算合同台账</title>
	<jsp:include page="/head.jsp" flush="true"></jsp:include>
</head>
<body onLoad="init()"> 
<nav class="breadcrumb"><i class="iconfont">&#xf012b;</i> 首页 <span class="c-gray en">&gt;</span> 查询结算合同台账 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="icon-refresh"></i></a></nav> 
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
              <td><div class="text-r">合同类型</div></td>
          	  <td>
          			<select class="select select-box" id="htlx" name="htlx" size="1"  onchange="getHtbh()"></select>
          	  </td>
            </tr>
            <tr>
            <td><div class="text-r">合同名称</div></td>
              <td><input type="text" class="input-text"  id="htmc" name="htmc" placeholder="合同名称"></td>
              <td><div class="text-r">合同编号</div></td>
              <td><input type="text" class="input-text"  id="htbh" name="htbh" placeholder="合同编号"></td>
            </tr>
            <tr>
              <td><div class="text-r">时间起</div></td>
              <td><input type="text" class="input-text" onClick="WdatePicker()" readonly id="sjq" name="sjq" ></td>
              <td><div class="text-r">时间止</div></td>
              <td><input type="text" class="input-text" onClick="WdatePicker()" readonly id="sjz" name="sjz" ></td>
            </tr>
            <tr>
              <td><div class="text-r">经办人</div></td>
              <td><input type="text" class="input-text"  id="jbr" name="jbr"  placeholder="经办人"></td>
              <td><div class="text-r">供应商</div></td>
              <td><input type="text" class="input-text"  id="gys" name="gys" placeholder="供应商"></td>
            </tr>
            <tr>
              <td><div class="text-r">控制人</div></td>
              <td><input type="text" class="input-text"  id="kzr" name="kzr" placeholder="控制人"></td>
           	  <td colspan="2"></td>
            </tr>
          </tbody>
        </table>
        </form>
	</div>
	
    <div align="center" class="pt-10">
         <a  onclick="doSearch()" class="btn btn-success"><i class="icon-search"></i> 查询</a>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> 
		<!-- <span class="r">
		<a href="javascript:;" onclick="exportJg()" class="btn btn-primary radius"><i class="icon-plus"></i> 导出</a>
		</span>  -->
	</div>
	<table class="table table-border table-bordered table-hover table-bg table-sort"  id="tableJg">
		<thead>
			<tr class="text-c">
				<th>序号</th>
				<th>项目名称</th>
				<th>类别</th>
				<th>合同编号</th>
				<th>合同名称</th>
				<th>资源名称</th>
				<th>规格</th>
				<th>单位</th>
				<th>单价</th>
				<th>经办人</th>
				<th>供应商</th>
				<th>控制人</th>
				<th>签订日期</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</div>
<div class="pt-20"></div>
<jsp:include page="/footer.jsp" flush="true"></jsp:include>
<script src="./js/cxjshttz.js" type="text/javascript" charset="utf-8" ></script>
</body>
</html>