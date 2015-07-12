var htJson;
var tableData;
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
	$("#selHtbh").find("option").remove();
	var xmdm = $("#xmdm").find("option:selected").val(); 
    var htStr = getMsg("xmdm="+xmdm,"jsdgl-getHtList.action");
    htJson = eval("["+htStr+"]")[0].data;
	for(var i=0;i < htJson.length;i ++){
		$("#selHtbh").append("<option value='"+$(htJson[i]).attr('HTBH')+"'>"+$(htJson[i]).attr('HTMC')+"</option>"); 
	}
	getLx();
}

function getLx(){
	$("#selJsxmGg").find("option").remove();
	var index = $("#selHtbh").find("option:selected")[0].index; 
	document.getElementById("lb").value = $(htJson[index]).attr('HTLXMC');

	var htmc = $("#selHtbh").find("option:selected").text(); 
	var htbh = $("#selHtbh").find("option:selected").val(); 
	var jsdbh = document.getElementById("jsdbh");
	var str = getMsg("htbh="+htbh,"jsdgl-excuteJsdbh.action") ;
	jsdbh.text = htmc+'-'+str;
	jsdbh.value = htmc+'-'+str;
	
	var htmx = $(htJson[index]).attr('HTMX');
	var htmxArray = eval("["+htmx+"]")[0].data;
	for(var i=0;i < htmxArray.length;i ++){
		$("#selJsxmGg").append("<option value='"+$(htmxArray[i]).attr('JSXMGGSJ')+"'>"+$(htmxArray[i]).attr('JSXMGG')+"</option>"); 
	}
}
function doSelectHt(){
	document.getElementById("divSelHt").style.display = 'block';
	var str = getMsg("","jsdgl-searchHtlist.action");
	var items = eval(str);
	var sel = document.getElementById("selHtbh");
	if(items){  
    for(var i=0; i<items.length; i++){  
     var oOption = document.createElement("OPTION");  
     oOption.text = items[i].text;  
     oOption.value = items[i].value;  
     sel.options.add(oOption);  
    }  
   }  
}



function uploadJcmxFile(){
	var options = {  
		 type:"post",
	     url:"file-uploadJcmxFile.action",
	     success: function(data){ 
	    	 tableData = data;
	    	 initJcmx(data);
	    	 layer.msg("上传成功",2,{type:1});
         },  
         error: function(XmlHttpRequest, textStatus, errorThrown){  
         	layer.msg("上传失败，请重新上传");  
         }
	};  
	$("#jcMxForm").ajaxSubmit(options); 
}

function initJcmx(dt){
	var dataJson = eval(dt)[0];
	document.getElementById("jsdwTable").innerHTML = dataJson.jcmxJsdw;
	document.getElementById("jsxmTable").innerHTML = dataJson.jcmxJsxm;
	document.getElementById("ggTable").innerHTML = dataJson.jcmxGg;
	document.getElementById("ghrqTable").innerHTML = dataJson.jcmxGhrq;
	document.getElementById("jsdzs").innerHTML = dataJson.jcmxZs;
	
	if ( $.fn.dataTable.isDataTable( '#tableZy' ) ) {
		table = $('#tableZy').DataTable();
		table.destroy();
	}
	var jsxmgg = $("#selJsxmGg").find("option:selected").val(); 
	var array = jsxmgg.split("/");
	var dj = array[1];
	document.getElementById("jsdzj").innerHTML = eval(dataJson.jcmxZs)*eval(dj);
	
	$("#tableZy").DataTable({
		data:eval("["+dataJson.jcmxDetail+"]")[0].data,
	    bFilter:false,
	    columns:[
	                { "data": "jcmxXh" },
	                { "data": "jcmxPh" },
	                { "data": "jcmxSl" },
	                { "data": null ,"defaultContent": dj},
	                { "data": null }
	            ],
	    columnDefs: [{
	                "render": function(data, type, row) {
	                    return eval(row.jcmxSl)*eval(dj);
	                },
	                "targets": 4
	            }],
	    aaSorting:[[ 0, "asc" ]],
	    sDom: '<rt<"bottom"flip>>'
	});
}

function doScjsd(){
	var xmmc = $("#xmdm").find("option:selected").text(); 
	var jsdzj = document.getElementById("jsdzj").innerHTML; 
	var options = {  
			 type:"post",
		     url:"jsdgl-saveJsd.action?table="+tableData+"&xmmc="+encodeURI(encodeURI(xmmc))+"&jsdzj="+jsdzj,
		     success: function(data){ 
		    	layer.confirm("生成结算单成功，是否打印？",function(index){
		    		layerShow("750","","打印结算单","../print/dyjsd.jsp?xmmc="+xmmc);
		    	});
		        //location.replace(location.href);
	         },  
	         error: function(XmlHttpRequest, textStatus, errorThrown){  
	         	layer.msg("失败");  
	         }
	};  

	$("#searchForm").ajaxSubmit(options); 
}
