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
    <form action="doLogin.html" method="post">
        <span>用户名：</span><input type="text" name="user.userName"><br>
        <span>密码：</span><input type="password" name="user.userPassword"><br>
        <input type="hidden" name="isPasswordMd5" value="false"><br>
        <span>验证码：</span><input type="text" name="captchaCode"><img src="captcha.html"><br>
        <input type="hidden" name="weiXinUserId" value="${weiXinUserId}">
        <input type="checkbox" name="isBindWeiXinUserId" value="true" checked="true"><input type="submit" value="登录">
    </form>
</body>
</html>
