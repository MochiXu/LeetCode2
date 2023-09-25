package top150;

public class removeElement_27_2 {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        int pre = index;
        int count = 0;
        while (index < nums.length && pre < nums.length){
            if(nums[index]==val) {
                // 将 index 移动到右侧首个非 val 元素
                while (index < nums.length && nums[index] == val) {
                    index++;
                }
                if (index>=nums.length){
                    break;
                }
                // index 需要和 pre 交换位置
                int temp = nums[index];
                nums[index] = nums[pre];
                nums[pre] = temp;
                pre++;
            }else {
                if (nums[pre]!=val){
                    pre++;
                }
                if(nums[index]!=val){
                    index++;
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args){
        removeElement_27_2 r = new removeElement_27_2();
        int[] temp = new int[]{0,1,2,2,3,2,4,2,8};
        int count = r.removeElement(temp, 2);
        System.out.println(count);
    }
}
