// Probability and Applied Statistics
// Tyler Santosuosso
// 10/25/2022

import java.util.Random;

public class Simulation {
    
    public void runGame(int numTrials) {
        double changeWins = 0;
        double stayWins = 0;
        Random rng = new Random();
        
        // The start of our game loop
        for (int i = 0; i < numTrials; i++) {
            // Defines an array of three elements to represent our doors
            int[] doors = {0,0,0};
            // Selects one of the random 3 elements in the array to 
            // be a 1, which represents a "win"
            doors[rng.nextInt(3)] = 1;
            // Generates a random choice by the "player" 
            // with the number representing the door
            // index in the array
            int choice = rng.nextInt(3);
            int shown;

            do {
                // Selects our initial door
                // that is opened
                shown = rng.nextInt(3);

            // While the door that is shown is equal to 1 or "win"
            // OR the shown door is equal to the chosen door
            } while (doors[shown] == 1 || shown == choice); 
                
                // Increment each type of win and simulate
                // each choice
                stayWins += doors[choice];
                changeWins += doors[3 - choice - shown];

        }
        // Calculates the percentage for both types of win.
        System.out.println("Changing Choice Win Rate: " + changeWins/numTrials);
        System.out.println("Staying Choice Win Rate: " + stayWins/numTrials);
        


    }

}
