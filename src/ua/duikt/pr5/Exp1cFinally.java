package ua.duikt.pr5;

/** Дослід 1в: блок finally виконується і за помилки, і без неї. */
public class Exp1cFinally {

    static void run(String input) {
        try {
            int value = Integer.parseInt(input);
            System.out.println("Розібрано число: " + value);
        } catch (NumberFormatException e) {
            System.out.println("catch: «" + input + "» не є числом");
        } finally {
            System.out.println("finally: виконано (вхід = «" + input + "»)");
        }
    }

    public static void main(String[] args) {
        Utf8.init();
        System.out.println("--- без помилки ---");
        run("95");
        System.out.println("--- з помилкою ---");
        run("abc");
    }
}
