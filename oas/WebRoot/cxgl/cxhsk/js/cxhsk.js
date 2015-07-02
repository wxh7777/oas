
function init(){
    isLogin();
}
//保存按钮
function doSearch(){
	var htbh = document.getElementById("htbh").value;
	var yzmc = document.getElementById("yzmc").value;
	var sj = document.getElementById("sj").value;
	var gclb = document.getElementById("gclb").value;
	
	var str = "xmlStr=<ROOT>";
	str += "<HTBH>"+htbh+"</HTBH>";
	str += "<YZMC>"+yzmc+"</YZMC>";
	str += "<SJ>"+sj+"</SJ>";
	str += "<GCLB>"+gclb+"</GCLB>";
	str += "</ROOT>"
	toPage(str,"skgl-searchSktzd.action","divMsg");
}

