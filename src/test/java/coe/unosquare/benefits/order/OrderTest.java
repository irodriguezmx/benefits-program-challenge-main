/*
 *  OrderTest
 *  1.0
 *  11/8/22, 8:28 PM
 *  Copyright (c) 2022 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.order;

import coe.unosquare.benefits.exception.EmptyOrderException;
import coe.unosquare.benefits.payment.CashPayment;
import coe.unosquare.benefits.payment.OrderPayment;
import coe.unosquare.benefits.product.Product;
import coe.unosquare.benefits.util.ProductGenerator;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static coe.unosquare.benefits.util.PayOrderSimulator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class   OrderTest {
    /**
     * Testing for payments using Visa card in orders with more than 10 products.
     */
    @Test
    void orderWithVisaMoreThan10ProductsDiscountTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(15);
        assertEquals(0.15, payOrderUsingVisaCard(products));
    }

    /**
     * Testing for payments using Visa card in orders with 10 products.
     */
    @Test
    void orderWithVisa10ProductsDiscountTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(10);
        assertEquals(0.15, payOrderUsingVisaCard(products));
    }

    /**
     * Testing for payments using Visa card in orders with 7 products.
     */
    @Test
    void orderWithVisa7ProductsDiscountTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(7);
        assertEquals(0.10, payOrderUsingVisaCard(products));
    }

    /**
     * Testing for payments using Visa card in orders with less than 7 products.
     */
    @Test
    void orderWithVisaLessThan7ProductsDiscountTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(5);
        assertEquals(0.05, payOrderUsingVisaCard(products));
    }

    /**
     * Testing for payments using MasterCard card in orders with more than 100 in total amount.
     */
    @Test
    void orderWithMasterCardMoreThan100DollarsDiscountTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(150.0);
        assertEquals(0.17, payOrderUsingMasterCard(products));
    }

    /**
     * Testing for payments using MasterCard card in orders with 100 in total amount.
     */
    @Test
    void orderWithMasterCard100DollarsDiscountTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(100.0);
        assertEquals(0.17, payOrderUsingMasterCard(products));
    }

    /**
     * Testing for payments using MasterCard card in orders with 75 in total amount.
     */
    @Test
    void orderWithMasterCard75DollarsDiscountTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(75.0);
        assertEquals(0.12, payOrderUsingMasterCard(products));
    }

    /**
     * Testing for payments using MasterCard card in orders with less than 75 in total amount.
     */
    @Test
    void orderWithMasterCardLessThan75DollarsDiscountTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(50.0);
        assertEquals(0.08, payOrderUsingMasterCard(products));
    }

    /**
     * Testing for payments using cash in orders with 75 in total amount.
     */
    @Test
    void orderWithCashPayment75DollarsDiscountTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(50.0);
        assertEquals(0.0, payOrderUsingCash(products));
    }

    /**
     * Testing for throw a custom exception when pay an empty order.
     */
    @Test
    void emptyOrderTest() {
        assertThrows(EmptyOrderException.class, () -> {
            OrderPayment cashPayment = new CashPayment(null);
            cashPayment.payOrder();
        });
    }
}
