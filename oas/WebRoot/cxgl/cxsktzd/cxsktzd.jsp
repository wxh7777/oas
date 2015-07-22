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
<nav class="breadcrumb"><i class="iconfont">&#xf012b;</i> 首页 <span class="c-gray en">&gt;</span>查询收款通知单 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="icon-refresh"></i></a></nav> 
<div class="pd-20">
	<div  class="container">
	  	<table id="receivalbeNoticeCardTotalTable" class="table table-striped table-bordered table-condensed" cellspacing="0" width="100%">
			<thead class="text-c">
				<tr>
			        <th rowspan="2" width="100">项目名称</th>
			        <th rowspan="2" width="80">期初应收款</th>
			        <th colspan="7" width="80">本次收款情况</th>
			        <th rowspan="2" width="80">期末应收款</th>
			        <th rowspan="2" width="80">时间</th>
				</tr>
				<tr>
			        <th width="80">开工预付款</th>
			        <th width="80">计量款</th>
			        <th width="80">保留金</th>
			        <th width="80">质保金5%</th>
			        <th width="80">农民工保证金</th>
			        <th width="80">其他</th>
			        <th width="80">合计</th>
				</tr>
			</thead>
	    	<tbody class="text-c">
	    	</tbody>
	  	</table>
  	</div>
</div>
<jsp:include page="/footer.jsp" flush="true"></jsp:include>
<script src="./js/cxsktzd.js" type="text/javascript" charset="utf-8" ></script>
</body>
</html>