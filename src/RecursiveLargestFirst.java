import java.util.*;

public class RecursiveLargestFirst {
    private final Map<Integer, Integer> colorSet;
    private final Map<int[], Integer> arrayMap;
    private final Graph graph;
    private int color;
    private final PriorityQueue<int[]> sortedGraph;

    public RecursiveLargestFirst(Graph graph) {
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

        int ID = this.arrayMap.get(this.sortedGraph.poll());
        fillColorMap(ID);
    }

    public void fillColorMap(int ID) {

        this.colorSet.put(ID, color);
        int selected = ID;

        List<Integer> adjacent = new ArrayList<>();
        for (int i = 0; i < this.graph.getNumVertices(); i++) {
            if (isAdjacent(selected, i)) adjacent.add(i);
        }

        while (true) {
            List<Integer> notAdjacent = new ArrayList<>();
            for (int i = 0; i < this.graph.getNumVertices(); i++) {
                if (!adjacent.contains(i) && !this.colorSet.containsKey(i)) notAdjacent.add(i);
            }


            int max = 0;

            for (int i = 0; i < notAdjacent.size(); i++) {
                int count = 0;
                for (int k = 0; k < this.graph.getNumVertices(); k++) {
                    if (isAdjacent(notAdjacent.get(i), k) && !notAdjacent.contains(k)) {
                        count++;
                    }
                }

                if (max < count) {
                    max = count;
                    selected = notAdjacent.get(i);
                }
            }

            this.colorSet.put(selected, color);

            for (int i = 0; i < this.graph.getNumVertices(); i++) {
                if (isAdjacent(selected, i) && notAdjacent.contains(i)) {
                    notAdjacent.remove(Integer.valueOf(i));
                    adjacent.add(i);
                }
            }

            notAdjacent.remove(Integer.valueOf(selected));
            adjacent.add(selected);

            if (notAdjacent.isEmpty()) {
                break;
            }
        }


        if (this.colorSet.size() != this.graph.getNumVertices()) {
            color++;
            fillColorMap(findUncoloredWithMaxAdjacent());
        }
    }

    public int findUncoloredWithMaxAdjacent() {
        int ID = 0;
        int max = 0;


        for (int i = 0; i < this.graph.getNumVertices(); i++) {
            if (this.colorSet.containsKey(i)) continue;

            int count = 0;
            for (int k = 0; k < this.graph.getNumVertices(); k++) {
                if (isAdjacent(i, k)) count++;
            }

            if (count > max) {
                max = count;
                ID = i;
            }

            if (count == max) {
                if (calculateDegree(this.graph.getAdjacencyMatrix()[ID], ID) < calculateDegree(this.graph.getAdjacencyMatrix()[i], i)) {
                    ID = i;
                }
            }
        }

        return ID;
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
