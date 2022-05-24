import java.io.File;
import java.util.Scanner;

public class Graph {
    private int numVertices, numEdges;
    private int[][] adjacencyMatrix;
    private Scanner fileReader;

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

    public void createAdjacencyMatrix() {
        adjacencyMatrix = new int[numVertices][numVertices];

        while (fileReader.hasNextLine()) {
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
