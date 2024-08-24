package Trees;

import java.util.*;


public class TopView {
    public static void main(String[] args) {
        
    }
    public static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        // Set<Integer> set = new HashSet<>();
        if (root == null) {
            return ans;
        }

        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root, 0));

        while (!queue.isEmpty()) {
            QueueNode qNode = queue.poll();
            int hd = qNode.horizontalDistance;
            
            if(!map.containsKey(hd)){
                // set.add(hd);
                map.put(hd, qNode.node.data);
            }
            
            if (qNode.node.left != null) {
                queue.offer(new QueueNode(qNode.node.left, hd - 1));
            }
            if (qNode.node.right != null) {
                queue.offer(new QueueNode(qNode.node.right, hd + 1));
            }
        }

        for (int value : map.values()) {
            ans.add(value);
        }
        return ans;
    }
}

class QueueNode {
    Node node;
    int horizontalDistance;

    public QueueNode(Node node, int horizontalDistance) {
        this.node = node;
        this.horizontalDistance = horizontalDistance;
    }
}
