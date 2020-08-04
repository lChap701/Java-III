<jsp:useBean id="user" class="user.UserData" scope="session"/>
<html>
<!-- Lucas Chapman Example Of JSP Beans -->
<title>Beans and Form Processing Example</title>
<body>
You entered<BR>
Name: <%= user.getUsername() %><br>
Email: <%= user.getEmail() %><br>
Age: <%= user.getAge() %><br>
<hr>
<a href="GetName3.jsp">Back to GetName3</a>
</body>
</html>