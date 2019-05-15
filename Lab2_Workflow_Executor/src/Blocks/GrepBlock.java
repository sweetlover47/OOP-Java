package Blocks;

public class GrepBlock  implements Block {
    @Override
    public String execute(String[] input, String text) throws Exception {
        if (input == null || input.length != 1)
            throw new Exception("Incorrect amount of arguments");
        if (text == null)
            throw new Exception("No text for GrepBlock");
        String[] buffArray = text.split("\n");
        StringBuilder result = new StringBuilder();
        for (String s : buffArray) {
            if (s.contains(input[0])) {
                result.append(s + "\n");
            }
        }
        if (!result.toString().isEmpty())
            result.deleteCharAt(result.toString().length() - 1);
        return result.toString();
    }
}