package an.bac;

import java.io.IOException;

public class ConsolePlayAgainQuestion implements PlayAgainQuestion {
    @Override
    public boolean ask() throws IOException {
        System.out.println("Сыграем еще? Y/N");
        int read = System.in.read();
        return read == 'Y';
    }
}
