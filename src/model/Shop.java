package model;

import javax.swing.*;
import java.util.ArrayList;

public class Shop {
    private ArrayList<Product> productList = new ArrayList<>();

    public void Shop(){
    }

    public void addProduct(String title, String type) throws DomainException{
        int id = productList.size();

        switch(type){
            case "M":
                Product p = new Movie(title, id);
                productList.add(p);
                break;
            case "G":
                Product pp = new Game(title, id);
                productList.add(pp);
                break;
            case "C":
                Product ppp = new CD(title, id);
                productList.add(ppp);
                break;
            default:
                throw new DomainException("Not a category");
        }
    }

    public String showProduct(int id){
        Product p  = searchDB(id);
        if (p == null) return null;
        return p.toString();
    }

    public double showPrice(int id, int days){
        Product p = searchDB(id);
        return p.getPrice(days);
    }

    public String showInventory(){
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

        return outString;
    }

    public boolean isIdAvailable(int id){
        Product p = searchDB(id);
        return p.isLoaned();
    }

    private Product searchDB(int id){
        for (Product p: productList){
            if (p.getID() == id) return p;
        }
        return null;
    }

}
