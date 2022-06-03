import java.util.*;

public class DegreeOfSaturation {
    private final Map<Integer, Integer> colorSet;
    private final Map<int[], Integer> arrayMap;
    private final Graph graph;
    private int color;
    private final PriorityQueue<int[]> sortedGraph;

    public DegreeOfSaturation(Graph graph) {
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


    public void startProcess() {
        fillArrayMap();
        sortArraysByDegree();
        fillColorMap();
    }

    public void fillColorMap() {
        colorFirstOne();

        while (this.colorSet.size() != this.graph.getNumVertices()) {
            int ID = findMaxDiffAdjacentColorOfUncoloredVertex();

            for (int i = 0; i <= color; i++) {
                boolean valid = isValid(ID, i, this.graph.getNumVertices());

                if (valid) {
                    this.colorSet.put(ID, i);
                    if (i == color) color++;
                    break;
                }
            }
        }
    }

    public int findMaxDiffAdjacentColorOfUncoloredVertex() {
        int ID = 0;
        int max = 0;


        for (int i = 0; i < this.graph.getNumVertices(); i++) {
            Set<Integer> colors = new HashSet<>();
            if (colorSet.containsKey(i)) continue;

            for (int k = 0; k < this.graph.getNumVertices(); k++) {
                if (isAdjacent(i, k) && this.colorSet.containsKey(k)) {
                    colors.add(this.colorSet.get(k));
                }
            }

            if (max < colors.size()) {
                ID = i;
                max = colors.size();
            }
            else if (max == colors.size()) {
                if (calculateDegree(this.graph.getAdjacencyMatrix()[ID], ID) < calculateDegree(this.graph.getAdjacencyMatrix()[i], i)) {
                    ID = i;
                }
            }
        }

        return ID;
    }

    public void colorFirstOne() {
        int ID = this.arrayMap.get(this.sortedGraph.poll());
        this.colorSet.put(ID, color++);
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


    public int getColor() {
        return color;
    }
}
