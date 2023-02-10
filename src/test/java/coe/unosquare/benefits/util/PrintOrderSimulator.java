package coe.unosquare.benefits.util;

import coe.unosquare.benefits.print.OrderPrinter;
import coe.unosquare.benefits.print.Printer;
import coe.unosquare.benefits.product.Product;

import java.util.Map;

/**
 *  Printer Simulator
 */
public final class PrintOrderSimulator {
    /**
     * Method to simulate print an order.
     * @param products
     */
    public static void printOrder(final Map<Product, Integer> products) {
        Printer printer = new OrderPrinter();
        printer.print(products);
    }
}
