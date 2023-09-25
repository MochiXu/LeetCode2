package top150;

import java.math.BigInteger;

public class trailingZeroes_172 {
    public int trailingZeroes(int n) {
        // 找到能凑出来 5 的个数
        int count=0;
        for (int i=5; i<=n; i+=5){
            for (int x=i; x%5==0; x/=5){
                count+=1;
            }
        }
        return count;
    }
    public static void main(String[] args){
        trailingZeroes_172 t = new trailingZeroes_172();
        System.out.println(t.trailingZeroes(15));
    }
}
