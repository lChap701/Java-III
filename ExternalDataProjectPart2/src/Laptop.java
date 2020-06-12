import java.text.DecimalFormat;

/**
 * Created by Lucas Chapman 6/1/2020
 * This program is used to read data in a DAT file and store it into objects in order to be displayed
 * back to the user in the console.
 * This class is used for another class to create objects from.
 */
public class Laptop {
    int id;
    String brand, name, productNumber, serial, os, cpu;
    double ram, storage, price;

    // Default Constructor
    Laptop() {
        id = 1010;
        brand = "Microsoft";
        name = "Business Surface Laptop 3";
        productNumber = "10JCR6UKR5";
        serial = "LKS67BX1";
        os = "Windows 10";
        ram = 999.9;    // in GB
        cpu = "Intel Core i9-999GHz";
        storage = 999.9;    // in GB
        price = 999999.99;
    }

    // Overloaded Constructor
    Laptop (int i, String b, String n, String pn, String se, String o, double r, String c, double st,
            double p) {
        setId(i);
        setBrand(b);
        setName(n);
        setProductNumber(pn);
        setSerial(se);
        setOs(o);
        setRam(r);
        setCpu(c);
        setStorage(st);
        setPrice(p);
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public String getSerial() {
        return serial;
    }

    public String getOs() {
        return os;
    }

    public double getRam() {
        return ram;
    }

    public String getCpu() {
        return cpu;
    }

    public double getStorage() {
        return storage;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setId(int i) {
        if (i > 0) {
            id = i;
        } else {
            id = 1010;
        }

    }

    public void setBrand(String b) {
        if (b.isEmpty()) {
            brand = "Microsoft";
        } else {
            brand = b;
        }
    }

    public void setName(String n) {
        if (n.isEmpty()) {
            name = "Business Surface Laptop 3";
        } else {
            name = n;
        }
    }

    public void setProductNumber(String pn) {
        if (pn.isEmpty()) {
            productNumber = "10JCR6UKR5";
        } else {
            productNumber = pn;
        }
    }

    public void setSerial(String se) {
        if (se.isEmpty()) {
            serial = "LKS67BX1";
        } else {
            serial = se;
        }
    }

    public void setOs(String o) {
        if (o.isEmpty()) {
            os = "Windows 10";
        } else {
            os = o;
        }
    }

    public void setRam(double r) {
        if (r > 0) {
            ram = r;
        } else {
            ram = 999.9;
        }
    }

    public void setCpu(String c) {
        if (c.isEmpty()) {
            cpu = "Intel Core i9-999GHz";
        } else {
            cpu = c;
        }
    }

    public void setStorage(double st) {
        if (st > 0) {
            storage = st;
        } else {
            storage = 999.9;
        }
    }

    public void setPrice(double p) {
        if (p < 0) {
            price = 999999.99;
        } else {
            price = p;
        }
    }

    @Override
    public String toString() {
        DecimalFormat cash = new DecimalFormat("$###,##0.00");
        String dashes = "-";
        dashes = dashes.repeat(50);
        return "Laptop\n" + dashes + "\nID: " + getId() +"\nBrand: " + getBrand() + "\nName: " +
                getName() + "\nProduct Number: " + getProductNumber() + "\nSerial: " + getSerial() +
                "\nOS: " + getOs() + "\nRAM: " + getRam() + " GB \nCPU: " + getCpu() + "\nStorage: "
                + getStorage() + " GB \nPrice: " + cash.format(getPrice()) + "\n";
    }
}