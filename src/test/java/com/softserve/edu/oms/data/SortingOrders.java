package com.softserve.edu.oms.data;

public class SortingOrders {
    private String orderName;
    private String totalPrice;
    private String maxDiscount;
    private String deliveryDate;
    private String orederStatusName;
    private String login;
    private String roleName;

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

    public String getOrderStatusName() {
        return orederStatusName;
    }

    public void setOrderStatusName(String orderStatusName) {
        this.orederStatusName = orderStatusName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "SortingOrders{" +
                "orderName='" + orderName + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                ", maxDiscount='" + maxDiscount + '\'' +
                ", deliveryDate='" + deliveryDate + '\'' +
                ", orderStatusName='" + orederStatusName + '\'' +
                ", login='" + login + '\'' +
                ", roleName='" + roleName + '\'' + '}';
    }
}
