package edu.greenriver.it.producttest;

import edu.greenriver.it.fileio.JsonWriter;
import edu.greenriver.it.fileio.ObjectWriter;
import edu.greenriver.it.fileio.Writer;
import edu.greenriver.it.fileio.XmlWriter;
import edu.greenriver.it.products.Product;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by peter on 10/14/2016.
 * <p>
 * This is the driver class
 * This class initiates the program
 * and provides input and output for the program.
 */
public class Driver {

    private static Scanner sc = new Scanner(System.in);

    /**
     * This is the main method
     * the main method initiates the programs
     *
     * @param args
     */
    public static void main(String[] args) {
        startProgram();
    }

    //Starts the program
    private static void startProgram() {
        int option;
        System.out.println("Product Manager Application");
        System.out.println("Choose an option:");
        System.out.println("    1.) Write a product to a file.");
        System.out.println("    2.) Read a file.");

        while (true) {

            option = sc.nextInt();

            if (option == 1 ^ option == 2) {
                break;
            } else {
                System.out.println("Invalid Option, please try again:");
            }
        }

        if (option == 1) {
            Product currentProduct = createProduct();
            chooseWriteObjectType(currentProduct);

        } else if (option == 2) {
            chooseReadObjectType();
        }
    }

    //Prompts user to enter fields to create project.
    private static Product createProduct() {

        System.out.println("Create Product:");
        System.out.println("    Enter Product Name:");
        String name = sc.next();
        System.out.println("    Enter Price:");
        double price = sc.nextDouble();

        int counter = 0;
        ArrayList<String> keywords = new ArrayList<>();
        System.out.println("    Enter Keywords:");

        while (true) {
            keywords.add(sc.next());

            System.out.println("    Add More Keywords? (y/n):");
            String yN = sc.next();
            if (yN.equals("n")) {
                break;
            }

            System.out.println("    Enter another keyword:");
        }

        System.out.println("Product Create!");

        return new Product(name, price, keywords);

    }

    //Prompts user to choose write option.
    private static void chooseWriteObjectType(Product p) {

        System.out.println("Choose an option:");
        System.out.println("    1.Write to a Dat file.");
        System.out.println("    2.Write to a JSON file.");
        System.out.println("    3.Write to a XML file.");
        int option;

        while (true) {

            option = sc.nextInt();

            if (option == 1 ^ option == 2 ^ option == 3) {
                break;
            } else {
                System.out.println("Invalid Option, please try again:");
            }
        }

        switch (option) {
            case 1:
                writeObject(new ObjectWriter(), p);
                break;
            case 2:
                writeObject(new JsonWriter(), p);
                break;
            case 3:
                writeObject(new XmlWriter(), p);
                break;
            default:
                System.out.println("Invalid option, please start over!");
        }

    }

    //Prompts user to enter file name to read
    private static void chooseReadObjectType() {
        System.out.println("Enter a file name INCLUDING extension:");
        sc.nextLine();
        String fileName = sc.nextLine();
        String fileExt = fileName.substring(fileName.length() - 3);

        switch (fileExt) {
            case "dat":
                readObject(new ObjectWriter(), fileName);
                break;
            case "son":
                readObject(new JsonWriter(), fileName);
                break;
            case "xml":
                readObject(new XmlWriter(), fileName);
                break;
            default:
                System.out.println("File not found please start over!");
        }


    }

    //Reads object from file
    private static void readObject(Writer w, String fileName) {
        System.out.println("Reading product from file...");

        w.loadObject(fileName);

        System.out.println("File Read Complete.");
    }

    //Writes object to file
    private static void writeObject(Writer w, Product p) {

        w.saveObject(p);
        System.out.println("Object saved!");

    }
}
