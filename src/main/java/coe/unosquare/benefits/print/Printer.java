package coe.unosquare.benefits.print;

import coe.unosquare.benefits.product.Product;

import java.util.Map;

/**
 *  Printer abstract class
 */
public abstract class Printer {

    /**
     *  The print method to implement
     * @param products
     */
    public abstract void print(Map<Product, Integer> products);
}
