<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/1/21
  Time: 15:34
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
  <title>笔记</title>
</head>
<body>
<header>
  <div class="back"><a class="iconfont" href="index.jsp">&#xe6b9;</a></div>
  <div class="title"><span>笔记管理</span></div>
  <div class="rightMenu"><a class="iconfont" onclick="addNote();">&#xe6b3;</a></div>
</header>
<nav>
</nav>
<div id="content">
</div>
<div id="editDiv" >
  <H2>添加笔记</H2>
  <div class="formDiv">
    <span>内容:</span>
    <textarea rows="4" name="content" id="noteContent" ></textarea>
    <br/><br/>
    <span>时间:</span>
    <input type="datetime" name="time" readonly>
    <div id="dtBox"></div>
    <script type="text/javascript">
      $(document).ready(function() {$("#dtBox").DateTimePicker();});
    </script>
    <br/><br/>
    <input type="text" name="id" style="display: none" />
    <input id="editSubmit" type="button" value="提交">
    <input id="editCancel" type="button" value="取消">
  </div>
</div>
</body>
<script type="text/javascript" src="<%= path %>/js/note.js"></script>
</html>
