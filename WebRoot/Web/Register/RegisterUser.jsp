<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
String path = request.getContextPath();
String current = path+"/Web/Register";
String common = path+"/Web/common";
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>ע��ҳ��</title>
<link rel="stylesheet" type="text/css" href="<%=current %>/reg.css">
</head>
<body>
<div id="container">

<div id="top" >
<a href="index">��ս����ҳ</a> |
<a href="login.jsp">�û���¼</a> |
<a href="#">ע�����</a>
</div>

<div id="reg">

<jsp:include page="_RegisterUser.jsp"></jsp:include>

</div>


</div>
</body>
</html>
