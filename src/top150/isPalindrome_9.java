package top150;

public class isPalindrome_9 {
    public boolean isPalindrome(int x) {
        if(x<0 || x%10==0){
            return false;
        }
        int inverted = 0;
        while (x>inverted){
            int temp = x%10;
            x=x/10;
            inverted=inverted*10+temp;
        }
        return x==inverted || x==inverted/10;
    }
    public static void main(String[] args){
        isPalindrome_9 i = new isPalindrome_9();
        System.out.println(i.isPalindrome(121));
    }
}
