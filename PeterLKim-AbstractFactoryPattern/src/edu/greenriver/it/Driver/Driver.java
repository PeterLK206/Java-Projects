package edu.greenriver.it.Driver;


import edu.greenriver.it.AbstractFactory.IOrderFactory;
import edu.greenriver.it.Console.Console;
import edu.greenriver.it.FactoryProducer.FactoryProducer;
import edu.greenriver.it.SalesTax.EU.EURegionData;
import edu.greenriver.it.SalesTax.ISalesTax;
import edu.greenriver.it.SalesTax.US.ZipData;
import edu.greenriver.it.ShippingRate.IShippingRate;

import java.util.Currency;

/**
 * Created by peter on 11/6/2016.
 * This is the driver class. this class is responsible for starting and running the whole program.
 */
public class Driver {

    public static final int US = 1;
    public static final int EU = 2;
    public static final int STANDARD = 1;
    public static final int PRIORITY = 2;

    /**
     * The main class initiates the entire program
     * @param args unused
     */
    public static void main(String[] args) {

        String location;
        double weight;
        String name;
        String shipping;
        String area;
        double totalCost;

        Console.print("Welcome to Pete's International Shipping We Have the Lowest Rates In The World!!! \n");

        Console.print("Where are you shipping?");
        Console.print("     1.) US");
        Console.print("     2.) EU \n");

       location = getShippingCountry();

        Console.print("OK! lets prepare your order then.");

        name = Console.getString("\nEnter a name for the order");
        weight = Console.getDouble("Enter package weight");

        Console.print("What type of shipping will you use?");
        Console.print("     1.) Standard");
        Console.print("     2.) Priority\n");


        shipping = getShippingType();

        totalCost = getShippingRegionAndReturnTotal(location, weight, shipping);

        Console.print("Hello " + name + " your order to the " + location + " is a grand total of " + String.format("%.2f",totalCost));
        System.exit(0);


    }

    //Used to get shipping type.
    private static String getShippingType() {

        while (true) {

            String shipping;

            int shippingType = Console.getInt("Enter 1 for Standard shipping or 2 for Priority shipping");

            if (shippingType == STANDARD || shippingType == PRIORITY) {

                if (shippingType == STANDARD) {
                    shipping = "Standard";
                } else {
                    shipping = "Priority";
                }

                return shipping;

            } else {
                Console.print("\nInvalid option please try again.");
            }

        }
    }

    //Used to get total based on region of the area.
    private static double getShippingRegionAndReturnTotal(String location, double weight, String shipping) {
        String area;
        double totalCost;
        ZipData zData = new ZipData();
        EURegionData rData = new EURegionData();
        FactoryProducer factoryProducer = new FactoryProducer();

        while (true) {

            if (location.equals("US")) {

                Console.print("Valid Locations by zip:");
                Console.print("     WA");
                Console.print("     NY");
                Console.print("     CA");
                Console.print("     FL\n");

                area = Console.getString("Please Enter a integer Zipcode in the area you want to ship.");


                if (zData.isValidZipcode(Integer.parseInt(area))) {
                    totalCost = calculateCost(factoryProducer.getFactory(location), area, weight, shipping);
                    return totalCost;
                } else {
                    Console.print("invalid zip code please try again.");
                }

            } else if (location.equals("EU")) {

                Console.print("Valid Locations:");
                Console.print("     United Kingdom");
                Console.print("     France");
                Console.print("     Spain");
                Console.print("     Germany");
                Console.print("     Ireland\n");

                area = Console.getString("Please Enter a Region in the area you want to ship");

                if (rData.isValidRegion(area)) {
                    totalCost = calculateCost(factoryProducer.getFactory(location), area, weight, shipping);
                    return totalCost;
                } else {
                    Console.print("invalid region please try again.");
                }

            }

        }
    }

    //Used to get the country location of where the goods will be shipped.
    private static String getShippingCountry() {
        int shippingLocation;
        String location;
        while (true) {

            shippingLocation = Console.getInt("Press 1 for US or 2 for EU");

            if (shippingLocation == US || shippingLocation == EU) {

                if (shippingLocation == US) {
                    location = "US";
                } else {
                    location = "EU";
                }

                return location;

            } else {
                Console.print("\nInvalid option please try again.");
            }
        }

    }

    // used to calculate the cost of the shipping rate with tax.
    private static double calculateCost(IOrderFactory factory, String area, double weight, String shippingType) {

        IShippingRate shippingRate = factory.getRateObject();
        ISalesTax salesTax = factory.getTaxObject(area);

        double subTotal = shippingRate.getRate(shippingType, weight).getRate();
        double tax = salesTax.calculateTax(subTotal);

        return subTotal + tax;

    }
}
