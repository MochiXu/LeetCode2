package top150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class merge_56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (left, right)->{return left[0]-right[0];});
        List<int[]> re = new ArrayList<>();
        for (int i=0; i<intervals.length; i++){
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i+1<intervals.length&&right>=intervals[i+1][0]){
                i++;
                right=Math.max(intervals[i][1], right);
            }

            re.add(new int[]{left, right});
        }

        return re.toArray(new int[re.size()][2]);
    }
    public static void main(String[] args){
        merge_56 m = new merge_56();
        System.out.println(m.merge(new int[][]{{2,6},{1,3},{8,10},{15,18}}));
    }
}
