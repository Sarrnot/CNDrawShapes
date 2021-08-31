package com.company;

public class Square {

    private int side;
    private int upLeftCornerX;
    private int upLeftCornerY;

    public Square() {
        this.side = 0;
        this.upLeftCornerX = 0;
        this.upLeftCornerY = 0;
    }

    public void squareScreen() {
        while (true) {
            System.out.println();
            System.out.println("Square:");
            System.out.println("1 Side: " + this.side);
            System.out.println("2 Upper left corner: [" + this.upLeftCornerX + "," + this.upLeftCornerY + "]");
            System.out.println();
            System.out.println("b Back");

            while (true) {

                String userInput = Main.sc.nextLine();

                if (userInput.equals("1")) {
                    setSide();
                } else if (userInput.equals("2")) {
                    setUpLeftCorner();
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

    public void setSide() {
        this.side = Math.abs(Main.inputInt("Side: "));
        return;
    }

    public void setUpLeftCorner() {
        this.upLeftCornerX = Main.inputInt("Upper left corner X: ");
        this.upLeftCornerY = Main.inputInt("Upper left corner Y: ");
        return;
    }

    public boolean isSquare(int x, int y) {
        if ((x == this.upLeftCornerX) && (y >= this.upLeftCornerY) && (y < this.upLeftCornerY + this.side)) {         //levá strana
            return true;
        } else if ((x == this.upLeftCornerX + this.side - 1) && (y >= this.upLeftCornerY) && (y < this.upLeftCornerY + this.side)) {       //pravá strana
            return true;
        } else if ((y == this.upLeftCornerY) && (x >= this.upLeftCornerX) && (x < this.upLeftCornerX + this.side)) {       //horní strana
            return true;
        } else if ((y == this.upLeftCornerY + this.side - 1) && (x >= this.upLeftCornerX) && (x < this.upLeftCornerX + this.side)) {    //dolní strana
            return true;
        } else {
            return false;
        }
    }

    public int maxX() {
        return this.upLeftCornerX + this.side - 1;
    }

    public int maxY() {
        return this.upLeftCornerY + this.side - 1;
    }
}
