import java.util.Map;

public class Testing {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.readFile("sample3.txt");
    }

    public static void printArray(int[][] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            for (int j = 1; j < length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printMap(Map<Integer, Integer> colorSet) {
        for (Integer key: colorSet.keySet()) {
            System.out.print(colorSet.get(key) + " ");
        }
    }
}
