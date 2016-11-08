package edu.greenriver.it.SalesTax.US;

import java.util.LinkedList;

/**
 * Created by peter on 11/5/2016.
 * This class is used to keep track of all the Zipcodes.
 */
public class ZipData {

    private LinkedList<Zipcode> allZips;

    /**
     * Constructor that sets the linklist of zipcodes when it is instantiated.
     */
    public ZipData() {
        allZips = new LinkedList<>();
        instantiateStatesToLinkedList();
    }

    // sets values
    private void instantiateStatesToLinkedList() {

        allZips.add(new Zipcode("CA", 90001, 96162, 0.075));
        allZips.add(new Zipcode("NY", 10001, 14975, 0.08875));
        allZips.add(new Zipcode("NY", 6390, 6390, 0.08875));
        allZips.add(new Zipcode("WA", 98001, 99403, 0.099));
        allZips.add(new Zipcode("FL", 32004, 34997, 0.06));

    }

    /**
     * Returns the LinkList of all zipcodes.
     *
     * @return Linkedlist of zipcodes.
     */
    public LinkedList<Zipcode> getZipDataLinkedList() {
        return allZips;
    }

    /**
     * Checks to see if a zip being passed in is valid.
     *
     * @param zip zip being passed in.
     * @return Boolean.
     */
    public boolean isValidZipcode(int zip) {

        for (Zipcode z : allZips) {
            if (z.getZipMax() >= zip && z.getZipMin() <= zip) {
                return true;
            }
        }

        return false;
    }
}
