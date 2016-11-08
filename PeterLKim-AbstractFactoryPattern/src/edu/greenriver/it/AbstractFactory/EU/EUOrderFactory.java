package edu.greenriver.it.AbstractFactory.EU;

import edu.greenriver.it.AbstractFactory.IOrderFactory;
import edu.greenriver.it.SalesTax.EU.EUSalesTax;
import edu.greenriver.it.SalesTax.ISalesTax;
import edu.greenriver.it.ShippingRate.EU.EUShippingRate;
import edu.greenriver.it.ShippingRate.IShippingRate;

/**
 * Created by peter on 11/5/2016.
 *
 * This is a concrete class that controls the EU factory.
 */
public class EUOrderFactory implements IOrderFactory {

    /**
     * Returns the EU tax object
     * @param region The region location it is being shipped to.
     * @return EUSalesTax object.
     */
    @Override
    public ISalesTax getTaxObject(String region) {
        return new EUSalesTax(region);
    }

    /**
     * Returns the EU shipping rate object.
     * @return EUShippingRate object.
     */
    @Override
    public IShippingRate getRateObject() {
        return new EUShippingRate();
    }
}
