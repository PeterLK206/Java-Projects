package edu.greenriver.it.fileio;

import edu.greenriver.it.products.Product;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by peter on 10/14/2016.
 * <p>
 * This is an interface that helps classes read and write files
 */
public interface Writer {

    /**
     * writes Product object to file
     *
     * @param object Product being written
     */
    public void saveObject(Product object);

    /**
     * reads from file
     *
     * @param name filename of file
     */
    public void loadObject(String name);
}
