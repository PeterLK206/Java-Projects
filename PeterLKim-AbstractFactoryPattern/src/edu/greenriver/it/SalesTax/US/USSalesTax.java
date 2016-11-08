package edu.greenriver.it.SalesTax.US;

import edu.greenriver.it.SalesTax.ISalesTax;

/**
 * Created by peter on 11/5/2016.
 * This class is used to calculate tax in the EU.
 */
public class USSalesTax implements ISalesTax {
    private ZipData zipData;
    private int zipcode;

    /**
     * a constructor that sets the object.
     *
     * @param zipcode name of region.
     */
    public USSalesTax(int zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * Used to calculate sales tax for the Zip area
     *
     * @param salesSubTotal the rate being passed in.
     * @return the tax of the rate.
     */
    @Override
    public double calculateTax(double salesSubTotal) {

        return salesSubTotal * getStateTax(zipcode);
    }

    //Gets the tax amount for that area
    private double getStateTax(int zipcode) {

        zipData = new ZipData();
        double tax = 0;

        for (Zipcode zip : zipData.getZipDataLinkedList()) {

            if (zipcode <= zip.getZipMax() && zipcode >= zip.getZipMin()) {
                tax = zip.getTax();
                break;
            }
        }

        return tax;

    }
}
