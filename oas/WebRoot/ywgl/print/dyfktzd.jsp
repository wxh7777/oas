<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<title>打印付款通知单</title>
	<jsp:include page="/head.jsp" flush="true"></jsp:include>
</head>
<body onload="init()">
<div class="pd-20">
  <form class="Huiform" id="form-role-add" action="" method="post">
    <table class="table table-border table-bordered table-bg">
      <tbody>
        <tr>
          <td class="text-c" colspan="8">材料结算单</td>
        </tr>
        <tr>
          <td class="text-r" colspan="8">结算单编号：XXXX</td>
        </tr>
        <tr>
          <td>合同编号</td>
          <td colspan="3"></td>
          <td colspan="2">期间</td>
          <td colspan="3"></td>
        </tr>
        <tr>
          <td>结算单位</td>
          <td colspan="3"></td>
          <td colspan="2">结算日期</td>
          <td colspan="3"></td>
        </tr>
        <tr>
          <td>结算项目</td>
          <td>规格</td>
          <td>数量</td>
          <td>单位</td>
          <td>单价</td>
          <td colspan="2">料款</td>
          <td>可否含税</td>
        </tr>
        <tr>
          <td>山皮石</td>
          <td></td>
          <td>12727.9</td>
          <td>吨</td>
          <td>29</td>
          <td colspan="2">369109.10</td>
          <td>含税</td>
        </tr>
        <tr>
          <td class="text-c">说明</td>
          <td class="text-l" colspan="7">结算单编号：XXXX</td>
        </tr>
        <tr>
        <tr class="text-c">
          <td>结算金额</td>
          <td></td>
          <td colspan="3">结算金额（大写）</td>
          <td colspan="3"></td>
        </tr>
		<tr class="text-c">
          <td width="100">公司主管</td>
          <td width="100"></td>
          <td width="100">工地负责人</td>
          <td width="100"></td>
          <td width="100">部门主管</td>
          <td width="100"></td>
          <td width="100">财务</td>
          <td width="100"></td>
        </tr>
        <tr class="text-c">
          <td width="100">复核</td>
          <td width="100"></td>
          <td width="100">统计</td>
          <td width="100"></td>
          <td width="100">经办人</td>
          <td width="100"></td>
          <td width="100">结算单位</td>
          <td width="100"></td>
        </tr>
        <tr class="text-r">
          <td colspan="4">统计员：XXXX</td>
          <td colspan="2">打印日期：XXXX</td>
          <td colspan="2">打印次数：XXXX</td>
        </tr>
        <tr>
          <td>
            <button type="submit" class="btn btn-success radius" id="admin-role-save" name="admin-role-save"><i class="icon-ok"></i> 确定</button>
          </td>
        </tr>
      </tbody>
    </table>
  </form>
</div>
<jsp:include page="/footer.jsp" flush="true"></jsp:include>
<script src="./js/print.js" type="text/javascript" charset="utf-8" ></script>
</body>
</html>