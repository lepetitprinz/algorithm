package string;

import java.util.HashMap;

/*
 205. Isomorphic Strings

 Test Examples
 - s = "egg", t = "add"
 - s = "foo", t = "acd"
 - s = "badc", t = "baba"
 */

public class No205 {
    private static final String s = "badc";
    private static final String t = "baba";

    public static void main(String[] args) {
        boolean result = isIsomorphic(s, t);
        System.out.println(result);
    }

    private static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> stMap = new HashMap<>();
        HashMap<Character, Character> tsMap = new HashMap<>();

        boolean flag = true;
        for (int i=0; i<s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (stMap.containsKey(sChar)) {
                if (stMap.get(sChar) != tChar) {
                    flag = false;
                    break;
                }
            } else {
                stMap.put(sChar, tChar);
            }

            if (tsMap.containsKey(tChar)) {
                if (tsMap.get(tChar) != sChar) {
                    flag = false;
                    break;
                }
            } else {
                tsMap.put(tChar, sChar);
            }
        }

        return flag;
    }
}
