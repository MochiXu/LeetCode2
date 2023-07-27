package top150;

import java.util.LinkedList;
import java.util.Objects;

// tokens = ["4","13","5","/","+"]
// (4 + (13 / 5)) = 6
public class evalRPN_150 {
    public int evalRPN(String[] tokens) {
        LinkedList<String> list = new LinkedList<>();
        for (int i=0; i<tokens.length; i++){
            if (Objects.equals(tokens[i], "+")){
                int r = Integer.valueOf(list.pollLast());
                int l = Integer.valueOf(list.pollLast());
                list.addLast(String.valueOf(l+r));
            }else if(Objects.equals(tokens[i], "-")){
                int r = Integer.valueOf(list.pollLast());
                int l = Integer.valueOf(list.pollLast());
                list.addLast(String.valueOf(l-r));
            }else if(Objects.equals(tokens[i], "*")){
                int r = Integer.valueOf(list.pollLast());
                int l = Integer.valueOf(list.pollLast());
                list.addLast(String.valueOf(l*r));
            }else if(Objects.equals(tokens[i], "/")){
                int r = Integer.valueOf(list.pollLast());
                int l = Integer.valueOf(list.pollLast());
                list.addLast(String.valueOf(l/r));
            }else {
                list.addLast(tokens[i]);
            }
        }
        return Integer.valueOf(list.pop());
    }
    public static void main(String[] args){
        evalRPN_150 e = new evalRPN_150();
        System.out.println(e.evalRPN(new String[]{"4","13","5","/","+"}));;
    }
}
