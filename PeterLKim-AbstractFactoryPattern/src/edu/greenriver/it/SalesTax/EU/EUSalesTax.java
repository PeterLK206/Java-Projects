package edu.greenriver.it.SalesTax.EU;

import edu.greenriver.it.SalesTax.ISalesTax;

/**
 * Created by peter on 11/5/2016.
 * This class is used to calculate tax in the EU.
 */
public class EUSalesTax implements ISalesTax {

    private String region;
    private EURegionData regionData;

    /**
     * a constructor that sets the object.
     * @param region name of region.
     */
    public EUSalesTax(String region) {
        this.region = region;
    }

    /**
     * Used to calculate sales tax for the Region
     * @param salesSubTotal the rate being passed in.
     * @return the tax if the rate.
     */
    @Override
    public double calculateTax(double salesSubTotal) {
        return getRegionTax() * salesSubTotal;
    }

    //gets the region tax amount.
    private double getRegionTax() {
        regionData = new EURegionData();
        double tax = 0;

        for (String regionInCollection : regionData.getRegionHashMap().keySet()) {
            if(regionInCollection.equals(this.region)){
                tax = regionData.getRegionHashMap().get(regionInCollection).getTax();
                break;
            }
        }

        return tax;
    }
}
