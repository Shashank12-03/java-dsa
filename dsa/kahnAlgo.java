import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class kahnAlgo {
    public static void main(String[] args) {
        
    }
    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int ind : adj.get(i)) {
                indegree[ind]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int[] res = new int[V];
        int i = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res[i++] = node;
            for (int ind : adj.get(node)) {
                indegree[ind]--;
                if (indegree[ind] == 0) {
                    queue.add(ind);
                }
            }
        }
        return res;
    }
}
