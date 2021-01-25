<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>第一个springmvc项目</p>
<p> <a href="user/some.do">发起some.do的请求</a> </p>

 <form action="user/other.do" method="post">
    姓名: <input type="text" name="name" value=""/>
    年龄: <input type="text" name="age" value=""/> <br>
     <button type="submit">发起 other.do的请求 </button>
 </form>

</body>
</html>
