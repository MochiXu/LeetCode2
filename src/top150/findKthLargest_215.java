package top150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class findKthLargest_215 {
    Random random = new Random();
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length-1);
//        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        return nums[k-1];
    }

    public void quickSort(int[] nums, int begin, int end){
        if (begin<end){
            int re = partition(nums, begin, end);
            quickSort(nums, begin, re);
            quickSort(nums, re+1, end);
        }
    }

    public int partition(int[] nums, int begin, int end){
        int randMid = random.nextInt(end)%(end-begin+1)+begin;
        int pivot = nums[randMid];
        int low = begin;
        int high = end;
        while (true){
            while (low<=high && nums[low]<pivot){
                low++;
            }
            while (low<=high && nums[high]>pivot){
                high--;
            }
            // 如果两个指针相遇/交叉, 则返回 high
            if (low>=high){
                return high;
            }
            // 调换左右两侧端点
            swap(nums, low, high);
            low++;
            high--;
        }
    }
    public void swap(int[]nums, int low, int height){
        int temp = nums[low];
        nums[low]=nums[height];
        nums[height]=temp;
    }


    public static void main(String[] args){
        findKthLargest_215 f = new findKthLargest_215();
        f.findKthLargest(new int[]{4,-1,2,9,-8,5,23,3},2);
    }
}
