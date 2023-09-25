package top150;

public class rangeBitwiseAnd_201 {
    public int rangeBitwiseAnd(int left, int right) {
        int prefix=0;
        while (left<right){
            left=left>>1;
            right=right>>1;
            prefix++;
        }
        return left<<prefix;
    }

    public static void main(String [] args){
        rangeBitwiseAnd_201 r = new rangeBitwiseAnd_201();
        System.out.println(r.rangeBitwiseAnd(5, 7));
    }
}
