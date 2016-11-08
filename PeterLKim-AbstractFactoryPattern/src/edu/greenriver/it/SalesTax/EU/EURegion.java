package edu.greenriver.it.SalesTax.EU;

/**
 * Created by peter on 11/5/2016.
 * This class us used to keep track of the different EU regions tax.
 */
public class EURegion {

    private String region;
    private double tax;

    /**
     * Constructor used to create a EU Region.
     *
     * @param region region name.
     * @param tax    region tax amount.
     */
    public EURegion(String region, double tax) {
        this.region = region;
        this.tax = tax;
    }

    /**
     * Returns the region name.
     *
     * @return region name.
     */
    public String getRegion() {
        return region;
    }

    /**
     * Returns the region tax amount.
     *
     * @return region tax amount.
     */
    public double getTax() {
        return tax;
    }
}
