
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
	var urlParams = {
			"xmdm": $("#xmdm").find("option:selected").val(), //项目名称
			"selHtbh": $("#selHtbh").find("option:selected").val(), //合同编号
			"skdw": $('#skdw').val(), //收款单位
			"rq":	$('#rq').val(), //日期,
			"jbr":	$('#jbr').val(), //经办人
			"gys":	$('#gys').val(), //供应商
			"kzr":	$('#kzr').val() //控制人
	};
//	strParams = "";
	
//	function genarateUrlParams(urlParams) {
//		var res = [];
//		for(param in urlParams) {
//			if(urlParams[param]) {
//				 res.push( [param, urlParams[param]].join('=') );
//			}
//		}
//		return res.join('&');
//	}
	
//	strParams = genarateUrlParams(urlParams);
//	var xmdm = $("#xmdm").find("option:selected").val(); 
	
	var filteredParms = extrackParmsValue(urlParams);
	
	var options = {  
			 type:"post",
			 url:"jsdgl-searchJsd.action",
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
	var btnPrint = "<a href=\"javascript:;\"  class=\"btn btn-link size-S delPrint\" >打印</a>";
	var dataArray = eval("["+dt+"]")[0].data
	$("#tableJg").DataTable({
		data:dataArray,
	    bFilter:false,
	    columns:[
	                { "data": "XH" },
	                { "data": "XMMC" },
	                { "data": "LB" },
	                { "data": "JSDBH" },
	                { "data": "HTBH" },
	                { "data": "JE" },
	                { "data": "SHSJ" },
	                { "data": "FKDJE" },
	                { "data": "YFKJE" },
	                { "data": "YSQJE" },
	                { "data": "JSRQ" },
	                { "data": null,"defaultContent": btnPrint }
	            ],
	    aaSorting:[[ 0, "asc" ]],
	    sDom: '<rt<"bottom"flip>>'
	});
	$("#tableJg tbody").on("click",".delPrint",function(row){
		var jsdbh=this.parentNode.parentNode.children[3].innerHTML;
        //var oTable = $('#tableJg').dataTable();
        layer.confirm('已经打印过一次，是否仍然打印？',function(index){
        	printJsd(jsdbh);
    	});
    });
}
function printJsd(jsdbh){
	layerShow("750","","打印结算单","../../ywgl/print/dyjsd.jsp?jsdbh="+jsdbh);
}
