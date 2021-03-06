
function init(){
	//判断是否登录
    isLogin();
    //初始化表格
    initReceivalbeNoticeCardListTable();
}

//初始化收款通知单列表
function initReceivalbeNoticeCardListTable(){
	$('#receivalbeNoticeCardListTable').DataTable({
		ajax:"recoverfund-getReceivalNoticeCardList.action",
	    bSort:false,
	    columns:[
	                { data: "ID" },
	                { data: "XM_MC" },
	                { data: "ADVANCE_MONEY" },
	                { data: "METERING_MONEY" },
	                { data: "HOLD_MONEY" },
	                { data: "WARRANTY_MONEY" },
	                { data: "FARMER_MONEY" },
	                { data: "OTHER_MONEY" },
	                { data: "CREATE_TIME" },
	                { data: "MEMO" }
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
	
	$('#receivalbeNoticeCardListTable tbody').on('click', 'tr', function () {
        var id = $('td', this).eq(0).text();
        var xiangMuName = $('td', this).eq(1).text();
        viewReceivalbeNoticeCard(id,xiangMuName);
    } );
}

//打开收款通知单
function addReceivalbeNoticeCard(){
	layerShow("800","","添加收款通知单","lrsktzd-add.jsp?type=add");
}

//查看
function viewReceivalbeNoticeCard(id,xiangMuName){
	layerShow("800","","查看收款通知单","recoverfund-getReceivalbeNoticeCardById.action?id="+id+"&xiangMuName="+xiangMuName);
}

//提交收款通知单
function doReceivableNoticeCardSubmit(){
	var options = {  
			type:'post',
		    url:'recoverfund-doReceivableNoticeCardSubmit.action',
	        success: function(data){ 
	        	if(data>0){
	        		layer.msg("保存成功");
	        		//延迟1s执行
	        		setTimeout(layerClose,1000);
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

//打开收款通知单汇总
function openReceivalbeNoticeCardTotal(){
	layerShow("800","","收款通知单汇总","lrsktzd-total.jsp?type=add");
}

//初始化汇总表格
function initReceivalbeNoticeCardTotalTable(){
	//判断是否登录
    isLogin();
    //初始化表格
	$('#receivalbeNoticeCardTotalTable').DataTable({
		ajax:"recoverfund-getReceivalNoticeCardTotalList.action",
	    bSort:false,
	    columns:[
	                { data: "XM_MC" },
	                { data: "MUST_TOTAL_MONEY" },
	                { data: "ADVANCE_MONEY" },
	                { data: "METERING_MONEY" },
	                { data: "HOLD_MONEY" },
	                { data: "WARRANTY_MONEY" },
	                { data: "FARMER_MONEY" },
	                { data: "OTHER_MONEY" },
	                { data: "TOTAL" },
	                { data: "LAST" }
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