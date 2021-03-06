import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by shuaiwang on 7/26/16.
 */
public class Permutation {

//    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
//        // write your code here
//
//        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
//        if (nums == null || nums.size() == 0) {
//            return result;
//        }
//
//        int[] visited = new int[nums.size()];
//
//        ArrayList<Integer> list = new ArrayList<>();
//
//        Collections.sort(nums);
//        helper(result, list, nums, visited);
//        return result;
//    }
//
//    // raw version
//    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, ArrayList<Integer> nums, int[] visited) {
//        if (list.size() == nums.size()) {
//            result.add(new ArrayList<>(list));
//        }
//
//        for (int i = 0; i < nums.size(); i++) {
//            if (visited[i] == 0) {
//                visited[i] = 1;
//                list.add(nums.get(i));
//                helper(result, list, nums, visited);
//                list.remove(list.size() - 1);
//                visited[i] = 0;
//
//                while (i < nums.size() - 1 && nums.get(i) == nums.get(i + 1)) {
//                    i++;
//                }
//            }
//        }
//    }
//
//
//    //upgraded version
//    private void helper2(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, ArrayList<Integer> nums, int[] visited) {
//        if (list.size() == nums.size()) {
//            result.add(new ArrayList<>(list));
//        }
//
//        for (int i = 0; i < nums.size(); i++) {
//            if (visited[i] != 0 || (i != 0 && nums.get(i) == nums.get(i - 1) && visited[i - 1] == 0)) {
//                continue;
//            }
//
//            visited[i] = 1;
//            list.add(nums.get(i));
//            helper(result, list, nums, visited);
//            list.remove(list.size() - 1);
//            visited[i] = 0;
//
//        }
//    }

    /**
     {}
     {1}
     {2,1} {1,2}
     {3,2,1} {2,3,1} {2,1,3} {3,1,2} {1,3,2} {1,2,3}
     */

//    public List<List<Integer>> permute(int[] nums) {
//        LinkedList<List<Integer>> result = new LinkedList<>();
//        result.add(new ArrayList<>());
//
//        for (int len = 0; len < nums.length; len++) {
//            int n = nums[len];
//            int size = result.size();
//            while (size != 0) {
//                List<Integer> cur = result.poll();
//                for (int i = 0; i <= len; i++) {
//                    List<Integer> tmp = new ArrayList<>(cur);
//                    tmp.add(i, n);
//                    result.add(tmp);
//                }
//                size--;
//            }
//        }
//        return result;
//    }

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> eachResult = new LinkedList<>();

        result.offer(eachResult);

        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> pivot = result.poll();
                for (int k = 0; k <= pivot.size(); k++) {
                    List<Integer> cur = new LinkedList<>(pivot);
                    cur.add(k, nums[i]);
                    result.offer(cur);
                }
            }
        }
        return result;
    }
}
