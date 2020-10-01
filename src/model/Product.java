package model;

import java.util.Objects;

public abstract class Product {
    protected String title;
    protected int ID;
    protected boolean isLoaned;

    public Product(String title, int ID) throws DomainException{
        setTitle(title);
        setID(ID);
        isLoaned = false;
        System.out.println("New Product Added: " + title + ", " + ID);
    }

    private void setTitle(String title) throws DomainException {
        if (title.strip().isEmpty()) throw new DomainException("Title cannot be empty");
        else this.title = title;
    }

    private void setID(int ID) throws DomainException{
        this.ID = ID;
    }

    public int getID(){
        return ID;
    }

    public abstract double getPrice(int days);

    public void setLoaned(boolean loaned) {
        isLoaned = loaned;
    }

    public boolean isLoaned() {
        return isLoaned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return ID == product.getID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
