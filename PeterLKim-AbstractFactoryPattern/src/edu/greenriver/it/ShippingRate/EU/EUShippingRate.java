package edu.greenriver.it.ShippingRate.EU;

import edu.greenriver.it.ShippingRate.IShippingRate;
import edu.greenriver.it.ShippingRate.Rate;

/**
 * Created by peter on 11/5/2016.
 * this is the concrete class for the EUShippingRate.
 */
public class EUShippingRate implements IShippingRate {

    /**
     * Used to return a rate object.
     *
     * @param type   type of shipping.
     * @param weight weight of item being shipped.
     * @return Rate object.
     */
    @Override
    public Rate getRate(String type, double weight) {

        return new Rate("Standard", weight * 0.5);

    }
}
