package edu.greenriver.it.products;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by peter on 10/14/2016.
 * <p>
 * Product class
 * This class is for creating product objects
 */

@XmlRootElement
public class Product implements Serializable {

    private String name;
    private double price;
    private List<String> keyword;

    /**
     * Default constructor
     * Needed to created a default constructor or Ill get a IllegalAnotationException
     */
    public Product() {

    }

    /**
     * Constructor
     *
     * @param name    = name of product
     * @param price   = price of product
     * @param keyword = List of keywords
     */
    public Product(String name, double price, List<String> keyword) {
        this.name = name;
        this.price = price;
        this.keyword = keyword;
    }

    /**
     * gets name of product
     *
     * @return name of product
     */
    @XmlElement
    public String getName() {
        return name;
    }

    /**
     * sets name of product
     *
     * @param name enter the new name of the product
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets price of product
     *
     * @return price of product
     */
    @XmlElement
    public double getPrice() {
        return price;
    }

    /**
     * sets price of product
     *
     * @param price enter the new price of the product
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * gets list of keywords associated with product
     *
     * @return list of keywords
     */
    @XmlElement
    public List<String> getKeyword() {
        return keyword;
    }

    /**
     * sets list of keywords
     *
     * @param keyword list os keywords
     */
    public void setKeyword(List<String> keyword) {
        this.keyword = keyword;
    }

    /**
     * converts product object to a string
     *
     * @return string of product
     */
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", keyword=" + keyword.toString() +
                '}';
    }
}
