/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package newpos.mvc;

import newpos.mvc.view.CustomerView;
import newpos.mvc.view.ItemView;
import newpos.mvc.view.OrderView;

/**
 *
 * @author ASUS
 */
public class NewposMvc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new CustomerView().setVisible(true);
        new ItemView().setVisible(true);
        new OrderView().setVisible(true);
    }

}
