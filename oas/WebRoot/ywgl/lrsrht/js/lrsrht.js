
function init(){
    isLogin();
}
//上传收入合同
function uploadIncomeContract(){
	var options = {  
			type:'post',
		    url:'file-uploadIncomeContract.action',
	        success: function(data){ 
	        	if(data>0){
	        		layer.msg("上传成功");
		        	$( "#incomeContractForm").resetForm(); 
	        	}else{
	        		layer.msg("上传失败，请重新上传");
	        	}
            },  
            error: function(XmlHttpRequest, textStatus, errorThrown){
            	layer.msg("上传失败，请重新上传");  
            }
		};  
	 $("#incomeContractForm").ajaxSubmit(options); 
}