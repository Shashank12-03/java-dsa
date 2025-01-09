package graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class leetcode399 {

    static class Pair{
        String deno;
        double value;
        Pair(String deno, double value){
            this.deno = deno;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(List.of("a", "b"));
        equations.add(List.of("b", "c"));
        
        double[] values = {2.0, 3.0};
        
        List<List<String>> queries = new ArrayList<>();
        queries.add(List.of("a", "c"));
        queries.add(List.of("b", "a"));
        queries.add(List.of("a", "e"));
        queries.add(List.of("a", "a"));
        queries.add(List.of("x", "x"));
        
        leetcode399 obj = new leetcode399();
        double[] result = obj.calcEquation(equations, values, queries);
        
        for (double res : result) {
            System.out.println(res);
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] ans = new double[queries.size()];
        Map<String,List<Pair>> map = new HashMap<>();
        for(int i = 0;i<values.length;i++){
            List<String> eqn = equations.get(i);
            if(map.containsKey(eqn.get(0))){
                List<Pair> list = map.get(eqn.get(0));
                list.add(new Pair(eqn.get(1),values[i]));
            }
            else{
                List<Pair> list = new ArrayList<>();
                list.add(new Pair(eqn.get(1), values[i]));
                map.put(eqn.get(0), list);
            }
            if(map.containsKey(eqn.get(1))){
                List<Pair> list = map.get(eqn.get(1));
                list.add(new Pair(eqn.get(0),(double)(1/values[i])));
            }
            else{
                List<Pair> list = new ArrayList<>();
                list.add(new Pair(eqn.get(0), (double)(1 / values[i])));
                map.put(eqn.get(1), list);
            }
        }
        for(int i = 0;i<queries.size();i++){
            ans[i] = bfs(queries.get(i).get(0),queries.get(i).get(1),map);
        }
        return ans;
    }
    private double bfs(String src, String target, Map<String,List<Pair>> map){
        if(!map.containsKey(src) || !map.containsKey(target)){
            return -1.0;
        }
        Deque<Pair> deque = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        deque.offer(new Pair(src,1));
        visited.add(src);
        while(!deque.isEmpty()){
            Pair pair = deque.poll();
            String node = pair.deno;
            double val = pair.value;
            if(node.equals(target)){
                return val;
            }  
            List<Pair> list = map.get(node);
            for(Pair pr:list){
                if(!visited.contains(pr.deno)){
                    deque.offer(new Pair(pr.deno,pr.value*val));
                    visited.add(pr.deno);
                }
            }
        }
        return -1;
    }
}

