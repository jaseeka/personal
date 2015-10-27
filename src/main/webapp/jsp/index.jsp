<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/10/21
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
  <%@include file="/common/resource.jsp"%>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no, minimal-ui" />
  <link rel="stylesheet" type="text/css" href="/css/index.css" />
  <link rel="apple-touch-icon-precomposed" href="">
  <title>菜单页</title>
</head>
<body>
  <header>
    <div class="back"></div>
    <div class="title"><span>主页</span></div>
  </header>
  <ul class="mainmenu">
    <li><a href="/jsp/toDoList.jsp" ><b class="iconfont">&#xe61a;</b><span>待办事项</span></a></li>
    <li><a href="" ><b class="iconfont">&#xe624;</b><span>任务编辑</span></a></li>
    <li><a href="" ><b class="iconfont">&#xe637;</b><span>添加任务</span></a></li>
    <li><a href="" ><b class="iconfont">&#xe600;</b><span>警示</span></a></li>
    <li><a href="" ><b class="iconfont">&#xe604;</b><span>备忘录</span></a></li>

    <li><a href="" ><b class="iconfont"></b><span>待添加</span></a></li>
    <li><a href="" ><b class="iconfont"></b><span>待添加</span></a></li>
    <li><a href="" ><b class="iconfont"></b><span>待添加</span></a></li>
    <li><a href="" ><b class="iconfont"></b><span>待添加</span></a></li>
  </ul>
</body>
</html>
