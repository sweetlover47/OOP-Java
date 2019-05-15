package Blocks;

import java.util.Arrays;

public class SortBlock  implements Block {
    @Override
    public String execute(String[] input, String text) throws Exception {
        if (input.length != 0)
            throw new Exception("Incorrect amount of arguments");
        if (text == null)
            throw new Exception("No text for SortBlock");
        String[] buffArray = text.split("\n");
        Arrays.sort(buffArray);
        StringBuilder result = new StringBuilder();
        for (String s : buffArray) {
            result.append(s + "\n");
        }
        result.deleteCharAt(result.toString().length() - 1);
        return result.toString();
    }
}
