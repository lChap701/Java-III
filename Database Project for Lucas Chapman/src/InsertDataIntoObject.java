import java.sql.*;

/**
 * Created by Lucas Chapman 6/29/2020.
 * This class is used to create Laptop objects using data in the database.
 */
public class InsertDataIntoObject {
    public static Connection connect = null;

    public static void main(String[] args) {
        createDatabase();
        loadDriver();
        connectToDatabase();
        select();
    }

    /**
     * Creates the database by setting up the driver and connecting to the server
     */
    private static void createDatabase() {
        // Driver
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception e) {
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
     * Runs a SELECT statement and puts the data in each column of the rows in the table in a Laptop object
     */
    private static void select() {
        Statement s;
        try {
            s = connect.createStatement();

            // Get a ResultSet by executing a query (your insert/delete/etc. statement) on that statement
            s.execute("select * from laptops"); // select the data from the table
            ResultSet rs = s.getResultSet();

            while (rs.next()) {
                Laptop laptop = new Laptop(
                        rs.getInt("id"),
                        rs.getString("brand"),
                        rs.getString("name"),
                        rs.getString("productNumber"),
                        rs.getString("serial"),
                        rs.getString("os"),
                        rs.getDouble("ram"),
                        rs.getString("cpu"),
                        rs.getDouble("storage"),
                        rs.getDouble("price")
                );
                System.out.print(laptop.toString());
            }
        } catch (SQLException e) {
            System.out.println("SQL error during SELECT, unable to create new Laptop objects\n" + e.getMessage());
        }
    }
}