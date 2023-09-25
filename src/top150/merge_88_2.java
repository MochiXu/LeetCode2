package top150;

public class merge_88_2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n <= 0) {
            return;
        }
        int index1 = m - 1;
        int index2 = n - 1;
        int reIndex = nums1.length - 1;
        while (reIndex >= 0 && index1 >= 0 && index2 >= 0) {
            if (nums1[index1] >= nums2[index2]) {
                nums1[reIndex] = nums1[index1--];
            } else {
                nums1[reIndex] = nums2[index2--];
            }
            reIndex--;
        }
        while (reIndex>=0&&index1>=0){
            nums1[reIndex--]=nums1[index1--];
        }
        while (reIndex>=0&&index2>=0){
            nums1[reIndex--]=nums2[index2--];
        }
    }
}
