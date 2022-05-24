import java.util.Map;

public class Testing {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.readFile("sample3.txt");

        LargestDegreeOrdering ldo = new LargestDegreeOrdering(graph);

        ldo.fillColorMap();

        System.out.println(ldo.getColor());

        printMap(ldo.getColorSet());
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
