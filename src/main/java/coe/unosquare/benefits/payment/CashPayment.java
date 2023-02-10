package coe.unosquare.benefits.payment;

import coe.unosquare.benefits.order.Order;

/**
 *  The cash payment definition.
 */
public class CashPayment extends OrderPayment {

    /**
     *  Instantiates a new CashPayment.
     * @param order The order
     */
    public CashPayment(Order order) {
        super(order);
    }

    /**
     *  Implementation for discount calculation.
     * @return The discount total value
     */
    public Double calculateDiscount() {
        return 0.0;
    }
}
