package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode207 {
    public static void main(String[] args) {
        System.out.println(canFinish(2,new int[][]{{1,0}/* ,{0,1}*/}));
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int j : adj.get(i) ) {
                indegree[j]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i]==0){
                queue.add(i);            }
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            int node = queue.peek();
            queue.remove();
            cnt++;
            for (int num : adj.get(node)) {
                indegree[num]--;
                if (indegree[num]==0) {
                    queue.add(num);
                }
            }
        }
        if (cnt==numCourses){
            return true;
        }else{
            return false;
        }
    }
}
