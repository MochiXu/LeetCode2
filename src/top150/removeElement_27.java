package top150;

public class removeElement_27 {

    public void moveForward(int[] nums, int leftIndex, int step){
        for (int i=leftIndex; i<nums.length; i++){
            nums[i-step] = nums[i];
        }
    }

    public int removeElement(int[] nums, int val) {
        int count=0;
        for (int i=0; i<nums.length; i++){
            if (nums[i]==val){
                count++;
            }
        }
        int preIndex=0;
        for (int i=0; i<nums.length; i++){
            if (nums[i]==val){
                preIndex=i;
                // 遇到目标元素，则持续向右探测
                int j=i;
                while (j<nums.length&&nums[j]==val){
                    j++;
                }
                if(j<nums.length){
                    preIndex=j;
                }
                moveForward(nums, j, j-i);
                if (j>=nums.length){
                    break;
                }
                i--;
            }
        }
        return nums.length-count;
    }

    public static void main(String[] args){
        removeElement_27 r = new removeElement_27();
        System.out.println(r.removeElement(new int[]{3,2,2,3}, 3));
//        System.out.println(r.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
        //[]
        //2
    }
}
