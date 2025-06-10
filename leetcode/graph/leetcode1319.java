package graph;

public class leetcode1319 {
    public static void main(String[] args) {
        
    }
    public int findParent(int[]parent, int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x] = findParent(parent,parent[x]);
    }
    public void joinSet(int[]rank, int[] parent, int x, int y){
        int parentX = findParent(parent,x);
        int parentY = findParent(parent,y);
        if(parentX==parentY){
            return;
        }
        if(rank[parentX]<rank[parentY]){
            parent[parentX] = parentY;
        } else if(rank[parentX]>rank[parentY]){
            parent[parentY] = parentX;
        } else {
            parent[parentY] = parentX;
            rank[parentX]++;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        for(int i = 0;i<n;i++){
            parent[i] = i;
        }
        int extra = 0;
        int connected = 0;
        for(int[] edge : connections){
            int x = edge[0];
            int y = edge[1];
            int parentX = findParent(parent, x);
            int parentY = findParent(parent, y);
            if(parentX==parentY){
                extra++;
                continue;
            }
            joinSet(rank, parent, x, y);
            connected++;
        }
        return extra >= connected ? connected : -1;
    }
}
