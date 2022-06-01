import java.io.IOException;
import java.util.Map;

public class Testing {
    public static void main(String[] args) throws IOException {
        Graph graph = new Graph();

        graph.readFile("sample3.txt");

        DegreeOfSaturation degreeOfSaturation = new DegreeOfSaturation(graph);

        degreeOfSaturation.startProcess();

        System.out.println(degreeOfSaturation.getColor());

        printMap(degreeOfSaturation.getColorSet());
    }

    public static void printArray(int[] array) {
        for (int k : array) {
            System.out.print(k + " ");
        }
        System.out.println();
    }

    public static void printMap(Map<Integer, Integer> colorSet) {
        for (Integer key: colorSet.keySet()) {
            System.out.print(colorSet.get(key) + " ");
        }
    }


}
