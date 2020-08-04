<html>
<%@ page import="java.sql.*" %>
<html>
<head>
    <!-- Ray Example of JSP with Database processing -->
    <title>JSP Example</title>
</head>
<body>
<%!
    private static void loadDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
        } catch (Exception ex) {
            System.out.println("Driver error");
        }
    }

    private static boolean insertRow() {
// Create a connection to the database
        Connection conn = null;
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost/STUDENTS";
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Database connection established");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            return false;
        }
// Create the insert statement. (This example uses hardcoded values.
        Statement s;
        int count;
        try {
            s = conn.createStatement();
            String stmt = "INSERT INTO student (name, age, gender)"
                    + " VALUES"
                    + "('John', 24, 'M')";
            System.out.println(stmt);
            count = s.executeUpdate(stmt);
            System.out.println("Row added " + stmt);
        } catch (SQLException e) {
            System.out.println("SQL error during DROP/CREATE");
            return false;
        }
        return true;
    }// end of insertRow
%>
Hello!
<%
    loadDriver();
    if (insertRow())
        out.print("Row inserted");
    else
        out.print("Row not inserted");
%>
</body>
</html>