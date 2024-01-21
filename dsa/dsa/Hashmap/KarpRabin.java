package dsa.Hashmap;

public class KarpRabin {
    private static int prime=101;
    private static double CalculateHash(String str){
        double hash=0;
        for(int i=0;i<str.length();i++){
            hash+=str.charAt(i)*Math.pow(prime, i);
        }
        return hash;
    }
    private static double UpdateHash(double prevhash, char oldchar,char newchar, int length){
        double newhash=(prevhash-oldchar)/prime;
        newhash=newhash+newchar*Math.pow(prime,length-1);
        return newhash;
    }
    public static void search(String text, String pattern){
        int patternlength=pattern.length();
        long patternhash=(long)CalculateHash(pattern);
        long texthash=(long)CalculateHash(text.substring(0, patternlength));
        for(int i=0;i<=text.length()-patternlength;i++){
            if(texthash==patternhash){
                if(text.substring(i, i+patternlength).equals(pattern)){
                    System.out.println("Pattern found at index "+i);
                }
            }
            if(i<text.length() -patternlength){
                texthash=(long)UpdateHash(texthash,text.charAt(i),text.charAt(i+patternlength),patternlength);
            }
        }
    }
    public static void main(String[] args) {
        search("Apoorvkunalrahul", "kunal");
    }
}
