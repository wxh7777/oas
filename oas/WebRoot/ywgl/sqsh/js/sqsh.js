function init(){
    isLogin();
    var str = getMsg("","qx-getProjectlist.action");
	var json = eval("["+str+"]")[0].data;
	for(var i=0;i < json.length;i ++){
		$("#xmdm").append("<option value='"+$(json[i]).attr('ID')+"'>"+$(json[i]).attr('NAME')+"</option>"); //为Select追加一个Option(下拉项) 
    }
	getHtList();
}
function getHtList(){
	$("#selHtbh").find("option").remove();
	var xmdm = $("#xmdm").find("option:selected").val(); 
    var htStr = getMsg("xmdm="+xmdm,"jsdgl-getHtList.action");
    htJson = eval("["+htStr+"]")[0].data;
	for(var i=0;i < htJson.length;i ++){
		$("#selHtbh").append("<option value='"+$(htJson[i]).attr('HTBH')+"'>"+$(htJson[i]).attr('HTMC')+"</option>"); 
	}
}
//保存按钮
function doSearch(){
	var htbh = $("#selHtbh").find("option:selected").val(); 
	var options = {  
			 type:"post",
		     url:"jsdgl-searchSqDsh.action?htbh="+encodeURI(encodeURI(htbh)),
		     success: function(data){ 
		    	initTable(data);
	         },  
	         error: function(XmlHttpRequest, textStatus, errorThrown){  
	         	layer.msg("查询失败");  
	         }
	};  
	$("#searchForm").ajaxSubmit(options);
	
}

function initTable(dt){
	if ( $.fn.dataTable.isDataTable( '#tableJg' ) ) {
		table = $('#tableJg').DataTable();
		table.destroy();
	}
	var btnSh = "<a href=\"javascript:;\"  class=\"btn btn-link size-S btnSh\" >确认</a>";
	var btnJj = "<a href=\"javascript:;\"  class=\"btn btn-link size-S btnJj\" >拒绝</a>";
	var tableData = eval("["+dt+"]")[0].data;
	$("#tableJg").DataTable({
		data:tableData,
	    bFilter:false,
	    bPaginate: false,
	    columns:[
	                { "data": "ID" },
	                { "data": "XH" },
	                { "data": "JSDBH" },
	                { "data": "JE" },
	                //{ "data": "YSQJE" },
	                { "data": "YSQCS" },
	                { "data": "BCSQJE" },
	                { "data": "SQLY" },
	                { "data": "SQJG" },
	                { "data": "YSQBZ" },
	                { "data": null,"defaultContent": btnSh },
	                { "data": null,"defaultContent": btnJj }
	            ],
	    aoColumnDefs: [ 
		                { "sClass":"dpass", "bSearchable" :false, "aTargets":[0] }
		             ],
	    aaSorting:[[ 0, "asc" ]],
	    sDom: '<rt<"bottom"flip>>'
	});
	$("#tableJg tbody").on("click",".btnSh",function(row){
        var id=this.parentNode.parentNode.children[0].innerHTML;
        shsq(id,true);//审核通过
    });
	$("#tableJg tbody").on("click",".btnJj",function(row){
		var id=this.parentNode.parentNode.children[0].innerHTML;
	    shsq(id,false);//拒绝审核
    });
}

function shsq(id,istg){
	var result=getMsg("sqid="+id+"&istg="+istg,"jsdgl-sqsh.action");
	layer.msg(result,2,{type:1});
}
