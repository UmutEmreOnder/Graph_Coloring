import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Testing {
    public static void main(String[] args) throws IOException {
        Graph graph = new Graph();

        graph.readFile("test4.txt");

        RecursiveLargestFirst recursiveLargestFirst = new RecursiveLargestFirst(graph);

        recursiveLargestFirst.startProcess();

        File file = new File("output4.txt");
        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write(String.valueOf(recursiveLargestFirst.getColor() + 1));

        fileWriter.write(System.lineSeparator());

        printMap(recursiveLargestFirst.getColorSet(), fileWriter);

        fileWriter.close();
    }


    public static void printMap(Map<Integer, Integer> colorSet, FileWriter fileWriter) throws IOException {
        for (Integer key: colorSet.keySet()) {
            fileWriter.write(colorSet.get(key) + " ");
        }
    }
}
