package top150;

public class reverseWords_151 {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int index = 0;
        StringBuilder ans = new StringBuilder();
        StringBuilder inner = new StringBuilder();
        for (int i=0; i<arr.length; i++){
            if (arr[i]!=' '){
                index=i;
                break;
            }
        }
        for (int i=s.length()-1; i>=index; i--){
            if (arr[i]==' '){
                if (!inner.toString().equals("")){
                    ans.append((i == index) ? inner.toString() : (inner.toString() + ' '));
                    inner = new StringBuilder();
                }
            }else {
                inner.insert(0, arr[i]);
            }
        }
        if (!inner.toString().equals("")){
            ans.append(inner);
        }
        return ans.toString();
    }
    public static void main(String[] args){
        reverseWords_151 r = new reverseWords_151();
        System.out.println(r.reverseWords("  the sky is blue   "));
    }
}
