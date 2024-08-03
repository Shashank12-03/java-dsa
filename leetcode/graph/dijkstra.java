package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class dijkstra {
    public static void main(String[] args) {
        // dijkstra sol = new dijkstra();
        // ArrayList<ArrayList<ArrayList<Integer>>> adj = {{{1, 9}}, {{0, 9}}};
        // System.out.println(sol.Dijkstra(0, , 0));
    }
    static int[] Dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b)-> a.dist-b.dist);
        int[] distance = new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[S] = 0;
        pq.add(new Pair(S,0));
        while(!pq.isEmpty()){
            int vertx = pq.peek().vertx;
            int dist = pq.peek().dist;
            pq.remove();
            for(int i=0;i<adj.get(vertx).size();i++){
                int edgeWeight = adj.get(vertx).get(i).get(1);
                int adjNode = adj.get(vertx).get(i).get(0);
                if(edgeWeight+dist<distance[adjNode]){
                    distance[adjNode]= edgeWeight+dist;
                    pq.add(new Pair(adjNode,distance[adjNode]));
                }
            }
        }
        return distance;
    }
}
class Pair{
    int vertx;
    int dist;
    Pair(int vertx,int dist){
        this.vertx=vertx;
        this.dist=dist;
    }
}


