import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class WorkflowReader {
    private FileReader in;
    private InputStreamReader inputStreamReader;
    private StringBuilder stringBuilder = new StringBuilder();
    boolean eof = false;

    WorkflowReader(String file) throws Exception {
        in = new FileReader(file);
        inputStreamReader = new InputStreamReader(new FileInputStream(file));
    }

    private String getString() throws Exception {
        stringBuilder.delete(0, stringBuilder.toString().length());
        int input;
        while(!eof) {
            input = inputStreamReader.read();
            if (input == -1)
                eof = true;
            if ( (char)input != '\n' && (char)input != '\r' && !eof)
                stringBuilder.append((char)input);
            else if (stringBuilder.toString().length() != 0)
                return stringBuilder.toString();
            else
                stringBuilder.delete(0, 1);
        }
        return null;
    }

    Map<Integer, BlockContext> readBlock() throws Exception {
        String str = getString();
        if (str.length() == 0)
            throw new Exception("EOF");
        while (!str.equals("desc") && !eof)
            str = getString();
        str = getString();
        Map <Integer, BlockContext> result = new HashMap<>();
        String[] formatArray, argsArray;
        while (!eof && !str.equals("csed")) {
            formatArray = str.split(" ");
            argsArray = new String[formatArray.length - 3];
            System.arraycopy(formatArray, 3, argsArray, 0, formatArray.length - 3);
            result.put(Integer.parseInt(formatArray[0]), new BlockContext(formatArray[2], argsArray));
            str = getString();
        }
        return result;
    }

    List<Integer> readBlockPipe() throws Exception {
        List<Integer> result = new LinkedList<>();
        String pipeDesc;

        pipeDesc = getString();
        if (pipeDesc == null)
            throw new Exception("File has ended");
        String[] parseID = pipeDesc.split(" -> ");
        for(String s: parseID)
            result.add(Integer.parseInt(s));
        return result;
    }
}

