package top150;

import java.util.LinkedList;
import java.util.Collections;

public class MedianFinder_295 {
    LinkedList<Integer> list;
    public MedianFinder_295() {
        list = new LinkedList<>();
    }

    public void addNum(int num) {
        // 二分查找并插入
        int left=0;
        int right=list.size()-1;
        while (left<=right){
            int mid = (left+right)/2;
            if (list.get(mid)<num){
                left=mid+1;
            }else if (list.get(mid)>num){
                right=mid-1;
            }else {
                left=mid;
                break;
            }
        }
        // 使用自带的二分查找函数也能够找到插入的位置, 需要注意的是正负的处理
//  int in=Collections.binarySearch(list, num);
//        if (in < 0) {
//            in = -(in + 1);
//        }
        list.add(left, num);
    }

    public double findMedian() {
        if (list.size()%2==0){
            return (list.get(list.size()/2)+list.get(list.size()/2-1))/2.0;
        }else {
            return list.get(list.size()/2);
        }
    }

    public static void main(String[] args){
        MedianFinder_295 m = new MedianFinder_295();
        m.addNum(41);
        m.addNum(14);
        m.addNum(9);
        m.addNum(28);
        m.addNum(6);
        m.addNum(3);
        System.out.println(m.findMedian());
    }
}
