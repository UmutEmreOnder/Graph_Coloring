import java.util.*;

public class WelshPowellAlgorithm {
    private Graph graph;
    private Map<Integer, Integer> colorSet;
    private int color;
    private PriorityQueue<int[]> sortedVertices;
    private Map<int[], Integer> arrayMap;

    public WelshPowellAlgorithm(Graph graph) {
        this.graph = graph;
        this.colorSet = new HashMap<>();
        this.arrayMap = new HashMap<>();
        this.color = 0;
        this.sortedVertices = new PriorityQueue<>(new TheComparator());
    }

    static class TheComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] t1, int[] t2) {
            return Integer.compare(calculateDegree(t2), calculateDegree(t1));
        }

        public int calculateDegree(int[] t1) {
            int degree = 0;

            for (int j : t1) {
                degree += j;
            }

            return degree;
        }
    }

    public void fillColorMap() {
        fillArrayMap();
        sortArraysByDegree();

        this.colorSet.put(this.arrayMap.get(this.sortedVertices.poll()), color++);

        int length = this.graph.getNumVertices();


    }

    public void fillArrayMap() {
        for (int i = 0; i < this.graph.getNumVertices(); i++) {
            this.arrayMap.put(this.graph.getAdjacencyMatrix()[i], i);
        }
    }

    public void sortArraysByDegree() {
        this.sortedVertices.addAll(Arrays.asList(this.graph.getAdjacencyMatrix()));
    }

    public boolean isValid(int i, int j, int length) {
        for (int k = 0; k < length; k++) {
            if (isAdjacent(i, k) && this.colorSet.containsKey(k) && Objects.equals(this.colorSet.get(j), this.colorSet.get(k))) {
                return false;
            }
        }

        return true;
    }

    public boolean isAdjacent(int i, int j) {
        return this.graph.getAdjacencyMatrix()[i][j] != 0;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public Map<Integer, Integer> getColorSet() {
        return colorSet;
    }

    public void setColorSet(Map<Integer, Integer> colorSet) {
        this.colorSet = colorSet;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public PriorityQueue<int[]> getSortedVertices() {
        return sortedVertices;
    }

    public void setSortedVertices(PriorityQueue<int[]> sortedVertices) {
        this.sortedVertices = sortedVertices;
    }

    public Map<int[], Integer> getArrayMap() {
        return arrayMap;
    }

    public void setArrayMap(Map<int[], Integer> arrayMap) {
        this.arrayMap = arrayMap;
    }
}


