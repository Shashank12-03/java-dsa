package stack;
import java.util.*;

class StockSpanner {
    class Pair{
        int val;
        int grt;
        Pair(int val,int grt){
            this.val=val;
            this.grt=grt;
        }
    }
    Stack<Pair> stock;
    int count ;
    public StockSpanner() {
        stock = new Stack<>();
        count = -1;
    }

    public int next(int price) {
        count = count + 1;
        while(!stock.isEmpty() && stock.peek().val<=price){
            stock.pop();
        }
        int ans = count - (stock.isEmpty()? -1: stock.peek().grt);
        stock.add(new Pair(price,count));
        return ans;
    }
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); 
        System.out.println(stockSpanner.next(80));// return 1
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }
}
