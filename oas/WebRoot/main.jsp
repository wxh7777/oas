<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<title>结算支付及流动资金管理系统 </title>
	<jsp:include page="/head.jsp" flush="true"></jsp:include>
	<security:authentication property="authorities" var="authorities" />
</head>
<body onload="initMain()">
<header class="Hui-header cl"> 
	<a class="Hui-logo l" title="结算支付及流动资金管理系统" href="/oas/main.jsp">结算支付及流动资金管理系统</a>
	<a class="Hui-logo-m l" href="<%=request.getContextPath() %>/main.jsp" title="Tips Mock">结算支付及流动资金管理系统</a> 
	<span class="Hui-subtitle l">燕峰路桥</span> 
	<span class="Hui-userbox">
	<span class="c-white">登陆账号：<security:authentication property="name" /></span> 
		<a class="btn-sm btn-danger radius ml-10" href="<%=request.getContextPath() %>/j_spring_security_logout" title="退出">
			<i class="icon-off"></i> 退出 &nbsp</a>
	</span> 
	<a aria-hidden="false" class="Hui-nav-toggle" href="#"></a> 
<style>
.resHide{
	display:none;
}
</style>
</header>
<aside class="Hui-aside">
  <input runat="server" id="divScrollValue" type="hidden" value="" />
  <div class="menu_dropdown bk_2">
    <dl id="menu-order">
      <dt class="selected"><i class="icon-cogs"></i> 功能菜单<b></b></dt>
      <dd style="display:block">
        <ul>
          <li id="user" style="display:none"><a _href="<%=request.getContextPath() %>/qx/user.jsp" href="javascript:;">用户管理</a></li>
          <li id="authority" style="display:none"><a _href="<%=request.getContextPath() %>/qx/authority.jsp" href="javascript:;">权限管理</a></li>
          <li id="resource" style="display:none"><a _href="<%=request.getContextPath() %>/qx/resource.jsp" href="javascript:;">功能列表</a></li>
          <li id="projects" style="display:none"><a _href="<%=request.getContextPath() %>/qx/projects.jsp" href="javascript:;">项目管理</a></li>
          <li id="search" style="display:none"><a _href="<%=request.getContextPath() %>/qx/search.jsp" href="javascript:;">查询管理</a></li>
          <li id="scjsht" style="display:none"><a _href="<%=request.getContextPath() %>/ywgl/scjsht/scjsht.jsp" href="javascript:;">上传合同</a></li>
          <li id="jshthbA" style="display:none"><a _href="<%=request.getContextPath() %>/ywgl/jshthb/jshthbA.jsp" href="javascript:;">合同核备A</a></li>
          <li id="jshthbB" style="display:none"><a _href="<%=request.getContextPath() %>/ywgl/jshthb/jshthbB.jsp" href="javascript:;">合同核备B</a></li>
          <li id="ckhthbjg" style="display:none"><a _href="<%=request.getContextPath() %>/ywgl/ckhthbjg/ckhthbjg.jsp" href="javascript:;">查看合同核备结果</a></li>
          <li id="lrjshtsj" style="display:none"><a _href="<%=request.getContextPath() %>/ywgl/lrjshtsj/lrjshtsj.jsp" href="javascript:;">录入结算合同数据</a></li>
          <li id="lrjsdsj" style="display:none"><a _href="<%=request.getContextPath() %>/ywgl/lrjsdsj/lrjsdsj.jsp" href="javascript:;">录入结算单数据</a></li>
          <li id="cxjsd" style="display:none"><a _href="<%=request.getContextPath() %>/cxgl/cxjsd/cxjsd.jsp" href="javascript:;">查询结算单</a></li>
          <li id="cxjshttz" style="display:none"><a _href="<%=request.getContextPath() %>/cxgl/cxjshttz/cxjshttz.jsp" href="javascript:;">查询结算合同台账</a></li>
          <li id="qrfhjsd" style="display:none"><a _href="<%=request.getContextPath() %>/ywgl/qrfhjsd/qrfhjsd.jsp" href="javascript:;">确认复核结算单</a></li>
          <li id="sqfk" style="display:none"><a _href="<%=request.getContextPath() %>/ywgl/sqfk/sqfk.jsp" href="javascript:;">授权付款</a></li>
          <!-- <li id="ysqfk" style="display:none"><a _href="<%=request.getContextPath() %>/ywgl/ysqfk/ysqfk.jsp" href="javascript:;">预授权付款</a></li> -->
          <li id="sqsh" style="display:none"><a _href="<%=request.getContextPath() %>/ywgl/sqsh/sqsh.jsp" href="javascript:;">授权审核</a></li>
          <li id="scfktzd" style="display:none"><a _href="<%=request.getContextPath() %>/ywgl/scfktzd/scfktzd.jsp" href="javascript:;">生成付款通知单</a></li>
          <li id="qrfktzd" style="display:none"><a _href="<%=request.getContextPath() %>/ywgl/qrfktzd/qrfktzd.jsp" href="javascript:;">确认付款通知单</a></li>
          <!-- <li id="cxfktzd" style="display:none"><a _href="<%=request.getContextPath() %>/cxgl/cxfktzd/cxfktzd.jsp" href="javascript:;">查询付款通知单</a></li> -->
          <li id="lrzjrb" style="display:none"><a _href="<%=request.getContextPath() %>/ywgl/lrzjrb/lrzjrb.jsp" href="javascript:;">录入资金日报</a></li>
          <li id="cxzjrb" style="display:none"><a _href="<%=request.getContextPath() %>/cxgl/cxzjrb/cxzjrb.jsp" href="javascript:;">查询资金日报</a></li>
          <li id="cxhsk" style="display:none"><a _href="<%=request.getContextPath() %>/cxgl/cxhsk/cxhsk.jsp" href="javascript:;">查询回收款</a></li>
          <li id="lrsrht" style="display:none"><a _href="<%=request.getContextPath() %>/ywgl/lrsrht/lrsrht.jsp" href="javascript:;">录入收入合同</a></li>
          <li id="lrsktzd" style="display:none"><a _href="<%=request.getContextPath() %>/ywgl/lrsktzd/lrsktzd.jsp" href="javascript:;">录入收款通知单</a></li>
          <li id="cxsktzd" style="display:none"><a _href="<%=request.getContextPath() %>/cxgl/cxsktzd/cxsktzd.jsp" href="javascript:;">查询收款通知单</a></li>
        </ul>
      </dd>
    </dl>
  </div>
</aside>
<div class="dislpayArrow"><a _href class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
  <div id="Hui-tabNav" class="Hui-tabNav">
    <div class="Hui-tabNav-wp">
      <ul id="min_title_list" class="acrossTab cl">
        <li class="active"><span title="首页" data-href="<%=request.getContextPath() %>/introduction.jsp">首页</span><em></em></li>
      </ul>
    </div>
    <div class="Hui-tabNav-more btn-group">
    	<a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;">
    		<i class="icon-step-backward"></i>
    	</a>
    	<a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;">
    		<i class="icon-step-forward"></i>
    	</a>
    </div>
  </div>
  <div id="iframe_box" class="Hui-article">
    <div class="show_iframe">
      <div style="display:none" class="loading"></div>
      <iframe scrolling="yes" frameborder="0" src="<%=request.getContextPath() %>/introduction.jsp">
      </iframe>
    </div>
  </div>
</section>

<jsp:include page="/footer.jsp" flush="true"></jsp:include>
</body>
</html>