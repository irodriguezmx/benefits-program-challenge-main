/*
 *  PayOrderSimulator
 *  1.0
 *  11/8/22, 8:29 PM
 *  Copyright (c) 2022 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.util;

import coe.unosquare.benefits.exception.EmptyOrderException;
import coe.unosquare.benefits.order.Order;
import coe.unosquare.benefits.payment.CashPayment;
import coe.unosquare.benefits.payment.MasterCardPayment;
import coe.unosquare.benefits.payment.OrderPayment;
import coe.unosquare.benefits.payment.VisaPayment;
import coe.unosquare.benefits.product.Product;
import java.util.Map;

/**
 * The type Pay order simulator.
 */
public final class PayOrderSimulator {
    /**
     * Hide constructor to avoid instances of this utility class.
     */
    private PayOrderSimulator() { }

    /**
     *  Method to simulate the discount calculation for an order being paid using MasterCard.
     * @param products The products
     * @return
     */
    public static Double payOrderUsingMasterCard(final Map<Product, Integer> products) {
        Order order = new Order(products);
        OrderPayment masterCardPayment = new MasterCardPayment(order);
        return masterCardPayment.calculateDiscount();
    }

    /**
     *  Method to simulate the discount calculation for an order being paid using VisaCard.
     * @param products The products
     * @return
     */
    public static Double payOrderUsingVisaCard(final Map<Product, Integer> products) {
        Order order = new Order(products);
        OrderPayment visaCardPayment = new VisaPayment(order);
        return visaCardPayment.calculateDiscount();
    }

    /**
     *  Method to simulate the discount calculation for an order being paid using Cash.
     * @param products The products
     * @return
     */
    public static Double payOrderUsingCash(final Map<Product, Integer> products) {
        Order order = new Order(products);
        OrderPayment cashPayment = new CashPayment(order);
        return cashPayment.calculateDiscount();
    }
}

