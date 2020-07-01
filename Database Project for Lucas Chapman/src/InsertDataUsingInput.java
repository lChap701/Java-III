import java.sql.*;
import java.util.Scanner;

/**
 * Created by Lucas Chapman 6/29/2020.
 * This class is used to insert data into tables and create new objects.
 */
public class InsertDataUsingInput {
    public static Connection connect = null;
    public static Scanner myScanner;

    public static void main(String[] args) {
        char again = 'Y';   // assigned this value to allow the user to enter the loop when the program is first ran
        myScanner = new Scanner(System.in);

        createDriver();
        loadDriver();
        connectToDatabase();

        // Loop that allows the user to enter multiple laptops
        while (Character.toUpperCase(again) == 'Y') {
            Laptop laptop = inputLaptop();
            insert(laptop);
            again = enterAgain();
        }

        select();
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
     * Contains all the prompts used to create new Laptop objects
     * @return returns the value stored in the Laptop object
     */
    private static Laptop inputLaptop() {
        Laptop lap = new Laptop();

        lap.setId(inputId());
        lap.setBrand(inputBrand());
        lap.setName(inputName());
        lap.setProductNumber(inputProdNum());
        lap.setSerial(inputSerial());
        lap.setOs(inputOs());
        lap.setRam(inputRam());
        lap.setCpu(inputCpu());
        lap.setStorage(inputStorage());
        lap.setPrice(inputPrice());

        return lap;
    }

    /**
     * Prompts the user for the laptop ID
     * @return returns the value in id to create new Laptop objects
     */
    private static int inputId() {
        boolean isValid = false;
        int id = 0;

        while (!isValid) {
            try {
                System.out.println("\nEnter laptop ID:");
                String input = myScanner.nextLine();
                id = Integer.parseInt(input.trim());
                isValid = true;

            } catch (Exception e) {
                System.out.println("Invalid data, please try again\nPress Enter to continue");
                myScanner.nextLine();
            }
        }

        return id;
    }

    /**
     * Prompts the user for the brand
     * @return returns the value in brand to create new Laptop objects
     */
    private static String inputBrand() {
        boolean isValid = false;
        String brand = "";

        while (!isValid) {
            try {
                System.out.println("Enter the brand of the laptop:");
                brand = myScanner.nextLine();
                isValid = true;

            } catch (Exception e) {
                System.out.println("Invalid data, please try again\nPress Enter to continue");
                myScanner.nextLine();
            }
        }

        return brand;
    }

    /**
     * Prompts the user for the laptop's name
     * @return returns the value in name to create new Laptop objects
     */
    private static String inputName() {
        boolean isValid = false;
        String name = "";

        while (!isValid) {
            try {
                System.out.println("Enter the name of the laptop:");
                name = myScanner.nextLine();
                isValid = true;

            } catch (Exception e) {
                System.out.println("Invalid data, please try again\nPress Enter to continue");
                myScanner.nextLine();
            }
        }

        return name;
    }

    /**
     * Prompts the user for the laptop's product number
     * @return returns the value in prodNum to create new Laptop objects
     */
    private static String inputProdNum() {
        boolean isValid = false;
        String prodNum = "";

        while (!isValid) {
            try {
                System.out.println("Enter the laptop's product number:");
                prodNum = myScanner.nextLine();
                isValid = true;

            } catch (Exception e) {
                System.out.println("Invalid data, please try again\nPress Enter to continue");
                myScanner.nextLine();
            }
        }

        return prodNum.trim();
    }

    /**
     * Prompts the user for the laptop's serial number
     * @return returns the value in serial to create new Laptop objects
     */
    private static String inputSerial() {
        boolean isValid = false;
        String serial = "";

        while (!isValid) {
            try {
                System.out.println("Enter the laptop's serial number:");
                serial = myScanner.nextLine();
                isValid = true;

            } catch (Exception e) {
                System.out.println("Invalid data, please try again\nPress Enter to continue");
                myScanner.nextLine();
            }
        }

        return serial.trim();
    }

    /**
     * Prompts the user for the laptop's OS
     * @return returns the value in os to create new Laptop objects
     */
    private static String inputOs() {
        boolean isValid = false;
        String os = "";

        while (!isValid) {
            try {
                System.out.println("Enter the laptop's operating system (OS):");
                os = myScanner.nextLine();
                isValid = true;

            } catch (Exception e) {
                System.out.println("Invalid data, please try again\nPress Enter to continue");
                myScanner.nextLine();
            }
        }

        return os;
    }

    /**
     * Prompts the user for the laptop's RAM
     * @return returns the value stored in ram to create new Laptop objects
     */
    private static Double inputRam() {
        boolean isValid = false;
        double ram = 0;

        while (!isValid) {
            try {
                System.out.println("Enter the laptop's RAM:");
                String input = myScanner.nextLine();
                ram = Double.parseDouble(input.trim());
                isValid = true;

            } catch (Exception e) {
                System.out.println("Invalid data, please try again\nPress Enter to continue");
                myScanner.nextLine();
            }
        }

        return ram;
    }

    /**
     * Prompts the user for the laptop's CPU
     * @return returns the value stored in cpu to create new Laptop objects
     */
    private static String inputCpu() {
        boolean isValid = false;
        String cpu = "";

        while (!isValid) {
            try {
                System.out.println("Enter the laptop's CPU:");
                cpu = myScanner.nextLine();
                isValid = true;

            } catch (Exception e) {
                System.out.println("Invalid data, please try again\nPress Enter to continue");
                myScanner.nextLine();
            }
        }

        return cpu;
    }

    /**
     * Prompts the user for the amount storage space the laptop has
     * @return returns the value stored in storage to create new Laptop objects
     */
    private static Double inputStorage() {
        boolean isValid = false;
        double storage = 0;

        while (!isValid) {
            try {
                System.out.println("Enter the amount of storage the laptop has:");
                String input = myScanner.nextLine();
                storage = Double.parseDouble(input);
                isValid = true;

            } catch (Exception e) {
                System.out.println("Invalid data, please try again\nPress Enter to continue");
                myScanner.nextLine();
            }
        }

        return storage;
    }

    /**
     * Prompts the user for the price the laptop is sold at
     * @return returns the value stored in price to create new Laptop objects
     */
    private static Double inputPrice() {
        boolean isValid = false;
        double price = 0;

        while (!isValid) {
            try {
                System.out.println("Enter the price of the laptop:");
                String input = myScanner.nextLine();
                price = Double.parseDouble(input);
                isValid = true;

            } catch (Exception e) {
                System.out.println("Invalid data, please try again\nPress Enter to continue");
                myScanner.nextLine();
            }
        }

        return price;
    }

    /**
     * Inserts the data collected in the prompt into the database table
     * @param laptop passes the values stored in the Laptop object
     */
    private static void insert(Laptop laptop) {
        int count = 0;  // variable used to keep track of how many rows were inserted

        System.out.println("Inserting data into the Laptops table...");

        try {
            PreparedStatement ps;

            ps = connect.prepareStatement(
                    "INSERT INTO laptops " +
                            "(id, brand, name, productNumber, serial, os, ram, cpu, storage, price) " +
                            "VALUES " +
                            "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );

            ps.setInt(1, laptop.getId());
            ps.setString(2, laptop.getBrand());
            ps.setString(3, laptop.getName());
            ps.setString(4, laptop.getProductNumber());
            ps.setString(5, laptop.getSerial());
            ps.setString(6, laptop.getOs());
            ps.setDouble(7, laptop.getRam());
            ps.setString(8, laptop.getCpu());
            ps.setDouble(9, laptop.getStorage());
            ps.setDouble(10, laptop.getPrice());
            count = ps.executeUpdate();
            ps.close ();

        } catch (SQLException e) {
            System.out.println("SQL error during INSERT\n" + e.getMessage());
        }

        if (count == 0) {
            System.out.println(count + " rows were inserted\n");
            System.exit(1);
        } else {
            System.out.println(count + " row was inserted\n");
        }
    }

    /**
     * Prompts the user for if the want to enter another laptop
     * @return returns the valid choice entered by the user
     */
    private static char enterAgain() {
        char data = ' ';
        boolean isValid = false;

        while (!isValid) {
            System.out.println("Enter another laptop? \nY - Yes \nN - No");
            data = myScanner.nextLine().trim().charAt(0);

            if (!(Character.toUpperCase(data) == 'Y' || Character.toUpperCase(data) == 'N')) {
                System.out.println("Invalid option, please try again\nPress Enter to continue");
                myScanner.nextLine();
            } else {
                isValid = true;
            }
        }

        return data;
    }

    /**
     * Displays all the rows in the Laptop tables by storing all of the rows in a Laptop object and then displaying it
     * in the console
     */
    private static void select(){
        Statement s;

        System.out.println("Selecting all the rows in the Laptops table...\n");
        try {
            s = connect.createStatement();

            // Get a ResultSet by executing a query (your insert/delete/etc. statement) on that statement
            s.execute("select * from laptops"); // select the data from the table
            ResultSet rs = s.getResultSet();
            Laptop laptop = new Laptop();

            // Loop that sets up the Laptop object that prints out all of the rows in the Laptops table
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
            System.out.println("SQL error during SELECT\n" + e.getMessage());
            System.exit(1);
        }
    }
}