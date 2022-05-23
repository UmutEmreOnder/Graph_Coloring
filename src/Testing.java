import java.util.Map;

public class Testing {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.readFile("sample3.txt");

        FirstFitAlgorithm firstFitAlgorithm = new FirstFitAlgorithm(graph);

        firstFitAlgorithm.fillColorMap();

        System.out.println(firstFitAlgorithm.getColor());

        printMap(firstFitAlgorithm.getColorSet());
    }

    public static void printMap(Map<Integer, Integer> colorSet) {
        for (Integer key: colorSet.keySet()) {
            System.out.print(colorSet.get(key) + " ");
        }
    }
}
