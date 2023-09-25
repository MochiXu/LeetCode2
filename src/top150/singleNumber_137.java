package top150;

public class singleNumber_137 {
    public int singleNumber(int[] nums) {
        int one=0, two=0;
        for (int i=0; i<nums.length; i++){
            // 某二进制位在 one 内出现了(即为 1), 并且当前 nums[i] 的二进制位也为 1, 说明出现了两次, two 置为 1
            two = two | one&nums[i];
            // 某二进制位在 one 内没有出现, 当前的 nums[i] 二进制位为 1, 属于首次出现
            // 某二进制位在 one 内出现了 1 次, 当前的 nums[i] 二进制位为 1, 属于第二次出现, 则 one 应当置为 0
            one = one ^ nums[i];
            // 若二进制位出现了 3 次, 则 two 和 one 会同时为 1, 取 two 和 one 的交集
            // 出现 1 次, one=1, two=0
            // 出现 2 次, one=0, two=1
            // 出现 3 次, one=1, two=1
            int three = one & two;
            // 将 one 和 two 内出现 3 次的二进制位变成 0
            one = one & ~three;
            two = two & ~three;
        }
        return one;
    }
}
