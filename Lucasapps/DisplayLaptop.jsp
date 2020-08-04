<jsp:useBean id="laptop" class="laptop.Laptop" scope="session"/>
<html>
<!-- Lucas Chapman Bean and Form Mini Project -->
<title>Bean and Form Mini Project</title>
<body>
<b>You entered</b>
<p>ID: <%= laptop.getId() %>
</p>
<p>Brand: <%= laptop.getBrand() %>
</p>
<p>Name: <%= laptop.getName() %>
</p>
<p>Product Number: <%= laptop.getProductNumber() %>
</p>
<p>Serial: <%= laptop.getSerial() %>
</p>
<p>OS: <%= laptop.getOs() %>
</p>
<p>RAM: <%= laptop.getRam() %> GB</p>
<p>CPU: <%= laptop.getCpu() %>
</p>
<p>Storage: <%= laptop.getStorage() %> GB</p>
<p>Price: $<%= laptop.getPrice() %>
</p>
<hr>
<a href="GetLaptop.jsp">Back to GetLaptop</a>
</body>
</html>