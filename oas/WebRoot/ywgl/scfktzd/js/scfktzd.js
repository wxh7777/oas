
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
			     url:"jsdgl-searchScfktzd.action?htbh="+encodeURI(encodeURI(htbh)), 
			     beforeSubmit: function(formData, jqForm, options){  
		                document.getElementById("info").innerText='正在装载数据,请耐心等待...';  
		                return true;  
		         },  
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
	var btnPrint = "<a href=\"javascript:;\"  class=\"btn btn-link size-S btnPrint\" >打印</a>";
	var btnScfkd = "<a href=\"javascript:;\"  class=\"btn btn-link size-S btnScfkd\" >生成付款通知单</a>";
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
	                { "data": "SQJE" },
	                { "data": "CLZT" },
	                { "data": "CLZTDM" },
	                { "data": null}
	            ],
	    columnDefs: [{
	                "render": function(data, type, row) {
	                	if(row.CLZTDM=="02"){
	                		return btnScfkd;
	                	}else if(row.CLZTDM=="04"){
	                		return btnPrint;
	                	}else{
		                    return "";
	                	}
	                },
	                "aTargets": [7]
	            },
	            { "sClass":"dpass", "aTargets":[0] },
	            { "sClass":"dpass", "aTargets":[6] }
	    		],
	    aaSorting:[[ 0, "asc" ]],
	    sDom: '<rt<"bottom"flip>>'
	});
	$("#tableJg tbody").on("click",".btnPrint",function(row){
	    var sqid=this.parentNode.parentNode.children[0].innerHTML;
	    printFktzd(sqid);//审核通过
	});
	$("#tableJg tbody").on("click",".btnScfkd",function(row){
	    var sqid=this.parentNode.parentNode.children[0].innerHTML;
	    scfktzd(sqid);//审核通过
	});
}

//生成付款通知单
function scfktzd(sqid){
	var result = getMsg("sqid="+sqid,"jsdgl-scfktzd.action");
	
	layer.msg(result,2,{type:1});
}

function printFktzd(sqid){
	layer.confirm('已经打印过一次，是否仍然打印？',function(index){
		layerShow("750","","打印付款通知单","../../ywgl/print/dyfktzd.jsp?sqid="+jsdbhsqid);
	});
}