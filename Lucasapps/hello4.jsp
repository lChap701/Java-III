<!-- Lucas Chapman of JSP Declarations Example -->
<!-- Taken from: http://web.archive.org/web/20190804083121/http://jsptut.com/Declarations.jsp -->
<%@ page import="java.util.*" %>
<HTML>
<title>JSP Declarations Example</title>
<BODY>
<%!
    // Uses a declaration (the symbols (top and bottom) that contain the code) to print the current date
    Date theDate = new Date();

    Date getDate() {
        System.out.println("In getDate() method");
        return theDate;
    }
%>
Hello! The time is now <%= getDate() %>
</BODY>
</HTML>