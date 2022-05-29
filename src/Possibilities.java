import java.util.ArrayList;
import java.util.List;

public class Possibilities {
    List<LargestDegreeOrdering> listLDO;
    Graph graph;
    LargestDegreeOrdering result;
    public Possibilities(Graph graph) {
        listLDO = new ArrayList<>();
        this.graph = graph;
    }

    public void addFirst() {
        listLDO.add(new LargestDegreeOrdering(this.graph));
        listLDO.get(0).startProcess();
        listLDO.get(0).addColor(0);
    }

    public void createLDOS() {
        int min = Integer.MAX_VALUE;
        long start = System.currentTimeMillis();
        while (true) {
            int size = this.listLDO.size();

            LargestDegreeOrdering headLdo = this.listLDO.get(0);
            for (int k = 0; k < headLdo.getColor(); k++) {
                LargestDegreeOrdering ldo = new LargestDegreeOrdering(headLdo);
                k = ldo.addColor(k);
                if(k != -1 && ldo.findMax() + 1 < min) {
                    this.listLDO.add(ldo);
                } else {
                    break;
                }
            }

            if (this.listLDO.size() == size || System.currentTimeMillis() - start >= 60000){
                break;
            }

            LargestDegreeOrdering removed = this.listLDO.remove(0);
            removed.solve();

            if (removed.getColorSet().size() == removed.getGraph().getNumVertices() && min > removed.findMax()) {
                min = removed.findMax();
                result = removed;
            }
            System.gc();
        }
        printMap();
    }

    public void printList() {
        for (LargestDegreeOrdering largestDegreeOrdering : this.listLDO) {
            System.out.println(largestDegreeOrdering.getColorSet());
        }
    }

    public void printMap() {
        System.out.println(result.findMax() + 1);
        for (Integer key: result.getColorSet().keySet()) {
            System.out.print(result.getColorSet().get(key) + " ");
        }
        System.out.println();
    }

    public int findMaxOfMin() {
        int min = Integer.MAX_VALUE;
        for (LargestDegreeOrdering largestDegreeOrdering : this.listLDO) {
            int max = largestDegreeOrdering.findMax();
            if (min > max) {
                min = max;
                this.result = largestDegreeOrdering;
            }
        }

        return min + 1;
    }
}
