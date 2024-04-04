import java.util.ArrayList;
import java.util.Stack;
public class topologicalSort {
    public static void main(String[] args) {
        
    }
    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int[] visited = new int[V];
        Stack<Integer> stack = new Stack<>();
        for (int index = 0; index < V; index++) {
            if (visited[index] == 0) {
                dfs(index, adj, visited,stack);
            }
        }
        int[] res = new int[V];
        int i=0;
        while (!stack.isEmpty()) {
            res[i++] = stack.pop();
        }
        return res;
    }
    private static void dfs(int index, ArrayList<ArrayList<Integer>> adj, int[] visited, Stack<Integer> stack) {
        visited[index] = 1;
        for (int ind : adj.get(index)) {
            if (visited[ind] == 0) {
                dfs(ind, adj, visited, stack);
            }
        }
        stack.push(index);
    }
}
