<html>
<head>
<!-- Lucas Chapman Example of Mixing HTML and JSP Scriplet With A Decision Structure -->
<title>JSP Decision Structure Example 1</title>
</head>
<body>
	<h1>Decision Example 1</h1>
	<p>Uses a decision structure to display a message using multiple JSP Scriptlets</p>
<%
	boolean hello = true;
	if (hello) {
%>
	<p>Hello, world</p>
<%
	} else { 
%>
	<p>Goodbye, world</p>
<%	
	}
%>
</body>
</html> 