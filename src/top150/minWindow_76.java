package top150;

import java.util.HashMap;

public class minWindow_76 {
    public String minWindow(String s, String t) {
        if (s.length()<t.length()){
            return "";
        }
        if (s.length()==1&&t.length()==1&&!s.equals(t)){
            return "";
        }
        char[] arrayS = s.toCharArray();
        char[] arrayT = t.toCharArray();
        HashMap<Character, Integer> hashMapT = new HashMap<>();
        HashMap<Character, Integer> hashMapS = new HashMap<>();
        int re = 0;
        int reLeft = 0;
        int reRight = 0;
        for (int i=0; i<arrayT.length; i++){
            if (hashMapT.containsKey(arrayT[i])){
                hashMapT.put(arrayT[i], hashMapT.get(arrayT[i])+1);
            } else {
                hashMapT.put(arrayT[i], 1);
            }
        }
        int left =0;
        int right=0;
        // 记录首次出现的覆盖子串
        boolean hasValid=false;
        for (int i=0; i<s.length(); i++){
            // 加入正在遍历的字符串
            if (hashMapT.containsKey(arrayS[i])) {
                if (hashMapS.containsKey(arrayS[i])) {
                    hashMapS.put(arrayS[i], hashMapS.get(arrayS[i]) + 1);
                } else {
                    hashMapS.put(arrayS[i], 1);
                }
            }
            // 判断是否已经变成第一个合法的覆盖子串
            boolean valid = true;
            for (int j=0; j<t.length(); j++){
                if (!hashMapS.containsKey(arrayT[j])){
                    valid = false;
                    break;
                }else {
                    if (hashMapS.get(arrayT[j])<hashMapT.get(arrayT[j])){
                        valid = false;
                        break;
                    }
                }
            }
            if (valid){
                hasValid=true;
                // 将左侧的长度缩短
                while (left<=i){
                    if (hashMapT.containsKey(arrayS[left])){
                        if (hashMapS.get(arrayS[left])>hashMapT.get(arrayS[left])){
                            hashMapS.put(arrayS[left], hashMapS.get(arrayS[left])-1);
                            left++;
                        }else {
                            // 不可再缩短左侧长度了
                            break;
                        }
                    } else {
                        left++;
                    }
                }

                right = i;
                re=right-left+1;
                reRight=right;
                reLeft=left;
                break;
            }
        }
        if (!hasValid){
            return "";
        }
        while (left<=right&&right<s.length()){
            right++;
            //向右扩展
            while (right<s.length()){
                if ( hashMapT.containsKey(arrayS[right])){
                    hashMapS.put(arrayS[right], hashMapS.get(arrayS[right])+1);
                    break;
                }
                right++;
            }
            // 缩短左侧的长度
            while (left<right){
                if (hashMapT.containsKey(arrayS[left])){
                    if (hashMapS.get(arrayS[left])>hashMapT.get(arrayS[left])){
                        hashMapS.put(arrayS[left], hashMapS.get(arrayS[left])-1);
                        left++;
                    }else {
                        // 不可再缩短左侧长度了
                        break;
                    }
                } else {
                  left++;
                }
            }
            // 更新 re
            if ((right-left+1)<re){
                re=right-left+1;
                reLeft=left;
                reRight=right;
            }
        }
        return s.substring(reLeft,reRight+1);
    }

    public static void main(String[] args){
        minWindow_76 m = new minWindow_76();
//        System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));
//        System.out.println(m.minWindow("a", "aa"));
//        System.out.println(m.minWindow("ab", "A"));
        System.out.println(m.minWindow("cfabeca", "cae"));
    }

}
