package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class dictonary {
    public static void main(String[] args) {
        
    }
    public String findOrder(String[] dict, int k) {
        // Write your code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<k;i++){
            adj.add(new ArrayList<>());
        }
        for (int i = 0;i<dict.length-1;i++){
            String str1 = dict[i];
            String str2 = dict[i+1];
            int len = Math.min(str1.length(),str2.length());
            for(int j = 0;j<len;j++){
                if(str1.charAt(j)!=str2.charAt(j)){
                    adj.get(str1.charAt(j)-'a').add(str2.charAt(j)-'a');
                    break;
                }
            }
        }
        List<Integer> list = topoSort(k,adj);
        StringBuilder ans = new StringBuilder();
        for(int i:list){
            ans.append((char)(i + (int)'a'));
        }
        return ans.toString();
        
    }
    
    private List<Integer> topoSort(int k , List<List<Integer>> adj){
        int[] indegree = new int[k];
        for(int i = 0;i<k;i++){
            for(int num:adj.get(i)){
                indegree[num]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<k;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            int vertex = queue.peek();
            queue.remove();
            list.add(vertex);
            for(int node:adj.get(vertex)){
                indegree[node]--;
                if(indegree[node]==0){
                    queue.add(node);
                }
            }
        }
        return list;
    }
}
