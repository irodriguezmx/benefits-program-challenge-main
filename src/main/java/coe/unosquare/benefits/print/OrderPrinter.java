package coe.unosquare.benefits.print;

import coe.unosquare.benefits.product.Product;

import java.util.Map;

/**
 *  Printer for orders
 *
 */
public class OrderPrinter extends Printer{

    /**
     *  Print products for orders
     * @param products
     */
    public void print(Map<Product, Integer> products) {
        products.forEach((product, quantity) ->
                System.out.println("Product:{" + product.getName() + ","
                        + product.getPrice() + ","
                        + product.getType()
                        + "},Quantity:" + quantity
                        + ",Total:" + product.getPrice() * quantity));
    }
}
