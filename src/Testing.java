import java.util.Map;
import java.io.IOException;


public class Testing {
    public static void main(String[] args) throws IOException {
        Graph graph = new Graph();

        graph.readFile(10240);

        System.out.println("Vertices = " + graph.getNumVertices() + " Edge = " + graph.getNumEdges());

        solveFirstFit(graph);
        solveWelshPowell(graph);
        solveLargestDegreeOrdering(graph);
        solveDegreeOfSaturation(graph);
        solveRecursivelyLargestFirst(graph);
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

    public static void solveFirstFit(Graph graph) {
        System.out.println("--- First Fit ---");
        FirstFitAlgorithm firstFitAlgorithm = new FirstFitAlgorithm(graph);

        firstFitAlgorithm.fillColorMap();

        System.out.println(firstFitAlgorithm.getColor());

        printMap(firstFitAlgorithm.getColorSet());
    }

    public static void solveWelshPowell(Graph graph) {
        System.out.println("\n--- Welsh Powell ---");
        WelshPowellAlgorithm wp = new WelshPowellAlgorithm(graph);

        wp.fillColorMap();

        System.out.println(wp.getColor());

        printMap(wp.getColorSet());
    }

    public static void solveLargestDegreeOrdering(Graph graph) {
        System.out.println("\n--- Largest Degree Ordering ---");
        LargestDegreeOrdering ldo = new LargestDegreeOrdering(graph);

        ldo.fillColorMap();

        System.out.println(ldo.getColor());

        printMap(ldo.getColorSet());
    }

    public static void solveDegreeOfSaturation(Graph graph) {
        System.out.println("\n--- Degree of Saturation ---");
        DegreeOfSaturation degreeOfSaturation = new DegreeOfSaturation(graph);

        degreeOfSaturation.startProcess();

        System.out.println(degreeOfSaturation.getColor());

        printMap(degreeOfSaturation.getColorSet());
    }

    public static void solveRecursivelyLargestFirst(Graph graph) {
        System.out.println("\n--- Recursively Largest First ---");
        RecursiveLargestFirst recursiveLargestFirst = new RecursiveLargestFirst(graph);

        recursiveLargestFirst.startProcess();

        System.out.println(recursiveLargestFirst.getColor() + 1);

        printMap(recursiveLargestFirst.getColorSet());
    }

}
