package top150;

import java.util.HashMap;

public class wordPattern_290 {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> charToString = new HashMap<>();
        HashMap<String, Character> stringToChar = new HashMap<>();
        char[] patternArr = pattern.toCharArray();
        String[] strArr = s.split(" ");
        if (patternArr.length!=strArr.length){
            return false;
        }
        for (int i=0; i< patternArr.length; i++){
            if (charToString.containsKey(patternArr[i])){
                if (!charToString.get(patternArr[i]).equals(strArr[i])){
                    return false;
                }
            }else {
                if (stringToChar.containsKey(strArr[i])){
                    return false;
                }
                charToString.put(patternArr[i], strArr[i]);
                stringToChar.put(strArr[i],patternArr[i]);
            }
        }
        return true;
    }

    public static void main(String[] args){
        wordPattern_290 w = new wordPattern_290();
        System.out.println(w.wordPattern("abba", "dog cat cat dog"));
    }
}
