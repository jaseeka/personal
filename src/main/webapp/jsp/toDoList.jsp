<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/10/21
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <%@include file="/common/resource.jsp"%>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no, minimal-ui" />
  <link rel="stylesheet" type="text/css" href="/css/toDoList.css" />
  <title>待办事项</title>
</head>
<body>
  <header>
    <div class="back"><a class="iconfont" href="index.jsp">&#xe602;</a></div>
    <div class="title"><span>待办事项</span></div>
    <div class="rightMenu"><a class="iconfont" onclick="addItem();">&#xe6b3;</a></div>
  </header>
  <nav>
  </nav>
  <div id="content">
  </div>
  <div id="editDiv" >
    <H2>任务添加</H2>
    <div class="formDiv">
      <span>说明:</span>
      <input type="text" name="content" id="itemContent" />
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
<script type="text/javascript" src="/js/toDoList.js"></script>
</html>
