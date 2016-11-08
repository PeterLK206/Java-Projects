package edu.greenriver.it.ShippingRate;

/**
 * Created by peter on 11/5/2016.
 * Interface shipping rate for all shipping types.
 */
public interface IShippingRate {

    /**
     * Returns a rate.
     *
     * @param type   type of shipping.
     * @param weight weight of the item being shipped.
     * @return Rate object.
     */
    public Rate getRate(String type, double weight);
}
