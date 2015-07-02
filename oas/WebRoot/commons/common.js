
function  isLogin(){
	$.ajax({
		type : "post",//发送方式
		url : "page-isLogin.action",// 路径
		data : "t="+Math.random() ,
		success: function(text){
			if(text=="islogin"){
				//location.href="./error.jsp";
			}else if(text=="nologin"){
				alert("请登录后再进行操作！");
				location.href=getRootPath()+"/login.jsp";
			}else{
				//location.href="./errorLogin.jsp";
			}
		},
		error: function(text) {
			alert("失败");
		}
	}); 
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