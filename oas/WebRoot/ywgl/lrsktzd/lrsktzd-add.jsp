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
<body onLoad="isLogin()">  
<div class="pd-20">
	<form id="receivalbeNoticeCardForm" action="" method="post">
		<div class="text-c">
			<table class="table table-border table-bordered table-striped">
	          <tbody>
	          	<tr>
	          		<td colspan="2"><div class="text-r">项目名称</div></td>
	            	<td colspan="3">
						<select class="select select-box" name="receivableNoticeCard.xiangmuId">
							<option value="11111139763039816337">项目一</option>
							<option value="11111118892061438478">项目二</option>
						</select>
					</td>
					<td><div class="text-r">合同金额</div></td>
	            	<td>
						<input type="text" class="input-text" name="receivableNoticeCard.contractMoney" placeholder="合同金额">
					 </td>
	          	</tr>
	          	<tr>
	          		<td colspan="2" rowspan="3"><div class="text-r">计量及收款</div></td>
	          		<td>
	          			<div class="text-r">计量期数</div>
	          		</td>
	          		<td>
	          			<input type="text" class="input-text" name="receivableNoticeCard.meteringNum" placeholder="计量期数">
	          		</td>
	          		<td colspan="2"><div class="text-r">累计收款</div></td>
	          		<td>
	          			<input type="text" class="input-text" name="receivableNoticeCard.totalReceivables" placeholder="累计收款">
	          		</td>
	          	</tr>
	          	<tr>
	          		<td><div class="text-r">应收计量款</div></td>
	          		<td>
	          			<input type="text" class="input-text" name="receivableNoticeCard.mustMeteringMoney" placeholder="应收计量款">
	          		</td>
	          		<td colspan="2"><div class="text-r">累计开票</div></td>
	          		<td>
	          			<input type="text" class="input-text" name="receivableNoticeCard.totalBilling" placeholder="累计开票">
	          		</td>
	          	</tr>
	          	<tr>
	          		<td><div class="text-r">其他</div></td>
	          		<td>
	          			<input type="text" class="input-text" name="receivableNoticeCard.mustOtherMoney" placeholder="其他">
	          		</td>
	          		<td colspan="2"><div class="text-r">应收款合计</div></td>
	          		<td>
	          			<input type="text" class="input-text" name="receivableNoticeCard.mustTotalMoney" placeholder="应收款合计">
	          		</td>
	          	</tr>
	          	<tr>
	          		<td rowspan="7"><div class="text-r">本次收款情况</div></td>
	          		<td colspan="2"><div class="text-r">本次收计量款合计</div></td>
	          		<td>
	          			<input type="text" class="input-text" name="receivableNoticeCard.totalMeteringMoney" placeholder="本次收计量款合计">
	          		</td>
	          		
	          		<td colspan="2"><div class="text-r">应收工程款合计</div></td>
	          		<td>
	          			<input type="text" class="input-text" name="receivableNoticeCard.mustTotalProjectMoney" placeholder="应收工程款合计">
	          		</td>
	          	</tr>
	          	<tr>
          			<td rowspan="6"><div class="text-r">其中</div></td>
          			<td><div class="text-r">开工预付款</div></td>
          			<td>
          				<input type="text" class="input-text" name="receivableNoticeCard.advanceMoney" placeholder="开工预付款">
          			</td>
          			<td rowspan="5"><div class="text-r" style="">应<br>收<br>账<br>款<br>、<br>其<br>他<br>应<br>收<br>款</div></td>
          			<td><div class="text-r">计量款</div></td>
          			<td>
          				<input type="text" class="input-text" name="receivableNoticeCard.meteringMoney" placeholder="计量款">
          			</td>
          		</tr>
	          	<tr>
          			<td><div class="text-r">计量款</div></td>
          			<td>
          				<input type="text" class="input-text" name="receivableNoticeCard.projectMeteringMoney" placeholder="计量款">
          			</td>
          			
          			<td><div class="text-r">保留金10%</div></td>
          			<td>
          				<input type="text" class="input-text" name="receivableNoticeCard.holdMoney" placeholder="保留金10%">
          			</td>
          		</tr>
	          	<tr>	
          			<td><div class="text-r">保留金10%</div></td>
          			<td>
          				<input type="text" class="input-text" name="receivableNoticeCard.projectHoldMoney" placeholder="保留金10%">
          			</td>
          			
          			<td><div class="text-r">质保金5%</div></td>
          			<td>
          				<input type="text" class="input-text" name="receivableNoticeCard.warrantyMoney" placeholder="质保金5%">
          			</td>
          		</tr>
	          	<tr>	
          			<td><div class="text-r">质保金5%</div></td>
          			<td>
          				<input type="text" class="input-text" name="receivableNoticeCard.projectWarrantyMoney" placeholder="质保金5%">
          			</td>
          			
          			<td><div class="text-r">农民工保证金</div></td>
          			<td>
          				<input type="text" class="input-text" name="receivableNoticeCard.farmerMoney" placeholder="农民工保证金">
          			</td>
          		</tr>
	          	<tr>	
          			<td><div class="text-r">农民工保证金</div></td>
          			<td>
          				<input type="text" class="input-text" name="receivableNoticeCard.projectFarmerMoney" placeholder="农民工保证金">
          			</td>
          			
          			<td><div class="text-r">其他</div></td>
          			<td>
          				<input type="text" class="input-text" name="receivableNoticeCard.otherMoney" placeholder="其他">
          			</td>
          		</tr>
          		<tr>
          			<td><div class="text-r">其他</div></td>
          			<td>
          				<input type="text" class="input-text" name="receivableNoticeCard.projectOtherMoney" placeholder="其他">
          			</td>
          			<td colspan="2"><div class="text-r">已收工预付款</div></td>
          			<td>
          				<input type="text" class="input-text" name="receivableNoticeCard.projectAdvanceMoney" placeholder="已收工预付款">
          			</td>
          		</tr>	
	          	<tr>
	          		<td colspan="2"><div class="text-r">备注</div></td>
	            	<td colspan="5">
	              		<input type="text" class="input-text"  name="receivableNoticeCard.memo"  placeholder="备注">
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