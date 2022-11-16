package itsc1212lab8;

import JavaSwingCode.*;
import java.util.Scanner;
import java.awt.Color;


/**
* Flower box here
*/
public class ITSC1212Lab8 {
    
    static int randomX = ((int)(Math.random() * 100)) * 5;
    static int randomY = ((int)(Math.random() * 100)) * 5;
    static World w = new World(500,500);

    /**
     * Main method of Lab 8.
     * @param args - Keyboard input
     * @throws InterruptedException (needed for Thread.sleep()
     */
    public static void main(String[] args) throws InterruptedException {
         Turtle yertle = new Turtle(w);
         yertle.setVisible(false);
         Scanner scnr = new Scanner(System.in);
         
         System.out.println(randomX);
         System.out.println(randomY);
         
    //set user's guess
        System.out.println("Hello! Welcome to guess where the turtle is!\nYou will be prompt to enter x,y coordinates of where you think the turtle might be!\nDon't worry will give you hints along the way!");

        System.out.print("Enter a guess for the X position of tom: ");
        int guessX = scnr.nextInt();
        System.out.print("Enter a guess for the Y position of tom: ");
        int guessY = scnr.nextInt();

        while (guessX != randomX || guessY != randomY){
            if (guessX> randomX){
                System.out.println("X value is too high! Try again");
                colorGuessX(guessX);
                guessX = scnr.nextInt();
                
            }
            else if (guessX==randomX){
                System.out.println("Your X is correct");
            }
            else{
                System.out.println("Your X value is too low! Try again");
                colorGuessX(guessX);
                guessX = scnr.nextInt();
                
            }
            if (guessY> randomY){
                System.out.println("Y value is too high! Try again");
                colorGuessY(guessY);
                guessY = scnr.nextInt();
                
            }
            else if (guessY== randomY){
                System.out.println("Your Y value is correct!");
                
            }
            else{
                System.out.println("Your Y value is too low! Try again");
                colorGuessY(guessY);
                guessY = scnr.nextInt();
                
            }
        }
        System.out.println("You found the turtle!");
        yertle.setVisible(true);
        w.repaint();
        scnr.close();
    }  
      public static void colorGuessY(int y) throws InterruptedException {
        // Set up a new Turtle to start drawing horizontal lines
        Thread.sleep(10);
        Turtle jen = new Turtle(w);
        jen.setVisible(false);
        jen.setPenColor(Color.black);
        jen.setHeading(90);
        jen.penUp();
        jen.moveTo(0, y);
        jen.penDown();

        // Draw lines to block off areas of the World where the Turtle isn't
        if (y > randomY) {
            for (int i=y; i==500;i++) {
                jen.moveTo(0, i);
                jen.forward(499);
            }
        } else {
            for (int i=y; i==0;i--) {
                jen.moveTo(0, i);
                jen.forward(499);
            }
        }

    }

    public static void colorGuessX(int x) throws InterruptedException {
        // Set up a new Turtle to start drawing vertical lines
        Thread.sleep(10);
        Turtle jen = new Turtle(w);
        jen.setVisible(false);
        jen.setPenColor(Color.black);
        jen.setHeading(180);
        jen.penUp();
        jen.moveTo(x, 0);
        jen.penDown();

        // Draw lines to block off areas of the World where the Turtle isn't
        if (x > randomX) {
            for ( int i=x; i==500;i++) {
                jen.moveTo(i, 0);
                jen.forward(499);
            }
        } else {
            for (int i=x; i==0;i--) {
                jen.moveTo(i, 0);
                jen.forward(499);
            }
        }

    }

}
