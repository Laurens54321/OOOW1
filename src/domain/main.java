package domain;

import javax.swing.*;

public class main {
    public static void main(String[] args) {
        Shop shop = new Shop();

        String menu = "1. Add product\n2. Show product\n3. Show rental price\n4. Show all products\n\n0. Quit";
        int choice = -1;
        while (choice != 0) {
            String choiceString = JOptionPane.showInputDialog(menu);
            choice = Integer.parseInt(choiceString);
            switch(choice) {
                case (1):
                    shop.addProduct();
                    break;
                case (2):
                    shop.showProduct();
                    break;
                case (3):
                    shop.showPrice();
                    break;
                case (4):
                    shop.showInventory();
            }
        }
    }
}
