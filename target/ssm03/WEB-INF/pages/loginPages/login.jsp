<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-09-28 0028
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="https://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css">
</head>
<body>
<form class="form-horizontal" role="form" action="/userLogin/checkLogin">
    <div class="form-group">
        <label for="userName" class="col-sm-2 control-label">用户名</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="userName" name="userName" placeholder="请输入用户名">
        </div>
    </div>
    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">密码</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <div class="checkbox">
                <label>
                    <input type="checkbox">请记住我
                </label>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="button" class="btn btn-default" onclick="login()">登录</button>
            <button type="button" class="btn btn-default" onclick="toAddUser()">注册</button>
        </div>
    </div>
</form>


<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.0.0.min.js"></script>
<script src="https://apps.bdimg.com/libs/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script>
    function toAddUser(){
        location.href="/hello/toAddUser";
    }

    function login(){
        var userName = $.trim($("#userName").val());
        var password = $.trim($("#password").val());
        if(userName == "" || password == ""){
            alert("请输入用户名和密码!");
        }else{
            $.ajax({
                url:"/userLogin/checkLogin",
                data:{
                    userName:userName,
                    password:password
                },
                dataType:"text",
                success:function(data){
                    if(data == "1000"){
                        alert("没有该用户!");
                    }else if(data == "1001"){
                        alert("密码错误!");
                    }else if(data == "1"){
                        window.location.href = "/hello/toHome";
                    }

                }

            })

        }

    }


</script>

</body>
</html>
