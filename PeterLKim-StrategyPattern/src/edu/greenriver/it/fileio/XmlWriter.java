package edu.greenriver.it.fileio;

import edu.greenriver.it.products.Product;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * Created by peter on 10/14/2016.
 * <p>
 * this class reads xml files and writes Java Objects to xml files.
 */
public class XmlWriter implements Writer {

    /**
     * Writes java objects to XML files
     *
     * @param object object being converted into xml
     */
    @Override
    public void saveObject(Product object) {

        try {

            JAXBContext context = JAXBContext.newInstance(Product.class);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            OutputStream os = new FileOutputStream("data/" + object.getName() + ".xml");
            marshaller.marshal(object, os);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * reads xml files
     *
     * @param name file name of xml file to read.
     */
    @Override
    public void loadObject(String name) {


        try {
            JAXBContext context = JAXBContext.newInstance(Product.class);
            File fileObj = new File("data/" + name);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Product readProduct = (Product) unmarshaller.unmarshal(fileObj);

            System.out.println("    " + readProduct.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
