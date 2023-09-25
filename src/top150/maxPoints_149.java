package top150;

public class maxPoints_149 {
    public int maxPoints(int[][] points) {
        int re=points.length>=2?2:points.length==0?0:1;
        for (int i=0; i<points.length; i++){
            for (int j=i+1; j<points.length; j++){
                int temp=0;
                for (int t=0; t<points.length; t++){
                    if ((points[t][0]-points[i][0])*(points[j][1]-points[i][1])==(points[t][1]-points[i][1])*(points[j][0]-points[i][0])){
                        temp+=1;
                    }
                }
                re=Math.max(re,temp);
            }
        }
        return re;
    }

    public static void main(String[] args){
        maxPoints_149 m = new maxPoints_149();
        System.out.println(m.maxPoints(new int[][]{{4,5},{4,-1},{4,0}}));
    }
}
