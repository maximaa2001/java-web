package by.bsuir.ausiukevich.task4.logic;

import by.bsuir.ausiukevich.input.InputInteger;
import by.bsuir.ausiukevich.task4.data.Sequence;
import by.bsuir.ausiukevich.task4.data.OutputSimpleNumber;

public class Main {
    public static void main(String[] args) {
        Sequence sequence = new Sequence(getSizeArray());
        OutputSimpleNumber simpleNumber = new OutputSimpleNumber(sequence);
        sequence.printElements();
        simpleNumber.findSimpleNumbers();
    }

    private static int getSizeArray(){
        return InputInteger.getInputInteger();
    }
}
