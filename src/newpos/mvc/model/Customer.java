/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpos.mvc.model;

/**
 *
 * @author ASUS
 */
public class Customer {
    
    private String id;
    private String name;
    private String address;
    private String eMail;
    private String postalCode;

    public Customer() {
    }

    public Customer(String id, String name, String address, String eMail, String postalCode) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.eMail = eMail;
        this.postalCode = postalCode;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddressl(String address) {
        this.address = address;
    }

    /**
     * @return the eMail
     */
    public String geteMail() {
        return eMail;
    }

    /**
     * @param eMail the eMail to set
     */
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    /**
     * @return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", address=" + address + ", eMail=" + eMail + ", postalCode=" + postalCode + '}';
    }
    
    
}
