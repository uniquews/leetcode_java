import java.util.*;

/**
 * Created by shuaiwang on 8/26/17.
 */
public class TaskScheduler {
//    public int leastInterval(char[] tasks, int n) {
//        int[] occur = new int[26];
//        int[] valid = new int[26];
//
//        for (char c : tasks) {
//            occur[c - 'A']++;
//        }
//
//        int count = 0, index = 0;
//        while (count < tasks.length) {
//            int nextTask = getNextValid(occur, valid, index);
//            if (nextTask != -1) {
//                count++;
//                valid[nextTask] = index + n + 1;
//                occur[nextTask]--;
//            }
//            index++;
//        }
//        return index;
//    }
//
//    private int getNextValid(int[] occur, int[] valid, int index) {
//        int maxOccur = 0, result = -1;
//        for (int i = 0; i < 26; i++) {
//            if (maxOccur < occur[i] && valid[i] <= index) {
//                maxOccur = occur[i];
//                result = i;
//            }
//        }
//        return result;
//    }
//    public int leastInterval(char[] tasks, int n) {
//        int[] occur = new int[26];
//        int[] valid = new int[26];
//
//        for (int i = 0; i < tasks.length; i++) {
//            occur[tasks[i] - 'A']++;
//        }
//
//        int len = 0;
//        int used = 0;
//        while (used < tasks.length) {
//            int task = getAvaiableTask(occur, valid, len);
//            if (task == -1) {
//                len++;
//            } else {
//                occur[task]--;
//                valid[task] = len + n + 1;
//                used++;
//                len++;
//            }
//        }
//        return len;
//    }
//
//    private int getAvaiableTask(int[] occur, int[] valid, int index) {
//        int maxOccurTask = -1;
//        int maxOccur = 0;
//        for (int i = 0; i < occur.length; i++) {
//            if (valid[i] <= index) {
//                if (occur[i] > maxOccur) {
//                    maxOccur = occur[i];
//                    maxOccurTask = i;
//                }
//            }
//        }
//        return maxOccurTask;
//    }


    // 数学方法
//    public int leastInterval(char[] tasks, int n) {
//        int[] counts = new int[26];
//        for (char task : tasks) {
//            counts[task - 'A']++;
//        }
//        int k = 0;
//        int maxCount = 0;
//        for (int count : counts) {
//            if (count > maxCount) {
//                maxCount = count;
//                k = 1;
//            } else if (count == maxCount) {
//                k++; // 出现最多的task的个数，比如A 和B 都是出现次数为3的task ，则k = 2
//            }
//        }
//
//        // 同时满足所有task被分配完 并且最多出现的task之间的空隙为n
//        // maxCount - 1 * (n + 1): a...a...a...的长度
//        // k 指  末尾的ab
//        // a...a...a...ab
//        return Math.max(tasks.length, (maxCount - 1) * (n + 1) + k);
//    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> occur = new HashMap<>();
        Map<Character, Integer> valid = new HashMap<>();

        for (int i = 0; i < tasks.length; i++) {
            occur.put(tasks[i], occur.getOrDefault(tasks[i], 0) + 1);
            valid.put(tasks[i], 0);
        }

        Queue<Map.Entry<Character, Integer>> q = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        q.addAll(occur.entrySet());

        int len = 0;
        int used = 0;
        while (used < tasks.length) {

            Map.Entry<Character, Integer> task = getMostAndValid(q, valid, len);
            if (task != null) {
                task.setValue(task.getValue() - 1);
                valid.put(task.getKey(), len + n + 1);
                if (task.getValue() != 0) {
                    q.offer(task);
                }
                used++;
            }
            len++;

        }
        return len;
    }

    private Map.Entry<Character, Integer> getMostAndValid(Queue<Map.Entry<Character, Integer>> q, Map<Character, Integer> valid, int len) {
        List<Map.Entry<Character, Integer>> tmp = new ArrayList<>();

        while (!q.isEmpty()) {
            Map.Entry<Character, Integer> cur = q.poll();

            if (valid.get(cur.getKey()) <= len) {
                q.addAll(tmp);
                return cur;
            }
            tmp.add(cur);
        }
        q.addAll(tmp);
        return null;
    }

    public static void main(String[] args) {
        TaskScheduler test = new TaskScheduler();
//        char[] tasks = {'A','A','A','B','B','B'};
        char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
//        char[] tasks = {'A','B'};
        System.out.print(test.leastInterval(tasks, 2));
    }
}
