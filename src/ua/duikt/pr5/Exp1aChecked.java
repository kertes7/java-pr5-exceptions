package ua.duikt.pr5;

import java.io.FileReader;
import java.io.IOException;

/** Дослід 1а: перевірюваний виняток — обробка через try-catch і через throws. */
public class Exp1aChecked {

    // Спосіб 1: обробка на місці (try-catch)
    static void readWithCatch(String path) {
        try (FileReader reader = new FileReader(path)) {
            System.out.println("Файл відкрито: " + path);
        } catch (IOException e) {
            System.out.println("[try-catch] Не вдалося відкрити файл: " + e.getMessage());
        }
    }

    // Спосіб 2: делегування викликаючому коду (throws)
    static void readWithThrows(String path) throws IOException {
        try (FileReader reader = new FileReader(path)) {
            System.out.println("Файл відкрито: " + path);
        }
    }

    public static void main(String[] args) {
        Utf8.init();
        readWithCatch("data.txt");
        try {
            readWithThrows("data.txt");
        } catch (IOException e) {
            System.out.println("[throws] Виняток передано нагору і оброблено в main: " + e.getClass().getSimpleName());
        }
    }
}
