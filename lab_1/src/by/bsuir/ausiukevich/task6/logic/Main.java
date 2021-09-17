package by.bsuir.ausiukevich.task6.logic;

import by.bsuir.ausiukevich.input.InputDouble;
import by.bsuir.ausiukevich.input.InputInteger;
import by.bsuir.ausiukevich.task6.data.Matrix;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int countElements = new Main().getCountElements();
        List<Double> listElements = InputDouble.getListDouble(countElements);
        Matrix matrix = new Matrix(listElements);
        matrix.fillMatrix();
        matrix.printMatrix();
    }

    private int getCountElements() {
        System.out.println("Input the order of the square matrix");
        return InputInteger.getInputInteger();
    }
}
