package top150;

import java.util.HashMap;

public class canConstruct_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> source = new HashMap<>();
        for (char c : magazine.toCharArray()){
            if (source.containsKey(c)){
                source.put(c, source.get(c)+1);
            }else {
                source.put(c, 1);
            }
        }
        for (char c : ransomNote.toCharArray()){
            if (source.containsKey(c)&&source.get(c)>0){
                source.put(c, source.get(c)-1);
            }else {
                return false;
            }
        }
        return true;
    }
}
