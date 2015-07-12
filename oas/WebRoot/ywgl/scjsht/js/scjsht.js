var num = 3;
function init(){
	isLogin();
	var str = getMsg("","qx-getProjectlist.action");
	var json = eval("["+str+"]")[0].data;
	var data = new Array();
	for(var i=0;i < json.length;i ++){
		$("#xmSel").append("<option value='"+$(json[i]).attr('ID')+"'>"+$(json[i]).attr('NAME')+"</option>"); //为Select追加一个Option(下拉项) 
    }
}
function onAdd(){
	var table = $("#tableData");
	var i = $("input[name=myFile]").length;
	if(i>10){
		layer.msg("最多上传十个文件");
	}
	else{
		var trid = "tr"+(num+1);
		var str = "<tr id=\""+trid+"\"><td colspan=\"3\">";
		str = str + "<span class=\"btn-upload\">";
		str = str + "<input class=\"input-text upload-url radius\" type=\"text\" name=\"uploadfile-2\" id=\"uploadfile-1\" readonly>&nbsp;";
		str = str + "<a href=\"javascript:void();\" class=\"btn btn-primary radius\"><i class=\"iconfont\">&#xf0020;</i> 浏览</a>&nbsp;";
		str = str + "<input type=\"file\" multiple id=\"myFile";
		str = str + (i+1);
		str = str + "\" name=\"myFile\" class=\"input-file\"></span>";
		str = str + "<a href=\"javascript:void();\" class=\"btn btn-primary  radius\" onclick='del("+trid+")'><i class='icon-remove'></i> 删除</a>";
		str = str + "</td>";
		table.append(str);
		num =  num+1;
	}
}

function addtr(){
	tr_id = $("#test>tbody>tr:last").attr("id");
	tr_id++;
	str = "<tr id = '"+tr_id+"'><tdwidth='30%'>re1</td><td width='30%'>re2</td><tdwidth='30%'>re3</td></tr>";
	$('#'+id).append(str);
}
//删除id对应的行
function del(id){
$(id).remove();
}

function upload(){
	 var options = {  
			 	type:'post',
		        url:'file-uploadHthb.action',
		        success: function(data){  
		        	//layer.msg("上传成功",2,{type:1});
                    $( "#info")[0].textContent="上传成功，核备编号为"+data;
		        	$( "#filesForm").resetForm();  
                },  
                error: function(XmlHttpRequest, textStatus, errorThrown){  
                	layer.msg("上传失败，请重新上传");  
                }
		       };  
	 $("#filesForm").ajaxSubmit(options); 
}
