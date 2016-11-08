package edu.greenriver.it.ShippingRate;

/**
 * Created by peter on 11/5/2016.
 * Rate object used to keep tract of different rates.
 */
public class Rate {

    private String shippingType;
    private double rate;

    /**
     * Constructor that sets each rate.
     *
     * @param shippingType shipping type.
     * @param rate         cost of the shipping.
     */
    public Rate(String shippingType, double rate) {
        this.shippingType = shippingType;
        this.rate = rate;
    }

    /**
     * Returns the type.
     *
     * @return shippingType.
     */
    public String getShippingType() {
        return shippingType;
    }

    /**
     * Returns the rate cost of the item.
     *
     * @return cost of shipping before tax.
     */
    public double getRate() {

        return rate;
    }

}
