package dsa.graph;

public class disJointSet {
    public static void main(String[] args) {
        disJointSet ds = new disJointSet(5);
        ds.joinSet(0, 1);
        ds.joinSet(1, 2);
        ds.joinSet(3, 4);
        System.out.println(ds.findParent(0));
        System.out.println(ds.findParent(1));
        System.out.println(ds.findParent(2));
        System.out.println(ds.findParent(3));
        System.out.println(ds.findParent(4));
        ds.joinSet(2, 3);
    }

    public static int[] parent;
    public static int[] rank;
    public disJointSet(int n){
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    public int findParent(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }
    public void joinSet(int x, int y){
        int parentX = findParent(x);
        int parentY = findParent(y);
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

}
