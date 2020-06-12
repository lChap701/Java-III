import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Lucas Chapman 6/1/2020.
 * This class is used to create Laptop objects in order to display data to the console.
 */
public class ReadingDATFile {
    /*
     * Global Variable
     */
    public static Scanner myScanner;

    public static void main(String[] args) {
        init();
        Laptop laptops = new Laptop();
        process(laptops);
    }

    /**
     * Sets up the Scanner and checks for the laptops DAT file
     */
    private static void init() {
        try {
            System.out.println("Loading file...");

            File f = new File("laptops.dat");
            myScanner = new Scanner(f);
            myScanner.useDelimiter("\\n");  // set to the Enter key

            System.out.println("File loaded\n");
        } catch (FileNotFoundException e) {
            System.out.println("Error, file was not found");
            System.exit(1);
        }
    }

    /**
     * Reads and processes the DAT file
     * @param laptops passed in order to create new Laptop objects
     */
    private static void process(Laptop laptops) {
        boolean eof = false;

        while (!eof) {
            if (myScanner.hasNext()) {
                String record = myScanner.nextLine();

                laptops.setId(Integer.parseInt(record.substring(0, 4)));
                laptops.setBrand(record.substring(4, 13));
                laptops.setName(record.substring(13, 38));
                laptops.setProductNumber(record.substring(38, 48));
                laptops.setSerial(record.substring(48, 56));
                laptops.setOs(record.substring(56, 69));
                laptops.setRam(Double.parseDouble(record.substring(69, 74)));
                laptops.setCpu(record.substring(74, 94));
                laptops.setStorage(Double.parseDouble(record.substring(94, 99)));
                laptops.setPrice(Double.parseDouble(record.substring(99, 108)));

                System.out.println(laptops.toString());
            } else {
                eof = true;
            }
        }
    }
}