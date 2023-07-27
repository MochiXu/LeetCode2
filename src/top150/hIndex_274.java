package top150;

import java.util.Arrays;

public class hIndex_274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        if (citations.length == 0 || citations[citations.length-1]==0){
            return 0;
        }
        int h=0;
        for (int i=citations.length-1; i>=0; i--){
            if (citations[i]>=(citations.length-i)){
                h++;
            }else {
                break;
            }
        }
        return h;
    }
    public static void main(String[] args){
        hIndex_274 h = new hIndex_274();
        System.out.println(h.hIndex(new int[]{1,3,1}));
    }
}
