<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<title>录入结算单数据</title>
	<jsp:include page="/head.jsp" flush="true"></jsp:include>
</head>
<body onLoad="init()"> 
<nav class="breadcrumb"><i class="iconfont">&#xf012b;</i> 首页 <span class="c-gray en">&gt;</span> 录入结算单数据 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="icon-refresh"></i></a></nav> 
<div class="pd-20">
	<div class="text-c">
	<form id="searchForm" method="POST">
		<table class="table">
          <tbody>
          	<tr>
          	<td><div class="text-r">项目名称</div></td>
          	<td>
          			<select class="select select-box" id="xmdm" name="xmdm" onchange="getHtList()" size="1"></select>
          	</td>
          	<td><div class="text-r">选择合同</div></td>
          	<td>
          			<select class="select select-box" id="selHtbh" name="htbh" onchange="getLx()" size="1"></select>
          	</td>
          	</tr>
            <tr>
              <td><div class="text-r">结算单编号</div></td>
              <td><input type="text" class="input-text"  id="jsdbh" name="jsdbh"  placeholder="结算单编号" readonly></td>
	          	<td><div class="text-r">类别</div></td>
	            <td><input type="text" class="input-text"  id="lb" name="lb"  placeholder="类别" readonly></td>
	            </td>
            </tr>
            <tr>
          	  <td><div class="text-r">结算项目/规格</div></td>
              <td><select class="select select-box" id="selJsxmGg" name="jsxmgg" size="1"></select></td>
              <td colspan="2"></td>
            </tr>
            <tr>
          	  <td><div class="text-r">日期</div></td>
              <td><input type="text" class="input-text" onClick="WdatePicker()" readonly id="rq" name="rq" placeholder="日期"></td>
              <td><div class="text-r">填报人</div></td>
              <td>
				<input type="text" class="input-text"  id="tbr" name="trb"  placeholder="请输入你的名字">
			  </td>
            </tr>
          </tbody>
        </table>
    </form>
  </div>
	<!-- <div class="cl pd-5 bg-1 bk-gray mt-20"> 
		<span class="r">
		<a href="javascript:;" onclick="addZy()" class="btn btn-primary radius"><i class="icon-plus"></i> 添加</a>
		<a href="javascript:;" onclick="importZy()" class="btn btn-danger radius"><i class="icon-save"></i> 导入</a> 
		</span> 
	</div> -->
	<div class="pd-20"></div>
	<table class="table">
		<tr>
			    <th width="200" class="text-r"><span>选择进场材料明细表文件：</span></th>
				<th width="450">
					<form id="jcMxForm" enctype="multipart/form-data" method="post">
				     	<span class="btn-upload form-group">
						  <input class="input-text upload-url radius" type="text" name="uploadfile-1" id="uploadfile-1" readonly>
						  <a href="javascript:void();" class="btn btn-primary radius"><i class="iconfont">&#xf0020;</i> 浏览</a>
						  <input type="file" multiple name="jcmxFile" class="input-file">
						</span>
			    	</form>
				</th>
				<th width="500" class="text-l">
			     	<button class="btn btn-primary radius" data-dismiss="modal" onclick="uploadJcmxFile()" >确定</button> 
			    </th>
		</tr>
	</table>
	<div class="pt-20">
  <table class="table table-border table-bordered">
  	<tr class="text-c">
  		<td width="50">结算单位</td><td width="100" id="jsdwTable"></td>
  		<td width="50">结算项目</td><td width="100" id="jsxmTable"></td>
  		<td width="50">规格</td><td width="100" id="ggTable"></td>
  		<td width="50">供货日期</td><td width="100" id="ghrqTable"></td>
  	</tr>
  </table>
  </div>
  <table class="table table-border table-bordered"  id="tableZy">
    <thead>
      <tr class="text-c">
		<th>序号</th>
		<th>票号</th>
		<th>数量</th>
		<th>单价</th>
		<th>总价</th>
      </tr>
    </thead>
    <tbody class="text-c">
    </tbody>
    <tfoot class="text-c">
    	<tr>
    		<td colspan="2">合计</td><td id="jsdzs"></td><td>/</td><td id="jsdzj"></td>
    	</tr>
    </tfoot>
  </table>
  
  </br>
  <div align="center" class="pt-10">
	<a href="javascript:;" onclick="doScjsd()" class="btn btn-success"><i class="icon-save"></i> 生成结算单</a>
  </div>
</div>
<jsp:include page="/footer.jsp" flush="true"></jsp:include>
<script src="./js/lrjsdsj.js" type="text/javascript" charset="utf-8" ></script>
</body>
</html>