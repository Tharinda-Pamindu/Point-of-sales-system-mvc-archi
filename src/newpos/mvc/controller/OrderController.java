/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpos.mvc.controller;

import java.util.List;
import newpos.mvc.model.OrderDetails;
import newpos.mvc.model.Orders;
import java.sql.Connection;
import newpos.mvc.db.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 *
 * @author ASUS
 */
public class OrderController {
    
    public String placeOrder(OrderDetails orderDetails, List<Orders> orders) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            String queryForOrderDetailsUpdate = "INSERT INTO orders VALUES (?,?,?,?)";
            PreparedStatement preparedStatementForOrderDetails = connection.prepareStatement(queryForOrderDetailsUpdate);
            preparedStatementForOrderDetails.setString(1, orderDetails.getOrderID());
            preparedStatementForOrderDetails.setString(2, orderDetails.getCustID());
            preparedStatementForOrderDetails.setString(3, sdf.format(orderDetails.getOrderDate()));
            preparedStatementForOrderDetails.setDouble(4, orderDetails.getSubTotal());
            
            if (preparedStatementForOrderDetails.executeUpdate() > 0) {
                
                String queryForOrderUpdate = "INSERT INTO orderDetails (orderID,itemCode,description,unitPrice,quantity,subTotal) VALUES (?,?,?,?,?,?)";
                
                boolean isOrderSaved = true;
                for (Orders order : orders) {
                    PreparedStatement preparedStatementForUpdateOrder = connection.prepareStatement(queryForOrderUpdate);
                    preparedStatementForUpdateOrder.setString(1, order.getOrderID());
                    preparedStatementForUpdateOrder.setString(2, order.getItemCode());
                    preparedStatementForUpdateOrder.setString(3, order.getDescription());
                    preparedStatementForUpdateOrder.setDouble(4, order.getUnitPrice());
                    preparedStatementForUpdateOrder.setInt(5, order.getQuantity());
                    preparedStatementForUpdateOrder.setDouble(6, order.getTotalPrice());
                    
                    if (!(preparedStatementForUpdateOrder.executeUpdate() > 0)) {
                        isOrderSaved = false;
                    }
                }
                
                if (isOrderSaved) {
                    
                    String queryForItemUpdate = "UPDATE item SET Quantity = Quantity - ? WHERE itemCode = ?";
                    boolean isItemUpdate = true;
                    for (Orders order : orders) {
                        PreparedStatement preparedStatementForItemUpdate = connection.prepareStatement(queryForItemUpdate);
                        preparedStatementForItemUpdate.setInt(1, order.getQuantity());
                        preparedStatementForItemUpdate.setString(2, order.getItemCode());
                        
                        if (!(preparedStatementForItemUpdate.executeUpdate() > 0)) {
                            isItemUpdate = false;
                        }
                    }
                    
                    if (isItemUpdate) {
                        connection.commit();
                        return "Success";
                    } else {
                        connection.rollback();
                        return "Item Update Error";
                    }
                    
                } else {
                    connection.rollback();
                    return "Order Update Error";
                }
                
            } else {
                connection.rollback();
                return "Order Details Update Error";
            }
            
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }
}
