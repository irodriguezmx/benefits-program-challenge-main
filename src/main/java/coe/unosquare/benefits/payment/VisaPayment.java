package coe.unosquare.benefits.payment;

import coe.unosquare.benefits.order.Order;

/**
 *  The Visa card payment definition.
 */
public class VisaPayment extends OrderPayment{

    /**
     *  Instantiates a new VisaPayment.
     * @param order The order
     */
    public VisaPayment(Order order) {
        super(order);
    }

    /**
     *  Implementation for discount calculation.
     * @return The discount total value
     */
    public Double calculateDiscount() {
        Integer productQuantity = getOrder().getProducts().values().stream().reduce(0, (totalProducts, quantity) -> totalProducts += quantity);
        return productQuantity >= 10 ? 0.15 : (productQuantity >= 7 && productQuantity <= 9 ? 0.10 : 0.05);
    }
}
