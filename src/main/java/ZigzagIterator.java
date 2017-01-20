import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuaiwang on 1/19/17.
 */
public class ZigzagIterator {
    // k list solution
    private List<List<Integer>> list;
    private int maxRow;
    private int maxColumn;
    private int currentRow;
    private int currentColumn;

    public ZigzagIterator(List<List<Integer>> li) {
        list = li;
        maxRow = list.size();
        for (int i = 0; i < list.size(); i++) {
            maxColumn = Math.max(list.get(i).size(), maxColumn);
        }
        currentColumn = 0;
        currentRow = -1;
        findNextNumber();
    }

    private void findNextNumber() {
        while (currentColumn < maxColumn) {
            currentRow++;
            if (currentRow == maxRow) {
                currentRow = 0;
                currentColumn++;
            }
            if (currentColumn < list.get(currentRow).size() || currentColumn < list.get(currentRow).size()) {
                break;
            }
        }
    }

    public int next() {
        int result = list.get(currentRow).get(currentColumn);
        findNextNumber();
        return result;
    }

    public boolean hasNext() {
        return currentColumn < maxColumn;
    }

// Two lists solution
//    private int maxRow;
//    private int maxColumn;
//    private int currentRow;
//    private int currentColumn;
//    private List<Integer> list1;
//    private List<Integer> list2;
//
//    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
//        maxRow = 2;
//        maxColumn = Math.max(v1.size(), v2.size());
//        currentColumn = 0;
//        currentRow = -1;
//        list1 = v1;
//        list2 = v2;
//        findNextNumberIndex();
//    }
//
//    public int next() {
//        int result = 0;
//        if (currentRow == 0) {
//            result = list1.get(currentColumn);
//        } else {
//            result = list2.get(currentColumn);
//        }
//        findNextNumberIndex();
//        return result;
//    }
//
//    private void findNextNumberIndex() {
//        while (currentColumn < maxColumn) {
//            currentRow++;
//            if (currentRow == maxRow) {
//                currentRow = 0;
//                currentColumn++;
//            }
//            if ((currentRow == 0 && currentColumn < list1.size()) || (currentRow == 1 && currentColumn < list2.size())) {
//                break;
//            }
//        }
//    }
//
//    public boolean hasNext() {
//        return currentColumn < maxColumn;
//    }

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>(Arrays.asList(3,4,5,6));
        List<Integer> l3 = new ArrayList<>(Arrays.asList(8,9));
        List<List<Integer>> input = new ArrayList<>();
        input.add(l1);
        input.add(l2);
        input.add(l3);
        List<Integer> result = new ArrayList<>();
        ZigzagIterator test = new ZigzagIterator(input);
        while (test.hasNext()) {

            result.add(test.next());
        }
        System.out.print(result);
    }

}
