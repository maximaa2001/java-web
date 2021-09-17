package by.bsuir.ausiukevich.task1.logic;

import by.bsuir.ausiukevich.task1.data.Argument;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sin;

public class Expression {
    public static void main(String[] args) {
        System.out.println(new Expression().calculate(new Argument()));
    }

    private Double calculate(Argument input) {
        double top = pow(sin(input.getNumberX() + input.getNumberY()), 2) + 1;
        double downTop = 2 * input.getNumberX();
        double downDown = (pow(input.getNumberX(), 2) * pow(input.getNumberY(), 2)) + 1;
        double down = abs(input.getNumberX() - (downTop / downDown)) + 2;
        return (top / down) + input.getNumberX();
    }
}
