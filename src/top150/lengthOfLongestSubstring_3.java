package top150;

import java.util.HashMap;

public class lengthOfLongestSubstring_3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){return 0;}
        char[] chars = s.toCharArray();
        HashMap<Character,Integer> hashMap = new HashMap();
        int left=0;
        int right=0;
        int re=1;
        while (right< chars.length){
            if (!hashMap.containsKey(chars[right])){

                hashMap.put(chars[right],right);
                right++;
            }else {
                re =Math.max(right-left, re);
                left++;
                right=left;
                hashMap.clear();
            }
        }
        re =Math.max(right-left, re);
        return re;
    }
    public static void main(String[] args){
        lengthOfLongestSubstring_3 l = new lengthOfLongestSubstring_3();
        System.out.println(l.lengthOfLongestSubstring("dvdf"));
    }
}
