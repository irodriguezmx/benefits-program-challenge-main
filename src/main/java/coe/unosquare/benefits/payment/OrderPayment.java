package coe.unosquare.benefits.payment;

import coe.unosquare.benefits.exception.EmptyOrderException;
import coe.unosquare.benefits.order.Order;

/**
 *  The order payment definition.
 */
public abstract class OrderPayment {
    /**
     * The order
     */
    private final Order order;

    /**
     * Instantiates a new OrderPayment.
     * @param order the order
     */
    public OrderPayment(Order order) {
        this.order = order;
    }

    /**
     *  Contract definition for discount calculation.
     * @return The discount total value
     */
    public abstract Double calculateDiscount();

    /**
     *  Implementation for order payment.
     * @return  The order total value.
     * @throws EmptyOrderException  The custom exception thrown
     */
    public Double payOrder() throws EmptyOrderException {
        if(order == null || order.getProducts() == null) {
            throw new EmptyOrderException("Error: Empty Order Encountered");
        }

        Double subtotal = order.getProducts().entrySet().stream().mapToDouble(product -> product.getValue() * product.getKey().getPrice()).sum();
        Double discount = calculateDiscount();
        return subtotal - (subtotal * discount);
    }

    /**
     * Gets the order
     * @return The order
     */
    public Order getOrder() {
        return order;
    }
}
