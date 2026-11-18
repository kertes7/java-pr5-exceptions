package ua.duikt.pr5;

/** Дослід 1б: неперевірювані винятки — компілюється, але падає під час виконання. */
public class Exp1bUnchecked {

    public static void main(String[] args) {
        Utf8.init();
        int[] arr = new int[3];

        System.out.println("Ділення на нуль:");
        try {
            int zero = args.length;          // 0
            System.out.println(10 / zero);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

        System.out.println("Вихід за межі масиву:");
        try {
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        System.out.println("Без обробки програма завершується аварійно:");
        System.out.println(arr[5]);          // не оброблено -> Exception in thread "main"
    }
}
