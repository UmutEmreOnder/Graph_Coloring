import java.util.*;

public class LargestDegreeOrdering {
    private Map<Integer, Integer> colorSet;
    private Map<int[], Integer> arrayMap;
    private Graph graph;
    private int color;
    private PriorityQueue<int[]> sortedGraph;

    public LargestDegreeOrdering(Graph graph) {
        this.colorSet = new HashMap<>();
        this.arrayMap = new HashMap<>();
        this.graph = graph;
        this.color = 0;
        this.sortedGraph = new PriorityQueue<>(
                (t1, t2) -> (-calculateDegree(t1, this.arrayMap.get(t1)) + calculateDegree(t2, this.arrayMap.get(t2))) == 0 ?
                (this.arrayMap.get(t1) - this.arrayMap.get(t2)) :
                (-calculateDegree(t1, this.arrayMap.get(t1)) + calculateDegree(t2, this.arrayMap.get(t2))));
    }

    public int calculateDegree(int[] t1, int id) {
        int degree = 0;

        for (int i = 0; i < t1.length; i++) {
            degree += id == i ? t1[i] * 2 : t1[i];
        }

        return degree;
    }

    public void fillColorMap() {
        fillArrayMap();
        sortArraysByDegree();

        while (!this.sortedGraph.isEmpty()) {
            int ID = this.arrayMap.get(this.sortedGraph.poll());

            for (int i = 0; i < color; i++) {
                boolean valid = isValid(ID, i, this.graph.getNumVertices());

                if (valid) {
                    this.colorSet.put(ID, i);
                    break;
                }
            }

            if (!this.colorSet.containsKey(ID)) {
                this.colorSet.put(ID, color++);
            }
        }
    }

    public boolean isValid(int ID, int value, int length) {
        for (int k = 0; k < length; k++) {
            if (isAdjacent(ID, k) && this.colorSet.containsKey(k) && this.colorSet.get(k) == value) {
                return false;
            }
        }

        return true;
    }


    public void fillArrayMap() {
        for (int i = 0; i < this.graph.getNumVertices(); i++) {
            this.arrayMap.put(this.graph.getAdjacencyMatrix()[i], i);
        }
    }

    public void sortArraysByDegree() {
        for (int i = 0; i < this.graph.getNumVertices(); i++) {
            this.sortedGraph.add(this.graph.getAdjacencyMatrix()[i]);
        }
    }

    public boolean isAdjacent(int i, int j) {
        return this.graph.getAdjacencyMatrix()[i][j] != 0;
    }

    public Map<Integer, Integer> getColorSet() {
        return colorSet;
    }

    public void setColorSet(Map<Integer, Integer> colorSet) {
        this.colorSet = colorSet;
    }

    public Map<int[], Integer> getArrayMap() {
        return arrayMap;
    }

    public void setArrayMap(Map<int[], Integer> arrayMap) {
        this.arrayMap = arrayMap;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public PriorityQueue<int[]> getSortedGraph() {
        return sortedGraph;
    }

    public void setSortedGraph(PriorityQueue<int[]> sortedGraph) {
        this.sortedGraph = sortedGraph;
    }
}
