package by.bsuir.ausiukevich.task3.data;

import by.bsuir.ausiukevich.input.InputDouble;

public class Function {
    private Double a;
    private Double b;
    private Double h;

    public Function(){
        installFields();
    }

    private void installFields(){
        while (true){
            a = InputDouble.getNumber("a");
            b = InputDouble.getNumber("b");
            if(b > a){
                break;
            }else {
                System.out.println("b SHOULD BE MORE THAN a");
            }
        }
        h = InputDouble.getNumber("h");
    }

    public void printTable(){
        System.out.println("----------------------------------");
        System.out.printf("|%s|--------|%s|\n","Arg","Value");
        while (a <= b){
            System.out.printf("|%s|--------|%s|\n",a,calcFunc(a));
            a = a + h;
        }
        System.out.println("----------------------------------");
    }

    private double calcFunc(Double arg){
        return Math.tan(arg);
    }

    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }

    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
    }

    public Double getH() {
        return h;
    }

    public void setH(Double h) {
        this.h = h;
    }
}
