package ua.duikt.pr5;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/** Допоміжний клас: вивід і стектрейси в UTF-8, щоб кирилиця читалась у консолі й у файлах. */
final class Utf8 {
    private Utf8() { }

    static void init() {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.setErr(new PrintStream(System.err, true, StandardCharsets.UTF_8));
    }
}
