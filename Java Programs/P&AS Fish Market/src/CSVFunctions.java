// Probability and Applied Statistics
// Tyler Santosuosso
// 10/25/2022

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class CSVFunctions {
    
    private BufferedWriter bw;
    private BufferedReader br;
    private int i = 0;

    public void writeCSV(ArrayList<Seafood> foodList) {

        try {
            bw = new BufferedWriter(new FileWriter("FishMarket.csv"));

            // Adds our heading to the CSV file.
            bw.append("Index,Type,Weight,Price\n");

            Iterator it = foodList.iterator();

            // Iterates over each piece of data in the provided
            // arraylist of seafood types. The data is then 
            // added to the CSV file in a fashion that conforms
            // to a CSV file type.
            while (it.hasNext()) {
                Seafood sf = (Seafood)it.next();
                bw.append(i + ",");
                bw.append(sf.getClass().getName() + ",");
                bw.append(sf.getWeight() + ",");
                bw.append(sf.getPrice() + "\n");
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                bw.close();
            } catch (IOException ie) {
                System.out.println("Error occurred while closing the file.");
                ie.printStackTrace();
            }
        }

    }

    // Function to interpret a CSV file with relevant data
    // and store it in an ArrayList with Seafood objects
    public ArrayList<Seafood> readCSV(String file) {

        ArrayList<Seafood> sf = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(file));

            String line = br.readLine();

            // Loops over each line and temporarily stores each line in an array (attributes).
            // This array is then checked in index 1 each loop to get the 
            // seafood type. Then, the String values of our weight and price
            // are parsed in order to get Double values.
            // Whichever case is found to be true will determine what seafood type is created.
            while (line != null) {
                String[] attributes = line.split(",");
                if (attributes[1].equals("Fish")) {
                    sf.add(new Fish(Double.parseDouble(attributes[2]), Double.parseDouble((attributes[3]))));
                } else if (attributes[1].equals("Shrimp")) {
                    sf.add(new Shrimp(Double.parseDouble(attributes[2]), Double.parseDouble((attributes[3]))));
                } else if (attributes[1].equals("Scallop")) {
                    sf.add(new Scallop(Double.parseDouble(attributes[2]), Double.parseDouble((attributes[3]))));
                } else if (attributes[1].equals("Crab")) {
                    sf.add(new Crab(Double.parseDouble(attributes[2]), Double.parseDouble((attributes[3]))));
                }
                line = br.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException ie) {
                System.out.println("Error occurred while closing the reader.");
                ie.printStackTrace();
            }
            
        }
        
        return sf;
    }

}
