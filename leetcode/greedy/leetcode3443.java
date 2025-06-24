package greedy;


public class leetcode3443 {
    public static void main(String[] args) {
        leetcode3443 sol = new leetcode3443();
        System.out.println(sol.maxDistance("EEWWS",1));
    }
    public int maxDistance(String str, int k) {
        // n = y+1
        // s = y-1
        // e = x+1
        // w = x-1
        int n = 0;
        int s = 0;
        int e = 0;
        int w = 0;
        int ans = 0;
        for(char ch:str.toCharArray()){
            if(ch=='N'){
                n++;
            }
            else if(ch=='S'){
                s++;
            }
            else if(ch=='E'){
                e++;
            }
            else {
                w++;
            }
            ans = Math.max(ans, Math.abs(n-s) + Math.abs(e-w));
        }
        if (k==0) {
            return ans; 
        }
        if(s==0 && n==0){
            return Math.max(w,e) + Math.min(Math.min(w,e),k);
        }
        if(e==0 && w==0){
            return Math.max(s,n) + Math.min(Math.min(s,n),k);
        }
        if(n>=s){
            // when n is greater than s so we have to cancel whatever number of s under k to increase after that if we remain with k then we will think about canceling whatever smaller between e and w
            int maxN = 0;
            if(s!=0){
                if(k>=s){
                    maxN = s;
                    k -= s;
                }
                else{
                    maxN = k;
                    k = 0;
                }
            } 
            if(e!=0 && w>=e){
                if(k>=e){
                    return Math.abs(n+maxN) + Math.abs(w+e); 
                }
                else{
                    return Math.abs(n+maxN) + Math.abs(w+k); 
                }
            }  
            else if(w!=0 && e>=w){
                if(k>=w){
                    return Math.abs(n+maxN) + Math.abs(w+e); 
                }
                else{
                    return Math.abs(n+maxN) + Math.abs(e+k); 
                }
            }
        }
        if(s>=n){
            int maxS = 0;
            if(n!=0){
                if(k>=n){
                    maxS = n;
                    k -= n;
                }
                else{
                    maxS = k;
                    k = 0;
                } 
            }
            if(e!=0 && w>=e){
                if(k>=e){
                    return Math.abs(s+maxS) + Math.abs(w+e); 
                }
                else{
                    return Math.abs(s+maxS) + Math.abs(w+k); 
                }
            }  
            else if(w!=0 && e>=w){
                if(k>=w){
                    return Math.abs(s+maxS) + Math.abs(w+e); 
                }
                else{
                    return Math.abs(s+maxS) + Math.abs(e+k); 
                }
            }
        }
        return n+w+s+e;
    }
}
