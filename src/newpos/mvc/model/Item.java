/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpos.mvc.model;

/**
 *
 * @author ASUS
 */
public class Item {
    
    private String itemCoe;
    private String description;
    private int quantity;
    private double unitPrice;

    public Item() {
    }

    public Item(String itemCoe, String description, int quantity, double unitPrice) {
        this.itemCoe = itemCoe;
        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    /**
     * @return the itemCoe
     */
    public String getItemCoe() {
        return itemCoe;
    }

    /**
     * @param itemCoe the itemCoe to set
     */
    public void setItemCoe(String itemCoe) {
        this.itemCoe = itemCoe;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
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
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Item{" + "itemCoe=" + itemCoe + ", description=" + description + ", quantity=" + quantity + ", unitPrice=" + unitPrice + '}';
    }
    
    
}
