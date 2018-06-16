<%--
  Created by IntelliJ IDEA.
  User: fantasy-tian
  Date: 2018/6/12
  Time: 下午7:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>提交订单</title>
    <script src="js/jquery-1.8.3.js"></script>
  </head>

  <%--ajax异步请求--%>
  <body>

      <form id="formorder">

        订单地址：<input type="text" name="address">
        订单价值：<input type="text" name="totalPrice">
        <input type="button" value="添加" onclick=addorder()>

      </form>

      <div id="list"></div>

  </body>
  <script src="js/add.js"></script>

</html>
