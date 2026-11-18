package ua.duikt.pr5;

/** Власний перевірюваний виняток (варіант 0: оцінки студентів). */
public class InvalidGradeException extends Exception {

    public InvalidGradeException(String message) {
        super(message);
    }

    public InvalidGradeException(String message, Throwable cause) {
        super(message, cause);
    }
}
