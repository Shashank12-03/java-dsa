package string;


public class leetcode1061 {
    public static void main(String[] args) {
        leetcode1061 solution = new leetcode1061();
        String s1 = "leetcode";
        String s2 = "programs";
        String baseStr = "sourcecode";
        System.out.println(solution.smallestEquivalentString(s1, s2, baseStr));
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // l=p p=l [l,p] 
        // r=e e=r [e,r]
        // e=o o=e [r,e,o]
        // t=g g=t [t,g] = [g,t]
        // c=r r=c [r,c,e,o]
        // o=a a=o [r,c,e,o,a]
        // d=m m=d [d,m]
        // e=s s=e [r,c,e,o,a,s] = [a,c,e,o,r,s]
        int n = s1.length();
        int[] parent = new int[26];
        for(int i = 0;i<n;i++){
            parent[s1.charAt(i)-'a'] = s1.charAt(i)-'a';
        }

        for(int i = 0;i<n;i++){
            int x = s1.charAt(i) - 'a';
            int y = s2.charAt(i) - 'a';
            int parentX = findParent(parent, x);
            int parentY = findParent(parent, y);
            if (parentX == parentY) {
                continue;
            }
            if (parentX < parentY) {
                parent[parentY] = parentX;
            } else {
                parent[parentX] = parentY;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            int parentChar = findParent(parent, c - 'a');
            sb.append((char) (parentChar + 'a'));
        }
        return sb.toString();
    }
    private int findParent(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = findParent(parent, parent[x]);
    }
}
