package greedy;


import java.util.PriorityQueue;

public class leetcode1298 {
    public static void main(String[] args) {
        int[] status = {1, 0, 1, 0};
        int[] candies = {7, 5, 4, 100};
        int[][] keys = { {}, {}, {1}, {} };
        int[][] containedBoxes = { {1, 2}, {3}, {}, {} };
        int[] initialBoxes = {0};
        leetcode1298 solver = new leetcode1298();
        System.out.println(solver.maxCandies(status, candies, keys, containedBoxes, initialBoxes));
    }
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int candy = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)-> b[1] - a[1]);
        int visited[] = new int[status.length];
        for(int box:initialBoxes){
            queue.add(new int[]{box, status[box]});
        }
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            if (visited[curr[0]] ==  1) {
                continue; 
                
            }
            if(status[curr[0]]==1) {
                visited[curr[0]] = 1;
                candy+=candies[curr[0]];
                for(int key:keys[curr[0]]){
                    status[key] = 1;
                }
                for(int box:containedBoxes[curr[0]]){
                    queue.add(new int[]{box, status[box]});
                }
            }
        }
        return candy;
    }
}
