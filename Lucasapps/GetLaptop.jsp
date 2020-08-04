<jsp:useBean id="laptop" class="laptop.Laptop" scope="session"/>
<html>
<!-- Lucas Chapman Bean and Form Mini Project -->
<title>Bean and Form Mini Project</title>
<body>
<h1>Please Fill Out The Form</h1>
<form method='post' action="SaveLaptop.jsp">
    <label>Enter a laptop ID: <input type='text' name='id' size='20' value=""></label><br>
    <label>Enter the brand of laptop: <input type='text' name='brand' size='20' value=""></label><br>
    <label>Enter the name of laptop: <input type='text' name='name' size='20' value=""></label><br>
    <label>Enter the product number: <input type='text' name='productNumber' size='20' value=""></label><br>
    <label>Enter the serial of the laptop: <input type='text' name='serial' size='20' value=""></label><br>
    <label>Enter the OS of the laptop: <input type='text' name='os' size='20' value=""></label><br>
    <label>Enter the RAM of the laptop: <input type='text' name='ram' size='20' value=""></label><br>
    <label>Enter the CPU of the laptop: <input type='text' name='cpu' size='20' value=""></label><br>
    <label>Enter the storage of the laptop: <input type='text' name='storage' size='20' value=""></label><br>
    <label>Enter the price of the laptop: <input type='text' name='price' size='20' value=""></label><br>
    <input value='Submit' type='submit'>
</form>
</body>
</html>