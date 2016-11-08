package edu.greenriver.it.fileio;

import edu.greenriver.it.products.Product;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by peter on 10/14/2016.
 * <p>
 * class that read json files and writes java objects to json
 */
public class JsonWriter implements Writer {

    /**
     * Writes a Java Object
     * to a JSON file
     *
     * @param object Product object being converted into JSON
     */
    @Override
    public void saveObject(Product object) {

        JSONObject productObj = new JSONObject();

        productObj.put("name", object.getName());
        productObj.put("price", object.getPrice());
        productObj.put("keywords", object.getKeyword());

        try {

            File file = new File("data/" + object.getName() + ".json");
            FileWriter fW = new FileWriter(file);
            fW.write(productObj.toJSONString());
            fW.flush();
            fW.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * reads a JSON file as an object
     *
     * @param name name of file being read
     */
    @Override
    public void loadObject(String name) {

        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("data/" + name));
            JSONObject jsonObject = (JSONObject) obj;

            Product readProduct = new Product((String) jsonObject.get("name"), (double) jsonObject.get("price"), (ArrayList<String>) jsonObject.get("keywords"));
            System.out.println("    " + readProduct.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
