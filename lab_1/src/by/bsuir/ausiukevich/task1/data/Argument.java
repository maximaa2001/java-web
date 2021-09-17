package by.bsuir.ausiukevich.task1.data;

import by.bsuir.ausiukevich.input.InputDouble;

public class Argument {

    private Double numberX;
    private Double numberY;

    public Argument() {
        numberX = InputDouble.getNumber("X");
        numberY = InputDouble.getNumber("Y");
    }

    public Double getNumberX() {
        return numberX;
    }

    public void setNumberX(Double numberX) {
        this.numberX = numberX;
    }

    public Double getNumberY() {
        return numberY;
    }

    public void setNumberY(Double numberY) {
        this.numberY = numberY;
    }
}
