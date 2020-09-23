package domain;

public class Game extends Product{
    public Game(String title, String ID) throws DomainException {
        super(title, ID);
    }

    @Override
    public double getPrice(int days) {
        int price = 0;
        price = days * 3;
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", type='"+ "Game" + '\'' +
                ", ID='" + ID + '\'' +
                '}';
    }
}
