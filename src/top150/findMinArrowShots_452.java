package top150;

import java.util.Arrays;
import java.util.Comparator;

public class findMinArrowShots_452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length==0){return 0;}
        if (points.length==1){return 1;}
        Arrays.sort(points, Comparator.comparingInt(o->o[0]));
        int re=0;
        for (int i=0; i < points.length; i++){
            int innerLeft = points[i][0];
            int innerRight = points[i][1];
            boolean collapse=false;
            while (i<points.length && points[i][0]<=innerRight && (innerRight>=innerLeft)){
                collapse=true;
                innerRight=Math.min(points[i][1],innerRight);
                innerLeft=Math.max(points[i][0],innerLeft);
                i++;
            }
            re+=1;
            if (collapse)i-=1;
        }
        return re;
    }
    public static void main(String[] args){
        findMinArrowShots_452 f = new findMinArrowShots_452();
//        System.out.println(f.findMinArrowShots(new int[][]{{1,2},{3,4},{5,6},{7,8}}));
//        System.out.println(f.findMinArrowShots(new int[][]{{-1,1},{0,1},{2,3},{1,2}}));
        System.out.println(f.findMinArrowShots(new int[][]{{-2147483648,2147483647},{-2147483648,2147483647}}));
//        int[] arr = new int[]{-2147483646, 2147483646};
//        int[] arr1 = new int[]{2147483646, -2147483646};
//        int[][] arr2 = new int[][]{{-2147483648,2147483647},{-2147483648,2147483647}};
//        Arrays.sort(arr);
//        Arrays.sort(arr1);
//        Arrays.sort(arr2, Comparator.comparingInt(o->o[0]));
//        System.out.println(-2147483646-2147483646);
        System.out.println(-2147483646-2147483646);
    }
}
