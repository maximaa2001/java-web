package by.bsuir.ausiukevich.task7.data;

import by.bsuir.ausiukevich.input.InputDouble;

public class InputArrayNumbers {
    private double[] inputArray;
    private int size;

    public InputArrayNumbers(int count) {
        size = count;
    }

    public void inputArray() {
        inputArray = InputDouble.getArrayDouble(size);
    }

    public double[] getInputArray() {
        return inputArray;
    }

    public void setInputArray(double[] inputArray) {
        this.inputArray = inputArray;
    }
}
