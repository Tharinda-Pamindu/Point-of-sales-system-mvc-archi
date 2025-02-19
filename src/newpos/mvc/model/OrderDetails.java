/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpos.mvc.model;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class OrderDetails {

    private String custID;
    private String orderID;
    private Date orderDate;
    private Double subTotal;

    public OrderDetails() {
    }

    public OrderDetails(String custID, String orderID, Date orderDate, Double subTotal) {
        this.custID = custID;
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.subTotal = subTotal;
    }

    /**
     * @return the custID
     */
    public String getCustID() {
        return custID;
    }

    /**
     * @param custID the custID to set
     */
    public void setCustID(String custID) {
        this.custID = custID;
    }

    /**
     * @return the orderID
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * @param orderID the orderID to set
     */
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    /**
     * @return the subTotal
     */
    public Double getSubTotal() {
        return subTotal;
    }

    /**
     * @param subTotal the subTotal to set
     */
    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * @return the orderDate
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "OrderDetails{" + "custID=" + custID + ", orderID=" + orderID + ", orderDate=" + orderDate + ", subTotal=" + subTotal + '}';
    }
    
}
