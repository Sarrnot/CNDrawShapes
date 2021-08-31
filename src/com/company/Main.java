package com.company;

import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("This program draws shapes with symbol \"x\" based on the parameters you enter.");
        System.out.print("[Press enter to continue]");
        sc.nextLine();

        mainScreen();

        sc.close();
    }

    public static void mainScreen() {

        Circle circle = new Circle();
        Square square = new Square();
        Triangle triangle = new Triangle();

        while (true) {

            System.out.println();
            System.out.println("Adjust:");
            System.out.println("1 Square");
            System.out.println("2 Circle");
            System.out.println("3 Triangle");
            System.out.println();
            System.out.println("d Draw");
            System.out.println("exit Exit");

            while (true) {

                String userInput = sc.nextLine();

                if (userInput.equals("1")) {
                    square.squareScreen();
                } else if (userInput.equals("2")) {
                    circle.circleScreen();
                } else if (userInput.equals("3")) {
                    triangle.triangleScreen();
                } else if (userInput.equals("d")) {
                  draw(circle,square,triangle);
                } else if (userInput.equals("exit")) {
                    return;
                } else {
                    System.out.println("Invalid value");
                    continue;
                }
                break;
            }
        }
    }

    public static void draw(Circle circle, Square square, Triangle triangle) {

        int maxX = square.maxX();
        int maxY = square.maxY();

        if (circle.maxX() > maxX) {
            maxX = circle.maxX();
        }
        if (circle.maxY() > maxY) {
            maxY = circle.maxY();
        }

        if (triangle.maxX() > maxX) {
            maxX = triangle.maxX();
        }
        if (triangle.maxY() > maxY) {
            maxY = triangle.maxY();
        }

        System.out.println();

        for (int y = 1; y <=maxY; y++){

            for (int x = 1; x <=maxX; x++){
                if (square.isSquare(x,y) || circle.isCircle(x,y) || triangle.isTriangle(x,y)) {
                    System.out.print("x  ");
                } else {
                    System.out.print("   ");
                }
            }

            System.out.println();
        }

        System.out.println();
        System.out.print("[Press enter to continue]");
        sc.nextLine();
    }

    public static int inputInt(String inputQuote) {

        while (true) {
            System.out.print(inputQuote);
            boolean isInt = sc.hasNextInt();
            if (isInt) {
                break;
            }
            sc.nextLine();
            System.out.println("Invalid input");
        }

        int value = sc.nextInt();
        Main.sc.nextLine();
        return value;
    }

}
