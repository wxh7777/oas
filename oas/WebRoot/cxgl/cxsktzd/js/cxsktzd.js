
function init(){
	//是否登录
    isLogin();
    //初始化表格
    initReceivalbeNoticeCardTotalTable();
}

//初始化汇总表格
function initReceivalbeNoticeCardTotalTable(){
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
	                { data: "LAST" },
	                { data: "CREATE_TIME" }	                
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