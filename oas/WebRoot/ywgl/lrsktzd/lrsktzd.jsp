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
	<div class="text-c">
		<table class="table table-border table-bordered table-striped">
          <tbody>
            <tr>
              <td><div class="text-r">合同编号</div></td>
              <td><input type="text" class="input-text" id="htbh" name="htbh"  placeholder="合同编号"></td>
            </tr>
            <tr>
              <td><div class="text-r">业主名称</div></td>
              <td><input type="text" class="input-text"  id="yzmc" name="yzmc" placeholder="业主名称"></td>
            </tr>
            <tr>
              <td><div class="text-r">时间</div></td>
              <td><input type="text" class="input-text" onClick="WdatePicker()" readonly id="sj" name="sj"  placeholder="时间"></td>
            </tr>
            <tr>
              <td><div class="text-r">工程类别</div></td>
              <td>
              	<span class="select-box">
				    <select class="select" id="gclb" name="gclb" size="1">
				        <option value="0">类别1</option>
				        <option value="1">类别2</option>
				    </select>
			    </span>
			  </td>
            </tr>
            <tr>
              <td><div class="text-r">计量期数</div></td>
              <td><input type="text" class="input-text"  id="jbr" name="jbr"  placeholder="经办人"></td>
            </tr>
            <tr>
              <td><div class="text-r">计量日期</div></td>
              <td><input type="text" class="input-text"  id="gys" name="gys" placeholder="供应商"></td>
            </tr>
            <tr>
              <td><div class="text-r">计量款</div></td>
              <td><input type="text" class="input-text"  id="kzr" name="kzr" placeholder="控制人"></td>
            </tr>
            <tr>
              <td><div class="text-r">质保金</div></td>
              <td><input type="text" class="input-text"  id="kzr" name="kzr" placeholder="控制人"></td>
            </tr>
            <tr>
              <td><div class="text-r">农民工工资保证金</div></td>
              <td><input type="text" class="input-text"  id="kzr" name="kzr" placeholder="控制人"></td>
            </tr>
            <tr>
              <td><div class="text-r">其他扣款</div></td>
              <td><input type="text" class="input-text"  id="kzr" name="kzr" placeholder="控制人"></td>
            </tr>
          </tbody>
        </table>
	</div>
	</br>
    <table  class="table table-hover table-bg table-sort" >
		<tr>
			<td class="text-r">
				<a href="javascript:;" onclick="doSave()" class="btn btn-success"><i class="icon-save"></i> 保存</a>
			</td>
			<td class="text-l">
				<a href="javascript:;" onclick="doClean()" class="btn btn-success"><i class="icon-save"></i> 清空</a>
			</td>
		</tr>
  	</table>
</div>
<jsp:include page="/footer.jsp" flush="true"></jsp:include>
<script src="./js/lrsktzd.js" type="text/javascript" charset="utf-8" ></script>
</body>
</html>