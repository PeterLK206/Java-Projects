package edu.greenriver.it.SalesTax;

/**
 * Created by peter on 11/5/2016.
 * Sales Tax interface.
 */
public interface ISalesTax {
    /**
     * Calculates the sales tax.
     *
     * @param salesSubTotal rate.
     * @return tax.
     */
    public double calculateTax(double salesSubTotal);
}
