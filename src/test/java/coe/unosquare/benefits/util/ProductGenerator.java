/*
 *  ProductGenerator
 *  1.0
 *  11/8/22, 8:30 PM
 *  Copyright (c) 2022 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.util;

import coe.unosquare.benefits.product.Product;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

import static java.lang.Math.round;

/**
 * The Product generator.
 */
public final class ProductGenerator {

    /**
     * Hide constructor to avoid instances of this utility class.
     */
    private ProductGenerator() { }

    /**
     * Generate products map.
     *
     * @param expectedSize the expected size of the map which matches
     *                     the number of different products in the cart.
     * @return the map
     */
    public static Map<Product, Integer> generateProducts(final Integer expectedSize) {
        HashMap<Product, Integer> products = new HashMap<>();
        IntStream.rangeClosed(1, expectedSize).forEach(id -> {
            products.put(new Product("Product " + id, //product name
                            Double.parseDouble(new DecimalFormat("0.00")
                                                .format(new Random().nextDouble() * 10.00)), //price
                            new Random().nextInt(3) + 1), //type
                    1); //quantity
        });
        return products;
    }

    /**
     * Generate products map.
     *
     * @param expectedTotal the expected total amount to pay for the order before discount
     * @return the map
     */
    public static Map<Product, Integer> generateProducts(final Double expectedTotal) {
        HashMap<Product, Integer> products = new HashMap<>();
        int quantity = 1;
        double total = 0.0;
        int id = 1;
        while (total < expectedTotal) {
            double price = Double.parseDouble(new DecimalFormat("0.0")
                            .format(new Random().nextDouble() * 10.0));
            price = round(price);
            if((total + price) > expectedTotal){
                price = expectedTotal - total;
            }

            products.put(new Product("Product " + id, //product name
                            price,
                            new Random().nextInt(3) + 1), //type
                    quantity); //quantity
            total = total + price * quantity;
            id++;
        }
        return products;
    }
}
