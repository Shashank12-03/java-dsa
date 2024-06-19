package backtracking;

import java.util.ArrayList;
import java.util.List;

public class binaryString {
    public static void main(String[] args) {
        List<String> result = generate_binary_string("1??0?101");
        for (String str : result) {
            System.out.println(str);
        }
    }

    public static List<String> generate_binary_string(String s) {
        List<String> list = new ArrayList<>();
        helper(0, s, list, "");
        return list;
    }

    private static void helper(int ind, String s, List<String> list, String str) {
        if (ind == s.length()) {
            list.add(str);
            return;
        }
        if (s.charAt(ind) == '?') {
            helper(ind + 1, s, list, str + '0');
            helper(ind + 1, s, list, str + '1');
        } else {
            helper(ind + 1, s, list, str + s.charAt(ind));
        }
    }
}
