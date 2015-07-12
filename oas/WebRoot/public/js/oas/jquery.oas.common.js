/* ===================================================
 * jquery.oas.common.js 
 * 基础插件与公用函数脚本
 * ===================================================
*/
function initMain(){
	isLogin();
	var str=getMsg("param=gnlb","qx-getGnlbList.action");
	var strjson = eval("["+str+"]");
	var json = strjson[0].data;
	for(var i=0; i<json.length; i++){  
    	var id = json[i].ID;  
    	var name = json[i].NAME;  
    	var url = json[i].URL;
    	var tagid = url.substring(url.lastIndexOf('/')+1,url.lastIndexOf('.'));
    	if(document.getElementById(tagid)){
    		document.getElementById(tagid).style.display="block";
    	}
	}
	
}
function  isLogin(){
	$.ajax({
		type : "post",//发送方式
		url : "page-isLogin.action",// 路径
		data : "path="+getPath()+"&&t="+Math.random(),
		async:false,  
		success: function(text){
			if(text=="islogin"){
				//location.href="./error.jsp";
			}else if(text=="nologin"){
				alert("请登录后再进行操作！");
				top.location.href=getRootPath()+"/login.jsp";
			}else{
				//location.href="./errorLogin.jsp";
			}
		},
		error: function(text) {
			alert("失败");
		}
	}); 
}

function GetToday(){ 
	var dd = new Date();
	var y = dd.getYear(); 
	var m = dd.getMonth()+1;//获取当前月份的日期 
	var d = dd.getDate(); 
	return y+"-"+m+"-"+d;
}
function getMsg(str,url){
	var result = null;
	$.ajax({
		type : "post",//发送方式
		url : url,// 路径
		async:false,  
		data : str+"&&t="+Math.random() ,
		success: function(text){
			result=text;
		},
		error: function(text) {
			result = "error";
		}
	}); 
	return result;
}

function getJson(str,url){
	var result = null;
	$.ajax({
		type : "post",//发送方式
        dataType: "json",
		url : url,// 路径
		async:false,  
		data : str+"&&t="+Math.random() ,
		success: function(text){
			result=text;
		},
		error: function(text) {
			result = "error";
		}
	}); 
	return result;
}


function getRootPath() {
            //获取当前网址，如： http://localhost:8080/ems/Pages/Basic/Person.jsp
            var curWwwPath = window.document.location.href;
            //获取主机地址之后的目录，如： /ems/Pages/Basic/Person.jsp
            var pathName = window.document.location.pathname;
            var pos = curWwwPath.indexOf(pathName);
            //获取主机地址，如： http://localhost:8080
            var localhostPath = curWwwPath.substring(0, pos);
            //获取带"/"的项目名，如：/ems
            var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
            return(localhostPath + projectName);
}
function getPath() {
    //获取主机地址之后的目录，如： /ems/Pages/Basic/Person.jsp
    var pathName = window.document.location.pathname;
    var pathName = pathName.substring(pathName.substr(1).indexOf('/')+1);
    return pathName;
}

function toPage(str,url,objId){
		$.ajax({
		type : "post",//发送方式
		url : url,// 路径
		data : str+"&&t="+Math.random() ,
		success: function(text){
			document.getElementById("tbBody").innerHTML=text;
		},
		error: function(text) {
			//alert("访问失败");
		}
	}); 
}

function TableToXml(tableid) { //tableid是你要转化的表的表名，是一个字符串，如"example"
	var rows = document.getElementById(tableid).rows; //获得行数(包括thead)
	var colums = document.getElementById(tableid).rows[0].cells; //获得列数
	var col = rows[0].getElementsByTagName("th");
	var xml = "";
	var tdValue;
	for (var i = 1; i < rows.length; i++) { //每行
		xml += "<ROW>";
		for (var j = 0; j < colums.length; j++) {
			xml += "<";
			tdName = col[j].id; //Json数据的键
			xml += tdName;
			xml += ">";
			tdValue = document.getElementById(tableid).rows[i].cells[j].textContent;//Json数据的值
			xml += tdValue;
			xml += "</";
			xml += tdName;
			xml += ">";
		}
		xml += "</ROW>";
	}
	return xml;

}


function XmlToTable(xml,tableid) { //tableid是你要转化的表的表名，是一个字符串，如"example"
	var rows = document.getElementById(tableid).rows; //获得行数(包括thead)
	var colums = document.getElementById(tableid).rows[0].cells; //获得列数
	var col = rows[0].getElementsByTagName("th");
	var xml = "";
	var tdValue;
	for (var i = 1; i < rows.length; i++) { //每行
		xml += "<ROW>";
		for (var j = 0; j < colums.length; j++) {
			xml += "<";
			tdName = col[j].id; //Json数据的键
			xml += tdName;
			xml += ">";
			tdValue = document.getElementById(tableid).rows[i].cells[j].textContent;//Json数据的值
			xml += tdValue;
			xml += "</";
			xml += tdName;
			xml += ">";
		}
		xml += "</ROW>";
	}
	return xml;

}


//提取表格的值,JSON格式  
function GetTableData(table){  
	var tableData = new Array();  
	alert("行数：" + table.rows.length);  
	for(var i=1; i<table.rows.length;i++){  
	   tableData.push(GetRowData(tabProduct.rows[i]));  
	}  
	return tableData;  

}  
//提取指定行的数据，JSON格式  
function GetRowData(row){  
	var rowData = {};  
	for(var j=0;j<row.cells.length; j++){  
	   name = row.parentNode.rows[0].cells[j].getAttribute("Name");  
	   if(name){  
	    var value = row.cells[j].getAttribute("Value");  
	    if(!value){  
	     value = row.cells[j].innerHTML;  
	    }  
	    rowData[name] = value;  
	   }  
	}  
	//alert("ProductName:" + rowData.ProductName);  
	//或者这样：alert("ProductName:" + rowData["ProductName"]);  
	return rowData;  
}  


function TableToJson(tableid) { //tableid是你要转化的表的表名，是一个字符串，如"example"
	var rows = document.getElementById(tableid).rows; //获得行数(包括thead)
	var colums = document.getElementById(tableid).rows[0].cells; //获得列数
	var col = rows[0].getElementsByTagName("th");
	var json = "[";
	var tdValue;
	for (var i = 1; i < rows.length; i++) { //每行
		json += "{";
		for (var j = 0; j < colums.length; j++) {
			tdName = col[j].id; //Json数据的键
			json += "\""; //加上一个双引号
			json += tdName;
			json += "\"";
			json += ":";
			tdValue = document.getElementById(tableid).rows[i].cells[j].textContent;//Json数据的值
			json += "\"";
			json += tdValue;
			json += "\"";
			json += ",";
		}
		json = json.substring(0, json.length - 1);
		json += "}";
		json += ",";
	}
	json = json.substring(0, json.length - 1);
	json += "]";
	return json;
}

function JsonToTable(json, tableid) { //tableid是你要转化的表的表名，是一个字符串，如"example"
	var table = document.getElementById(tableid);
	var rows = json.ROOT.ROW;
	for(var i=0;i<rows.length;i++){
		var tableRow=table.insertRow(i);
		var cols = rows[i].COL;
		for(var j=0;j<cols.length;j++){
			var col=tableRow.insertCell(j);
			col.innerHTML=""+cols[j]+"";
		}
	}
	
}


//提取表格的值,JSON格式  
function GetTableData(table){  
var tableData = new Array();  
alert("行数：" + table.rows.length);  
for(var i=1; i<table.rows.length;i++){  
 tableData.push(GetRowData(tabProduct.rows[i]));  
}  

return tableData;  

}  
//提取指定行的数据，JSON格式  
function GetRowData(row){  
var rowData = {};  
for(var j=0;j<row.cells.length; j++){  
 name = row.parentNode.rows[0].cells[j].getAttribute("Name");  
 if(name){  
  var value = row.cells[j].getAttribute("Value");  
  if(!value){  
   value = row.cells[j].innerHTML;  
  }  
   
  rowData[name] = value;  
 }  
}  
//alert("ProductName:" + rowData.ProductName);  
//或者这样：alert("ProductName:" + rowData["ProductName"]);  
return rowData;  

}  

//检查当前数据行中需要运行的字段  
function CheckExpression(row){  
for(var j=0;j<row.cells.length; j++){  
 expn = row.parentNode.rows[0].cells[j].getAttribute("Expression");  
 //如指定了公式则要求计算  
 if(expn){  
  var result = Expression(row,expn);  
  var format = row.parentNode.rows[0].cells[j].getAttribute("Format");  
  if(format){  
   //如指定了格式，进行字值格式化  
   row.cells[j].innerHTML = formatNumber(Expression(row,expn), format);  
  }else{  
   row.cells[j].innerHTML = Expression(row,expn);  
  }  
 }  
  
}  
}  

//计算需要运算的字段  
function Expression(row, expn){  
var rowData = GetRowData(row);  
//循环代值计算  
for(var j=0;j<row.cells.length; j++){  
 name = row.parentNode.rows[0].cells[j].getAttribute("Name");  
 if(name){  
  var reg = new RegExp(name, "i");  
  expn = expn.replace(reg, rowData[name].replace(/\,/g, ""));  
 }  
}  
return eval(expn);  
}  

///////////////////////////////////////////////////////////////////////////////////  
/** 
* 格式化数字显示方式   
* 用法 
* formatNumber(12345.999,'#,##0.00'); 
* formatNumber(12345.999,'#,##0.##'); 
* formatNumber(123,'000000'); 
* @param num 
* @param pattern 
*/  
/* 以下是范例 
formatNumber('','')=0 
formatNumber(123456789012.129,null)=123456789012 
formatNumber(null,null)=0 
formatNumber(123456789012.129,'#,##0.00')=123,456,789,012.12 
formatNumber(123456789012.129,'#,##0.##')=123,456,789,012.12 
formatNumber(123456789012.129,'#0.00')=123,456,789,012.12 
formatNumber(123456789012.129,'#0.##')=123,456,789,012.12 
formatNumber(12.129,'0.00')=12.12 
formatNumber(12.129,'0.##')=12.12 
formatNumber(12,'00000')=00012 
formatNumber(12,'#.##')=12 
formatNumber(12,'#.00')=12.00 
formatNumber(0,'#.##')=0 
*/  
function formatNumber(num,pattern){    
var strarr = num?num.toString().split('.'):['0'];    
var fmtarr = pattern?pattern.split('.'):[''];    
var retstr='';    
  
//整数部分    
var str = strarr[0];    
var fmt = fmtarr[0];    
var i = str.length-1;      
var comma = false;    
for(var f=fmt.length-1;f>=0;f--){    
  switch(fmt.substr(f,1)){    
    case '#':    
      if(i>=0 ) retstr = str.substr(i--,1) + retstr;    
      break;    
    case '0':    
      if(i>=0) retstr = str.substr(i--,1) + retstr;    
      else retstr = '0' + retstr;    
      break;    
    case ',':    
      comma = true;    
      retstr=','+retstr;    
      break;    
  }    
}    
if(i>=0){    
  if(comma){    
    var l = str.length;    
    for(;i>=0;i--){    
      retstr = str.substr(i,1) + retstr;    
      if(i>0 && ((l-i)%3)==0) retstr = ',' + retstr;     
    }    
  }    
  else retstr = str.substr(0,i+1) + retstr;    
}    
  
retstr = retstr+'.';    
//处理小数部分    
str=strarr.length>1?strarr[1]:'';    
fmt=fmtarr.length>1?fmtarr[1]:'';    
i=0;    
for(var f=0;f<fmt.length;f++){    
  switch(fmt.substr(f,1)){    
    case '#':    
      if(i<str.length) retstr+=str.substr(i++,1);    
      break;    
    case '0':    
      if(i<str.length) retstr+= str.substr(i++,1);    
      else retstr+='0';    
      break;    
  }    
}    
return retstr.replace(/^,+/,'').replace(/\.$/,'');    
}  


function String2XML(xmlString) {
    // for IE
    if (window.ActiveXObject) {
      var xmlobject = new ActiveXObject("Microsoft.XMLDOM");
      xmlobject.async = "false";
      xmlobject.loadXML(xmlString);
      return xmlobject;
    }
    // for other browsers
    else {
      var parser = new DOMParser();
      var xmlobject = parser.parseFromString(xmlString, "text/xml");
      return xmlobject;
    }
}
//convert xml object to string
function XML2String(xmlObject) {
    // for IE
    if (window.ActiveXObject) {      
      return xmlobject.xml;
    }
    // for other browsers
    else {       
      return (new XMLSerializer()).serializeToString(xmlobject);
    }
}

/*弹出层*/
function layerShow(w,h,title,url){
	if (w == null || w == '') {
		w=800;
	};
	if (h == null || h == '') {
		h=($(window).height() - 50);
	};
	if (title == null || title == '') {
		title=false;
	};
	if (url == null || url == '') {
		url="/error.jsp";
	};
	$.layer({
    	type: 2,
    	shadeClose: false,
    	title: title,
		maxmin:false,
    	closeBtn: [0, true],
    	shade: [0.8, '#000'],
    	border: [0],
    	offset: ['20px',''],
    	area: [w+'px', h +'px'],
    	iframe: {src: url}
	});
}
function layerClose(){
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.close(index);
}

function GetQueryString(name)
{
	 var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)
    	 return  unescape(r[2]); 
     return null;
}

function GetRequest() {  
	   var url = location.search; //获取url中"?"符后的字串  
	   var theRequest = new Object();  
	   if (url.indexOf("?") != -1) {  
	      var str = url.substr(1);  
	      strs = str.split("&");  
	      for(var i = 0; i < strs.length; i ++) {  
	         theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);  
	      }  
	   }  
	   return theRequest;  
	}  

function curDateTime(){  
    var d = new Date();   
    var year = d.getFullYear();   
    var month = d.getMonth()+1;   
    var date = d.getDate();   
    var curDateTime= year;  
    if(month>9)  
        curDateTime = curDateTime +"-"+month;  
    else  
        curDateTime = curDateTime +"-0"+month;  
    if(date>9)  
        curDateTime = curDateTime +"-"+date;  
    else  
        curDateTime = curDateTime +"-0"+date;  
    return curDateTime;  
}

function extrackParmsValue(urlParams) {
	var res ={};
	for(param in urlParams) {
		if(urlParams[param]) {
			 res[param] = urlParams[param];
		}
	}
	return res;
}