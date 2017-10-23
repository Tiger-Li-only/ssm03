<%@ page import="com.springapp.mvc.utils.PageInfo" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-09-26 0026
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
    <!-- 包含头部信息用于适应不同设备 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 包含 bootstrap 样式表 -->
    <link rel="stylesheet" href="https://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/page.css">
</head>
<body>
<%@ include file="../top.jsp"%>
<div id="myCarousel" class="carousel slide">
    <!-- 轮播（Carousel）指标 -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
        <li data-target="#myCarousel" data-slide-to="3"></li>
        <li data-target="#myCarousel" data-slide-to="4"></li>
    </ol>

    <!-- 轮播（Carousel）项目 -->
    <div class="carousel-inner">
        <div class="item active">
            <img src="/resources/images/img01.jpg" alt="First slide">
        </div>
        <div class="item">
            <img src="/resources/images/img02.jpg" alt="Second slide">
        </div>
        <div class="item">
            <img src="/resources/images/img03.jpg" alt="Third slide">
        </div>
        <div class="item">
            <img src="/resources/images/img04.jpg" alt="forth slide">
        </div>
        <div class="item">
            <img src="/resources/images/img05.jpg" alt="fifth slide">
        </div>
    </div>
    <!-- 轮播（Carousel）导航 -->
    <a class="carousel-control left" href="#myCarousel" data-slide="prev">‹</a>
    <a class="carousel-control right" href="#myCarousel" data-slide="next">›</a>
</div>

<!-- 控制按钮 -->

<%--<div style="text-align:center;">--%>
    <%--<input type="button" class="btn start-slide" value="Start">--%>
    <%--<input type="button" class="btn pause-slide" value="Pause">--%>
    <%--<input type="button" class="btn prev-slide" value="Previous Slide">--%>
    <%--<input type="button" class="btn next-slide" value="Next Slide">--%>
    <%--<input type="button" class="btn slide-one" value="Slide 1">--%>
    <%--<input type="button" class="btn slide-two" value="Slide 2">--%>
    <%--<input type="button" class="btn slide-three" value="Slide 3">--%>
<%--</div>--%>
<div class="container">
    <%--<button type="button" class="btn btn-primary" onclick="toAddUser()">添加用户</button>--%>
    <h2>所有用户</h2>
    <p>用户列表</p>
    <div class="table-responsive">
        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>序号</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody class="bodyContent">
         <c:forEach var="user" items="${pageInfo.rows}" varStatus="num">
            <tr>
                <td>${num.count}</td>
                <td>${user.userName}</td>
                <td>${user.age}</td>
                <td><a href="/hello/toAddUser?userId=${user.userId}">编辑</a>  <a href="/user/batchDeleteUser?userIds=${user.userId}">删除</a></td>
            </tr>
         </c:forEach>
            </tbody>
        </table>
        <div style="text-align: center">
            <div class="page"></div>
            <input type="hidden" id="count" name="count" value="${pageInfo.total}">
            <input type="hidden" id="total" name="total" value="${pageInfo.totalPages}">
            <%--<ul class="pagination">--%>
                <%--<li><a <c:choose> <c:when test="${pageInfo.pageNumber == 1}">href="#"</c:when><c:otherwise>href="/user/getUserList?pageNumber=${pageInfo.pageNumber}&add=-1"</c:otherwise></c:choose> >&laquo;</a></li>--%>
                <%--<c:set var="pageTotal" value="${pageInfo.total}"></c:set>--%>
                <%--<%--%>
                    <%--PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");--%>
                <%--for(int i=1;i<=(pageInfo.getTotal()%pageInfo.getPageSize() == 0?pageInfo.getTotal()/pageInfo.getPageSize():pageInfo.getTotal()/pageInfo.getPageSize()+1);i++){--%>
                    <%--request.setAttribute("i",i);--%>
                <%--%>--%>
                <%--<li <c:if test="${pageInfo.pageNumber == i}">class="active"</c:if> ><a href="#">${i}</a></li>--%>
                <%--<%--%>
                    <%--}--%>
                <%--%>--%>
                <%--<li class="disabled"><a href="#">?</a></li>--%>
                <%--<li><a <c:choose> <c:when test="${(pageInfo.pageNumber+1) > (pageInfo.getTotal()%pageInfo.getPageSize() == 0?pageInfo.getTotal()/pageInfo.getPageSize():pageInfo.getTotal()/pageInfo.getPageSize()+1)}">href="#"</c:when><c:otherwise>href="/user/getUserList?pageNumber=${pageInfo.pageNumber}&add=1"</c:otherwise></c:choose>>&raquo;</a></li>--%>
            <%--</ul>--%>
        </div>
    </div>
        <form action="/file/upload" method="post" enctype="multipart/form-data">
            选择文件:<input type="file" name="file" width="120px">
            <input type="submit" value="上传">
        </form>
        <hr>
        <form action="/file/down" method="get">
            <input type="submit" value="下载">
        </form>
        <h2>图像</h2>
    <p>创建响应式图片(将扩展到父元素)。 另外：图片以椭圆型展示：</p>
    <img src="/resources/images/img01.jpg" class="img-responsive img-circle" alt="Cinque Terre" width="304" height="236">

    <h2>图标</h2>
    <p>插入图标:</p>
    <p>云图标: <span class="glyphicon glyphicon-cloud"></span></p>
    <p>信件图标: <span class="glyphicon glyphicon-envelope"></span></p>
    <p>搜索图标: <span class="glyphicon glyphicon-search"></span></p>
    <p>打印图标: <span class="glyphicon glyphicon-print"></span></p>
    <p>下载图标：<span class="glyphicon glyphicon-download"></span></p>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.page.js"></script>
<!-- JavaScript 放置在文档最后面可以使页面加载速度更快 -->
<!-- 可选: 合并了 Bootstrap JavaScript 插件 -->
<script src="https://apps.bdimg.com/libs/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script>
    function toAddUser(){
        location.href="/hello/toAddUser";
    }

    //分页
    $(".page").createPage({
        pageCount: ${pageInfo.totalPages}, //总页数
        current: ${pageInfo.pageNumber}, //当前页
        display:1,//跳转功能1为显示，0为隐藏
        backFn: function(p) {
            $.ajax({
               url:"/user/getUserList",
               data:{
                   pageNumber:p
               },
                dataType:"text",
                success:function(data){
                    var all = eval("(" + data + ")");
                    var jsonArr = all.rows;
                    var len = jsonArr.length;
                    if (len > 0) {
                        $(".bodyContent").empty();
                    }
                    var str = "";
                    for (var i = 0; i < len; i++) {
                    var user = jsonArr[i];
                        str += "<tr>"+
                                "<td>"+(++i)+"</td>"+
                                "<td>"+user.userName+"</td>"+
                                "<td>"+user.age+"</td>"+
                                "<td><a href='/hello/toAddUser?userId="+user.userId+"'>编辑</a>  <a href='/user/batchDeleteUser?userIds="+user.userId+"'>删除</a></td>"+
                                "</tr>";
                    }
                    $(".bodyContent").append(str);
                }
            });
        }
    });


    $(function(){
        // 初始化轮播
//        $(".start-slide").click(function(){
            $("#myCarousel").carousel('cycle');
//        });
//        // 停止轮播
//        $(".pause-slide").click(function(){
//            $("#myCarousel").carousel('pause');
//        });
//        // 循环轮播到上一个项目
//        $(".prev-slide").click(function(){
//            $("#myCarousel").carousel('prev');
//        });
//        // 循环轮播到下一个项目
//        $(".next-slide").click(function(){
//            $("#myCarousel").carousel('next');
//        });
//        // 循环轮播到某个特定的帧
//        $(".slide-one").click(function(){
//            $("#myCarousel").carousel(0);
//        });
//        $(".slide-two").click(function(){
//            $("#myCarousel").carousel(1);
//        });
//        $(".slide-three").click(function(){
//            $("#myCarousel").carousel(2);
//        });
    });

</script>
</body>
</html>
