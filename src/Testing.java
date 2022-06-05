import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Testing {
    public static void main(String[] args) throws IOException {
        Graph graph = new Graph();

        String fileName = args.length != 0 ? args[0] : "test1.txt";

        graph.readFile(fileName);

        RecursiveLargestFirst recursiveLargestFirst = new RecursiveLargestFirst(graph);

        recursiveLargestFirst.startProcess();

        printToFile(fileName, recursiveLargestFirst);
    }

    public static void printToFile(String fileName, RecursiveLargestFirst recursiveLargestFirst) throws IOException {
        String outputName = "output" + fileName.charAt(fileName.length() - 5) + ".txt";

        File file = new File(outputName);

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
