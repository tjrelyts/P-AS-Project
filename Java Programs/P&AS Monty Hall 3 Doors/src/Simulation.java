// Probability and Applied Statistics
// Tyler Santosuosso
// 10/25/2022

import java.util.Random;

public class Simulation {
    
    public void runGame(int numTrials) {
        double changeWins = 0;
        double stayWins = 0;
        Random rng = new Random();

        for (int i = 0; i < numTrials; i++) {
            int[] doors = {0,0,0};
            doors[rng.nextInt(3)] = 1;
            int choice = rng.nextInt(3);
            int shown;

            do {
                shown = rng.nextInt(3);

            } while (doors[shown] == 1 || shown == choice); 

                stayWins += doors[choice];
                changeWins += doors[3 - choice - shown];

        }
        System.out.println("Changing Choice Win Rate: " + changeWins/numTrials);
        System.out.println("Staying Choice Win Rate: " + stayWins/numTrials);
        


    }

}
