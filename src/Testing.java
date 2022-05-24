import java.util.Map;

public class Testing {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.readFile("sample3.txt");

        WelshPowellAlgorithm wp = new WelshPowellAlgorithm(graph);

        wp.fillColorMap();

        System.out.println(wp.getColor());



        printMap(wp.getColorSet());
    }

    public static void printMap(Map<Integer, Integer> colorSet) {
        for (Integer key: colorSet.keySet()) {
            System.out.print(colorSet.get(key) + " ");
        }
    }

}
