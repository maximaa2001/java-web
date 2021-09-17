package by.bsuir.ausiukevich.task6.data;

import java.util.List;

public class Matrix {
    private double[][] square;
    private List<Double> elements;

    public Matrix(List<Double> arr) {
        square = new double[arr.size()][arr.size()];
        elements = arr;
    }

    public void fillMatrix() {
        for (int i = 0; i < square.length; i++) {
            int temp = i;
            for (int j = 0; j < square[i].length; j++) {
                square[i][j] = elements.get(temp % elements.size());
                temp++;
            }
        }
    }

    public void printMatrix() {
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                System.out.print(square[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public double[][] getSquare() {
        return square;
    }

    public void setSquare(double[][] square) {
        this.square = square;
    }

    public List<Double> getElements() {
        return elements;
    }

    public void setElements(List<Double> elements) {
        this.elements = elements;
    }
}
