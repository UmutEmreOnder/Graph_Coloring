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
        this.sortedVertices = new PriorityQueue<>((t1, t2) -> -calculateDegree(t1, this.arrayMap.get(t1)) + calculateDegree(t2, this.arrayMap.get(t2)));
    }

    public void fillColorMap() {
        fillArrayMap();
        sortArraysByDegree();

        while(this.colorSet.size() != this.graph.getNumVertices()) {
            int arrayID = this.arrayMap.get(this.sortedVertices.poll());
            if (this.colorSet.containsKey(arrayID)) continue;

            this.colorSet.put(arrayID, color);

            List<int[]> pqList = findNonAdjacencyVertices(arrayID);

            while (!pqList.isEmpty()) {
                int tempId = this.arrayMap.get(pqList.get(0));
                this.colorSet.put(tempId, color);

                for (int i = 1; i < pqList.size(); i++) {
                    if (pqList.contains(this.graph.getAdjacencyMatrix()[i]) && isAdjacent(tempId, this.arrayMap.get(pqList.get(i)))) {
                        pqList.remove(i);
                    }
                }

                pqList.remove(0);
            }
            color++;
        }

    }

    public int calculateDegree(int[] t1, int id) {
        int degree = 0;

        for (int i = 0; i < t1.length; i++) {
            degree += id == i ? t1[i] * 2 : t1[i];
        }

        return degree;
    }

    public PriorityQueue<int[]> constructPqOfNonAdjacencyVertices(int id) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((t1, t2) -> calculateDegree(t1, this.arrayMap.get(t1)) - calculateDegree(t2, this.arrayMap.get(t2)));
        int length = this.graph.getNumVertices();
        for (int i = 0; i < length; i++) {
            if (i != id && this.graph.getAdjacencyMatrix()[id][i] == 0 && !this.colorSet.containsKey(i)) {
                pq.add(this.graph.getAdjacencyMatrix()[i]);
            }
        }
        return pq;
    }

    public ArrayList<int[]> findNonAdjacencyVertices(int id) {
        return new ArrayList<>(constructPqOfNonAdjacencyVertices(id));
    }

    public void fillArrayMap() {
        for (int i = 0; i < this.graph.getNumVertices(); i++) {
            this.arrayMap.put(this.graph.getAdjacencyMatrix()[i], i);
        }
    }

    public void sortArraysByDegree() {
        this.sortedVertices.addAll(Arrays.asList(this.graph.getAdjacencyMatrix()));
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


