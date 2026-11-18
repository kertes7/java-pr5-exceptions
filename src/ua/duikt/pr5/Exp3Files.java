package ua.duikt.pr5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/** Дослід 3: незакритий потік, try-with-resources і вплив кодування на кирилицю. */
public class Exp3Files {

    static final String[] LINES = {"Привіт", "Оцінка: 95", "Іваненко Петро"};

    static void fill(BufferedWriter w) throws IOException {
        for (String s : LINES) {
            w.write(s);
            w.newLine();
        }
    }

    static String readAs(Path p, Charset cs) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader r = Files.newBufferedReader(p, cs)) {
            String line;
            while ((line = r.readLine()) != null) sb.append(line).append(" | ");
        } catch (MalformedInputException e) {
            return "MalformedInputException (байти не відповідають кодуванню " + cs + ")";
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        Utf8.init();

        // 1) без close(): дані лишаються в буфері, файл порожній
        Path unclosed = Path.of("unclosed.txt");
        BufferedWriter w = Files.newBufferedWriter(unclosed, StandardCharsets.UTF_8);
        fill(w);                                         // жодного flush()/close()
        System.out.println("1) Без close(): розмір файлу = " + Files.size(unclosed)
                + " байт; вміст: «" + Files.readString(unclosed) + "»");

        // 2) try-with-resources: потік закривається автоматично, дані записано
        Path closed = Path.of("closed.txt");
        try (BufferedWriter w2 = Files.newBufferedWriter(closed, StandardCharsets.UTF_8)) {
            fill(w2);
        }
        System.out.println("2) try-with-resources: розмір файлу = " + Files.size(closed) + " байт");

        // 3) кодування під час читання
        System.out.println("3) Читання як UTF-8:        " + readAs(closed, StandardCharsets.UTF_8));
        System.out.println("   Читання як windows-1251: " + readAs(closed, Charset.forName("windows-1251")));
    }
}
