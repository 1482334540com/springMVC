<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function(){
            $("button").click(function(){
                alert("button click");
                $.ajax({
                    // url:"user/returnVoid-ajax.do",
                    // url:"user/returnStudentJson.do",
                    // url:"user/returnStudentJsonArray.do",
                    url:"user/returnStringData.do",
                    data:{
                        name:"小明",
                        age:20
                    },
                    type:"post",
                    dataType:"text",
                    // dataType:"json",
                    success:function(resp){
                        //resp从服务器端返回的是json格式的字符串 {"name":"zhangsan","age":20}
                        //jquery会把字符串转为json对象， 赋值给resp形参。
                        console.log(resp);
                        // [{"name":"李四同学","age":20},{"name":"张三","age":28}]
                        alert(resp.name + "  "+resp.age);



                    }
                })
            })
        })
    </script>
</head>
<body>

<p>处理器方法返回String表示视图名称</p>
<form action="user/returnString1.do" method="post">
    姓名：<input type="text" name="name"> <br/>
    年龄：<input type="text" name="age"> <br/>
    <input type="submit" value="提交参数">
</form>
<br/>

<p>处理器方法返回String表示视图完整路径</p>
<form action="user/returnString2.do" method="post">
    姓名：<input type="text" name="name"> <br/>
    年龄：<input type="text" name="age"> <br/>
    <input type="submit" value="提交参数">
</form>
<br/>
<br/>

<button id="btn">发起ajax请求</button>

</body>
</html>