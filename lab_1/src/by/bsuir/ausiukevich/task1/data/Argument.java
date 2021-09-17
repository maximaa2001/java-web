package by.bsuir.ausiukevich.task1.data;

import by.bsuir.ausiukevich.input.InputDouble;

public class Argument {

    private double numberX;
    private double numberY;

    public Argument() {
        numberX = InputDouble.getInputDouble("X");
        numberY = InputDouble.getInputDouble("Y");
    }

    public double getNumberX() {
        return numberX;
    }

    public void setNumberX(double numberX) {
        this.numberX = numberX;
    }

    public double getNumberY() {
        return numberY;
    }

    public void setNumberY(double numberY) {
        this.numberY = numberY;
    }
}
