
//初始化收入合同列表
function initIncomeContractList(){
	//判断是否登录
    isLogin();
    //初始化列表
	$('#incomeContractListTable').DataTable({
		ajax:"recoverfund-getIncomeContractList.action",
	    bSort:false,
	    columns:[
	                { data: "ID" },
	                { data: "XM_MC" },
	                { data: "TYPE" },
	                { data: "NUMBER" },
	                { data: "PATH" }
	    ],
	    oLanguage: {
	            	"sLengthMenu": "每页显示 _MENU_ 条记录",
	            	"sZeroRecords": "抱歉， 没有找到",
	            	"sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
	            	"sInfoEmpty": "没有数据",
	            	"sInfoFiltered": "(从 _MAX_ 条数据中检索)",
	            	"oPaginate": {
		            	"sFirst": "首页",
		            	"sPrevious": "前一页",
		            	"sNext": "后一页",
		            	"sLast": "尾页"
		            	}
	      }
	});
}

//添加收入合同
function addIncomeContract(){
	layerShow("800","","添加收入合同","lrsrht-add.jsp?type=add");
}

//上传收入合同
function uploadIncomeContract(){
	var options = {  
			type:'post',
		    url:'file-uploadIncomeContract.action',
	        success: function(data){ 
	        	if(data>0){
	        		layer.msg("上传成功",2,{type:1});
	        		//延迟1s执行
	        		setTimeout(layerClose,1000);
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