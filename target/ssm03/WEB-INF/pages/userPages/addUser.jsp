<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-09-26 0026
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加用户</title>
    <!-- 包含头部信息用于适应不同设备 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 包含 bootstrap 样式表 -->
    <link rel="stylesheet" href="https://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css">

</head>
<body>
<%@ include file="../top.jsp"%>
<div class="container">
    <h2>
      <c:choose>
          <c:when test="${not empty user.userId}">编辑用户</c:when>
          <c:otherwise>创建用户</c:otherwise>
      </c:choose>
    </h2>
    <p>创建响应式表格 (将在小于768px的小型设备下水平滚动)。另外：添加交替单元格的背景色：</p>
    <div class="table-responsive">
        <form action="/user/add?userId=${user.userId}" method="post">
        <table class="table table-striped table-bordered">
            <tbody>
                <tr>
                    <td>姓名</td>
                    <td><input type="text" name="userName" value="${user.userName}"></td>
                    </tr>
                    <tr>
                    <td>年龄</td>
                    <td><input type="tel" name="age" value="${user.age}"></td>
                    </tr>
                    <tr>
                    <td>年龄</td>
                    <td><input type="tel" name="age" value="${user.age}"></td>
                    </tr>
                    <tr>
                    <td colspan="2" align="center"><input type="submit" class="btn btn-primary" value="提交"></td>
                    </tr>
            </tbody>
        </table>
        </form>
    </div>

    <h2>图像</h2>
    <p>创建响应式图片(将扩展到父元素)。 另外：图片以椭圆型展示：</p>
    <img src="cinqueterre.jpg" class="img-responsive img-circle" alt="Cinque Terre" width="304" height="236">

    <h2>图标</h2>
    <p>插入图标:</p>
    <p>云图标: <span class="glyphicon glyphicon-cloud"></span></p>
    <p>信件图标: <span class="glyphicon glyphicon-envelope"></span></p>
    <p>搜索图标: <span class="glyphicon glyphicon-search"></span></p>
    <p>打印图标: <span class="glyphicon glyphicon-print"></span></p>
    <p>下载图标：<span class="glyphicon glyphicon-download"></span></p>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.0.0.min.js"></script>
<!-- JavaScript 放置在文档最后面可以使页面加载速度更快 -->
<!-- 可选: 合并了 Bootstrap JavaScript 插件 -->
<script src="https://apps.bdimg.com/libs/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
