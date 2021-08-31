package com.company;

public class Triangle {

    private int base;
    private int height;
    private int offsetX;
    private int offsetY;

    public Triangle() {
        this.base = 0;
        this.height = 0;
        this.offsetX = 0;
        this.offsetY = 0;
    }

    public void triangleScreen() {
        while (true) {
            System.out.println();
            System.out.println("Triangle:");
            System.out.println("1 Base: " + this.base);
            System.out.println("2 Offset: [" + this.offsetX + "," + this.offsetY + "]");
            System.out.println();
            System.out.println("b Back");

            while (true) {

                String userInput = Main.sc.nextLine();

                if (userInput.equals("1")) {
                    setBase();
                    setHeight();
                } else if (userInput.equals("2")) {
                    setOffset();
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

    public void setBase() {
        this.base = Math.abs(Main.inputInt("Base: "));
        return;
    }

    public void setHeight() {
        if (this.base % 2 == 0) {
            this.height = base / 2 - 1;
        } else {
            this.height = base / 2;
        }
        return;
    }

    public void setOffset() {
        this.offsetX = Main.inputInt("Offset X: ");
        this.offsetY = Main.inputInt("Offset Y: ");
        return;
    }

    public boolean isTriangle(int x, int y) {

        if ((y == this.height + 1 + this.offsetY) && (x > this.offsetX && x <= this.offsetX + this.base)) {         //základna
            return true;
        }

        if ((y <= this.offsetY + this.height) && (y > this.offsetY)) {
            if ((x > this.offsetX) && (x <= this.offsetX + Math.ceil(this.base / 2d))) {             //levá strana
                if (y == (this.offsetY + this.height + 1) - (x - this.offsetX - 1)) {
                    return true;
                }
            }

            if ((x <= this.offsetX + this.base) && (x > this.offsetX + (this.base / 2))) {      //pravá strana
                if (y == (this.offsetY + this.height + 1) - (this.offsetX + this.base - x)) {
                    return true;
                }
            }
        }

        return false;
    }

    public int maxX() {
        return this.offsetX + this.base;
    }
    public int maxY() {
        return this.offsetY + this.height + 1;
    }
}
