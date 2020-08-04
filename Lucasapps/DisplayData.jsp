<html>
<%@ page import="java.sql.*" %>
<head>
    <!-- Lucas Chapman Database Processing -->
    <title>Database Processing</title>
</head>
<body>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    String brand = (String) request.getParameter("brand");
    String name = (String) request.getParameter("name");
    String prodNum = (String) request.getParameter("prodNum");
    String serial = (String) request.getParameter("serial");
    String os = (String) request.getParameter("os");
    double ram = Double.parseDouble(request.getParameter("ram"));
    String cpu = (String) request.getParameter("cpu");
    double storage = Double.parseDouble(request.getParameter("storage"));
    double price = Double.parseDouble(request.getParameter("price"));

    if (id <= 0) {
        id = 1010;
    }
    session.setAttribute("id", id);

    if (brand.isEmpty()) {
        brand = "Microsoft";
    }
    session.setAttribute("brand", brand);

    if (name.isEmpty()) {
        name = "Business Surface Laptop 3";
    }
    session.setAttribute("name", name);

    if (prodNum.isEmpty()) {
        prodNum = "10JCR6UKR5";
    }
    session.setAttribute("prodNum", prodNum);

    if (serial.isEmpty()) {
        serial = "LKS67BX1";
    }
    session.setAttribute("serial", serial);

    if (os.isEmpty()) {
        os = "Windows 10";
    }
    session.setAttribute("os", os);

    if (ram <= 0) {
        ram = 999.9;
    }
    session.setAttribute("ram", ram);

    if (cpu.isEmpty()) {
        cpu = "Intel Core i9-999GHz";
    }
    session.setAttribute("cpu", cpu);

    if (storage <= 0) {
        storage = 999.9;
    }
    session.setAttribute("storage", storage);

    if (price < 0) {
        price = 999999.99;
    }
    session.setAttribute("price", price);

    // Load driver
    try {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
    } catch (Exception ex) {
        System.out.println("Driver error");
    }

    // Connect to the database
    Connection conn = null;

    try {
        String userName = "root";
        String password = "";
        String url = "jdbc:mysql://localhost/laptopslucaschapman";
        conn = DriverManager.getConnection(url, userName, password);
        System.out.println("Connection established");
    } catch (Exception e) {
        System.err.println("Unable to connect to the database");
        System.err.println(e.getMessage());
    }

    // The insert statement
    Statement s;
    boolean inserted;    // used to determine if a row was inserted
    int count;

    try {
        s = conn.createStatement();
        String stmt = "INSERT INTO laptops (id, brand, name, productNumber, serial, os, ram, cpu, storage, price)"
                + " VALUES("
                + id
                + ", '"
                + brand
                + "', '"
                + name
                + "', '"
                + prodNum
                + "', '"
                + serial
                + "', '"
                + os
                + "', "
                + ram
                + ", '"
                + cpu
                + "', "
                + storage
                + ", "
                + price
                + ")";
        System.out.println(stmt);
        count = s.executeUpdate(stmt);
        System.out.println("Row added " + stmt);
        inserted = true;
    } catch (SQLException e) {
        System.out.println("SQL error during CREATE/DROP");
        inserted = false;
    }
%>
<h1>Results</h1>
<%
    if (inserted) {
%>
<b>You entered</b>
<p>ID: <%= session.getAttribute("id") %>
</p>
<p>Brand: <%= session.getAttribute("brand") %>
</p>
<p>Name: <%= session.getAttribute("name") %>
</p>
<p>Product Number: <%= session.getAttribute("prodNum") %>
</p>
<p>Serial: <%= session.getAttribute("serial") %>
</p>
<p>OS: <%= session.getAttribute("os") %>
</p>
<p>RAM: <%= session.getAttribute("ram") %> GB</p>
<p>CPU: <%= session.getAttribute("cpu") %>
</p>
<p>Storage: <%= session.getAttribute("storage") %> GB</p>
<p>Price: $<%= session.getAttribute("price") %>
</p>

<%
} else {
%>
<b>Error, data was not inserted into laptops</b>
<%
    }
%>
<hr>
<a href="GetData.html">Back to GetData</a>
</body>
</html>