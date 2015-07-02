
function init(){
	isLogin();
    var str = getMsg("","qx-getProjectlist.action");
	var json = eval("["+str+"]")[0].data;
	for(var i=0;i < json.length;i ++){
		$("#xmdm").append("<option value='"+$(json[i]).attr('ID')+"'>"+$(json[i]).attr('NAME')+"</option>"); //为Select追加一个Option(下拉项) 
    }
	getHtList();
    $("#rq")[0].value = curDateTime();
}

function getHtList(){
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
		     url:"jsdgl-searchFktzd.action?htbh="+encodeURI(encodeURI(htbh)),
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
	var btnQrjj = "<a href=\"javascript:;\"  class=\"btn btn-link size-S btnQrjj\" >交接确认</a>";
	var dataArray = eval("["+dt+"]")[0].data
	$("#tableJg").DataTable({
		data:dataArray,
	    bFilter:false,
	    columns:[
	                { "data": "ID" },
	                { "data": "XH" },
	                { "data": "XMMC" },
	                { "data": "HTBH" },
	                { "data": "JSDBH" },
	                { "data": "JE" },
	                { "data": "YFKJE" },
	                { "data": "FKDJE" },
	                { "data": null,"defaultContent": btnQrjj }
	            ],
	    aaSorting:[[ 0, "asc" ]],
	    sDom: '<rt<"bottom"flip>>'
	});
	$("#tableJg tbody").on("click",".btnQrjj",function(row){
		var fktzdid=this.parentNode.parentNode.children[0].innerHTML;
        
    });
}

function printFktzd(fktzdid){
	layerShow("750","","打印结算单","../../ywgl/print/dyfktzd.jsp?fktzdid="+fktzdid);
}
