<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<title>录入收款通知单</title>
	<jsp:include page="/head.jsp" flush="true"></jsp:include>
</head>
<body onLoad="init()"> 
<nav class="breadcrumb"><i class="iconfont">&#xf012b;</i> 首页 <span class="c-gray en">&gt;</span> 录入收款通知单 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="icon-refresh"></i></a></nav> 
<div class="pd-20">
	<%
		//判断什么role才有添加收款通知单权限
	%>
 	<div class="cl pd-5 bg-1 bk-gray">
   		<span class="l">
     		<a class="btn btn-primary radius" href="javascript:;" onclick="addReceivalbeNoticeCard()"><i class="icon-plus"></i> 添加收款通知单</a>
   		</span>
 	</div>
 	<%
 	%>
 	<div  class="container">
	  	<table id="receivalbeNoticeCardListTable" class="table table-striped table-bordered table-condensed" cellspacing="0" width="100%">
			<thead class="text-c">
				<tr>
			        <th width="100">ID</th>
			        <th width="100">项目名称</th>
			        <th width="80">计量期数</th>
			        <th width="80">开工预付款</th>
			        <th width="80">计量款</th>
			        <th width="80">保留金10%</th>
			        <th width="80">质保金5%</th>
			        <th width="80">农民工保证金</th>
			        <th width="80">其他</th>
			        <th>备注</th>
				</tr>
			</thead>
	    	<tbody class="text-c">
	    	</tbody>
	  	</table>
  	</div>
</div>
<jsp:include page="/footer.jsp" flush="true"></jsp:include>
<script src="./js/lrsktzd.js" type="text/javascript" charset="utf-8" ></script>
</body>
</html>