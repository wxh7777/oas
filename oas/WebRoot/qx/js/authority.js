function initAdd(){
	var str = getMsg("param=resource","qx-getList.action");
	var json = eval("["+str+"]")[0].data;
	var data = new Array();
	for(var i=0;i < json.length;i ++){
		data.push({label:$(json[i]).attr('NAME'),value:$(json[i]).attr('ID')});
    }
	$('#gnlb-selected').multiselect({
	    buttonText: function(options, select) {
	        if (options.length === 0) {
	            return '选择功能（可多选）';
	        }
	        else {
	        	return '已选'+options.length+'个';
	         }
	    },
	    maxHeight: 150
	});
	$("#gnlb-selected").multiselect('dataprovider', data);
	
	if(GetQueryString("type")=="edit"){
		document.getElementById("id").value = GetQueryString("id");
		document.getElementById("name").value = GetQueryString("name");
		document.getElementById("desc").readonly = "readonly";
		document.getElementById("desc").value = decodeURI(decodeURI(GetQueryString("desc")));
		var gnlbs = GetQueryString("gnlb").split(",");
        $('#gnlb-selected').multiselect('select', gnlbs);
        
	}

}

function saveAuth(){
	$.ajax({
        cache: true,
        type: "POST",
        url:"qx-saveAuthority.action",
        data:$('#form-add').serialize(),// 你的formid
        async: false,
        success: function(request) {
        	parent.location.replace(parent.location.href);
        	parent.layer.msg('保存成功',2,{type:1});
        	var index = parent.layer.getFrameIndex(window.name);
        	parent.layer.close(index);
        },
        error: function(data) {
        	layer.msg('保存失败');
        }
    });    
}

function initAuthority(){
	isLogin();
	var str = getMsg("param=authority","qx-getList.action");
	if(str=="error"){
		alert("初始化数据失败");
	}
	else{
		var btnEdit = "<a href=\"javascript:;\" class=\"btn btn-success size-S editBtn\" >修改</a>"
		var btnDel = "<a href=\"javascript:;\"  class=\"btn btn-success size-S delBtn\" >删除</a>";
		$('#tableJg').DataTable({
			ajax:"qx-getList.action?param=authority",
		    bSort:false,
		    columns:[
		                { "data": "ID"},
		                { "data": "DESC" },
		                { "data": "NAME" },
		                { "data": "GNLB" },
		                { "data": "GNLBID" },
		                { "data": null ,"defaultContent": btnEdit},
		                { "data": null ,"defaultContent": btnDel}
		                
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
		    aoColumnDefs: [ 
		                { "sClass":"dpass", "bSearchable" :false, "aTargets":[0] },
		                { "sClass":"dpass", "bSearchable" :false, "aTargets":[4] },
		             ] 
		});
	}
	
	$("#tableJg tbody").on("click",".editBtn",function(row){
        var id=this.parentNode.parentNode.children[0].innerHTML;
        var desc= this.parentNode.parentNode.children[1].innerHTML;
        var name=this.parentNode.parentNode.children[2].innerHTML;
        var gnlb=this.parentNode.parentNode.children[4].innerHTML;
        editAuthority("id="+id+"&&desc="+encodeURI(encodeURI(desc))+"&&name="+encodeURI(encodeURI(name))+"&&gnlb="+gnlb);
    });
	$("#tableJg tbody").on("click",".delBtn",function(row){
		var id=this.parentNode.parentNode.children[0].innerHTML;
        var oTable = $('#tableJg').dataTable();
        layer.confirm('确认要删除吗？',function(index){
        	deleteAuthority(id);
    	});
    });
}

function addAuthority(){
	layerShow("500","","添加权限","authority-add.jsp?type=add");
}
function editAuthority(str){
	layerShow("500","","修改权限","authority-add.jsp?type=edit&&"+str);
}
function deleteAuthority(id){
	$.ajax({
        cache: true,
        type: "POST",
        url:"qx-delData.action",
        data:"param=authority&&id="+id+"&&t="+Math.random(),
        async: false,
        success: function(request) {
        	layer.msg("已删除");
        	location.replace(location.href);
        },
        error: function(data) {
            layer.msg("删除失败");
        }
    }); 
}

function valadate(){
	//判断名称是否重复
	//判断是否选择功能列表（不可为空）
}