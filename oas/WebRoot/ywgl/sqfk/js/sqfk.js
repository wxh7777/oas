var tableData;
var jsdbh;
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
	//var xmdm = $("#xmdm").find("option:selected").val(); 
	var htbh = $("#selHtbh").find("option:selected").val(); 
	var options = {  
			 type:"post",
		     url:"jsdgl-searchJsdSq.action?htbh="+encodeURI(encodeURI(htbh)),
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
	tableData = eval("["+dt+"]")[0].data;
	if(tableData.length==0){
		document.getElementById("ysqxx").style.display="block";
		document.getElementById("sqxx").style.display="none";
		document.getElementById("tableDiv").style.display="none";
		return;
	}
	document.getElementById("sqxx").style.display="none";
	document.getElementById("ysqxx").style.display="none";
	document.getElementById("tableDiv").style.display="block";
	$("#tableJg").DataTable({
		data:tableData,
	    bFilter:false,
	    bPaginate: false,
	    columns:[
	                { "data": "XH" },
	                { "data": "XMMC" },
	                { "data": "LB" },
	                { "data": "JSDBH" },
	                { "data": "HTBH" },
	                { "data": "JE" },
	                { "data": "YSQJE" },
	                { "data": "YSQCS" }
	            ],
	    aoColumnDefs: [ 
	                { "sClass":"dpass", "bSearchable" :false, "aTargets":[6] }
	             ],
	    aaSorting:[[ 0, "asc" ]],
	    sDom: '<rt<"bottom"flip>>'
	});
	$("#tableJg tbody td").on("click",function(){
		document.getElementById("sqxx").style.display="block";
		jsdbh = this.parentNode.children[3].innerHTML;
		var zje=this.parentNode.children[5].innerHTML;
		var ysqje=this.parentNode.children[6].innerHTML;
		document.getElementById("ysqje").innerHTML=ysqje+"";
		document.getElementById("wsqje").innerHTML=(eval(zje)-eval(ysqje))+"";
		document.getElementById("bcye").innerHTML=(eval(zje)-eval(ysqje))+"";
    });
}
function jsye(){
	var wsqje = document.getElementById("wsqje").innerHTML;
	var bcsqje = document.getElementById("bcsqje").value;
	var bcye = eval(wsqje)-eval(bcsqje);
	document.getElementById("bcye").innerHTML = bcye+"";
}

//确认授权
function qrsq(){
	var bcsqje = document.getElementById("bcsqje").value;
   var result = getMsg("jsdbh="+encodeURI(encodeURI(jsdbh))+"&sqje="+bcsqje,"jsdgl-qrsq.action");
   layer.msg(result);
}

function doYsq(){
	var htbh = $("#selHtbh").find("option:selected").val(); 
	var yusqje = $("#yusqje").val();
	var ysqly = document.getElementById("ysqly").value;
	var str = "htbh="+encodeURI(encodeURI(htbh))+"&yusqje="+yusqje+"&ysqly="+encodeURI(encodeURI(ysqly));
	var result = getMsg(str,"jsdgl-ysq.action");
	layer.msg(result);
}