package com.softserve.edu.oms.data;

/**
 * Created by Jane on 05.12.2015.
 */
public class OrderContainer {
    private String orderName;
    private String totalPrice;
    private String maxDiscount;
    private String deliveryDate;
    private String status;
    private String assignee;
    private String role;


    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getMaxDiscount() {
        return maxDiscount;
    }

    public void setMaxDiscount(String maxDiscount) {
        this.maxDiscount = maxDiscount;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderContainer that = (OrderContainer) o;

        if (!orderName.equals(that.orderName)) return false;
        if (!totalPrice.equals(that.totalPrice)) return false;
        if (!maxDiscount.equals(that.maxDiscount)) return false;
        if (!deliveryDate.equals(that.deliveryDate)) return false;
        if (!status.equals(that.status)) return false;
        if (!assignee.equals(that.assignee)) return false;
        return role.equals(that.role);

    }

    @Override
    public int hashCode() {
        int result = orderName.hashCode();
        result = 31 * result + totalPrice.hashCode();
        result = 31 * result + maxDiscount.hashCode();
        result = 31 * result + deliveryDate.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + assignee.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }
}