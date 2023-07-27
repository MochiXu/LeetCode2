package top150;

public class isSubsequence_392 {
    public boolean isSubsequence(String s, String t) {
        if (t.length()<s.length()){
            return false;
        }
        if(s.length()==0){
            return true;
        }
        int i=0,j=0;
        while (i<s.length()){
            while (j<t.length() && i<s.length() && t.charAt(j)!=s.charAt(i)){
                j++;
            }
            if (j>=t.length()){
                return false;
            }else  if(i==s.length()-1&&s.charAt(i)==t.charAt(j)){
                return true;
            }else if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }
        }
        return false;
    }
    public static void main(String[] args){
        isSubsequence_392 i = new isSubsequence_392();
        System.out.println(i.isSubsequence("b","c"));
    }
}
