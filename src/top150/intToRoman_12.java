package top150;

public class intToRoman_12 {
    public String intToRoman(int num) {
        String ans = "";
        int[] number = new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] roman = new String[]{"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        for (int i=number.length-1; i>=0; i--){
            if(num==0){
                break;
            }
            while (num>=number[i]&&num!=0){
                ans+=roman[i];
                num-=number[i];
            }
        }
        return ans;
    }
    public static void main(String[] args){
        intToRoman_12 i = new intToRoman_12();
        System.out.println(i.intToRoman(58));
    }
}
