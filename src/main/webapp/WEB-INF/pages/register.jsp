<%--
  Created by IntelliJ IDEA.
  User: blademainer
  Date: 2014/10/28 0028
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form action="../user.html" method="post">
        <!--
        private String userName;
        private String userPassword;
        private String realName;
        private String nickName;
        private Date birthday;
        private Short age;
        private String mobile;
        private Short level;
        private String email;
        -->
        <span>用户名：</span><input type="text" name="user.userName">
        <span>密码：</span><input type="password" name="user.userPassword">
        <span>姓名：</span><input type="text" name="user.realName">
        <span>昵称：</span><input type="text" name="user.nickName">
        <span>手机：</span><input type="text" name="user.mobile">
        <input type="submit" value="注册">
    </form>
</body>
</html>
