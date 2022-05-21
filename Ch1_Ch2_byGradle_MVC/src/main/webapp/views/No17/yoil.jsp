<%--
  Created by IntelliJ IDEA.
  User: JKM
  Date: 2022-05-11
  Time: 오전 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
year = <%=request.getParameter("year")%>
<%--${} : EL (Expression Langugage)--%>
<p>${myDate.year}년 ${requestScope.myDate.month}월 ${pageContext.request.getAttribute("myDate").getDay()}일은 ${yoil}요일입니다.</p>
</body>
</html>
