<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title1</title>
</head>
<body>
<div>
<%--아래 request.getParameter는 request 즉 queryString에 있는 변수 값을 가져온다.--%>
    year=<%=request.getParameter("year")%>
    month=<%=request.getParameter("month")%>
    day=<%=request.getParameter("day")%>
</div>
<%--Expression Language
    EL에 의한 값 호출은 Model에 있는 값을 가져오므로 아래 15번째 줄에는 아무데이터도 존재하지 않는다.--%>
    ${year}년 ${month}월 ${day}일은 ${yoil}요일입니다.
<br>
    ${myDate.year}년 ${myDate.month}월 ${myDate.day}일은 ${yoil.toString()}요일입니다.
<br>
    ${myDate}
</body>

<%--결과--%>
<%--
request : http://localhost:8085/getYoilMVC5?year=2021&month=10&day=3

year=2021 month=10 day=3
년 월 일은 일요일입니다.
2021년 10월 3일은 일요일입니다.
MyDate(year=2021, month=10, day=3)
--%>
</html>
