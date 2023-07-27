package top150;

public class maxArea_11 {
    public int maxArea(int[] height) {
        int maxHeight = 0;
        for (int i=0; i<height.length; i++){
            maxHeight = Math.max(height[i], maxHeight);
        }
        int re=0;
        for (int h=maxHeight; h>0; h--){
            int left=0;
            int right=height.length-1;
            while (left<=right){
                if (height[left]<h){
                    left++;
                }else {
                    break;
                }
            }
            while (left<=right){
                if (height[right]<h){
                    right--;
                }else {
                    break;
                }
            }
            re=Math.max(re,(right-left)*h);
        }
        return re;
    }
    public static void main(String[] args){
        maxArea_11 m = new maxArea_11();
        System.out.println(m.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
