// Probability and Applied Statistics
// Tyler Santosuosso
// 10/25/2022

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Room {
    
    private Random rng;
    private int numPersons;
    private StatsLibrary sLib = new StatsLibrary();

    public ArrayList<Person> generateRoom() {
        
        rng = new Random();
        ArrayList<Person> pList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("-------Birthday Probability-------");
        System.out.println("How many people are in the sample?");
        numPersons = in.nextInt();

        for (int i = 0; i < numPersons*2; i++) {
            pList.add(new Person(rng.nextInt(365) + 1));
        }

        return pList;
    }
    
    // I found a certain equation online to determine this
    // (364/365)^(sample size)
    // This function determines the probability of 2 people sharing
    // a birthday in a specified size group
    public void determineTheoretical(ArrayList<Person> p) {

        double result = 0;

        System.out.println(p.size());

        result = 1 - Math.pow(364.0/365.0, (double) p.size());
        System.out.println("The chance of two or more out of " + p.size() + " sharing a birthday: " + result);
    }

    // This takes our array and determines the actual
    // occurrences of shared birthdays.
    public void determineActual(ArrayList<Person> p) {

        // double count;
        double result = 0;
        ArrayList<Person> copy = p;

        for (int i = 0; i < copy.size(); i++) {
            // count = 0; 
            for (int j = 0; j < copy.size(); j++) {
                if (copy.get(i).getBirthday() == copy.get(j).getBirthday() && i != j) {
                    // count++;
                    result++;
                }
            }
            //if (count != 0) {
               // System.out.println("Person " + i + " shares their birthday with " + count + " people.");
           // }
            copy.remove(i);      
        }

        System.out.println(result + " out of " + sLib.comb(p.size(), 2) + " occurrences of shared birthdays.");
        System.out.println("Percentage representing occurrences of shared birthdays: " + result/sLib.comb(p.size(), 2));
    }

}
