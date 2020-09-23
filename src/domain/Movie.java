package domain;

public class Movie extends Product{
    public Movie(String title, String ID) throws DomainException {
        super(title, ID);
    }

    @Override
    public double getPrice(int days) {
        double price = 0;
        price = 5;
        int daysLeft = days - 3;
        if (daysLeft > 0) {
            price += (daysLeft * 2);
        }
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", type='"+ "Movie" + '\'' +
                ", ID='" + ID + '\'' +
                '}';
    }


}
