public class Testing {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.readFile("sample3.txt");

        Possibilities possibilities = new Possibilities(graph);
        possibilities.addFirst();
        possibilities.createLDOS();
    }

    public static void printArray(int[] array) {
        for (int k : array) {
            System.out.print(k + " ");
        }
        System.out.println();
    }


}
