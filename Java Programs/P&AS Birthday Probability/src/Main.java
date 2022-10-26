// Probability and Applied Statistics
// Tyler Santosuosso
// 10/25/2022

import java.util.ArrayList;

public class Main {

    public static void main(String[] args)  {
        
        Room rm = new Room();

        ArrayList<Person> al = rm.generateRoom();
        System.out.println("----ACTUAL----");
        rm.determineActual(al);
        System.out.println("----THEORETICAL----");
        rm.determineTheoretical(al);

    }
    
}
