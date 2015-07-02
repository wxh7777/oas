
function init(){
    isLogin();
}

//保存按钮
function doSave(){
	var htbh = document.getElementById("htbh").value;
	var yzmc = document.getElementById("yzmc").value;
	var sj = document.getElementById("sj").value;
	var gclb = document.getElementById("gclb").value;
	var jlqs = document.getElementById("jlqs").value;
	var jlrq = document.getElementById("jlrq").value;
	var jlk = document.getElementById("jlk").value;
	var zbj = document.getElementById("zbj").value;
	var nmggzbzj = document.getElementById("nmggzbzj").value;
	var qtkk = document.getElementById("qtkk").value;
	var str = "xmlStr=<ROOT>";
	str += "<HTBH>"+htbh+"</HTBH>";
	str += "<YZMC>"+yzmc+"</YZMC>";
	str += "<SJ>"+sj+"</SJ>";
	str += "<GCLB>"+gclb+"</GCLB>";
	str += "<JLQS>"+jlqs+"</JLQS>";
	str += "<JLRQ>"+jlrq+"</JLRQ>";
	str += "<JLK>"+jlk+"</JLK>";
	str += "<ZBJ>"+zbj+"</ZBJ>";
	str += "<NMGGZBZJ>"+nmggzbzj+"</NMGGZBZJ>";
	str += "<QTKK>"+qtkk+"</QTKK>";
	str += "</ROOT>"
	//alert("save");
	toPage(str,"skgl-saveSktzd.action","divMsg");
}
