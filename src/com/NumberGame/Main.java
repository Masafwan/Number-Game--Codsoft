package com.NumberGame;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 10;
        int score = 0;

        System.out.println("Welcome to Number Guessing Game");

        boolean playAgain = true;
        while (playAgain) {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println(" \n I have selected a number between " + minRange + " and " + maxRange + ".");
            System.out.println("You have " + attemptsLimit + " attempts to guess it.");

            int attempts = 0;
            boolean guessedCorrectly = false;
            while (attempts < attemptsLimit && !guessedCorrectly) {
                System.out.print("\nEnter your guess: ");
                int userGuess = scanner.nextInt();
                scanner.nextLine();
                attempts++;

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You've guessed the number " + generatedNumber + " correctly in " + attempts + " attempts!");
                    guessedCorrectly = true;
                    score++;
                } else if (userGuess < generatedNumber) {
                    System.out.println("That's too low! Try again.");
                } else {
                    System.out.println("That's too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\n HaHaHaHa, you've run out of attempts. The correct number was: " + generatedNumber);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playChoice = scanner.nextLine().toLowerCase();
            if (!playChoice.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Your score: " + score);
        scanner.close();
    }
}