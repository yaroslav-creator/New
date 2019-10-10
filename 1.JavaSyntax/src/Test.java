import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

        public class Test {
            public static void main(String[] args) throws Exception {
                try {
                    System.out.println("Я буду зарабатывать $" +
                            (new BufferedReader(new InputStreamReader(System.in))).readLine()
                            + " в час");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }

