package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class detectCycle {
    public static void main(String[] args) {
        
    }
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited=new boolean[V];
        for (int i = 0; i < visited.length; i++) {
            visited[i]=true;
        }
        for (int i = 0; i < visited.length; i++) {
            if(detectcycle(i,V,adj,visited)){
                return true;
            }
        }
        return false;
    }
    private static boolean detectcycle(int src, int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[src]=true;
        Queue<Pairs> store=new LinkedList<>();
        store.add(new Pairs(src,-1));
        while (!store.isEmpty()) {
            Pairs current=store.poll();
            int currentNode=current.first;
            int parent=current.second;
            for (int node :adj.get(currentNode)) {
                if (!visited[node]) {
                    visited[node]=true;
                    store.add(new Pairs(node,currentNode));
                }else if (parent!=node) {
                    return true;
                }
            }
        }
        return false;
    }
}
