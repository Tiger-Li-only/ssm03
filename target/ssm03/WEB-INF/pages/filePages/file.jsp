<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-09-29 0029
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>获取目录</title>
    <link rel="stylesheet" href="https://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css">
</head>
<body>
<%@ include file="../top.jsp"%>
<div class="table-responsive">
<form action="/file/getAllFileByPath" method="get">
    <table class="table table-striped table-bordered">
        <tbody>
        <tr>
            <td>路径</td>
            <td><input type="text" name="pathName" value="${pathName}"></td>
        </tr>

        <tr>
            <td colspan="2" align="center"><input type="submit" class="btn btn-primary" value="查询"></td>
        </tr>
        </tbody>
    </table>
</form>
</div>
<div class="table-responsive">
    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>文件列表</th>
        </tr>
        </thead>
        <tbody class="bodyContent">
        <c:forEach var="file" items="${fileList}">
            <tr>
                <td>${file}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.page.js"></script>
<!-- JavaScript 放置在文档最后面可以使页面加载速度更快 -->
<!-- 可选: 合并了 Bootstrap JavaScript 插件 -->
<script src="https://apps.bdimg.com/libs/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
