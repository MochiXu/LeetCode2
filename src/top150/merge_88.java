package top150;

public class merge_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int s1=m-1, s2=n-1, s3=m+n-1;
        while (s2!=-1){
            if(nums2[s2]>=nums1[s1]){
                nums1[s3]=nums2[s2];
                s3--;
                s2--;
            }else {
                nums1[s3]=nums1[s1];
                s1--;
                s3--;
            }
        }
    }
}
