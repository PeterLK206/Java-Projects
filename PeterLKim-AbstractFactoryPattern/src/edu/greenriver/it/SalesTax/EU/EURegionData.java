package edu.greenriver.it.SalesTax.EU;

import java.util.HashMap;

/**
 * Created by peter on 11/5/2016.
 * This class is used to keep track of all the Regions.
 */
public class EURegionData {

    private HashMap<String, EURegion> allRegions;

    /**
     * Constructor that sets the hashmap when it is instantiated.
     */
    public EURegionData() {
        allRegions = new HashMap<>();
        instantiateRegionsToHashMap();
    }

    private void instantiateRegionsToHashMap() {

        allRegions.put("united kingdom", new EURegion("United Kingdom", 0.175));
        allRegions.put("france", new EURegion("France", 0.196));
        allRegions.put("spain", new EURegion("Spain", 0.18));
        allRegions.put("germany", new EURegion("Germany", 0.19));
        allRegions.put("ireland", new EURegion("Ireland", 0.23));

    }

    /**
     * Returns a hashmap of all the regions in the EU
     * @return HashMap of regions
     */
    public HashMap<String, EURegion> getRegionHashMap() {
        return allRegions;
    }

    /**
     * checks if a entered region is valid.
     * @param area name of region.
     * @return boolean.
     */
    public boolean isValidRegion(String area) {
        for (String r: allRegions.keySet()) {
            if (r.toLowerCase().equals(area.toLowerCase())) {
                return true;
            }
        }

        return false;
    }
}
