package ua.duikt.pr5;

/** Дослід 2: перекидання власного винятку без причини та з причиною (cause). */
public class Exp2Rethrow {

    static int parseWithoutCause(String text) throws InvalidGradeException {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new InvalidGradeException(e.getMessage());                 // причину ВТРАЧЕНО
        }
    }

    static int parseWithCause(String text) throws InvalidGradeException {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new InvalidGradeException("Некоректна оцінка", e);          // причину ЗБЕРЕЖЕНО
        }
    }

    public static void main(String[] args) {
        Utf8.init();
        System.out.println("=== 1) new InvalidGradeException(e.getMessage()) ===");
        try {
            parseWithoutCause("abc");
        } catch (InvalidGradeException e) {
            e.printStackTrace();
            System.out.println("getCause() = " + e.getCause());
        }

        System.out.println();
        System.out.println("=== 2) new InvalidGradeException(\"Некоректна оцінка\", e) ===");
        try {
            parseWithCause("abc");
        } catch (InvalidGradeException e) {
            e.printStackTrace();
            System.out.println("getCause() = " + e.getCause());
        }
    }
}
