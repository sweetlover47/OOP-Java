package Parser;

import java.io.FileWriter;
import java.io.IOException;

public class MyPrinter implements Printer{
    private FileWriter file;
    public MyPrinter() throws IOException {
        file = new FileWriter("out.csv", false);
    }
    @Override
    public void print(String str) throws IOException{
        file.write(str);
    }
    @Override
    public void closeFile() throws IOException {
        file.close();
    }

}
