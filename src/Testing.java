import java.util.List;
import java.util.Map;

public class Testing {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.readFile("sampleOfReport.txt");

        RecursiveLargestFirst recursiveLargestFirst = new RecursiveLargestFirst(graph);

        recursiveLargestFirst.startProcess();

        System.out.println(recursiveLargestFirst.getColor() + 1);

        printMap(recursiveLargestFirst.getColorSet());
    }

    public static void printArray(List<Integer> array) {
        for (Integer integer : array) {
            System.out.print((integer + 1) + " ");
        }
        System.out.println();
    }

    public static void printMap(Map<Integer, Integer> colorSet) {
        for (Integer key: colorSet.keySet()) {
            System.out.print(colorSet.get(key) + " ");
        }
    }
}
