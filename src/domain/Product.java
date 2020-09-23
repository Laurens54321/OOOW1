package domain;

import java.util.Objects;

public abstract class Product {
    protected String title;
    protected String ID;

    public Product(String title, String ID) throws DomainException{
        setTitle(title);
        setID(ID);
        System.out.println("New Product Added: " + title + ", " + ID);
    }

    private void setTitle(String title) throws DomainException {
        if (title.strip().isEmpty()) throw new DomainException("Title cannot be empty");
        else this.title = title;
    }

    private void setID(String ID) throws DomainException{
        if (ID.strip().isEmpty()) throw new DomainException("ID cannot be empty");
        else this.ID = ID;
    }

    public String getID(){
        return ID;
    }

    public abstract double getPrice(int days);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return ID.equals(product.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
