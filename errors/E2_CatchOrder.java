import java.io.FileReader;
import java.io.IOException;

public class E2_CatchOrder {
    public static void main(String[] args) {
        try (FileReader r = new FileReader("data.txt")) {
            System.out.println("ok");
        } catch (Exception e) {        // загальний виняток першим
            System.out.println("Exception");
        } catch (IOException e) {      // недосяжний блок
            System.out.println("IOException");
        }
    }
}
