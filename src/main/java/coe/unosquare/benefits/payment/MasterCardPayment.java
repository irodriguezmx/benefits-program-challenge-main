package coe.unosquare.benefits.payment;

import coe.unosquare.benefits.order.Order;

/**
 *  The MasterCard payment definition.
 */
public class MasterCardPayment extends OrderPayment {

    /**
     *  Instantiates a new MasterCardPayment.
     * @param order The order
     */
    public MasterCardPayment(Order order) {
        super(order);
    }

    /**
     *  Implementation for discount calculation.
     * @return The discount total value
     */
    public Double calculateDiscount() {
        Double subtotal = getOrder().getProducts().entrySet().stream().mapToDouble(product -> product.getKey().getPrice() * product.getValue()).sum();
        return subtotal >= 100.0 ? 0.17 : (subtotal >= 75.0 && subtotal <= 99.0 ? 0.12 : 0.08);
    }
}
