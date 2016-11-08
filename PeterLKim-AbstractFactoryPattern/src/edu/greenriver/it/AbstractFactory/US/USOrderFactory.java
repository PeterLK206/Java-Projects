package edu.greenriver.it.AbstractFactory.US;

import edu.greenriver.it.AbstractFactory.IOrderFactory;
import edu.greenriver.it.SalesTax.ISalesTax;
import edu.greenriver.it.SalesTax.US.USSalesTax;
import edu.greenriver.it.ShippingRate.IShippingRate;
import edu.greenriver.it.ShippingRate.US.USShippingRate;

/**
 * Created by peter on 11/5/2016.
 * This is a concrete class that controls the EU factory
 */
public class USOrderFactory implements IOrderFactory {

    /**
     * Returns the US tax object
     * @param zip the zipcode it is being shipped to.
     * @return USSalesTax object
     */
    @Override
    public ISalesTax getTaxObject(String zip) {
        return new USSalesTax(Integer.parseInt(zip));
    }

    /**
     * Returns the US shipping object.
     * @return USShippingRate object.
     */
    @Override
    public IShippingRate getRateObject() {
        return new USShippingRate();
    }
}
