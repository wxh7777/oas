
function init(){
    isLogin();
    getHtList();
}

//保存按钮
function doSave(){
	var xmmc = document.getElementById("xmmc").value;
	var rq = document.getElementById("rq").value;
	var lb = document.getElementById("lb").value;
	var tbr = document.getElementById("tbr").value;
	var jsdbh = document.getElementById("jsdbh").value;
	//var tableZy = document.getElementById("tableZy");
	var tbXml = TableToXml("tableZy");
	var str = "xmlStr=<ROOT>"
	str += "<JSDBH>"+jsdbh+"</JSDBH>"
	str += "<XMMC>"+xmmc+"</XMMC>"
	str += "<RQ>"+rq+"</RQ>"
	str += "<LB>"+lb+"</LB>"
	str += "<TBR>"+tbr+"</TBR>"
	str += "<TABLE>"+tbXml+"</TABLE>"
	str += "</ROOT>"
	//alert("save");
	toPage(str,"jsdgl-saveJsdsj.action","保存成功");
}
function getHtList(){
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

function doScjsd(){
	var xmmc = document.getElementById("xmmc").value;
	var rq = document.getElementById("rq").value;
	var lb = document.getElementById("lb").value;
	var tbr = document.getElementById("tbr").value;
	var jsdbh = document.getElementById("jsdbh").value;
	var htbh = document.getElementById("selHtbh").value;
	
	//var tableZy = document.getElementById("tableZy");
	var tbXml = TableToXml("tableZy");
	var str = "xmlStr=<ROOT>"
	str += "<JSDBH>"+jsdbh+"</JSDBH>"
	str += "<HTBH>"+jsdbh+"</HTBH>"
	str += "<XMMC>"+xmmc+"</XMMC>"
	str += "<RQ>"+rq+"</RQ>"
	str += "<LB>"+lb+"</LB>"
	str += "<TBR>"+tbr+"</TBR>"
	str += "<TABLE>"+tbXml+"</TABLE>"
	str += "</ROOT>"
	//alert("save");
	toPage(str,"jsdgl-scJsd.action","生成结算单成功");
}

//清空按钮，清空form中的数据
function doClean(){
//alert("clean");
}

function addZy(){
   var table = document.getElementById("tableZy"); 
   var row=table.rows.length;
   AddRow(table, row);
}

function deleteZy(thisObj){
	var trRow = thisObj.parentElement.parentElement;
   var table = document.getElementById("tableZy"); 
   DeleteRow(table, trRow.rowIndex);
}

function importZy(){
//alert("export");
}

