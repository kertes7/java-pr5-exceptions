import java.io.FileReader;

public class E1_Unreported {
    public static void main(String[] args) {
        FileReader reader = new FileReader("data.txt");   // перевірюваний виняток не оброблено
    }
}
