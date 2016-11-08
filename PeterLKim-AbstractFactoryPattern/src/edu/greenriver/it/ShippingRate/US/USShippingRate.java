package edu.greenriver.it.ShippingRate.US;

import edu.greenriver.it.ShippingRate.IShippingRate;
import edu.greenriver.it.ShippingRate.Rate;

/**
 * Created by peter on 11/5/2016.
 * Concrete class for USShippingRate.
 */
public class USShippingRate implements IShippingRate {

    private static final Rate STANDARD_RATE_FOR_UNDER_A_POUND = new Rate("Standard", 1);
    private static final Rate STANDARD_RATE_FOR_BETWEEN_ONE_AND_FIVE_POUNDS = new Rate("Standard", 5);
    private static final Rate STANDARD_RATE_FOR_BETWEEN_SIX_AND_TEN_POUNDS = new Rate("Standard", 10);
    private static final Rate STANDARD_RATE_FOR_ABOVE_TEN_POUNDS = new Rate("Standard", 15);


    private static final double ONE_POUND = 1;
    private static final double FIVE_POUNDS = 5;
    private static final double TEN_POUNDS = 10;


    /**
     * Gets the US rate.
     *
     * @param type   type of shipping.
     * @param weight weight of item being shipped.
     * @return Rate object.
     */
    @Override
    public Rate getRate(String type, double weight) {

        if (type.equals("Standard")) {

            if (weight < ONE_POUND) {
                return STANDARD_RATE_FOR_UNDER_A_POUND;
            } else if (weight >= ONE_POUND && weight <= FIVE_POUNDS) {
                return STANDARD_RATE_FOR_BETWEEN_ONE_AND_FIVE_POUNDS;
            } else if (weight > FIVE_POUNDS && weight <= TEN_POUNDS) {
                return STANDARD_RATE_FOR_BETWEEN_SIX_AND_TEN_POUNDS;
            } else if (weight > TEN_POUNDS) {
                return STANDARD_RATE_FOR_ABOVE_TEN_POUNDS;
            } else {
                return null;
            }

        } else if (type.equals("Priority")) {

            return new Rate("Priority", weight * 3);
        } else {
            return null;
        }

    }
}
