package model;

public class CD extends Product {

    public CD(String title, int ID) throws DomainException {
        super(title, ID);
    }

    @Override
    public double getPrice(int days) {
        return 1.5*days;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", type='"+ "CD" + '\'' +
                ", ID='" + ID + '\'' +
                '}';
    }
}
