<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<title>查询资金日报</title>
	<jsp:include page="/head.jsp" flush="true"></jsp:include>
</head>
<body onLoad="init()"> 
<nav class="breadcrumb"><i class="iconfont">&#xf012b;</i> 首页  <span class="c-gray en">&gt;</span> 查询资金日报 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="icon-refresh"></i></a></nav> 
<div class="pd-20">
	<div class="text-c">
		<table class="table table-border table-bordered table-striped">
          <tbody>
            <tr>
              <td><div class="text-r">查询类型</div></td>
              <td>
              		<select class="select" id="cxlx" name="cxlx" onchange="changeType()" size="1">
				        <option value="0" >总计查询</option>
				        <option value="1" selected>日报查询</option>
				    </select>
			  </td>
			  <td colspan="2" width="50%"></td>
            </tr>
            <tr id="rbcx">
              <td><div class="text-r">日期</div></td>
              <td><input type="text" class="input-text" onClick="WdatePicker()" readonly id="rq" name="rq" placeholder="点击选择日期"></td>
			  <td colspan="2"></td>
            </tr>
            <tr id="zjcx" style="display:none">
              <td><div class="text-r">日期起</div></td>
              <td><input type="text" class="input-text" onClick="WdatePicker()" readonly id="rqq" name="rqq" placeholder="点击选择起始日期"></td>
              <td><div class="text-r">日期止</div></td>
              <td><input type="text" class="input-text" onClick="WdatePicker()" readonly id="rqz" name="rqz" placeholder="点击选择结束日期"></td>
            </tr>
            <tr class="text-c">
            <td  colspan="4">
            	<button  onclick="doSearch()" class="btn btn-success" id="" name=""><i class="icon-search"></i> 查询</button>
			</td>
			</tr>
          </tbody>
        </table>
	</div>
	<table class="table table-border table-bordered table-striped table-hover"  id="tableJg">	
	</table>
</div>
<jsp:include page="/footer.jsp" flush="true"></jsp:include>
<script src="./js/cxzjrb.js" type="text/javascript" charset="utf-8" ></script>
</body>
</html>