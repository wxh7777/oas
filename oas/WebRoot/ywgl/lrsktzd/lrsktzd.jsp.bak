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
	<form id="receivalbeNoticeCardForm" action="" method="post">
		<div class="text-c">
			<table class="table table-border table-bordered table-striped">
	          <tbody>
	            <tr>
	              	<td><div class="text-r">项目名称</div></td>
	            	<td>
						<select class="select select-box" name="xiangmuId">
							<option value="11111139763039816337">项目一</option>
							<option value="11111139763039816337">项目二</option>
						</select>
					 </td>
	              	<td><div class="text-r">业主名称</div></td>
	              	<td>
	              		<input type="text" class="input-text" name="ownerName" placeholder="业主名称">
	              	</td>
	            </tr>
	            <tr>
	              	<td><div class="text-r">时间</div></td>
	              	<td>
	              		<input type="text" class="input-text" onClick="WdatePicker()" readonly name="time"  placeholder="时间">
	              	</td>
	              	<td><div class="text-r">工程类别</div></td>
	              	<td>
		              	<span class="select-box">
						    <select class="select" name="projectType" size="1">
						        <option value="类别1">类别1</option>
						        <option value="类别2">类别2</option>
						    </select>
					    </span>
				  	</td>
	            </tr>
	            <tr>
	              	<td><div class="text-r">计量期数</div></td>
	              	<td>
	              		<input type="text" class="input-text"  name="meteringNum"  placeholder="计量期数">
	              	</td>
		           
	              	<td><div class="text-r">计量日期</div></td>
	              	<td>
	              		<input type="text" class="input-text" onClick="WdatePicker()" readonly  name="meteringTime" placeholder="计量日期">
	              	</td>
	            </tr>
	            <tr>
	              	<td><div class="text-r">计量款</div></td>
	              	<td>
	              		<input type="text" class="input-text" name="meteringCash" placeholder="计量款">
	              	</td>
		            
	              	<td><div class="text-r">质保金</div></td>
	              	<td>
	              		<input type="text" class="input-text" name="warrantyCash" placeholder="质保金">
	              	</td>
	            </tr>
	            <tr>
	              	<td><div class="text-r">农民工工资保证金</div></td>
	              	<td>
	              		<input type="text" class="input-text" name="farmerCash" placeholder="农民工工资保证金">
	              	</td>
	              	<td><div class="text-r">其他扣款</div></td>
	              	<td>
	              		<input type="text" class="input-text" name="otherCash" placeholder="其他扣款">
	              	</td>
	            </tr>
	          </tbody>
	        </table>
		</div>
	    <table  class="table table-hover table-bg table-sort" >
			<tr>
				<td class="text-r">
					<a href="javascript:;" onclick="doReceivableNoticeCardSubmit()" class="btn btn-success"><i class="icon-save"></i> 保存</a>
				</td>
				<td class="text-l">
					<a href="javascript:;" onclick="doReceivableNoticeCardClean()" class="btn btn-success"><i class="icon-save"></i> 清空</a>
				</td>
			</tr>
	  	</table>
  	</form>
</div>
<jsp:include page="/footer.jsp" flush="true"></jsp:include>
<script src="./js/lrsktzd.js" type="text/javascript" charset="utf-8" ></script>
</body>
</html>