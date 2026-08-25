package za.ac.cput.digitalpharmacysystem.domain;
/*
 * Sibulele Pama
 * 221447498
 */

import jakarta.persistence.*;

@Entity
@Table(name = "order_item")

public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String orderId;
    private String orderQty;
    private String priceAtPurchase;

    protected OrderItem() {
    }

    private OrderItem(Builder builder) {
        this.orderId = builder.orderId;
        this.orderQty = builder.orderQty;
        this.priceAtPurchase = builder.priceAtPurchase;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getOrderQty() {
        return orderQty;
    }

    public String getPriceAtPurchase() {
        return priceAtPurchase;
    }

    public static class Builder {
        private String orderId;
        private String orderQty;
        private String priceAtPurchase;

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setOrderQty(String orderQty) {
            this.orderQty = orderQty;
            return this;
        }

        public Builder setPriceAtPurchase(String priceAtPurchase) {
            this.priceAtPurchase = priceAtPurchase;
            return this;
        }

        public OrderItem build() {
            return new OrderItem(this);
        }
    }
}
