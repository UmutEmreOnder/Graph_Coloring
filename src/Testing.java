import java.io.File;
import java.io.FileWriter;
import java.util.Map;
import java.io.IOException;


public class Testing {
    public static void main(String[] args) throws IOException {
        Graph graph = new Graph();

        graph.readFile("sample2.txt");

        solveDegreeOfSaturation(graph);
    }

    public static void printMap(Map<Integer, Integer> colorSet, FileWriter fileWriter) throws IOException {
        for (Integer key: colorSet.keySet()) {
            fileWriter.write(colorSet.get(key) + " ");
        }
    }


    public static void solveDegreeOfSaturation(Graph graph) throws IOException {
        DegreeOfSaturation degreeOfSaturation = new DegreeOfSaturation(graph);

        degreeOfSaturation.startProcess();

        File file = new File("output.txt");
        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write(String.valueOf(degreeOfSaturation.getColor()));

        fileWriter.write(System.lineSeparator());

        printMap(degreeOfSaturation.getColorSet(), fileWriter);

        fileWriter.close();
    }

}
