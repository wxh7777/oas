<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<title>项目编辑</title>
	<jsp:include page="/headb.jsp" flush="true"></jsp:include>
<style>

.table .text-c th,.table .text-c td{text-align:center}/*整行居中*/
.table .text-r th,.table .text-r td{text-align:right}/*整行居右*/
.table th.text-l,.table td.text-l{text-align:left!important}/*单独列居左*/
.table th.text-c,.table td.text-c{text-align:center!important}/*单独列居中*/
.table th.text-r,.table td.text-r{text-align:right!important}/*单独列居右*/

</style>
</head>
<body onload="initAdd()">
<div class="pd-20 radius">
  <form class="Huiform" id="form-add" action="" method="post">
    <table class="table table-border table-bordered table-bg table-condensed radius">
      <tbody>
        <tr style="display:none">
          <td class="text-r va-m cl-4">项目ID：</td>
          <td><input id="id" name="proAdd.id" type="text" class="input-text" datatype="*1-20" nullmsg="角色名称不能为空！"> 
          </td>
        </tr>
        <tr>
          <td class="text-r cl-4">项目名称：</td>
          <td><input id="name" name="proAdd.name" type="text" class="input-text" datatype="*1-20" nullmsg="角色名称不能为空！"> 
          </td>
        </tr>
        <tr>
          <td class="text-r va-t cl-4">项目说明：</td>
          <td>
          	<input id="xmsm" name="proAdd.xmsm" type="text" class="input-text" datatype="*1-20" nullmsg="登陆账号不能为空！"> 
          </td>
        </tr>
        <tr>
          <td class="text-r va-t cl-4">选择人员</td>
          <td class="cl-8">
          	<div class="btn-group">
	            <select id="users-selected" name="proAdd.selrylb" multiple="multiple">
				</select>
        	</div>
          	
          </td>
        </tr>
        <tr style="height:200px">
          <td colspan="4" class="text-c va-b">
            <button type="submit" class="btn btn-success radius" id="btnsave" name="btnsave" onclick="saveProject()"><i class="icon-save"></i> 保存</button>
          	<button  class="btn btn-info radius" id="btnCancel" name="btnCancel" onclick="layerClose()"><i class="icon-save"></i> 取消</button>
          </td>
        </tr>
      </tbody>
    </table>
  </form>
</div>
<jsp:include page="/footer.jsp" flush="true"></jsp:include>
<script src="./js/projects.js" type="text/javascript" charset="utf-8" ></script>
</body>
</html>