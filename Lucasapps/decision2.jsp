<html>
<head>
    <!-- Lucas Chapman Example of Mixing HTML and JSP Scriplet With A Decision Structure -->
    <title>JSP Decision Structure Example 2</title>
</head>
<body>
<h1>Decision Example 2</h1>
<p>Uses a decision structure to display a message using only 1 JSP Scriptlet</p>
<%
    boolean hello = false;
    if (hello) {
        out.print("<p>Hello, world</p>\n");
    } else {
        out.print("<p>Goodbye, world</p>\n");
    }
%>
</body>
</html> 