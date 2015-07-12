
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
			"rq":	$('#rq').val(), //日期,
			"skdw": $('#skdw').val(), //收款单位
			"jbr":	$('#jbr').val(), //经办人
			"gys":	$('#gys').val(), //供应商
			"kzr":	$('#kzr').val() //控制人
	};
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
	var btnJjqr = "<a href=\"javascript:;\"  class=\"btn btn-link size-S btnJjqr\" >交接</a>";
	var btnFhqr = "<a href=\"javascript:;\"  class=\"btn btn-link size-S btnFhqr\" >复核</a>";
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
	                { "data": "JSRQ" },
	                { "data": null},
	                { "data": null}
	            ],
	    columnDefs: [{
	                "render": function(data, type, row) {
	                	if(row.JJSJ==""){
	                		return btnJjqr;
	                	}
	                	else{
		                    return row.JJSJ;
	                	}
	                },
	                "targets": 8
	            },
	            {
	                "render": function(data, type, row) {
	                	if(row.SHSJ==""){
	                		return btnFhqr;
	                	}
	                	else{
		                    return row.SHSJ;
	                	}
	                },
	                "targets": 9
	            }],
	    aaSorting:[[ 0, "asc" ]],
	    sDom: '<rt<"bottom"flip>>'
	});
	$("#tableJg tbody").on("click",".btnJjqr",function(row){
		var jsdbh=this.parentNode.parentNode.children[3].innerHTML;
		jiaoJieQueRen(jsdbh);
		doSearch();
    });
	$("#tableJg tbody").on("click",".btnFhqr",function(row){
		var jsdbh=this.parentNode.parentNode.children[3].innerHTML;
		fuHeQueRen(jsdbh);
		doSearch();
    });
}
//交接确认
function jiaoJieQueRen(jsdbh){
	var result = getMsg("jsdbh="+jsdbh,"jsdgl-jjJsd.action");
	layer.msg(result);
}

//复核确认
function fuHeQueRen(jsdbh){
	var result = getMsg("jsdbh="+jsdbh,"jsdgl-fhJsd.action");
	layer.msg(result);
}