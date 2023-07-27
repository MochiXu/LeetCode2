package top150;

import java.util.Arrays;

public class candy_135 {
    public int candy(int[] ratings) {
        int[] changed = new int[ratings.length];
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i=0; i<ratings.length; i++){
            // 向左
            int left = i;
            while (left>0 && ratings[left-1]>ratings[left] && candies[left-1]<=candies[left]){
                candies[left-1]=candies[left]+1;
                left--;
            }
            int right = i;
            while (right<ratings.length-1 && ratings[right+1]>ratings[right] && candies[right+1]<=candies[right]){
                candies[right+1]=candies[right]+1;
                right++;
            }
            i=right;
        }
        return Arrays.stream(candies).sum();  // 使用流求和
    }
    public static void main(String[] args){
        candy_135 c = new candy_135();
        System.out.println(c.candy(new int[]{1,0,2}));
    }
}
