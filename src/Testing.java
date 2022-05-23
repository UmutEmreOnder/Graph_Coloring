public class Testing {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.readFile("test.txt");

        System.out.println("Number of edges : " + graph.getNumEdges() + "\nNumber of Vertices : " + graph.getNumEdges());

        printArray(graph.getAdjacencyMatrix());
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
}
