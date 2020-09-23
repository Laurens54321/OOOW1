package domain;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Shop {
    private ArrayList<Product> productList = new ArrayList<>();

    public void Shop(){
    }

    public void AddProduct(){
        String title = JOptionPane.showInputDialog("Enter the title:");
        String id = JOptionPane.showInputDialog("Enter the id:");
        String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game):");

        switch(type){
            case "M":
                try{
                    Product p = new Movie(title, id);
                    productList.add(p);
                }
                catch (DomainException e){
                    System.out.println(e.getMessage());
                }
                break;
            case "G":
                try{
                    Product p = new Game(title, id);
                    productList.add(p);
                }
                catch (DomainException e){
                    System.out.println(e.getMessage());
                }
                break;
        }

    }

    public void showProduct(){
        String id = JOptionPane.showInputDialog("Enter the id:");
        ArrayList<Product> pl = searchDB(id);

        if (!pl.isEmpty()){
            for (Product p: pl) {
                JOptionPane.showMessageDialog(null, p.toString());
            }
        }

    }

    public void showPrice(){
        String id = JOptionPane.showInputDialog("Enter the id:");
        ArrayList<Product> pl = searchDB(id);

        if (!pl.isEmpty()){
            for (Product p: pl) {
                String daysString = JOptionPane.showInputDialog("Enter the number of days:");
                int days = Integer.parseInt(daysString);
                JOptionPane.showMessageDialog(null, p.getPrice(days));
            }
        }
    }

    private ArrayList<Product> searchDB(String id){
        ArrayList<Product> pl = new ArrayList<>();
        for (Product p: productList){
            if (p.getID().equals(id)) pl.add(p);
        }
        return pl;
    }

}
