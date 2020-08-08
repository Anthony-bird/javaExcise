<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 20/08/08
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
    <input type="file" name="file"/>
    <input type="submit" value="upload">
</form>

<a href="${pageContext.request.contextPath}/statics/1.jpg">点击下载</a>
</body>
</html>
