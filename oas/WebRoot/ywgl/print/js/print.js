function initJsd(){
	var jsdbh = GetQueryString("jsdbh");
	var str = getMsg("","jsdgl-getPrintJsd.action?jsdbh="+jsdbh);
		var json = eval("["+str+"]")[0].data;
		for(var i=0;i < json.length;i ++){
			$("#xmdm").append("<option value='"+$(json[i]).attr('ID')+"'>"+$(json[i]).attr('NAME')+"</option>"); //为Select追加一个Option(下拉项) 
	    }
		getHtList();
	    $("#rq")[0].value = curDateTime();
}