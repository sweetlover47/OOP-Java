import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyReader {

    private StringBuilder stringBuilder = new StringBuilder();
    private InputStreamReader in;
    MyReader(String fileName) throws FileNotFoundException {
        this.in = new InputStreamReader(new FileInputStream(fileName));
    }

    String getString() throws IOException {
        String str = "";
        int word;
        boolean working = true;
        while (working) {
            if ((word = in.read()) == -1) {
                working = false;
            }
            if (!Character.isWhitespace(word))
                stringBuilder.append((char) word);
            else {
                str = stringBuilder.toString();
                working = false;
            }
        }
        return str;
    }
}
