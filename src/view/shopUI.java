package view;

import model.DomainException;
import model.Shop;

import javax.swing.*;



public class shopUI {

    Shop shop;

    public shopUI(){
        shop = new Shop();


    }

    public void openShop(){
        String menu = "1. Add product\n2. Show product\n3. Show rental price\n4. Show all products\n5. Is product available\n\n0. Quit";
        int choice = -1;
        while (choice != 0) {
            String choiceString = JOptionPane.showInputDialog(menu);
            choice = Integer.parseInt(choiceString);
            switch(choice) {
                case (1):
                    addProduct();
                    break;
                case (2):
                    showProduct();
                    break;
                case (3):
                    showPrice();
                    break;
                case (4):
                    showInventory();
                    break;
                case (5):
                    isIdAvailable();
                    break;
            }
        }
    }

    public void addProduct(){
        String title = JOptionPane.showInputDialog("Enter the title:");
        String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game/C for CD):");
        try{
            shop.addProduct(title, type);
        } catch (DomainException errors){
            JOptionPane.showMessageDialog(null, errors.getMessage());
        }
    }

    private void showProduct(){
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the id:"));
        String s = shop.showProduct(id);
        if (s == null) JOptionPane.showMessageDialog(null, "No products were found");
        else JOptionPane.showMessageDialog(null, s);
    }

    private void showPrice(){
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the id:"));
        int days = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of days:"));
        if (days == 0){
            JOptionPane.showMessageDialog(null, "Amount of days cannot be 0");
        }
        double s = shop.showPrice(id, days);
        if (s == 0) JOptionPane.showMessageDialog(null, "No products were found");
        else JOptionPane.showMessageDialog(null, "€" + s);
    }

    private void showInventory(){
        JOptionPane.showMessageDialog(null, shop.showInventory());
    }

    private void isIdAvailable(){
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the id:"));
        boolean isAvailable = shop.isIdAvailable(id);
        if (isAvailable) JOptionPane.showMessageDialog(null, "Product " + id + " is loaned out");
        else JOptionPane.showMessageDialog(null,"Product " + id + " is available");

    }
}
