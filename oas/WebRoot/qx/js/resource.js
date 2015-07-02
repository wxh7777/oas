
function initResource(){
	isLogin();
	var str = getMsg("param=resource","qx-getList.action");
	if(str=="error"){
		alert("初始化数据失败");
	}
	else{
		var btnEdit = "<a href=\"javascript:;\" class=\"btn btn-success size-S editBtn\" >修改</a>"
		var btnDel = "<a href=\"javascript:;\"  class=\"btn btn-success size-S delBtn\" >删除</a>";
		$('#tableJg').DataTable({
			ajax:"qx-getList.action?param=resource",
		    bSort:false,
		    columns:[
		                { "data": "ID" },
		                { "data": "NAME" },
		                { "data": "URL" },
		                { "data": "DESC" }
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
		            	},
			aoColumnDefs: [ { "sClass":"dpass", "bSearchable" :false, "aTargets":[0] } ] 
		});
	}
	
}
