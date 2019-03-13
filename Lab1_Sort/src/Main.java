import Parser.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {

    public static void main(String[] args) throws IOException{
        if (args.length  == 0) {
            System.err.println("Error: no file name");
            return;
        }
        Reader reader = null;
        Parser parser = new ParserCSV();
        Printer printer = new MyPrinter();
        try {
            reader = new InputStreamReader(new FileInputStream(args[0]));
            parser.parse(reader);
            parser.print(printer);
        }
        catch (IOException e) {
            System.err.println("Error while reading file: " + e.getLocalizedMessage());
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                }
                catch(IOException e) {
                    e.printStackTrace(System.err);
                }
            }
        }



    }
}

/*

    Можно использовать Scanner в качестве парсера

    TreeMap <String, Integer> map = new TreeMap();
    map.put("aaa", 9);
    map.put("yyy", 0);
    map.put("abc", 5);
    map.put("cba", 5);
                                                             Нужно передать компаратор
                                                                         |
                                                                         v
    List <Map.Entry<String, Integer>> l = map.entrySet().stream().sorted()                          .collect(Collectors.toList());
                                                                                                    .filter();
                                                                 .sorted(Map.Entry.comparingByValue())
                                                                 .sorted(new MyComparator());                                           СТАНДАРТНЫЙ СПОСОБ
                                                                 .sorted(new Comparator<Map.Entry<String, Integer>() { ... })           АНОНИМНЫЙ КЛАСС
                                                                 .sorted(( //можно не писать типы//o1, o2) -> { ... })                   LAMBDA EXPRESSION
    for (Map.Entry<String, Integer>> item: l) {
          System.out.println(item);
    }




    Class MyIterator implement Comparator <Map.Entry<String, Integer>> {

        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            int c = o2.getValue().compareTo(o1.getValue);
            return (c == 0) ? o1.getKey().compareTo(o2.getKey()) : c;
        }
    }
 */