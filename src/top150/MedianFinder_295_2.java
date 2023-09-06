package top150;

import java.util.LinkedList;
import java.util.Collections;
import java.util.PriorityQueue;

// 使用两个堆维护中位数，需要考虑好边界条件，转换条件
public class MedianFinder_295_2 {
    PriorityQueue<Integer> queMax;
    PriorityQueue<Integer> queMin;
    public MedianFinder_295_2() {
        queMax = new PriorityQueue<>((a,b)->a-b);
        queMin = new PriorityQueue<>((a,b)->b-a);
    }

    public void addNum(int num) {
        if (queMin.isEmpty() || num<=queMin.peek()){
            queMin.add(num);
            if (queMin.size()>queMax.size()+1){
                queMax.add(queMin.poll());
            }
        }else {
            queMax.add(num);
            // 边界需要考虑清楚
            if (queMax.size()>queMin.size()){
                queMin.add(queMax.poll());
            }
        }
    }

    public double findMedian() {
        if (queMin.size()>queMax.size()){
            return queMin.peek();
        }else {
            return (queMin.peek()+queMax.peek())/2.0;
        }
    }

    public static void main(String[] args){
        MedianFinder_295_2 m = new MedianFinder_295_2();
        m.addNum(41);
        m.addNum(14);
        m.addNum(9);
        m.addNum(28);
        m.addNum(6);
        m.addNum(3);
        System.out.println(m.findMedian());
    }
}
