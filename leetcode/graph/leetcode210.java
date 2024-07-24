package graph;

import java.util.*;

public class leetcode210 {
    public static void main(String[] args) {
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(findOrder(4, prerequisites)));

    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] indegree = new int[numCourses];
        for(int i=0 ; i < numCourses; i++){
            for(int num:adj.get(i)){
                indegree[num]++;
            }
        }
        List<Integer> topo = new ArrayList<>();
        // int j =0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i< indegree.length;i++){
            if(indegree[i]==0){
                queue.add(i);
                topo.add(i);
            }
        }

        
        while(!queue.isEmpty()){
            int node = queue.peek();
            queue.remove();
            for(int no:adj.get(node)){
                indegree[no]--;
                if(indegree[no]==0){
                    queue.add(no);
                    topo.add(no);
                }
            }
        }
        if (topo.size()==numCourses){
            int[] courses = new int[numCourses];
            for(int i=0;i<numCourses;i++){
                courses[i] = topo.get(i);
            }
            return courses;
        }else{
            return new int[]{};
        }
    }
}
