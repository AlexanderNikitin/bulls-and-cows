package an.bac;

import java.io.IOException;

public class Main {
    public static void main(String... args) throws IOException {
        do{
            new BullAndCows().play();
        } while (new ConsolePlayAgainQuestion().ask());
    }
}
