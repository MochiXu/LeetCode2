package top150;

import java.util.LinkedList;

public class minMutation_433 {
    public boolean compare(String a, String b){
        // 比较a和b是否只有一个字符的差距
        int count=0;
        if (a.length()!=b.length()){
            return false;
        }
        for (int i=0; i<a.length(); i++){
            if (a.charAt(i)!=b.charAt(i)){
                count++;
            }
        }
        return count==1;
    }
    class ElementCount{
        String element;
        int count;
        public ElementCount(String element, int count){
            this.element = element;
            this.count = count;
        }
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        boolean[] visited=new boolean[bank.length];
        LinkedList<ElementCount> queue = new LinkedList<>();
        queue.add(new ElementCount(startGene, 0));
        while (queue.size()!=0){
            ElementCount left = queue.pollFirst();
            for (int i=0; i<bank.length; i++){
                if (compare(left.element, bank[i])){
                    if (bank[i].equals(endGene)){
                        return left.count+1;
                    }else {
                        if (!visited[i]){
                            visited[i]=true;
                            queue.addLast(new ElementCount(bank[i], left.count+1));
                        }
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        minMutation_433 m = new minMutation_433();
        System.out.println(m.minMutation("AAAAACCC","AACCCCCC",new String[]{"AAAAAACC","AAAACCCC","AAACCCCC","AACCCCCC"}));
    }
}
