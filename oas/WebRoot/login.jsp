<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<head>
	<title>结算支付及流动资金管理系统 | 登录</title>
	<jsp:include page="/head.jsp" flush="true"></jsp:include>
</head>

<body class="login">
<div>
<input type="hidden" id="TenantId" name="TenantId" value="" />
<div class="header"></div>
<div class="loginWraper">
  <div id="loginform" class="loginBox">
    <form class="form form-horizontal" action="j_spring_security_check"  method="post"  onsubmit="validate()">
      <div class="row cl">
      <%
      if("true".equals(request.getParameter("error"))){
      %>
      	<div class="col-3"></div><div class="col-8"><span style="color:red; height: 30px;">用户密码错误</span></div>
      <%
      }
      %>
      </div>
      <div class="row cl">
        <label class="form-label col-3"><i class="iconfont">&#xf00ec;用户名</i></label>
        <div class="formControls col-8">
          <input id="" name="j_username" type="text" placeholder="用户名" class="input-text size-L"
          	required=true  oninvalid="this.setCustomValidity('用户名不能为空.');"  oninput="setCustomValidity('');">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-3"><i class="iconfont">&#xf00c9;密码</i></label>
        <div class="formControls col-8">
          <input id="" name="j_password" type="password" placeholder="密码" class="input-text size-L"
          	required=true  oninvalid="this.setCustomValidity('密码不能为空.');"  oninput="setCustomValidity('');">
        </div>
      </div>
      <div class="row">
        <div class="formControls col-8 col-offset-3">
          <input name="" type="submit" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
        </div>
      </div>
    </form>
  </div>
</div>
<div class="footer">Copyright 2015 by pfkj|感谢jquery、bootstrap、H-ui的分享和支持</div>
</body>
<!-- END BODY -->
</html>