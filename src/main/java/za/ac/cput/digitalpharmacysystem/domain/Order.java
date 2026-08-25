package za.ac.cput.digitalpharmacysystem.domain;
/*
 * Sibulele Pama
 * 221447498
 */

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")

public class Order {
    @Id
    private String orderNumber;
    private String customerId;
    private double totalAmt;
    private String orderType;
    private String orderStatus;
    private String paymentStatus;

    protected Order() {
    }

    private Order(Builder builder) {
        this.orderNumber = builder.orderNumber;
        this.customerId = builder.customerId;
        this.totalAmt = builder.totalAmt;
        this.orderType = builder.orderType;
        this.orderStatus = builder.orderStatus;
        this.paymentStatus = builder.paymentStatus;
    }

    public String getId() {
        return orderNumber;
    }

    public static class Builder {
        private String orderNumber;
        private String customerId;
        private double totalAmt;
        private String orderType;
        private String orderStatus;
        private String paymentStatus;

        public Builder setOrderNumber(String orderNumber) {
            this.orderNumber = orderNumber;
            return this;
        }

        public Builder setCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setTotalAmt(double totalAmt) {
            this.totalAmt = totalAmt;
            return this;
        }

        public Builder setOrderType(String orderType) {
            this.orderType = orderType;
            return this;
        }

        public Builder setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public Builder setPaymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }

    //Getters
    public String getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public double getTotalAmt() {
        return totalAmt;
    }

    public String getOrderType() {
        return orderType;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }
}
