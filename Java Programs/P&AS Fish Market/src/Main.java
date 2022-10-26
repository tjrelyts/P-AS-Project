// Probability and Applied Statistics
// Tyler Santosuosso
// 10/25/2022

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        FishMarket fm = new FishMarket();
        CSVFunctions csv = new CSVFunctions();
        ArrayList<Seafood> sf = csv.readCSV("FishMarketLoadEx.csv");

        // Values assigned must add up to 100.
        // EX: fm.generateMarket(45, 25, 15, 15)
        // indicates 45% chance of fish, 25% chance of shrimp
        // 15% chance of scallop, and 15% chance of crab
        csv.writeCSV(fm.generateMarket(45, 25, 15, 15));

        // This loop take the read data from the CSV file stored in 'sf'
        // and prints out each element in the array, which calls our
        // toString function in the Seafood class
        for (Seafood x : sf) {
            System.out.println(x);
        }

    }

}
