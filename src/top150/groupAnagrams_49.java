package top150;

import java.util.*;

//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
public class groupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (int i=0; i<strs.length; i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = String.copyValueOf(chars);
            if (hashMap.containsKey(s)){
                List<String> list = hashMap.get(s);
                list.add(strs[i]);
                hashMap.put(s, list);
            }else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                hashMap.put(s, list);
            }
        }
        ArrayList<List<String>> re = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry:hashMap.entrySet()){
            re.add(entry.getValue());
        }
        return re;
    }
    public static void main(String[] ars){
        groupAnagrams_49 g = new groupAnagrams_49();
        System.out.println(g.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
