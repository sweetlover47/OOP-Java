package Parser;
import java.io.IOException;

public interface Printer {
    void print(String str) throws IOException;
    void closeFile() throws IOException;
}
