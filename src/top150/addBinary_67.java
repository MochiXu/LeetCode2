package top150;

public class addBinary_67 {
    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        boolean plus=false;
        int aIndex =a.length()-1, bIndex=b.length()-1;
        while (aIndex>=0&&bIndex>=0){
            if (a.charAt(aIndex)=='1'&&b.charAt(bIndex)=='1'){
                sb.insert(0, plus?'1':'0');
                plus=true;
            }else if (a.charAt(aIndex)=='1'||b.charAt(bIndex)=='1'){
                sb.insert(0, plus?'0':'1');
            }else {
                sb.insert(0, plus?'1':'0');
                plus=false;
            }
            aIndex--;
            bIndex--;
        }
        // 处理剩余的字符
        while (aIndex>=0){
            if (plus){
                sb.insert(0, a.charAt(aIndex)=='1'?'0':'1');
                plus=a.charAt(aIndex)=='1';
            }else {
                sb.insert(0, a.charAt(aIndex));
            }
            aIndex--;
        }
        while (bIndex>=0){
            if (plus){
                sb.insert(0, b.charAt(bIndex)=='1'?'0':'1');
                plus=b.charAt(bIndex)=='1';
            }else {
                sb.insert(0, b.charAt(bIndex));
            }
            bIndex--;
        }
        if (plus){
            sb.insert(0, '1');
        }
        return sb.toString();
    }

    public static void main(String args[]){
        addBinary_67 a = new addBinary_67();
//        System.out.println(a.addBinary("1000", "101"));
        System.out.println(a.addBinary("1011", "101"));
    }
}
