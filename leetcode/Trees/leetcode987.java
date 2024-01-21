import java.util.*;
public class leetcode987 {
    public class Tuple {
        TreeNode node;
        int row;
        int col;
        public Tuple(TreeNode node,int row,int col){
            this.node=node;
            this.row=row;
            this.col=col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root){
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map= new TreeMap<>();
        Queue<Tuple> queue=new LinkedList<Tuple>();
        queue.offer(new Tuple(root,0,0));
        while (!queue.isEmpty()) {
            Tuple tuple=queue.poll();
            TreeNode node=tuple.node;
            int x=tuple.row;
            int y=tuple.col;
            if (!map.containsKey(x)) {
                map.put(x,new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y,new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.val);
            if (node.left!=null) {
                queue.offer(new Tuple(node.left, x-1, y+1));
            }
            if(node.right!=null){
                queue.offer(new Tuple(node.right, x+1, y+1));
            }
        }
        List<List<Integer>> list=new ArrayList<>();
        for (TreeMap<Integer,PriorityQueue<Integer>> ys : map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer>nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size()-1).add(nodes.poll());
                }
            }
        }
        return list;
    }
    // public List<List<Integer>> verticalTraversal(TreeNode root) {
    //     List<List<Integer>> ans= new ArrayList<>();
    //     if(root==null){
    //         return null;
    //     }
    //     int col=0;
    //     Queue<Map.Entry<TreeNode,Integer>> queue=new ArrayDeque<>();
    //     Map<Integer, TreeSet<Integer>> map = new TreeMap<>();
    //     queue.offer(new AbstractMap.SimpleEntry<>(root, col));
    //     int min=0;
    //     int max=0;
    //     while (!queue.isEmpty()) {
    //         Map.Entry<TreeNode,Integer> removed= queue.poll();
    //         root=removed.getKey();
    //         col=removed.getValue();
    //         if (root!=null) {
    //             if(!map.containsKey(col)){
    //                 map.put(col, new ArrayList<Integer>());
    //             }
    //             map.get(col).add(root.val);
    //             min=Math.min(min, col);
    //             max=Math.max(max, col);
    //             queue.offer(new AbstractMap.SimpleEntry<>(root.left, col-1));
    //             queue.offer(new AbstractMap.SimpleEntry<>(root.right, col+1));
    //         }
    //     }
    //     for (int i=min;i<=max;i++){
    //         ans.add(map.get(i));
    //     }
    //     return ans;
    // }
}
