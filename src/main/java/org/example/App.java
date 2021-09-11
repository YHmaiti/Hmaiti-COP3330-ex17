/*
 *  UCF COP3330 Fall 2021 Assignment 17 Solution
 *  Copyright 2021 Yohan Hmaiti
 */

// The program prompts for your weight, gender,
// total alcohol consumed (in ounces), and the amount of time since your
// last drink.
// The program calculates your blood alcohol content (BAC) using
// the formula provided by the assignment and that is stated within the program.

package org.example;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // Initialize a scanner called scanner
        Scanner scanner = new Scanner(System.in);

        // Variables declaration:
        int MorF = 0; // variable to store the value corresponding to either male/female
        double ounces = 0.0; // store ounces consumed of alcohol
        double weight = 0.0; // store the weight
        double hoursPassed = 0.0; // store the hours passed
        double BAC; // store the BAC value calculated
        Boolean notnumerical = true; // determine if a value is numerical or no
        String string; // store a string scanned correspondingly

        // create constants to store the alcohol distribution ratio
        // depending on the gender of the person
        final double ratioMen = 0.73;
        final double ratioWomen = 0.66;

        // prompt the user for their gender
        System.out.print("Enter a 1 if you are male or a 2 if you are female: ");
        string = scanner.nextLine();

        // check if the value entered corresponds to a numerical input
        do {

            notnumerical = false;

            try {

                MorF = Integer.parseInt(string);

            } catch (NumberFormatException ex) {

                notnumerical = true;
                System.out.print("The Value entered is invalid, please enter either 1 and 2 (numerical value): ");
                string = scanner.nextLine();
            }

        } while (notnumerical || (MorF != 1 && MorF !=2));

        // propt the user for the ounces consumed of alcohol
        System.out.print("How many ounces of alcohol did you have? ");
        string = scanner.nextLine();

        // check if the value entered corresponds to a numerical input
        do {

            notnumerical = false;

            try {

                ounces = Double.parseDouble(string);

            } catch (NumberFormatException ex) {

                notnumerical = true;
                System.out.print("The Value entered is invalid, please enter a numerical value: ");
                string = scanner.nextLine();
            }

        } while (notnumerical);

        // prompt the user for their weight
        System.out.print("What is your weight, in pounds? ");
        string = scanner.nextLine();

        // check if the value entered corresponds to a numerical input
        do {

            notnumerical = false;

            try {

                weight = Double.parseDouble(string);

            } catch (NumberFormatException ex) {

                notnumerical = true;
                System.out.print("The Value entered is invalid, please enter a numerical value: ");
                string = scanner.nextLine();
            }

        } while (notnumerical);

        // prompt the user for the hours passed since their last drink
        System.out.print("How many hours has it been since your last drink? ");
        string = scanner.nextLine();

        // check if the value entered corresponds to a numerical input
        do {

            notnumerical = false;

            try {

                hoursPassed = Double.parseDouble(string);

            } catch (NumberFormatException ex) {

                notnumerical = true;
                System.out.print("The Value entered is invalid, please enter a numerical value: ");
                string = scanner.nextLine();
            }

        } while (notnumerical);

        // calculate the BAC based on the given equation and depending on the gender inputted
        if (MorF == 1) {

            BAC = (ounces * 5.14 / weight * ratioMen) - .015 * hoursPassed;

        } else {

            BAC = (ounces * 5.14 / weight * ratioWomen) - .015 * hoursPassed;

        }

        // output the BAC value
        System.out.printf("\nYour BAC is %f%n", BAC);

        // output driving eligibility depending on BAC
        if (BAC <= 0.08) {

            System.out.print("It is legal for you to drive.");

        } else {

            System.out.print("It is not legal for you to drive.");

        }

    }

}