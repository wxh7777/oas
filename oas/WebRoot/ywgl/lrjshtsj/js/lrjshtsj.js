var zyJson;
var tableData;
function init(){
    isLogin();
    var str = getMsg("","qx-getProjectlist.action");
	var json = eval("["+str+"]")[0].data;
	for(var i=0;i < json.length;i ++){
		$("#xmdm").append("<option value='"+$(json[i]).attr('ID')+"'>"+$(json[i]).attr('NAME')+"</option>"); //为Select追加一个Option(下拉项) 
    }
	
    
    var hthbStr = getMsg("","jsdgl-getHthbList.action");
    var hthbJson = eval("["+hthbStr+"]")[0].data;
	for(var i=0;i < hthbJson.length;i ++){
		$("#hthb").append("<option>"+$(hthbJson[i]).attr('HTHBBH')+"</option>"); 
    }    
	
    var zyStr = getMsg("","jsdgl-searchZylist.action");
    zyJson =  eval("["+zyStr+"]")[0].data;
    for(var i=0;i < zyJson.length;i ++){
    	if(zyJson[i].ZYJB=="1"){
    		$("#htlb").append("<option value='"+$(zyJson[i]).attr('ZYDM')+"'>"+$(zyJson[i]).attr('ZYMC')+"</option>"); 
    	}
    }  
    getHtbh();
    $("#rq")[0].value = curDateTime();
    
}

function getZylist(){
	var sel = document.getElementById("htlb");
	if(zyJson){  
    for(var i=0; i<zyJson.length; i++){  
    	if(zyJson[i].zyjb=="1"){
		     var oOption = document.createElement("OPTION");  
		     oOption.text = zyJson[i].text;  
		     oOption.value = zyJson[i].value;  
		     sel.options.add(oOption);  
    	}
    }  
   }  
}

//保存按钮
function doSave(){
	if(!validate()){
			return;
	};
	var xmmc = $("#xmdm").find("option:selected").text(); 
	var options = {  
			 type:"post",
		     url:"jsdgl-saveHtsj.action?table="+tableData+"&xmmc="+encodeURI(encodeURI(xmmc)),
		     success: function(data){ 
		    	layer.msg("保存成功");
		        location.replace(location.href);
	         },  
	         error: function(XmlHttpRequest, textStatus, errorThrown){  
	         	layer.msg("保存失败");  
	         }
	};  
	$("#jshtsjForm").ajaxSubmit(options); 
}

function validate(){
	var xmmc = document.getElementById("xmdm").value;
	var htlb = document.getElementById("htlb").value;
	var rq = document.getElementById("rq").value;
	var jbr = document.getElementById("jbr").value;
	
	if(xmmc==""){
		alert("项目名称不能为空，请选择项目名称");
		return false;
	}
	if(htlb==""){
		alert("合同类别不能为空。请选择合同类别");
		return false;
	}
	if(rq==""){
		alert("请输入日期");
		return false;
	}
	if(jbr==""){
		alert("请输入经办人");
		return false;
	}
	var table = document.getElementById("tableZy");
	var rows = table.rows; //获得行数(包括thead)
	var colums = table.rows[0].cells; //获得列数
	if(rows.length==1){
		alert("尚未添加资源，无法保存");
		return false;
	}
	return true;
}


function getHtbh(){
	var xmmc = $("#xmdm").find("option:selected").text(); 
	var xmid = $("#xmdm").find("option:selected").val(); 
	var htlb = $("#htlb").find("option:selected").text(); 
	var htlbdm = $("#htlb").find("option:selected").val(); 
	var htbh = document.getElementById("htbh");
	var htmc = document.getElementById("htmc");
	var str = getMsg("xmid="+xmid+"&htlbdm="+htlbdm,"jsdgl-excuteHtbh.action") ;
	htbh.text = xmmc+'-'+htlb+'-'+str;
	htbh.value = xmmc+'-'+htlb+'-'+str;
	htmc.text = xmmc+'-'+htlb+'-'+str;
	htmc.value = xmmc+'-'+htlb+'-'+str;
}



function uploadZymxFile(){
	var options = {  
		 type:"post",
	     url:"file-uploadHtmxFile.action",
	     success: function(data){ 
	    	 tableData = data;
	    	 initHtmx(data);
	    	 layer.msg("上传成功");
         },  
         error: function(XmlHttpRequest, textStatus, errorThrown){  
         	layer.msg("上传失败，请重新上传");  
         }
	};  
	$("#htMxForm").ajaxSubmit(options); 
}

function initHtmx(dt){
	if ( $.fn.dataTable.isDataTable( '#tableZy' ) ) {
		table = $('#tableZy').DataTable();
		table.destroy();
	}
	var dataArray = eval("["+dt+"]")[0].data
	$("#tableZy").DataTable({
		data:dataArray,
	    bFilter:false,
	    columns:[
	                { "data": "xh" },
	                { "data": "htmxZymc" },
	                { "data": "htmxGg" },
	                { "data": "htmxDw" },
	                { "data": "htmxDj" },
	                { "data": "htmxSl" },
	                { "data": "htmxZj" }
	            ],
	    aaSorting:[[ 0, "asc" ]],
	    sDom: '<rt<"bottom"flip>>'
	});
	var htzj = 0;
	for(var i = 0;i<dataArray.length;i++){
		htzj = htzj + eval(dataArray[i].htmxZj);
	}
	document.getElementById("htzj").innerHTML = ""+htzj;
}
