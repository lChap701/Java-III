<%
    String name = request.getParameter("username");
    session.setAttribute("theName", name);
%>
<html>
<body>
<a href="NextPage.jsp">Continue</a>
</body>
</html>