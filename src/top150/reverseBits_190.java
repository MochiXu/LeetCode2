package top150;

/**
 * 颠倒给定的 32 位无符号整数的二进制位
 * Java 不存在无符号整数类型
 * */
public class reverseBits_190 {
    public int reverseBits(int n) {
        int res=0;
        for (int i=0; i<32; i++){
            res |= (n&1) << (31-i);
            n=n>>>1;
        }
        return res;
    }
}
