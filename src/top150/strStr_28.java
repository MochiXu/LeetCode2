package top150;

public class strStr_28 {
    public int strStr(String haystack, String needle) {
        char[] left = haystack.toCharArray();
        char[] right = needle.toCharArray();
        for (int i=0; i<left.length; i++){
            int preI=i;
            int j=0;
            while (j<right.length && right[j]==left[i]){
                j++;
                i++;
            }
            if(j==right.length){
                return preI;
            }
//            i--;
            i=preI;
        }
        return -1;
    }
    public static void main(String[] args){
        strStr_28 s = new strStr_28();
        System.out.println(s.strStr("mississippi", "issip"));
    }
}
