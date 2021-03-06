import utils.TreeNode;

import java.util.*;

/**
 * Created by shuaiwang on 3/14/17.
 */
public class SerializeAandDeserializeBinaryTree {
    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        if (root == null)
//            return "";
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//
//        StringBuilder sb = new StringBuilder();
//        while (!queue.isEmpty()) {
//            TreeNode cur = queue.poll();
//            if (cur == null) {
//                sb.append("null ");
//            } else {
//                sb.append(cur.val).append(" ");
//                queue.offer(cur.left);
//                queue.offer(cur.right);
//            }
//        }
//
//        return sb.toString();
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        if (data.equals("")) {
//            return null;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        String[] nodes = data.split(" ");
//        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
//        queue.offer(root);
//
//        for (int i = 1; i < nodes.length; i++) {
//            TreeNode cur = queue.poll();
//            if (!nodes[i].equals("null")) {
//                TreeNode leftNode = new TreeNode(Integer.valueOf(nodes[i]));
//                queue.offer(leftNode);
//                cur.left = leftNode;
//            }
//            if (!nodes[++i].equals("null")) {
//                TreeNode rightNode = new TreeNode(Integer.valueOf(nodes[i]));
//                queue.offer(rightNode);
//                cur.right = rightNode;
//            }
//        }
//        return root;
//    }

    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        if (root == null) {
//            return "";
//        }
//        StringBuilder sb = new StringBuilder();
//        Queue<TreeNode> q = new LinkedList<>();
//        q.add(root);
//        sb.append(root.val).append(" ");
//
//        while (!q.isEmpty()) {
//            TreeNode cur = q.poll();
//            if (cur.left != null) {
//                sb.append(cur.left.val).append(" ");
//                q.add(cur.left);
//            } else {
//                sb.append("null").append(" ");
//            }
//
//            if (cur.right != null) {
//                sb.append(cur.right.val).append(" ");
//                q.add(cur.right);
//            } else {
//                sb.append("null").append(" ");
//            }
//        }
//        return sb.toString();
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        if (data.equals("")) {
//            return null;
//        }
//
//        String[] s = data.split(" ");
//        Queue<TreeNode> q = new LinkedList<>();
//        TreeNode root = new TreeNode(Integer.valueOf(s[0]));
//        q.add(root);
//
//        for (int i = 1; i < s.length; i++) {
//            TreeNode cur = q.poll();
//            String leftStr = s[i];
//            if (!leftStr.equals("null")) {
//                TreeNode lnode = new TreeNode(Integer.valueOf(leftStr));
//                cur.left = lnode;
//                q.add(lnode);
//            }
//
//            String rightStr = s[++i];
//            if (!rightStr.equals("null")) {
//                TreeNode rnode = new TreeNode(Integer.valueOf(rightStr));
//                cur.right = rnode;
//                q.add(rnode);
//            }
//        }
//        return root;
//    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode n, StringBuilder sb) {
        if (n == null) {
            sb.append("#").append(" ");
            return;
        }
        sb.append(n.val).append(" ");
        serializeHelper(n.left, sb);
        serializeHelper(n.right, sb);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }

        String[] s = data.split(" ");
        LinkedList<String> l = new LinkedList<>(Arrays.asList(s));
        return deserializeHelper(l);
    }

    private TreeNode deserializeHelper(LinkedList<String> l) {
        String cur = l.poll();
        if (cur.equals("#")) {
            return null;
        }

        TreeNode n = new TreeNode(Integer.valueOf(cur));
        TreeNode leftChild = deserializeHelper(l);
        TreeNode rightChild = deserializeHelper(l);
        n.left = leftChild;
        n.right = rightChild;
        return n;
    }

    public static void main(String[] args) {
//        TreeNode a = new TreeNode(1);
//        TreeNode b = new TreeNode(2);
//        TreeNode c = new TreeNode(3);
//        TreeNode d = new TreeNode(4);
//        TreeNode e = new TreeNode(5);
//        c.left = d;
//        c.right = e;
//
//        a.left = b;
//        a.right = c;
//
//        SerializeAandDeserializeBinaryTree test = new SerializeAandDeserializeBinaryTree();
//        TreeNode result = test.deserialize(test.serialize(a));
//        System.out.println();

        String a = "  b";
        String[] s = a.split(" ");
        System.out.println(s.length);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
}
