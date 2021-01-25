<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>/WEB-INF/view/show.jsp从request作用域获取数据</h3><br/>
    <h3 >name：${requestScope.name}</h3><br/>
    <h3>age：${requestScope.age}</h3>
</body>
</html>
