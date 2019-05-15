package Blocks;

public class ReplaceBlock  implements Block{
    @Override
    public String execute(String[] input, String text) throws Exception {
            if (input == null || input.length != 2)
                throw new Exception("Incorrect amount of arguments");
            if (text == null)
                throw new Exception("No text for ReplaceBlock");
            return text.replaceAll(input[0], input[1]);
    }
}
