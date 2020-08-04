<html>
<head>
    <!-- Lucas Chapman Example of Mixing HTML and JSP Scriplet -->
    <title>JSP Loop Example 2</title>
</head>
<body>
<h1>Loop Example 2</h1>
<p>Create a table using only 1 JSP Scriptlet</p>
<%
    int n = 5;
    out.print("<table BORDER=2>");
    for (
            int i = 0; i < n; i++) {
        out.print("<tr>");
        out.print("<td>Number</td>");
        out.print("<td> " + (i + 1) + "</td>");
        out.print("</tr> ");
    }
    out.print("</table>");
%>
</body>
</html> 