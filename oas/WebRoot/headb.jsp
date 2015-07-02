<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String ip = request.getRemoteAddr();
%>

<meta name="keywords" content="结算支付及流动资金管理系统  made by pfkj">
<meta name="description" content="结算支付及流动资金管理系统  made by pfkj">

<LINK rel="Bookmark" href="<%=request.getContextPath() %>/public/favicon.ico" >
<LINK rel="Shortcut Icon" href="<%=request.getContextPath() %>/public/favicon.ico" />

<!--[if lt IE 9]>
<script type="text/javascript" src="<%=request.getContextPath() %>/public/lib/html5.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/public/lib/respond.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/public/lib/PIE_IE678.js"></script>
<![endif]-->
<link href="<%=request.getContextPath() %>/public/lib/datePicher/datePicker.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/public/lib/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/public/lib/font-awesome/font-awesome.min.css" rel="stylesheet" type="text/css" />
<!--[if IE 7]>
<link href="<%=request.getContextPath() %>/public/lib/font-awesome/font-awesome-ie7.min.css" rel="stylesheet" type="text/css" />
<![endif]-->

<link href="<%=request.getContextPath() %>/public/css/datepicker.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/public/lib/My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/public/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/public/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/public/css/H-ui.login.css" rel="stylesheet" type="text/css" />


<link href="<%=request.getContextPath() %>/public/css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/public/css/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/public/css/bootstrap-multiselect.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/public/css/style.css" rel="stylesheet" type="text/css" />
