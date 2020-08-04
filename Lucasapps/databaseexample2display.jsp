<%@page import="java.sql.*" %>
<html>
<head>
    <!--Example of JSP with Database processing   -->
    <title>JSP Example with MySQL Database</title>
</head>
<body>
Students:
<br>
<%
    try {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
        // Create a connection to the database
        Connection conn = null;
        Statement s;

        String userName = "root";
        String password = "";
        String url = "jdbc:mysql://localhost/students";
        conn = DriverManager.getConnection(url, userName, password);
        System.out.println("Database connection established");

        s = conn.createStatement();

        // Get a ResultSet by executing a query (your insert/delete/etc. statement) on that statement
        s.execute("select * from student"); // select the data from the table
        ResultSet rs = s.getResultSet();
        out.print("<table BORDER=2> ");
        out.print("<tr> <th>Id</th><th>Name</th><th>Age</th><th>Gender</th><th>Graduation</th></tr>");
        while (rs.next()) {
            int id = Integer.parseInt(rs.getString("id"));
            String name = rs.getString("name");
            int age = Integer.parseInt(rs.getString("age"));
            char gender = rs.getString("gender").charAt(0);
            String graduation = rs.getString("graduation");
            out.print("<tr>");
            out.print("<td>" + id + "</td>");
            out.print("<td>" + name + "</td>");
            out.print("<td>" + age + "</td>");
            out.print("<td>" + gender + "</td>");
            out.print("<td>" + graduation + "</td>");
            out.print("</tr>");
        }
        out.print("</table>");
    } catch (Exception ex) {
        out.print("database error");
        System.out.println("database error");
    }
%>
</BODY>
</HTML>