package edu.greenriver.it.fileio;

import edu.greenriver.it.products.Product;

import java.io.*;

/**
 * Created by peter on 10/14/2016.
 * <p>
 * ObjectWriter is a Subclass of writer
 * it writes Java objects to a dat file
 * and reads dat file back into java objects.
 */
public class ObjectWriter implements Writer {

    /**
     * writes a product object
     * to a dat file
     *
     * @param object product object that is bing written to a file.
     */
    @Override
    public void saveObject(Product object) {

        try {
            FileOutputStream fos = new FileOutputStream("data/" + object.getName() + ".dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * reads a file with the string name and finds that file and reads it.
     *
     * @param name file name of item.
     */
    @Override
    public void loadObject(String name) {

        try {
            FileInputStream fis = new FileInputStream("data/" + name);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Product p = (Product) ois.readObject();
            System.out.println(p.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
