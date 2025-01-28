package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class leetcode1462 {
    
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{2, 3}, {2, 1}, {0, 3}, {0, 1}};
        int[][] queries = {{0, 1}, {0, 3}, {2, 3}, {3, 0}, {2, 0}, {0, 2}};
        
        leetcode1462 obj = new leetcode1462();
        List<Boolean> result = obj.checkIfPrerequisite(numCourses, prerequisites, queries);
        
        // System.out.println("Prerequisites in graph form:");
        // for (int i = 0; i < numCourses; i++) {
        //     System.out.print(i + ": ");
        //     for (int j = 0; j < prerequisites.length; j++) {
        //     if (prerequisites[j][0] == i) {
        //         System.out.print(prerequisites[j][1] + " ");
        //     }
        //     }
        //     System.out.println();
        // }
        
        System.out.println("Query results:");
        for (Boolean res : result) {
            System.out.println(res);
        }
    }
    List<Integer> list;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        if(prerequisites.length==0){
            List<Boolean> ans = new ArrayList<>();
            for(int[] query:queries){
                ans.add(false);
            } 
            return ans;
        }
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] prerequisite:prerequisites){
            adj.get(prerequisite[0]).add(prerequisite[1]);
        }
        list = new ArrayList<>();
        Map<Integer,Integer> map = topoSort(numCourses,adj);
        List<Boolean> ans = new ArrayList<>();
        for(int[] query:queries){
            if (list.contains(query[1])) {
                ans.add(false);
            }
            else if(map.get(query[0])<map.get(query[1])){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
        } 
        return ans;
    }
    private Map<Integer,Integer> topoSort(int numCourses, List<List<Integer>> adj){
        int[] indegree = new int[numCourses];
        for(int i = 0;i<numCourses;i++){
            for(int num:adj.get(i)){
                indegree[num]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<numCourses;i++){
            if(indegree[i]==0){
                list.add(i);
                queue.add(i);
            }
        }
        Map<Integer,Integer> map = new HashMap<>();
        int i = 0;
        while(!queue.isEmpty()){
            int vrtx = queue.poll();
            map.put(vrtx,i);
            i++;
            for(int node:adj.get(vrtx)){
                indegree[node]--;
                if(indegree[node]==0){
                    queue.add(node);
                }
            }
        }
        return map;
    }
}
