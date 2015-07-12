
function init(){
    isLogin();
}

//提交收款通知单
function doReceivableNoticeCardSubmit(){
	var options = {  
			type:'post',
		    url:'recoverfund-doReceivableNoticeCardSubmit.action',
	        success: function(data){ 
	        	if(data>0){
	        		layer.msg("保存成功",2,{type:1});
		        	$( "#receivalbeNoticeCardForm").resetForm(); 
	        	}else{
	        		layer.msg("保存失败，请重新提交");
	        	}
            },  
            error: function(XmlHttpRequest, textStatus, errorThrown){
            	layer.msg("保存失败，请重新提交");  
            }
		};  
	 $("#receivalbeNoticeCardForm").ajaxSubmit(options); 
}

//清空
function doReceivableNoticeCardClean(){
	$( "#receivalbeNoticeCardForm").resetForm();
}