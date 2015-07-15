function init(abtype){
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
	                { "data": "SCWJSJ" },
	                { "data": "HTWJLB" },
	                { "data": abtype=="A"?"GCBSHYJWD":"SWBSHYJWD"},
	                { "data": abtype=="A"?"GCBSHYJWD":"SWBSHYJWD"}
	                
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
	                 { "sClass":"dpass", "bSearchable" :false, "aTargets":[0] },
	                 {
			            "render": function(data, type, row) {
	                		var tmp = data;
	                		if(tmp==null||tmp==""){
	                			tmp = uploadForm;
	                		}else{
	                			tmp="<a name='file' class='btn-link' href='javascript:;'>"+ tmp +"</a>";
	                		}
		                    return tmp;
			            },
			            "aTargets": [3]
			        },
	                 {
			            "render": function(data, type, row) {
	                		var tmp = data;
	                		if(tmp==null||tmp==""){
	                			tmp = btnUpload;
	                		}
	                		else{
	                			tmp="";
	                		}
		                    return tmp;
			            },
			            "aTargets": [4]
			        }]
	});

	$("a[name=file]").on("click","",function(){
		var hthbbh=this.parentNode.parentNode.children[0].innerHTML;
        var filename = "\\"+hthbbh+"\\"+this.textContent;
		download(filename);
	});
	
	$("#tableData tbody").on("click",".uploadBtn",function(row){
        var hthbbh=this.parentNode.parentNode.children[0].innerHTML;
        var form = this.parentNode.parentNode.children[3].children[0];
        var type = "";
        if(this.baseURI.indexOf("jshthbB")>0){
        	type = "B";
        }
        else{
        	type = "A";
        }
    	
        uploadShyj(form,"hthbbh="+hthbbh+"&type="+type);
    });
	
}
function uploadShyj(obj1,str){
	 var options = {  
			 	type:"post",
		        url:"file-uploadHthbYj.action?"+str,
		        success: function(data){ 
		        layer.msg("上传成功",2,{type:1});
             },  
             error: function(XmlHttpRequest, textStatus, errorThrown){  
             	layer.msg("上传失败，请重新上传");  
             }
	};  
	$(obj1).ajaxSubmit(options); 
}


function download(file){
	window.open("file-download.action?dwFileName="+encodeURI(encodeURI(file)),"_blank");
}