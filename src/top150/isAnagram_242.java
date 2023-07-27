package top150;

import java.lang.reflect.Array;
import java.util.Arrays;

public class isAnagram_242 {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        char[] arrayS = s.toCharArray();
        char[] arrayT = t.toCharArray();
        Arrays.sort(arrayS);
        Arrays.sort(arrayT);
        for (int i=0; i<s.length(); i++){
            if (arrayS[i]!=arrayT[i]){
                return false;
            }
        }
        return true;

    }
}
