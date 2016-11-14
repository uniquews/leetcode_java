package main;

import com.sun.org.apache.xerces.internal.impl.dv.xs.UnionDV;
import main.utils.UndirectedGraphNode;

import java.util.*;

/**
 * Created by shuaiwang on 11/13/16.
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
            return node;
        }

        ArrayList<UndirectedGraphNode> allNodes = getAllNodesByDFS(node);

        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

        for (UndirectedGraphNode cur : allNodes) {
            UndirectedGraphNode newCur = new UndirectedGraphNode(cur.label);
            map.put(cur, newCur);
        }

        for (UndirectedGraphNode current : allNodes) {
            UndirectedGraphNode newCurrent = map.get(current);
            for (UndirectedGraphNode neighbor : current.neighbors) {
                newCurrent.neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }

    // bfs collects all nodes
//    private ArrayList<UndirectedGraphNode> getAllNodesByBFS(UndirectedGraphNode start) {
//        HashSet<UndirectedGraphNode> set = new HashSet<>();
//        Queue<UndirectedGraphNode> queue = new LinkedList<>();
//
//        queue.offer(start);
//        set.add(start);
//
//        while (!queue.isEmpty()) {
//            UndirectedGraphNode current = queue.poll();
//            for (UndirectedGraphNode node : current.neighbors) {
//                if (!set.contains(node)) {
//                    queue.add(node);
//                    set.add(node);
//                }
//            }
//        }
//        return new ArrayList<>(set);
//    }

    // dfs collects all nodes
    class StackElement {
        public UndirectedGraphNode node;
        public Integer neighborIndex;
        public StackElement(UndirectedGraphNode n, Integer index) {
            node = n;
            neighborIndex = index;
        }
    }
    private ArrayList<UndirectedGraphNode> getAllNodesByDFS(UndirectedGraphNode start) {
        Stack<StackElement> stack = new Stack<>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();

        StackElement startStk = new StackElement(start, -1);
        stack.add(startStk);
        set.add(start);
        while (!stack.isEmpty()) {
            StackElement current = stack.peek();
            current.neighborIndex++;
            if (current.neighborIndex == current.node.neighbors.size()) {
                stack.pop();
                continue;
            }

            UndirectedGraphNode nextNode = current.node.neighbors.get(current.neighborIndex);

            if (set.contains(nextNode)) {
                continue;
            } else{
                StackElement nextStkElem = new StackElement(nextNode, -1);
                stack.add(nextStkElem);
                set.add(nextNode);
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        CloneGraph test = new CloneGraph();
        UndirectedGraphNode a = new UndirectedGraphNode(-1);
        UndirectedGraphNode b = new UndirectedGraphNode(1);
        a.neighbors.add(b);
        test.cloneGraph(a);
    }
}
