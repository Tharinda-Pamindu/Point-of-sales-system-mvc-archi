/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpos.mvc.controller;

import newpos.mvc.model.Item;
import java.sql.Connection;
import newpos.mvc.db.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ItemController {
    
    public String addItem(Item item) throws SQLException {
        
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Item VALUES (?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, item.getItemCoe());
        ps.setString(2, item.getDescription());
        ps.setInt(3, item.getQuantity());
        ps.setDouble(4, item.getUnitPrice());
        
        return ps.executeUpdate() > 0 ? "Item Added Successfully" : "Fail";
        
    }
    
    public String deleteItem(String itemCode) throws SQLException {
        
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Item Where itemCode=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, itemCode);
        
        return ps.executeUpdate() > 0 ? "Item Deleted Successfully" : "Fail";
        
    }
    
    public String updateItem(Item item) throws SQLException {
        
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE Item SET description=?, quantity=?, unit_Price=? WHERE itemCode=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, item.getDescription());
        ps.setInt(2, item.getQuantity());
        ps.setDouble(3, item.getUnitPrice());
        ps.setString(4, item.getItemCoe());
        
        return ps.executeUpdate() > 0 ? "Item Updated Successfully" : "Fail";
        
    }
    
    public Item getSelectedItem(String itemCode) throws SQLException {
        
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Item WHERE itemCode=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, itemCode);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Item(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getDouble(4)
            );
        }
        return null;
        
    }
    
    public List<Item> getAllItems() throws SQLException {
        
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Item";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Item> items = new ArrayList<>();
        while (rs.next()) {
            items.add(new Item(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getDouble(4)
            ));
        }
        
        return items;
        
    }
    
    public Item searchItem(String itemCode) throws SQLException {
        
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Item WHERE itemCode=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, itemCode);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Item(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getDouble(4)
            );
        }
        return null;
        
    }
    
}
