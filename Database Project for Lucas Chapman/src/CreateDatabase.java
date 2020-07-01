import java.sql.*;

/**
 * Created by Lucas Chapman 6/23/2020.
 * This class is used to create SQL tables in a database using WAMP.
 */
public class CreateDatabase {
    public static Connection connect = null;

    public static void main(String[] args) {
        createDatabase();
        loadDriver();
        connectToDatabase();
        createTable();
    }

    /**
     * Creates the database by setting up the driver and connecting to the server
     */
    private static void createDatabase() {
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
            System.out.println ("Connected to server");

        } catch (Exception e) {
            System.out.println ("Cannot connect to server, unable to create database\n" + e.getMessage());
            System.exit(1);
        }

        // Create database
        try {
            Statement stmt = connect.createStatement();
            String sql;

            // Uncomment these to reset the database back to empty.
            //sql= "DROP DATABASE LAPTOPSLUCASCHAPMAN";
            //stmt.executeUpdate(sql);
            sql = "CREATE DATABASE LAPTOPSLUCASCHAPMAN";
            stmt.executeUpdate(sql);
            System.out.println ("Database made");

        } catch (SQLException e) {
            // If the database already exists it will come here.
            System.out.println ("Cannot create database\n" + e.getErrorCode());
            System.exit(1);
        }
    }

    /**
     * Loads the driver that was created in createDatabase()
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
     * Connects to the database signing in
     */
    private static void connectToDatabase() {
        // Connects to database and sets up the URL it will be under
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost/LaptopsLucasChapman";
            connect = DriverManager.getConnection (url, userName, password);
            System.out.println ("Connection established with database server");

        } catch (Exception e) {
            System.out.println ("Cannot connect to database server\n" + e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Creates the Laptops table and drops any existing laptops table
     */
    private static void createTable() {
        Statement s;

        try {
            connect.setAutoCommit(false);   // disables autocommit
            s = connect.createStatement();
            s.executeUpdate ("DROP TABLE IF EXISTS laptops");
            String createStatement = "CREATE TABLE laptops ("
                    + "id INT NOT NULL AUTO_INCREMENT, "
                    + "PRIMARY KEY (id), "
                    + "brand VARCHAR(25) NOT NULL, "
                    + "name VARCHAR(25) NOT NULL, "
                    + "productNumber CHAR(10) NOT NULL, "
                    + "serial CHAR(8) NOT NULL, "
                    + "os VARCHAR(15), "
                    + "ram DEC(4,1) CHECK (ram > 0), "
                    + "cpu VARCHAR(20), "
                    + "storage DEC(4,1) CHECK (storage > 0), "
                    + "price DEC(8,2) NOT NULL CHECK(price > 0))";

            System.out.println(createStatement);
            s.executeUpdate (createStatement + " ENGINE = innoDB");

            connect.commit(); // used in place of autocommit
            s.executeUpdate(
                    "INSERT INTO laptops (id, brand, name, productNumber, serial, os, ram, cpu, storage, price)"
                    + " VALUES"
                    + "(1010, 'Microsoft', 'Business Surface Laptop 3', '10JCR6UKR5', 'LKS67BX1', 'Windows 10', 999.9, 'Intel Core i9-999GHz', 999.9, 999999.99)"
            );

            s.executeUpdate(
                    "INSERT INTO laptops (id, brand, name, productNumber, serial, os, ram, cpu, storage, price)"
                    + " VALUES"
                    + "(1011, 'Apple', 'macBook Air Pro', '15MNW66KRS', '3QOM1AAW', 'macOS', 50.5, 'Intel Core i9-75GHz', 246.1, 599.99)"
            );

            connect.setAutoCommit(true); // turns autocommit back on
        } catch (Exception e) {
            System.out.println("Error, unable to CREATE/DROP laptops table\n" + e.getMessage());
            System.exit(1);
        }
    }
}