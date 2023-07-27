package top150;

import java.util.HashMap;

public class isHappy_202 {

    public int getAns(int n){
        int ans =0;
        while (n/10>0){
            ans+=Math.pow(n%10,2);
            n/=10;
        }
        if (n%10!=0){
            ans+=Math.pow(n%10,2);
        }
        return ans;
    }

    public boolean isHappy(int n) {
        HashMap hashMap = new HashMap();
        int temp = getAns(n);
        while (temp!=1){
            if (hashMap.containsKey(temp)){
                return false;
            }else {
                hashMap.put(temp,1);
            }
            temp=getAns(temp);
        }
        return true;
    }
    public static void main(String[] args){
        isHappy_202 i = new isHappy_202();
        System.out.println(i.isHappy(1));
    }
}
