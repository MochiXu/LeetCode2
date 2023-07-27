package top150;

import java.util.ArrayList;

public class isPalindrome_125 {
    public boolean isPalindrome(String s) {
        char[] raw = s.toCharArray();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i=0; i<raw.length; i++){
            if(raw[i]<=90&&raw[i]>=65){
                arr.add(raw[i]+32);
            } else if ((raw[i] >= 48 && raw[i] <= 57) || (raw[i] >= 97 && raw[i] <= 122)) {
                arr.add((int)raw[i]);
            }
        }
        int left=0, right=arr.size()-1;
        while (left<=right){
            if(arr.get(left)!=arr.get(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args){
        isPalindrome_125 i = new isPalindrome_125();
        System.out.println(i.isPalindrome("9"));
    }
}
