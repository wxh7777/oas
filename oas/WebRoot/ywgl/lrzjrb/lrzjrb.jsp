<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<title>录入收入合同</title>
	<jsp:include page="/head.jsp" flush="true"></jsp:include>
</head>
<body onLoad="init()"> 
<nav class="breadcrumb"><i class="iconfont">&#xf012b;</i> 首页 <span class="c-gray en">&gt;</span> 录入资金日报 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="icon-refresh"></i></a></nav> 
<div class="pd-20" style="width:90%;padding-left:5%">
	<div class="row">
		<div calss="col-3" style="float:left">填报单位：</div>
		<div calss="col-3" style="float:left"></div>
		<div calss="col-3" style="float:right">填报时间：</div>
		<div calss="col-3" style="float:right"></div>
	</div>
	<div class="row">
		<div class="col-12 pb-10">
			<table class="table" id="tableJg" style="table-layout:fixed;">	
				<thead class="text-c  table-border table-bordered table-striped" >
					<tr id="XM">
						<td id="NAME" colspan="3" width="18%">项目</td><td>银行存款</td>
						<td>现金</td><td>银行卡</td><td>承兑</td><td>合计</td>
					</tr>
					<tr id="QCJE">
						<td colspan="3">期初金额</td>
						<td id="qcje1" class="num">0</td>
						<td id="qcje2" class="num">0</td>
						<td id="qcje3" class="num">0</td>
						<td id="qcje4" class="num">0</td>
						<td name="HJL">0</td>
					</tr>
					<tr id="BQSR">
						<td colspan="3">本期收入</td>
						<td id="bssr1" class="num">0</td>
						<td id="bssr2" class="num">0</td>
						<td id="bssr3" class="num">0</td>
						<td id="bssr4" class="num">0</td>
						<td name="HJL">0</td>
					</tr>
					<tr id="BQZC">
						<td colspan="3">本期支出</td>
						<td id="bszc1" class="num">0</td>
						<td id="bszc2" class="num">0</td>
						<td id="bszc3" class="num">0</td>
						<td id="bszc4" class="num">0</td>
						<td name="HJL">0</td>
					</tr>
					<tr id="QMJE">
						<td colspan="3">期末余额</td>
						<td id="qmye1" class="num">0</td>
						<td id="qmye2" class="num">0</td>
						<td id="qmye3" class="num">0</td>
						<td id="qmye4" class="num">0</td>
						<td id="qmye" name="HJL">0</td>
					</tr>
					<tr id="LM">
						<td colspan="3">项目</td><td>银行存款</td><td>现金</td><td>银行卡</td><td>承兑</td><td>合计</td>
					</tr>
				</thead>
				<tbody id="zjrbBody"  class="text-c  table-border table-bordered table-striped">
				</tbody>
			</table>
		</div>
	</div>
	<div class="pt-10 text-c">
		<button type="button" onClick="doSave()" class="btn blue btn-primary radius"> 保存</button>
	</div>
</div>
<jsp:include page="/footer.jsp" flush="true"></jsp:include>
<script src="./js/lrzjrb.js" type="text/javascript" charset="utf-8" ></script>
</body>
</html>