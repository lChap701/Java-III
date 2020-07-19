<html>
<head>
<!-- Lucas Chapman of JSP Directives -->
<title>JSP Directives Example</title>
<%@ page import="java.util.*,java.text.*" %>
</head>
<body>
<h1>Hello World from Lucas Chapman</h1>
Hello!
<%
	// Uses the packages imported from the import directive found below the pair of <title> tags
	System.out.println( "Evaluating date now" );
	out.println("<b>Hello</b>");
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("M/d/y");
%>
Hello! <br /> The date is now <%= sdf.format(date) %>
<br />The java version is
<% out.println(System.getProperty("java.version")); %>

<!-- The loop2.jsp file included using the include directive  -->
<%@ include file="loop2.jsp" %>
</body>
</html>