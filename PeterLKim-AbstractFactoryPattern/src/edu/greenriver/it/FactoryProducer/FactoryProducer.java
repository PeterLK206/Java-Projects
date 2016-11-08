package edu.greenriver.it.FactoryProducer;

import edu.greenriver.it.AbstractFactory.EU.EUOrderFactory;
import edu.greenriver.it.AbstractFactory.IOrderFactory;
import edu.greenriver.it.AbstractFactory.US.USOrderFactory;

/**
 * Created by peter on 11/6/2016.
 * I use this class as a handler to different factories.
 */
public class FactoryProducer {

    /**
     * This method is used to create different factories dynamically.
     * @param factory factory type name.
     * @return IOrderFactory object.
     */
    public static IOrderFactory getFactory(String factory) {

        if (factory.equals("US")) {

            return new USOrderFactory();

        }

        else if (factory.equals("EU")){

            return new EUOrderFactory();
        } else {

            return null;

        }

    }
}
