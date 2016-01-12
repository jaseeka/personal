<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/11/9
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
  <jsp:include page="../common/resource.jsp" />
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no, minimal-ui" />
  <title>任务管理</title>
</head>
<body>
<header>
  <div class="back"><a class="iconfont" href="index.jsp">&#xe6b9;</a></div>
  <div class="title"><span>任务管理</span></div>
  <div class="rightMenu"><a class="iconfont" onclick="editPlan();">&#xe6b3;</a></div>
</header>
<nav>
</nav>
<div id="content">
</div>
<div id="editDiv" >
  <H2>计划编辑</H2>
  <div class="formDiv">
    <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;说&nbsp;&nbsp;&nbsp;&nbsp;明:</span>
    <input type="text" name="content" id="planContent" />
    <br/><br/>
    <span>循环参数(天):</span>
    <input type="text" name="cycleNum" id="cycleNum" />
    <br/><br/>
    <input type="text" name="id" style="display: none" />
    <input id="editSubmit" type="button" value="提交">
    <input id="editCancel" type="button" value="取消">
  </div>
</div>
</body>
<script type="text/javascript" src="<%= path %>/js/planList.js"></script>
</html>
