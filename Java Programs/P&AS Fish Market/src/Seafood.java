// Probability and Applied Statistics
// Tyler Santosuosso
// 10/25/2022

public class Seafood {
    
    public double weight;
    public double price;

    public Seafood(double weight, double price) {
        this.weight = weight;
        this.price = price;
    }

    // Gets the weight
    public double getWeight() {
        return weight;
    }

    // Gets the total price
    public double getPrice() {
        return price * weight;
    }

    // Simple toString method to display the seafood type, weight, and total price
    @Override
    public String toString() {
        return this.getClass() + "[weight= " + getWeight() + ", price= " + getPrice() + "]";
    }

}
