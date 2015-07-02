var id= 0;
var zjrbXmList;
function init(){
    isLogin();
    var str = getMsg("","jsdgl-initZjrbTable.action");
    zjrbXmList = eval(eval(str)[0].TABLE)[0];
	initZjrbJe(eval(str)[0].ZJRBJE);
	initZjrbTable(eval(str)[0].TABLE);
    $.fn.editable.defaults.mode = 'inline';
    $('.edit').editable({
    	showbuttons:false,
    	onblur:'submit',
        type: 'text',
        pk: 1,
        title: 'Enter username',
        emptytext:'',
        inputclass:'input-text',
        success:function(response, newValue) {
        	excuteTable(this,newValue);
        }
    });
}
function getZjrbArray(){
	var hkgcsr = zjrbXmList.HKGCSR;
	var hkqt = zjrbXmList.HKQT;
	var fkzjfy = zjrbXmList.FKZJFY;
	var fkjjfy = zjrbXmList.FKJJFY;
	var fkqt = zjrbXmList.FKQT;
	var array = new Array();
	var str = getArray(hkgcsr,"H");
	if(str.length>0){
		array.push(str);
	}
	str = getArray(hkqt,"H");
	if(str.length>0){
		array.push(str);
	}
	str = getArray(fkzjfy,"F");
	if(str.length>0){
		array.push(str);
	}
	str = getArray(fkjjfy,"F");
	if(str.length>0){
		array.push(str);
	}
	str = getArray(fkqt,"F");
	if(str.length>0){
		array.push(str);
	}
	str = getOtherArray();
	if(str.length>0){
		array.push(str);
	}
	return array.join(",");
}
function getOtherArray(){
	var array = new Array();
	if($("#hk1").text()!=""&&$("#hk1").text()!="0"){
		var obj = new Object();
		obj.zjrbxmdm = "1034";
		obj.je = $("#hk1").text();
		obj.kxtype = 'A';
		obj.type = "H";
		array.push(JSON.stringify(obj));
	}
	if($("#hk2").text()!=""&&$("#hk2").text()!="0"){
		var obj = new Object();
		obj.zjrbxmdm = "1035";
		obj.je = $("#hk2").text();
		obj.kxtype = 'B';
		obj.type = "H";
		array.push(JSON.stringify(obj));
	}
	if($("#hk3").text()!=""&&$("#hk3").text()!="0"){
		var obj = new Object();
		obj.zjrbxmdm = "1036";
		obj.je = $("#hk3").text();
		obj.kxtype = 'C';
		obj.type = "H";
		array.push(JSON.stringify(obj));
	}
	if($("#fk1").text()!=""&&$("#fk1").text()!="0"){
		var obj = new Object();
		obj.zjrbxmdm = "1037";
		obj.je = $("#fk1").text();
		obj.kxtype = 'A';
		obj.type = "F";
		array.push(JSON.stringify(obj));
	}
	if($("#fk2").text()!=""&&$("#fk2").text()!="0"){
		var obj = new Object();
		obj.zjrbxmdm = "1038";
		obj.je = $("#fk2").text();
		obj.kxtype = 'B';
		obj.type = "F";
		array.push(JSON.stringify(obj));
	}
	if($("#fk3").text()!=""&&$("#fk3").text()!="0"){
		var obj = new Object();
		obj.zjrbxmdm = "1039";
		obj.je = $("#fk3").text();
		obj.kxtype = 'C';
		obj.type = "F";
		array.push(JSON.stringify(obj));
	}
	return array;
}
function getArray(data,type){
	var k = 0;
	var array = new Array();
	for(var i = 0;i<data.length;i++){
		$('#'+data[i].ZJRBXMDM).find('.num').each(function(){
			if($(this).text()!=""&&$(this).text()!="0"){
				var obj = new Object();
				obj.zjrbxmdm = data[i].ZJRBXMDM;
				obj.je = $(this).text();
				if($(this).attr('name').indexOf('1')>0){
					obj.kxtype = 'A';
				}else if($(this).attr('name').indexOf('2')>0){
					obj.kxtype = 'B';
				}else if($(this).attr('name').indexOf('3')>0){
					obj.kxtype = 'C';
				}else if($(this).attr('name').indexOf('4')>0){
					obj.kxtype = 'D';
				};
				obj.type = type;
				k++;
				array.push(JSON.stringify(obj));
			}
		});
	}
	return array;
}

function doSave(){
	var tableStr = document.getElementById("tableJg").innerHTML;
	var qmye1 = $("#qmye1")[0].innerHTML;
	var qmye2 = $("#qmye2")[0].innerHTML;
	var qmye3 = $("#qmye3")[0].innerHTML;
	var qmye4 = $("#qmye4")[0].innerHTML;
	var qmye = $("#qmye")[0].innerHTML;
	var urlData = "data="+encodeURI(encodeURI(tableStr));
	urlData += "&qmye1="+qmye1;
	urlData += "&qmye2="+qmye2;
	urlData += "&qmye3="+qmye3;
	urlData += "&qmye4="+qmye4;
	urlData += "&qmye="+qmye;
	urlData += "&array="+getZjrbArray();
	var str = getMsg(urlData,"jsdgl-saveZjrb.action");
	layer.msg(str);
	
}

function initZjrbJe(dt){
	var data = eval(dt)[0];
	$("#qcje1").html(data.QCJE1);
	$("#qcje2").html(data.QCJE2);
	$("#qcje3").html(data.QCJE3);
	$("#qcje4").html(data.QCJE4);
}
function initZjrbTable(dt){
	var data = eval(dt)[0];
	var hkgcsr = data.HKGCSR;
	var hkqt = data.HKQT;
	var fkzjfy = data.FKZJFY;
	var fkjjfy = data.FKJJFY;
	var fkqt = data.FKQT;
	initFirst(hkgcsr.length+hkqt.length+3,hkgcsr,"hkgcsr");
	initNext(hkqt,"hkqt");
	initHj("hk");
	initHk();
	initFirst(fkzjfy.length+fkjjfy.length+fkqt.length+4,fkzjfy,"fkzjfy");
	initNext(fkjjfy,"fkjjfy");
	initNext(fkqt,"fkqt");
	initHj("fk");
	initFk();
}
function initFirst(n,data,type){
	var nData = data.length+1;
	for(var i = 0;i<data.length;i++){
		$("#zjrbBody").append("<tr id=\""+data[i].ZJRBXMDM+"\">");
		if(i==0){
			var str = data[i].ZJRBXMTYPENAME.split("-");
			$("#"+data[i].ZJRBXMDM).append("<td rowspan=\""+n+"\">"+str[0]+"</td>");
			$("#"+data[i].ZJRBXMDM).append("<td rowspan=\""+nData+"\">"+str[1]+"</td>");
		}
		$("#"+data[i].ZJRBXMDM).append("<td>"+data[i].ZJRBXMMC+"</td>");
		$("#"+data[i].ZJRBXMDM).append("<td class=\"edit num\" name=\""+type+"1\"></td>");
		$("#"+data[i].ZJRBXMDM).append("<td class=\"edit num\" name=\""+type+"2\"></td>");
		$("#"+data[i].ZJRBXMDM).append("<td class=\"edit num\" name=\""+type+"3\"></td>");
		$("#"+data[i].ZJRBXMDM).append("<td class=\"edit num\" name=\""+type+"4\"></td>");
		$("#"+data[i].ZJRBXMDM).append("<td name=\"HJL\">0</td>");
	}
	initXj(type);
}
function initNext(data,type){
	var nData = data.length+1;
	for(var i = 0;i<data.length;i++){
		$("#zjrbBody").append("<tr id=\""+data[i].ZJRBXMDM+"\">");
		if(i==0){
			var str = data[i].ZJRBXMTYPENAME.split("-");
			$("#"+data[i].ZJRBXMDM).append("<td rowspan=\""+nData+"\">"+str[1]+"</td>");
		}
		$("#"+data[i].ZJRBXMDM).append("<td>"+data[i].ZJRBXMMC+"</td>");
		$("#"+data[i].ZJRBXMDM).append("<td class=\"edit num\" name=\""+type+"1\"></td>");
		$("#"+data[i].ZJRBXMDM).append("<td class=\"edit num\" name=\""+type+"2\"></td>");
		$("#"+data[i].ZJRBXMDM).append("<td class=\"edit num\" name=\""+type+"3\"></td>");
		$("#"+data[i].ZJRBXMDM).append("<td class=\"edit num\" name=\""+type+"4\"></td>");
		$("#"+data[i].ZJRBXMDM).append("<td name=\"HJL\">0</td>");
	}
	initXj(type);
}

function initXj(type){
	$("#zjrbBody").append("<tr id=\""+id+"\">");
	$("#"+id).append("<td>小计</td>");
	$("#"+id).append("<td class=\"num\" name=\""+type+"1XJ\">0</td>");
	$("#"+id).append("<td class=\"num\" name=\""+type+"2XJ\">0</td>");
	$("#"+id).append("<td class=\"num\" name=\""+type+"3XJ\">0</td>");
	$("#"+id).append("<td class=\"num\" name=\""+type+"4XJ\">0</td>");
	$("#"+id).append("<td name=\"HJL\">0</td>");
	id++;
}
function initHj(type){
	$("#zjrbBody").append("<tr id=\""+id+"\">");
	$("#"+id).append("<td colspan=\"2\">合计</td>");
	$("#"+id).append("<td class=\"num\" name=\""+type+"1HJ\">0</td>");
	$("#"+id).append("<td class=\"num\" name=\""+type+"2HJ\">0</td>");
	$("#"+id).append("<td class=\"num\" name=\""+type+"3HJ\">0</td>");
	$("#"+id).append("<td class=\"num\" name=\""+type+"4HJ\">0</td>");
	$("#"+id).append("<td name=\"HJL\">0</td>");
	id++;
}

function initHk(){
	$("#zjrbBody").append("<tr id=\"hk\">");
	$("#hk").append("<td colspan=\"3\">银行存款</td>");
	$("#hk").append("<td class=\"edit num\" id=\"hk1\">0</td>");
	$("#hk").append("<td>现金转入</td>");
	$("#hk").append("<td class=\"edit num\" id=\"hk2\">0</td>");
	$("#hk").append("<td>银行卡转入</td>");
	$("#hk").append("<td class=\"edit num\" id=\"hk3\">0</td>");
}

function initFk(){
	$("#zjrbBody").append("<tr id=\"fk\">");
	$("#fk").append("<td colspan=\"3\" >银行存款</td>");
	$("#fk").append("<td class=\"edit num\" id=\"fk1\">0</td>");
	$("#fk").append("<td>现金转出</td>");
	$("#fk").append("<td class=\"edit num\" id=\"fk2\">0</td>");
	$("#fk").append("<td>银行卡转出</td>");
	$("#fk").append("<td class=\"edit num\" id=\"fk3\">0</td>");
}

function excuteTable(obj,newValue){
	var table = obj.parentNode.parentNode.parentNode;
	
        
    //计算小计
    var classname = "td[name='"+$(obj).attr('name')+"']";
    var classnameXJ = "td[name='"+$(obj).attr('name')+"XJ']";
    var sumxj =0;
    $(table).find(classname).each(function(){
    	var i = "0";
    	if(this==obj){
    		i = newValue;
    	}else {
	        i = this.innerHTML==""?"0":this.innerHTML;
    	}
    	sumxj += Number(i);
    });
    $(table).find(classnameXJ).html(sumxj);
    
    for(var n = 1;n<=4;n++){
    	var sumhkhj =0; 
        var classnameGKHJ = "td[name='hk"+n+"HJ']";
        sumhkhj += Number($("td[name='hkgcsr"+n+"XJ']").text());
        sumhkhj += Number($("td[name='hkqt"+n+"XJ']").text());
    	$(classnameGKHJ).html(sumhkhj);
    	var hkn = $("#hk"+n).text();
    	if($("#hk"+n)[0]==obj){
    		hkn = newValue;
    	}
    	var sumsr = sumhkhj + Number(hkn);;
    	$("#bssr"+n).html(sumsr);
    	
    	var sumfkhj =0; 
        var classnameFkHJ = "td[name='fk"+n+"HJ']";
        sumfkhj += Number($("td[name='fkzjfy"+n+"XJ']").text());
        sumfkhj += Number($("td[name='fkjjfy"+n+"XJ']").text());
        sumfkhj += Number($("td[name='fkqt"+n+"XJ']").text());
    	$(classnameFkHJ).html(sumfkhj);
    	
    	var fkn = $("#fk"+n).text();
    	if($("#fk"+n)[0]==obj){
    		fkn = newValue;
    	}
    	var sumzc = sumfkhj + Number(fkn);
    	$("#bszc"+n).html(sumzc);
    	
    	var qcje = $("#qcje"+n).text();
    	var qmye = Number(qcje)+sumsr-sumzc;
    	$("#qmye"+n).html(qmye);
    }
    
    $(table).find("td[name='HJL']").each(function(){
        //计算行合计
    		var sum = 0;
            var tr = this.parentNode;
            $(tr).find('.num').each(function(){
            	var i = "0";
            	if(this==obj){
            		i = newValue;
            	}else {
        	        i = this.innerHTML==""?"0":this.innerHTML;
            	}
    	        sum += Number(i);
            });
            $(tr).find("td[name='HJL']").html(sum);
        });
}