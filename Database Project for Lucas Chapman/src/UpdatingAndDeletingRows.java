import java.sql.*;

/**
 * Created by Lucas Chapman 6/30/2020.
 * This program was created to update and delete a row from the Laptops table.
 */
public class UpdatingAndDeletingRows {
    public static Connection connect;

    public static void main(String[] args) {
        createDriver();
        loadDriver();
        connectToDatabase();
        update();
        delete();
    }

    /**
     * Creates the driver and connects to the server
     */
    private static void createDriver() {
        // Driver
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver error, unable to create the database\n" + e.getMessage());
            System.exit(1);
        }

        // Connect to server
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost/";
            connect = DriverManager.getConnection(url, userName, password);
            System.out.println("Connected to server");

        } catch (SQLException e) {
            System.out.println("Cannot connect to server, unable to create database\n" + e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Loads the driver that was created in createDatabase() in the CreateDatabase class
     */
    private static void loadDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");

        } catch (Exception ex) {
            System.out.println("Driver error\n" + ex.getMessage());
            System.exit(1);
        }
    }

    /**
     * Connects to the database by signing in
     */
    private static void connectToDatabase() {
        // Connects to database and sets up the URL it will be under
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost/LaptopsLucasChapman";
            connect = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection established with database server");

        } catch (SQLException e) {
            System.out.println("Cannot connect to database server\n" + e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Updates the Laptop ID 1012 row to change the data in the RAM and Storage columns
     */
    private static void update() {
        int count = 0;
        int id = 1012;
        double ram = 234.9;
        double storage = 599.7;

        try {
            PreparedStatement ps;

            ps = connect.prepareStatement("UPDATE laptops SET ram = ?, storage = ? WHERE id = ?");

            ps.setDouble(1, ram);
            ps.setDouble(2, storage);
            ps.setInt (3, id);
            count = ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            System.out.println("SQL error during UPDATE\n" + e.getMessage());
            System.exit(1);
        }

        if (count == 0) {
            System.out.println(count + " rows were updated\n");
            System.exit(1);
        } else {
            System.out.println(count + " row was updated\n");
            selectUpdatedRow();
        }
    }

    /**
     * Displays the row that was updated in the Laptop tables by storing the row in a Laptop object
     * and then displaying it in the console
     */
    private static void selectUpdatedRow() {
        Statement s;

        System.out.println("Selecting the update row in the Laptops table...\n");

        try {
            s = connect.createStatement();

            // Get a ResultSet by executing a query (your insert/delete/etcW. statement) on that statement
            s.execute("SELECT * FROM laptops WHERE id = 1012"); // select the data from the table
            ResultSet rs = s.getResultSet();
            Laptop laptop = new Laptop();

            // Loop that sets up the Laptop object that prints out the row that was updated in the Laptops table
            while (rs.next()) {
                laptop.setId(rs.getInt("id"));
                laptop.setBrand(rs.getString("brand"));
                laptop.setName(rs.getString("name"));
                laptop.setProductNumber(rs.getString("productNumber"));
                laptop.setSerial(rs.getString("serial"));
                laptop.setOs(rs.getString("os"));
                laptop.setRam(rs.getDouble("ram"));
                laptop.setCpu(rs.getString("cpu"));
                laptop.setStorage(rs.getDouble("storage"));
                laptop.setPrice(rs.getDouble("price"));
                System.out.println(laptop.toString());  // prints out each Laptop object
            }

        } catch (SQLException e) {
            System.out.println("SQL error during UPDATE\n" + e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Deletes the Laptop ID 1000 row
     */
    private static void delete() {
        int count = 0;
        int id = 1000;

        try {
            PreparedStatement ps;

            ps = connect.prepareStatement("DELETE FROM laptops WHERE id = ?");
            ps.setInt(1, id);
            count = ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            // If the row no longer exists or is not found
            System.out.println("SQL error during DELETE FROM\n" + e.getMessage());
            System.exit(1);
        }

        if (count == 0) {
            System.out.println(count + " rows were deleted\n" + "Row was not found");
            System.exit(1);
        } else {
            System.out.println(count + " row was deleted\n");
            selectDeletedRow();
        }
    }

    /**
     * Verifies the row used in the delete() that was deleted in the Laptop tables by selecting the
     * deleted row
     */
    private static void selectDeletedRow() {
        Statement s;

        System.out.println("Selecting delete row in the Laptops table to verify it was removed...\n");

        try  {
            s = connect.createStatement();

            s.execute("SELECT * FROM laptops WHERE id = 1000"); // select the deleted data from the table
            System.out.println("Row was successfully deleted from the table");
            System.exit(1);

        } catch (SQLException e) {
            System.out.println("Row still exists, DELETE FROM was unsuccessful");
            System.exit(1);
        }
    }
}