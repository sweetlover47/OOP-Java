package Blocks;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadBlock  implements Block {
    @Override
    public String execute(String[] input, String text) throws Exception {
        if (input == null || input.length != 1)
            throw new Exception("Incorrect amount of arguments");
        InputStreamReader in = new InputStreamReader(new FileInputStream(input[0]));
        StringBuilder stringBuilder = new StringBuilder();
        int inputInt;
        while ((inputInt = in.read()) != -1) {
            stringBuilder.append((char) inputInt);
        }
        return stringBuilder.toString();
    }
}
