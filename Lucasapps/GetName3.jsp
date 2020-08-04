<jsp:useBean id="user" class="user.UserData" scope="session"/>
<html>
<!-- Lucas Chapman Example Of JSP Beans -->
<title>Beans and Form Processing Example</title>
<body>
<form method='post' action="SaveName3.jsp">
    What's your name? <input type='text' name='username' size='20' value="<%= user.getUsername() %>"><br>
    What's your e-mail address? <input type='text' name='email' size='20' value="<%= user.getEmail() %>"><br>
    What's your age? <input type='text' name='age' size='4' value="<%= user.getAge() %>">
    <p><input type='submit'>
</form>
</body>
</html>