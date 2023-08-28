package top150;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class findMaximizedCapital_502 {

    class IPO {
        public int profit;
        public int capital;
        public IPO(int profit, int capital){
            this.profit = profit;
            this.capital = capital;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        ArrayList<IPO> list = new ArrayList<>();
        PriorityQueue<IPO> queue = new PriorityQueue<>((a,b)->{return b.profit-a.profit;});
        for (int i=0; i<profits.length; i++){
            list.add(new IPO(profits[i], capital[i]));
        }
        list.sort((a,b)->{return a.capital-b.capital;});
        int i=0;
        while (k>0){
            while (i<list.size() && list.get(i).capital<=w){
                queue.add(list.get(i++));
            }
            if (queue.size()==0){
                return w;
            }
            w+=queue.poll().profit;

            k--;
        }
        return w;
    }

    public static void main(String[] args){
        findMaximizedCapital_502 f = new findMaximizedCapital_502();
        System.out.println(f.findMaximizedCapital(2,0,new int[]{1,2,3},new int[]{0,1,1}));
    }
}
