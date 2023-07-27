package top150;

import java.util.ArrayList;

public class insert_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        boolean added = false;
        for (int i=0; i<intervals.length; i++){
            int left = intervals[i][0];
            int right = intervals[i][1];

            if (left>newInterval[1]){
                if(!added){list.add(newInterval);}
                list.add(intervals[i]);
                added=true;
            }else if(right<newInterval[0]){
                list.add(intervals[i]);
            }else {
                newInterval[0]=Math.min(intervals[i][0], newInterval[0]);
                newInterval[1]=Math.max(intervals[i][1], newInterval[1]);
            }
        }
        if (!added){
            list.add(newInterval);
        }
        System.out.println("");
        return list.toArray(new int[list.size()][2]);
    }
    public static void main(String[] args){
        insert_57 i = new insert_57();
//        i.insert(new int[][]{{1,3},{6,9}}, new int[]{2,5});
        i.insert(new int[][]{{2,5},{6,7},{8,9}}, new int[]{0,1});
    }
}
