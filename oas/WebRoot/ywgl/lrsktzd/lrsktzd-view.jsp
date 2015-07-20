<%@page import="com.pfkj.oas.recover.model.ReceivableNoticeCard"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%
	ReceivableNoticeCard receivableNoticeCard = (ReceivableNoticeCard)request.getAttribute("receivableNoticeCard");
	String xiangMuName = (String)request.getAttribute("xiangMuName");
%>

<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<title>查看收款通知单</title>
	<jsp:include page="/head.jsp" flush="true"></jsp:include>
</head>
<body onLoad="isLogin()">  
<div class="pd-20">
	<form id="receivalbeNoticeCardForm" action="" method="post">
		<div class="text-c">
			<table class="table table-border table-bordered table-striped">
			<colgroup>
				<col width="7%">
				<col width="2%">
				<col width="10%">
				<col width="10%">
				<col width="2%">
				<col width="10%">
				<col width="10%">
			</colgroup>
	          <tbody>
	          	<tr>
	          		<td colspan="2"><div class="text-r">项目名称</div></td>
	            	<td colspan="3">
						<%=xiangMuName %>					
					</td>
					<td><div class="text-r">合同金额</div></td>
	            	<td>
	            		<%=receivableNoticeCard.getContractMoney() %>
					 </td>
	          	</tr>
	          	<tr>
	          		<td colspan="2" rowspan="3"><div class="text-r">计量及收款</div></td>
	          		<td>
	          			<div class="text-r">累计计量</div>
	          		</td>
	          		<td>
	          			<%=receivableNoticeCard.getTotalMetering() %>
	          		</td>
	          		<td colspan="2"><div class="text-r">累计收款</div></td>
	          		<td>
	          			<%=receivableNoticeCard.getTotalReceivables() %>
	          		</td>
	          	</tr>
	          	<tr>
	          		<td><div class="text-r">应收计量款</div></td>
	          		<td>
	          			<%=receivableNoticeCard.getMustMeteringMoney() %>
	          		</td>
	          		<td colspan="2"><div class="text-r">累计开票</div></td>
	          		<td>
	          			<%=receivableNoticeCard.getTotalBilling() %>
	          		</td>
	          	</tr>
	          	<tr>
	          		<td><div class="text-r">其他</div></td>
	          		<td>
	          			<%=receivableNoticeCard.getMustOtherMoney() %>
	          		</td>
	          		<td colspan="2"><div class="text-r">应收款合计</div></td>
	          		<td>
	          			<%=receivableNoticeCard.getMustTotalMoney() %>
	          		</td>
	          	</tr>
	          	<tr>
	          		<td rowspan="7"><div class="text-r">本次收款情况</div></td>
	          		<td colspan="2"><div class="text-r">本次收计量款合计</div></td>
	          		<td>
	          			<%=receivableNoticeCard.getTotalMeteringMoney() %>
	          		</td>
	          		
	          		<td colspan="2"><div class="text-r">应收工程款合计</div></td>
	          		<td>
	          			<%=receivableNoticeCard.getMustTotalProjectMoney() %>
	          		</td>
	          	</tr>
	          	<tr>
          			<td rowspan="6"><div class="text-r">其中</div></td>
          			<td><div class="text-r">开工预付款</div></td>
          			<td>
          				<%=receivableNoticeCard.getAdvanceMoney() %>
          			</td>
          			<td rowspan="5"><div class="text-r" style="">应<br>收<br>账<br>款<br>、<br>其<br>他<br>应<br>收<br>款</div></td>
          			<td><div class="text-r">计量款</div></td>
          			<td>
          				<%=receivableNoticeCard.getMeteringMoney() %>
          			</td>
          		</tr>
	          	<tr>
          			<td><div class="text-r">计量款</div></td>
          			<td>
          				<%=receivableNoticeCard.getProjectMeteringMoney() %>
          			</td>
          			
          			<td><div class="text-r">保留金10%</div></td>
          			<td>
          				<%=receivableNoticeCard.getHoldMoney() %>
          			</td>
          		</tr>
	          	<tr>	
          			<td><div class="text-r">保留金10%</div></td>
          			<td>
          				<%=receivableNoticeCard.getProjectHoldMoney() %>
          			</td>
          			
          			<td><div class="text-r">质保金5%</div></td>
          			<td>
          				<%=receivableNoticeCard.getWarrantyMoney() %>
          			</td>
          		</tr>
	          	<tr>	
          			<td><div class="text-r">质保金5%</div></td>
          			<td>
          				<%=receivableNoticeCard.getProjectWarrantyMoney() %>
          			</td>
          			
          			<td><div class="text-r">农民工保证金</div></td>
          			<td>
          				<%=receivableNoticeCard.getFarmerMoney() %>
          			</td>
          		</tr>
	          	<tr>	
          			<td><div class="text-r">农民工保证金</div></td>
          			<td>
          				<%=receivableNoticeCard.getProjectFarmerMoney() %>
          			</td>
          			
          			<td><div class="text-r">其他</div></td>
          			<td>
          				<%=receivableNoticeCard.getOtherMoney() %>
          			</td>
          		</tr>
          		<tr>
          			<td><div class="text-r">其他</div></td>
          			<td>
          				<%=receivableNoticeCard.getProjectOtherMoney() %>
          			</td>
          			<td colspan="2"><div class="text-r">已收工预付款</div></td>
          			<td>
          				<%=receivableNoticeCard.getProjectAdvanceMoney() %>
          			</td>
          		</tr>	
	          	<tr>
	          		<td colspan="2"><div class="text-r">备注</div></td>
	            	<td colspan="5">
	            		<%=receivableNoticeCard.getMemo() %>
	              	</td>
	          	</tr>
	          </tbody>
	        </table>
		</div>
  	</form>
</div>
<jsp:include page="/footer.jsp" flush="true"></jsp:include>
<script src="./js/lrsktzd.js" type="text/javascript" charset="utf-8" ></script>
</body>
</html>