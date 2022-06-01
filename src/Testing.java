import java.util.Map;
import java.io.IOException;


public class Testing {
    public static void main(String[] args) throws IOException {
        Graph graph = new Graph();

        graph.readFile(10);
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
