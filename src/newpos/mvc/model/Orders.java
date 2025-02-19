/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpos.mvc.model;

/**
 *
 * @author ASUS
 */
public class Orders {

    private String orderID;
    private String itemCode;
    private String Description;
    private Double unitPrice;
    private int quantity;
    private Double totalPrice;

    public Orders() {
    }

    public Orders(String orderID, String itemCode, String Description, Double unitPrice, int quantity, Double totalPrice) {
        this.orderID = orderID;
        this.itemCode = itemCode;
        this.Description = Description;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
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
     * @return the itemCode
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode the itemCode to set
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * @return the unitPrice
     */
    public Double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the totalPrice
     */
    public Double getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice the totalPrice to set
     */
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Orders{" + "orderID=" + orderID + ", itemCode=" + itemCode + ", Description=" + Description + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", totalPrice=" + totalPrice + '}';
    }

}
