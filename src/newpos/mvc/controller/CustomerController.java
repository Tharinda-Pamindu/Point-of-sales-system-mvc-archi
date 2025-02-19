/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpos.mvc.controller;

import java.sql.Connection;
import newpos.mvc.db.DBConnection;
import newpos.mvc.model.Customer;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author ASUS
 */
public class CustomerController {
    
    public String addCustomer(Customer customer) throws SQLException {
        
        Connection connection = DBConnection.getInstance().getConnection();
        
        String sql = "INSERT INTO customer VALUES (?,?,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        
        pstmt.setString(1, customer.getId());
        pstmt.setString(2, customer.getName());
        pstmt.setString(3, customer.getAddress());
        pstmt.setString(4, customer.geteMail());
        pstmt.setString(5, customer.getPostalCode());
        
        return pstmt.executeUpdate() > 0 ? "Successfully" : "Fail";
        
    }
    
    public List<Customer> getAllCustomers() throws SQLException {
        
        Connection connection = DBConnection.getInstance().getConnection();
        
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM Customer";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            customers.add(new Customer(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)
            ));
        }
        
        return customers;
    }
    
    public Customer getSelectedCustomer(String custID) throws SQLException {
        
        Connection connection = DBConnection.getInstance().getConnection();
        
        String sql = "SELECT * FROM customer where id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, custID);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            return new Customer(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)
            );
        }
        return null;
    }
    
    public String deleteCustomer(String custID) throws SQLException {
        
        Connection connection = DBConnection.getInstance().getConnection();
        
        String sql = "DELETE FROM Customer WHERE ID=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, custID);
        
        if (ps.executeUpdate() > 0) {
            return "Delete Successfully";
        }
        return "Customer Not Found";
    }
    
    public String updateCustomer(Customer customer) throws SQLException {
        
        Connection connection = DBConnection.getInstance().getConnection();
        
        String sql = "UPDATE Customer SET name=?, address=?, email=?,postalCode=? WHERE id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, customer.getName());
        ps.setString(2, customer.getAddress());
        ps.setString(3, customer.geteMail());
        ps.setString(4, customer.getPostalCode());
        ps.setString(5, customer.getId());
        
        if (ps.executeUpdate() > 0) {
            return "Update Successfully";
        }
        return "Can't Modify ID Number";
    }
    
    public Customer searchCustomer(String custID) throws SQLException {
        
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Customer WHERE ID=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, custID);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Customer(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)
            );
        }
        return null;
        
    }
    
}
