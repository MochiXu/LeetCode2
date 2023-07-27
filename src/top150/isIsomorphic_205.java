package top150;

import java.util.HashMap;

public class isIsomorphic_205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        HashMap<Character, Character> sourceToTarget = new HashMap<>();
        HashMap<Character, Character> targetToSource = new HashMap<>();
        char[] source = s.toCharArray();
        char[] target = t.toCharArray();
        for (int i=0; i<s.length(); i++){
            if (sourceToTarget.containsKey(source[i])){
                if (target[i]!=sourceToTarget.get(source[i])) {
                    return false;
                }
            }else {
                sourceToTarget.put(source[i], target[i]);
            }

            if(targetToSource.containsKey(target[i])) {
                if (source[i] != targetToSource.get(target[i])) {
                    return false;
                }
            }else {
                targetToSource.put(target[i], source[i]);
            }
        }
        return true;
    }

    public static void main(String[] args){
        isIsomorphic_205 i = new isIsomorphic_205();
        System.out.println(i.isIsomorphic("badc","baba"));
    }
}
