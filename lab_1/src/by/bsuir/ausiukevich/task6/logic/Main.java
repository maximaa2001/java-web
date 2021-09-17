package by.bsuir.ausiukevich.task6.logic;

import by.bsuir.ausiukevich.input.InputInteger;
import by.bsuir.ausiukevich.task6.data.Matrix;
import by.bsuir.ausiukevich.task6.data.Sequence;

public class Main {
    public static void main(String[] args) {
        int countElements = new Main().getCountElements();
        Sequence sequence = new Sequence(countElements);
        Matrix matrix = new Matrix(sequence);
        matrix.fillMatrix();
        matrix.printMatrix();
    }

    private int getCountElements() {
        System.out.println("Input the order of the square matrix");
        return InputInteger.getInputInteger();
    }
}
