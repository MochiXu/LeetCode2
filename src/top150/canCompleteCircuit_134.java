package top150;

import java.util.ArrayList;
import java.util.Arrays;

public class canCompleteCircuit_134 {
    public int getIndex(int[] node){
        ArrayList<Integer> arrNodes = new ArrayList<>();
        ArrayList<Integer> arrIndex = new ArrayList<>();
        for (int i=0; i<node.length; i++){
            int j=i+1;
            int temp=node[i];
            while (j<node.length){
                if ((node[i]<0&&node[j]<0) || (node[i]>0&&node[j]>0)){
                    temp+=node[j];
                }else {
                    break;
                }
                j++;
            }
            arrNodes.add(temp);
            arrIndex.add(i);
            i=j-1;
        }
        for (int i=0; i<arrNodes.size()-1;i++){
            if(arrNodes.get(i) >0&& arrNodes.get(i) + arrNodes.get(i + 1)>=0){
                return arrIndex.get(i);
            }
        }
        return arrIndex.get(arrIndex.size()-1);
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] node = new int[gas.length];
        int sum=0;
        for (int i=0; i < gas.length; i++){
            node[i]=gas[i]-cost[i];
            sum+=node[i];
        }
        if(sum<0){
            return -1;
        }
        return getIndex(node);
    }
    public static void main(String[] args){
        canCompleteCircuit_134 c = new canCompleteCircuit_134();
//        System.out.println(c.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
        System.out.println(c.canCompleteCircuit(new int[]{3,1,1}, new int[]{1,2,2}));
    }
}
