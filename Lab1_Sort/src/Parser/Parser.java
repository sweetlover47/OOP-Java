package Parser;

import java.io.IOException;
import java.io.Reader;

public interface Parser {
    void parse(Reader reader) throws IOException;
    String readWord() throws IOException;
    void print(Printer printer) throws IOException;
}
