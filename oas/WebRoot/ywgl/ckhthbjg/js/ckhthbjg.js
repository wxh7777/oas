
function init(){
	isLogin();
	var str = getMsg("","jsdgl-getHthbList.action");
	var data = eval("["+str+"]");
	var btnUpload = "<a href=\"javascript:;\" class=\"btn btn-success size-S uploadBtn\" >上传</a>"
	var uploadForm = "<form  enctype=\"multipart/form-data\" method=\"post\"><input type=\"file\" name=\"hthbYjFile\"></form>";
	$('#tableData').DataTable({
		data:data[0].data,
	    bSort:false,
	    columns:[
	                { "data": "HTHBBH" },
	                { "data": "HTWJLB" },
	                { "data": "GCBSHYJWD" },
	                { "data": "GCBSHSJ" },
	                { "data": "GCBSHR" },
	                { "data": "SWBSHYJWD" },
	                { "data": "SWBSHSJ" },
	                { "data": "SWBSHR" }
	                
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
	    columnDefs: [
	                 {
			            "render": function(data, type, row) {
	                		var tmp = data;
	                		if(tmp!=null&&tmp!=""){
	                			tmp="<a name='file' class='btn-link' href='javascript:;'>"+ tmp +"</a>";
	                		}
	                		else{
	                			tmp="未审核";
	                		}
		                    return tmp;
			            },
			            "aTargets": [2,5]
			        }]
	});

	$("a[name=file]").on("click","",function(){
		var hthbbh=this.parentNode.parentNode.children[0].innerHTML;
        var filename = "\\"+hthbbh+"\\"+this.textContent;
		download(filename);
	});
	
}


function download(file){
	window.open("file-download.action?dwFileName="+encodeURI(encodeURI(file)),"_blank");
}