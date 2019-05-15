package Blocks;

import java.io.FileWriter;

public class WriteBlock implements Block {
    @Override
    public String execute(String[] input, String text) throws Exception {
        if (input == null || input.length != 1)
            throw new Exception("Incorrect amount of arguments");
        if (text == null)
            throw new Exception("No text for WriteBlock");
        FileWriter fileWriter = new FileWriter(input[0], false);
        fileWriter.write(text);
        fileWriter.flush();
        fileWriter.close();
        return null;
    }
}
