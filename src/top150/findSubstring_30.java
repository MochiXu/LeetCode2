package top150;

import java.util.*;

public class findSubstring_30 {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String,Integer> hashMap = new HashMap();
        for (int i=0; i<words.length; i++){
            if (hashMap.containsKey(words[i])){
                hashMap.put(words[i],hashMap.get(words[i])+1);
            }else {
                hashMap.put(words[i], 1);
            }
        }
        ArrayList<Integer> re = new ArrayList<>();
        HashMap<String, Integer> currentHashMap = new HashMap<>();
        int currentHashMapSize = 0;
        for (int left=0; left<=(s.length()-words[0].length())&&left>=0; left++){
            int preLeft = left;
            int right=left+words[0].length()-1;
            while (right<s.length()&&hashMap.containsKey(s.substring(left,right+1))){
                String cur = s.substring(left,right+1);
                // 边界判断
                if (currentHashMap.containsKey(cur)&&currentHashMap.get(cur)>=hashMap.get(cur)){
                    break;
                }
                if (!currentHashMap.containsKey(cur)){
                    currentHashMap.put(cur, 1);
                }else {
                    currentHashMap.put(cur, currentHashMap.get(cur)+1);
                }
                currentHashMapSize++;

                if (currentHashMapSize==words.length){
                    // 添加到结果集里面
                    re.add(preLeft);
                    break;
                }else {
                    // 更新中间步骤
                    left+=words[0].length();
                    right=left+words[0].length()-1;
                }
            }
            currentHashMap.clear();
            currentHashMapSize=0;
            left=preLeft;
        }
        return re;
    }
    public static void main(String[] args){
        findSubstring_30 f = new findSubstring_30();
//        System.out.println(f.findSubstring("barfoothefoobarman",new String[]{"foo", "bar"}));
//        System.out.println(f.findSubstring("wordgoodgoodgoodbestword",new String[]{"word","good","best","word"}));
//        System.out.println(f.findSubstring("wordgoodgoodgoodbestword",new String[]{"word","good","best","word"}));
        System.out.println(f.findSubstring("a",new String[]{"a"}));
    }
}