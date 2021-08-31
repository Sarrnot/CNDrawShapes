package com.company;

public class Circle {

    private int radius;
    private int centerX;
    private int centerY;

    public Circle() {
        this.radius = 0;
        this.centerX = 0;
        this.centerY = 0;
    }

    public void circleScreen() {
        while (true) {
            System.out.println();
            System.out.println("Circle:");
            System.out.println("1 Radius: " + this.radius);
            System.out.println("2 Center: [" + this.centerX + "," + this.centerY + "]");
            System.out.println();
            System.out.println("b Back");

            while (true) {

                String userInput = Main.sc.nextLine();

                if (userInput.equals("1")) {
                    setRadius();
                } else if (userInput.equals("2")) {
                    setCenter();
                } else if (userInput.equals("b")) {
                    return;
                } else {
                    System.out.println("Invalid value");
                    continue;
                }
                break;
            }
        }
    }

    public void setRadius() {
        this.radius = Math.abs(Main.inputInt("Radius: "));
        return;
    }

    public void setCenter() {
        this.centerX = Main.inputInt("Center X: ");
        this.centerY = Main.inputInt("Center Y: ");
        return;
    }

    public boolean isCircle(int x, int y) {
        double distance = (double) Math.sqrt((x - this.centerX) * (x - this.centerX) + (y - this.centerY) * (y - this.centerY));

        if (this.radius == 1) {
            if (Math.ceil(distance) == this.radius) {
                return true;
            } else {
                return false;
            }
        }

        if (Math.round(distance) == this.radius) {
            return true;
        } else {
            return false;
        }
    }

    public int maxX() {
        return this.centerX + this.radius;
    }

    public int maxY() {
        return this.centerY + this.radius;
    }

}
