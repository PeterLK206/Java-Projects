package edu.greenriver.it.SalesTax.US;

/**
 * Created by peter on 11/5/2016.
 * This class is a class that keeps track of zip areas
 */
public class Zipcode {

    private String state;
    private int zipMin;

    private int zipMax;
    private double tax;

    /**
     * Constructor used to create Zipcode objects.
     *
     * @param state  state code.
     * @param zipMin areas lowest zip value.
     * @param zipMax areas highest zip value.
     * @param tax    tax in this area.
     */
    public Zipcode(String state, int zipMin, int zipMax, double tax) {

        this.state = state;
        this.zipMin = zipMin;
        this.zipMax = zipMax;
        this.tax = tax;
    }

    /**
     * Returns the state code.
     *
     * @return state code.
     */
    public String getState() {
        return state;
    }

    /**
     * Returns the min zip
     *
     * @return min zip.
     */
    public int getZipMin() {
        return zipMin;
    }

    /**
     * Returns the max zip.
     *
     * @return max zip.
     */
    public int getZipMax() {
        return zipMax;
    }

    /**
     * Returns the tax.
     *
     * @return tax.
     */
    public double getTax() {
        return tax;
    }

}
