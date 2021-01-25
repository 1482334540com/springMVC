<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>第一个springmvc项目</p>
<p> <a href="user/some.do">发起some.do的请求</a> </p>

 <form action="user/some.do" method="post">
    姓名: <input type="text" name="name" value=""/>
    年龄: <input type="text" name="age" value=""/> <br>
     <button type="submit">提交数据 </button>
 </form>

<div>
    <p>请求参数名和处理器方法形参不一致</p>
    <form action="user/receiveParam.do " method="post">
        姓名: <input type="text" name="Sname" value=""/>
        年龄: <input type="text" name="Sage" value=""/> <br>
        <button type="submit">提交数据 </button>
    </form>
</div>

<div>
    <p>使用java对象接收参数</p>
    <form action="user/objectParam.do " method="post">
        姓名: <input type="text" name="name" value=""/>
        年龄: <input type="text" name="age" value=""/> <br>
        <button type="submit">提交数据 </button>
    </form>
</div>

</body>
</html>
