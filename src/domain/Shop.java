package domain;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Shop {
    private ArrayList<Product> productList = new ArrayList<>();

    public void Shop(){
    }

    public void addProduct(){
        String title = JOptionPane.showInputDialog("Enter the title:");
        int id = productList.size();
        String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game/C for CD):");

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
            case "C":
                try{
                    Product p = new CD(title, id);
                    productList.add(p);
                }
                catch (DomainException e){
                    System.out.println(e.getMessage());
                }
                break;
        }

    }

    public void showProduct(){
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the id:"));
        ArrayList<Product> pl = searchDB(id);


        if (!pl.isEmpty()){
            for (Product p: pl) {
                JOptionPane.showMessageDialog(null, p.toString());
            }
        }

    }

    public void showInventory(){
        //Dit is echt de lelijkste shit ooit
        //pls refactor
        ArrayList<Product> out = new ArrayList<>();
        for (Product p: productList){
            if (p.getClass().equals(Movie.class)) out.add(p);
        }
        for (Product p: productList){
            if (p.getClass().equals(Game.class)) out.add(p);
        }
        for (Product p: productList){
            if (p.getClass().equals(CD.class)) out.add(p);
        }

        String outString = "";
        for (Product p: productList){
            outString += p.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null, outString);
    }

    public void showPrice(){
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the id:"));
        ArrayList<Product> pl = searchDB(id);

        if (!pl.isEmpty()){
            for (Product p: pl) {
                String daysString = JOptionPane.showInputDialog("Enter the number of days:");
                int days = Integer.parseInt(daysString);
                JOptionPane.showMessageDialog(null, p.getPrice(days));
            }
        }
    }

    private ArrayList<Product> searchDB(int id){
        ArrayList<Product> pl = new ArrayList<>();
        for (Product p: productList){
            if (p.getID() == id) pl.add(p);
        }
        return pl;
    }

}
