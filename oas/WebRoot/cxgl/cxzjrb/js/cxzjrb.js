
function init(){
	 isLogin();
}
function changeType(){
	if($("#cxlx").val()=="0"){
		$("#rbcx").hide();
		$("#zjcx").show();
	}else{
		$("#zjcx").hide();
		$("#rbcx").show();
	}
}
//保存按钮
function doSearch(){
	var date = $("#rq").val();
	var dateq = $("#rqq").val();
	var datez = $("#rqz").val();
	var type = $("#cxlx").val();
	var str = getMsg("type="+type+"&rq="+date+"&rqq="+dateq+"&rqz="+datez,"jsdgl-searchZjrb.action");
	//document.getElementById("tableJg").innerHTML = str;
	$("#tableJg").empty();
	$("#tableJg").append(str);
}