<%--
  Created by IntelliJ IDEA.
  User: Krisyu
  Date: 2021/3/6
  Time: 14:28
  To change this template use File | Settings | File Templates.

  Warn: 文件路径放在web目录下
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="response" method="post">
        用户名：<input type="text" name="username" value=""><br/>
        密码：<input type="password" name="pwd" value=""><br/>
        <input type="submit" name="登录">
        <br/>
        爱好： <br/>
         <input type="checkbox" name="fav" value="1"> java
         <input type="checkbox" name="fav" value="2"> php
         <input type="checkbox" name="fav" value="3"> Scala

    </form>

</body>
</html>
