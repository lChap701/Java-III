<html>
<head>
<!-- Lucas Chapman of JSP Expressions and Scriplets -->
<title>JSP Example</title>
</head>
<body>
<h1>Hello World from Lucas Chapman</h1>
Hello!
<%
 // This is a scriptlet. Notice that the "date"
 // variable we declare here is available in the
 // embedded expression later on.
 System.out.println( "Evaluating date now" );
out.println("<b>Hello</b>");
 java.util.Date date = new java.util.Date();
java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("M/d/y");
%>
Hello! <br /> The date is now <%= sdf.format(date) %>
<br />The java version is
<% out.println(System.getProperty("java.version")); %>
</body>
</html>