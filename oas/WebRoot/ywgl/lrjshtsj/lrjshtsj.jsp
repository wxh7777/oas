<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<title>录入结算合同数据</title>
	<jsp:include page="/head.jsp" flush="true"></jsp:include>
</head>
<body onLoad="init()"> 
<nav class="breadcrumb"><i class="iconfont">&#xf012b;</i> 首页<span class="c-gray en">&gt;</span> 录入结算合同数据 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="icon-refresh"></i></a></nav> 
<div class="pd-20">
	<div class="text-c">
	<form id="jshtsjForm" method="POST">
		<table class="table">
          <tbody>
          	<tr>
              <td><div class="text-r">项目名称</div></td>
          	  <td>
          		<select class="select select-box" id="xmdm" name="xmdm" size="1" ></select>
          	  </td>
              <td><div class="text-r">合同核备编号</div></td>
          	  <td>
          			<select class="select select-box" id="hthb" name="hthbbh" size="1" >
          				<option value="0">请选择合同核备编号...</option>
          			</select>
          	  </td>
            </tr>
            <tr>
              <td><div class="text-r">合同类型</div></td>
          	  <td>
          			<select class="select select-box" id="htlb" name="htlx" size="1"  onchange="getHtbh()"></select>
          	  </td>
              <td><div class="text-r">合同编号</div></td>
              <td><input type="text" class="input-text"  id="htbh" name="htbh" placeholder="合同编号" readonly></td>
            </tr>
            <tr>
              <td><div class="text-r">日期</div></td>
              <td><input type="text" class="input-text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly id="rq" name="rq"  placeholder="日期"></td>
              <td><div class="text-r">合同名称</div></td>
              <td><input type="text" class="input-text"  id="htmc" name="htmc" placeholder="合同名称" readonly></td>
            </tr>
            <tr>
              <td><div class="text-r">结算单位名称</div></td>
              <td><input type="text" class="input-text"  id="jsdwmc" name="jsdwmc" placeholder="结算单位名称"></td>
              <td><div class="text-r">供应商</div></td>
              <td><input type="text" class="input-text"  id="gys" name="gys" placeholder="供应商"></td>
            </tr>
            <tr>
              <td><div class="text-r">控制人</div></td>
              <td><input type="text" class="input-text"  id="kzr" name="kzr" placeholder="控制人"></td>
              <td><div class="text-r">经办人</div></td>
              <td><input type="text" class="input-text"  id="jbr" name="jbr"  placeholder="经办人"></td>
            </tr>
            <tr>	
              <td><div class="text-r">填报人</div></td>
              <td><input type="text" class="input-text"  id="tbr" name="tbr" placeholder="填报人"></td>
            </tr>
          </tbody>
        </table>
        </form>
	</div>
	<div class="pt-20"></div>
	<table class="table">
		<tr>
			    <th width="100" class="text-r"><span>选择资源文件：</span></th>
				<th width="350">
					<form id="htMxForm" enctype="multipart/form-data" method="post">
				     	<span class="btn-upload form-group">
						  <input class="input-text upload-url radius" type="text" name="uploadfile-1" id="uploadfile-1" readonly>
						  <a href="javascript:void();" class="btn btn-primary radius"><i class="iconfont">&#xf0020;</i> 浏览</a>
						  <input type="file" multiple name="htmxFile" class="input-file">
						</span>
			    	</form>
				</th>
				<th width="500" class="text-l">
			     	<button class="btn btn-primary radius" data-dismiss="modal" onclick="uploadZymxFile()" >确定</button> 
			    </th>
		</tr>
	</table>
	<table  class="table table-border table-bordered table-hover table-bg table-sort"  id="tableZy">
		<thead>
			<tr class="text-c">
				<th>序号</th>
				<th>资源名称</th>
				<th>规格</th>
				<th>单位</th>
				<th>单价</th>
				<th>数量</th>
				<th>总价</th>
			</tr>
		</thead>
		<tbody  class="text-c">
		</tbody>
		<tfoot>
			<tr>
				<td class="text-r" colspan="6">合计：</td><td class="text-c"><span id="htzj">&nbsp;</span></td>
			</tr>
		</tfoot>
	</table>
	</br>
	<table>
		<tr class="text-c">
			<td>
				<a href="javascript:;" onclick="doSave()" class="btn btn-success"><i class="icon-save"></i> 保存</a>
			</td>
		</tr>
	</table>
</div>
<jsp:include page="/footer.jsp" flush="true"></jsp:include>
<script src="./js/lrjshtsj.js" type="text/javascript" charset="utf-8" ></script>
</body>
</html>