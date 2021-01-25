
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" +
            request.getServerPort() +
            request.getContextPath() + "/";
%>

<html>
<head>
    <title>Title</title>
</head>
<base href="<%=basePath%>">
<body>
<p>第一个springmvc项目</p>
<p> <a href="user/some.do">发起some.do的请求</a> </p>

</body>
</html>
