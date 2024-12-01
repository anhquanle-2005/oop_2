package tuan11.BTN;

public class Game {
    private int id;
    private String name;
    private String genre;
    private double pricePerHour;

    public Game(int id, String name, String genre, double pricePerHour) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.pricePerHour = pricePerHour;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Genre: " + genre + ", Price per Hour: " + pricePerHour;
    }
}
