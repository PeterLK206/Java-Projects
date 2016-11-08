package edu.greenriver.it.AbstractFactory;

import edu.greenriver.it.SalesTax.ISalesTax;
import edu.greenriver.it.ShippingRate.IShippingRate;

/**
 * Created by peter on 11/5/2016.
 * This is the abstract factory for all other factories.
 */
public interface IOrderFactory {

    /**
     * Returns SalesTax object.
     *
     * @param area the location the item is being shipped to.
     * @return ISalesTax object.
     */
    public ISalesTax getTaxObject(String area);

    /**
     * Returns ShippingRate object.
     *
     * @return IShippingRate object.
     */
    public IShippingRate getRateObject();
}
