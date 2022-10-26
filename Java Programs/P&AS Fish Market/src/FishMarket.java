// Probability and Applied Statistics
// Tyler Santosuosso
// 10/25/2022

import java.util.ArrayList;
import java.util.Random;

public class FishMarket {

    public Random rng = new Random();
    public ArrayList<Seafood> sf = new ArrayList<>();

    public ArrayList<Seafood> generateMarket(int fishWeight, int shrimpWeight, int scallopWeight, int crabWeight) {

        // Exception handler to check if weight values are equal to 100
        if ((fishWeight + shrimpWeight + scallopWeight + crabWeight) != 100) {
            System.out.println("Values must be equal to 100.");
            throw new Error();
        }

        // Takes into account our weight values by assigning a range of RNG to each
        // type of seafood. Also displays our set price-per-pound, which is
        // mathematically interpreted by our getPrice() function later.
        for (int i = 0; i < 300; i++) {
            int sel = rng.nextInt(100) + 1;
            if (sel <= fishWeight) { 
                sf.add(new Fish(rng.nextDouble(5) + 1, 3.99));
            } else if (sel > fishWeight && sel <= fishWeight + shrimpWeight) {
                sf.add(new Shrimp(rng.nextDouble(5) + 1, 12.99));
            } else if (sel > fishWeight + shrimpWeight && sel <= fishWeight + shrimpWeight + scallopWeight) {
                sf.add(new Scallop(rng.nextDouble(5) + 1, 29.99));
            } else { // case rng = 3
                sf.add(new Crab(rng.nextDouble(5) + 1, 17.99));
            }
        }
        return sf;
    }   

}
