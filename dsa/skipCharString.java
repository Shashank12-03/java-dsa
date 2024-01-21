public class skipCharString {
    public static void main(String[] args) {
        skipChar("", "bacccdah");
        System.out.println(skipString("baccappledah"));
    }
    static void skipChar(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        if(ch=='a'){
            skipChar(p, up.substring(1));
        }
        else{
            skipChar(p+ch, up.substring(1));
        }
    }
    static String skipString(String up){
        if(up.isEmpty()){
            return " ";
        }
        if(up.startsWith("apple")){
            return skipString(up.substring(5));
        }
        else{
            return up.charAt(0)+skipString(up.substring(1));
        }
    }
    static String skipStringnotsubstring(String up){
        if(up.isEmpty()){
            return " ";
        }
        if(up.startsWith("app")&& !up.startsWith("apple")){
            return skipStringnotsubstring(up.substring(3));
        }
        else{
            return up.charAt(0)+skipStringnotsubstring(up.substring(1));
        }
    }
}
