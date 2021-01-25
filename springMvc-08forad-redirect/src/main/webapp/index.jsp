
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

<p>当方法返回ModelAndView实现forward</p>

<form action="user/doForward.do" method="post">
    姓名:<input type="text" name="name"> <br/>
    年龄:<input type="text" name="age"> <br/>
    <input type="submit" value="提交数据">

</form>

<p>当方法返回ModelAndView实现 redirect </p>
<form action="user/doRedirect.do" method="post">
    姓名:<input type="text" name="name"> <br/>
    年龄:<input type="text" name="age"> <br/>
    <input type="submit" value="提交数据">

</form>

</body>
</html>
