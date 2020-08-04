<html>
<head>
    <!-- Lucas Chapman Example of Mixing HTML and JSP Scriplet -->
    <title>JSP Loops Example 1</title>
</head>
<body>
<h1>Loop Example 1</h1>
<table border='2'>
    <%
        int n = 5;
        for (int i = 0; i < n; i++) {
    %>
    <tr>
        <td>Number</td>
        <td><%= i + 1 %>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>