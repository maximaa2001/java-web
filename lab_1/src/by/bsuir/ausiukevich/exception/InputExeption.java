package by.bsuir.ausiukevich.exception;

public class InputExeption extends RuntimeException{

    public InputExeption() {
    }

    public InputExeption(String message) {
        super(message);
    }

    public InputExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public InputExeption(Throwable cause) {
        super(cause);
    }

    public InputExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
