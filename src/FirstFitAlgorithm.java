import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class FirstFitAlgorithm {
    private Map<Integer, Integer> colorSet;
    private Graph graph;
    private int color;

    public FirstFitAlgorithm(Graph graph) {
        this.colorSet = new HashMap();
        this.graph = graph;
        this.color = 0;
    }

    public void fillColorMap() {
        this.colorSet.put(0, color++);

        int length = this.graph.getNumVertices();

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (j == i) continue;

                if (!isAdjacent(i, j) && colorSet.containsKey(j)) {

                    boolean valid = isValid(i, j, length);

                    if (valid) {
                        this.colorSet.put(i, colorSet.get(j));
                        break;
                    }
                }
            }

            if (!colorSet.containsKey(i)) {
                colorSet.put(i, color++);
            }
        }
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

    public Map<Integer, Integer> getColorSet() {
        return colorSet;
    }

    public void setColorSet(Map<Integer, Integer> colorSet) {
        this.colorSet = colorSet;
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
}
