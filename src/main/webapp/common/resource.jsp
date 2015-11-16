<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/10/23
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<link rel="stylesheet" type="text/css" href="<%= path %>/common/common.css" />
<link rel="stylesheet" type="text/css" href="<%= path %>/js/DateTimePicker/DateTimePicker.css" />

<script type="text/javascript" src="<%= path %>/common/common.js"></script>
<script type="text/javascript" src="<%= path %>/js/jquery/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="<%= path %>/js/DateTimePicker/DateTimePicker.js"></script>
