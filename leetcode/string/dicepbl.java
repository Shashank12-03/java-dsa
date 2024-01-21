package string;
public class dicepbl {
    public static void main(String[] args) {
        dcomb(4,"");
    }
    static void dcomb( int target, String p){
        if(target==0){
            System.out.println(p);
            return;
        }
        for(int i=1;i<=target && i<=6;i++){
            dcomb(target-i, p+i);
        }
    }
}
