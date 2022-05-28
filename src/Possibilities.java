import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        while (true) {
            int size = this.listLDO.size();

            for (int i = 0; i < size; i++) {
                LargestDegreeOrdering headLdo = this.listLDO.get(i);
                for (int k = 0; k < headLdo.getColor(); k++) {
                    LargestDegreeOrdering ldo = new LargestDegreeOrdering(headLdo);
                    k = ldo.addColor(k);
                    if(k != -1) {
                        this.listLDO.add(ldo);
                    } else {
                        break;
                    }
                }
            }

            if (this.listLDO.size() == size) break;
            else {
                this.listLDO.subList(0, size).clear();
            }

            System.gc();
        }
    }

    public void printList() {
        for (LargestDegreeOrdering largestDegreeOrdering : this.listLDO) {
            System.out.println(largestDegreeOrdering.getColorSet());
        }
    }

    public void printMap() {
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
