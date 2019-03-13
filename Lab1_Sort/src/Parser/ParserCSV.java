package Parser;

import java.io.IOException;
import java.io.Reader;
import java.util.*;
import java.util.stream.Collectors;

public class ParserCSV implements Parser{
    private Reader _in = null;
    private boolean fileExist = true;
    private Map<String, Integer> map = new TreeMap<>();
    private int countWord = 0;
    private StringBuilder strBuilder = new StringBuilder();
    private List<Map.Entry<String, Integer>> list;

    @Override
    public void parse(Reader in) throws IOException {
        _in = in;
        String word;
        int tmp = 0;
        while (fileExist) {
            word = readWord();
            if (!word.isEmpty()) {
                if (map.containsKey(word))
                    tmp = map.get(word);
                map.put(word, tmp + 1);
                countWord++;
                tmp = 0;
            }
        }
    }

    @Override
    public String readWord() throws IOException {
        int inputWord;
        String word = "";
        strBuilder.delete(0, strBuilder.toString().length());
        while (fileExist) {
            inputWord = _in.read();
            if (inputWord == -1)
                fileExist = false;
            if (Character.isLetterOrDigit(inputWord))
                strBuilder.append((char) inputWord);
            else if ( (word = strBuilder.toString()).length() > 0)
                return word.toLowerCase();
        }
        return "";
    }

    public void print(Printer out) throws IOException {
        sort();
        for (Map.Entry<String, Integer> item: list) {
            out.print(item.getKey() + ", " + item.getValue() + ", " + ( (float) item.getValue() / countWord * 100) + "%\n");
        }
        out.closeFile();
    }

    private void sort() throws IOException {
        list = map.entrySet().stream().sorted(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int c = o2.getValue().compareTo(o1.getValue());
                return (c == 0) ? o1.getKey().compareTo(o2.getKey()) : c;
            }
        }).collect(Collectors.toList());

    }
}
