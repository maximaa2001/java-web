package by.bsuir.ausiukevich.task2.logic;

import by.bsuir.ausiukevich.input.InputDouble;
import by.bsuir.ausiukevich.task2.data.Graphic;
import by.bsuir.ausiukevich.task2.data.Point;

public class Check {
    public static void main(String[] args) {
        Check check = new Check();
        Graphic graphic = new Graphic(check.installPoint());
        System.out.println(graphic.checkPoint());
    }

    private Point installPoint() {
        Point point = new Point();
        point.setX(installOneCoordinate("X"));
        point.setY(installOneCoordinate("Y"));
        return point;
    }

    private Double installOneCoordinate(String str) {
        return InputDouble.getInputDouble(str);
    }
}
