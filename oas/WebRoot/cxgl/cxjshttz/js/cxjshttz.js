
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
	var urlParams = {					
			"xmmc": $('#xmmc').find("option:selected").val(), //项目名称
			"htlx": $('#htlx').find("option:selected").val(), //合同类型
			"htmc": $('#htmc').val(), //合同名称
			"htbh": $('#htbh').val(), //合同编号
			"sjq":	$('#sjq').val(), //时间起
			"sjz": $('#sjz').val(), //时间止
			"jbr":	$('#jbr').val(), //经办人
			"gys":	$('#gys').val(), //供应商
			"kzr":	$('#kzr').val() //控制人
	};
	var filteredParms = extrackParmsValue(urlParams);
	var options = {  
			 type:"post",
		     url:"jsdgl-searchHtsj.action",
		     data: filteredParms,
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
