import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Graph {
    private int numVertices, numEdges;
    private int[][] adjacencyMatrix;
    private Scanner fileReader;
    private Set<String> edgeSet;

    public void readFile(String fileName) {
        File file;

        try {
            file = new File(fileName);
            fileReader = new Scanner(file);
        } catch (Exception FileNotFoundException) {
            System.out.println(FileNotFoundException.getMessage());
            System.exit(-1);
        }

        fileReader.next();
        numVertices = fileReader.nextInt();
        numEdges = fileReader.nextInt();

        createAdjacencyMatrix();
    }

    public void readFile(int numVertices) throws IOException {
        int temp = createFile(numVertices);
        readFile("created.txt");
        this.numEdges = temp;
    }

    public int createFile(int numVertices) throws IOException {
        int edges = 0;
        File file = new File("created.txt");
        this.edgeSet = new HashSet<>();

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("p " + numVertices + " " + 0 + "\n");
        for (int i = 1; i <= numVertices; i++) {
            Random random = new Random();
            int edge = random.nextInt(6);
            edges += edge;
            for (int j = 0; j < edge; j++) {
                int vertex = random.nextInt(numVertices) + 1;
                if (!this.edgeSet.contains(createString(i, vertex)) && i != vertex) {
                    fileWriter.write("e " + i + " " + vertex + "\n");
                }
                else {
                    edges--;
                }
            }
        }
        fileWriter.close();
        return edges;
    }

    public String createString(int a, int b) {
        return a <= b ? a + " -> " + b : b + " -> " + a;
    }

    public void createAdjacencyMatrix() {
        adjacencyMatrix = new int[numVertices][numVertices];

        while (fileReader.hasNext()) {
            fileReader.next();
            int num1 = fileReader.nextInt() - 1;
            int num2 = fileReader.nextInt() - 1;
            adjacencyMatrix[num1][num2]++;
            adjacencyMatrix[num2][num1]++;
        }
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public int getNumEdges() {
        return numEdges;
    }

    public void setNumEdges(int numEdges) {
        this.numEdges = numEdges;
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public void setAdjacencyMatrix(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }
}
