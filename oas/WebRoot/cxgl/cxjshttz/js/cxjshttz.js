
function init(){
    isLogin();
    var str = getMsg("","qx-getProjectlist.action");
	var json = eval("["+str+"]")[0].data;
	for(var i=0;i < json.length;i ++){
		$("#xmmc").append("<option value='"+$(json[i]).attr('ID')+"'>"+$(json[i]).attr('NAME')+"</option>"); //为Select追加一个Option(下拉项) 
    }
	var zyStr = getMsg("","jsdgl-searchZylist.action");
    zyJson =  eval("["+zyStr+"]")[0].data;
    for(var i=0;i < zyJson.length;i ++){
    	if(zyJson[i].ZYJB=="1"){
    		$("#htlx").append("<option value='"+$(zyJson[i]).attr('ZYDM')+"'>"+$(zyJson[i]).attr('ZYMC')+"</option>"); 
    	}
    }  

    $("#sjq")[0].value = curDateTime();
    $("#sjz")[0].value = curDateTime();
}


function doSearch(){
	var options = {  
			 type:"post",
		     url:"jsdgl-searchHtsj.action",
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
	var dataArray = eval("["+dt+"]")[0].data
	$("#tableJg").DataTable({
		data:dataArray,
	    bFilter:false,
	    columns:[
	                { "data": "XH" },
	                { "data": "XMMC" },
	                { "data": "LB" },
	                { "data": "HTBH" },
	                { "data": "HTMC" },
	                { "data": "ZYMC" },
	                { "data": "GG" },
	                { "data": "DW" },
	                { "data": "DJ" },
	                { "data": "JBR" },
	                { "data": "GYS" },
	                { "data": "KZR" },
	                { "data": "QDRQ" }
	            ],
	    aaSorting:[[ 0, "asc" ]],
	    sDom: '<rt<"bottom"flip>>'
	});
}
