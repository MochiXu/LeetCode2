package top150;

import java.util.ArrayList;
import java.util.List;

public class fullJustify_68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int currentLineChars=0;
        ArrayList<String> currentLineList = new ArrayList<>();
        ArrayList<String> re = new ArrayList<>();
        for (int i=0; i<words.length; i++){
            if (currentLineChars+currentLineList.size()+words[i].length()>maxWidth){
                // 当前的 currentLineList 内包含的字符串是单行所能容纳最多的
                // Step1. 计算剩余的空格数目
                int blankCount = maxWidth-currentLineChars;
                // Step2. 分布这些空格
                if(currentLineList.size()==1){
                    StringBuilder tail = new StringBuilder();
                    for(int _i=0; _i<blankCount; _i++){
                        tail.append(' ');
                    }
                    re.add(currentLineList.get(0)+tail);
                }else if(currentLineList.size()>1){
                    // 计算第一个空格个数
                    int firstBlankCount = blankCount%(currentLineList.size()-1)+blankCount/(currentLineList.size()-1);
                    // 计算其他空格个数
                    int otherBlankCount = blankCount/(currentLineList.size()-1);
                    // 第一个空格形成的字符串
                    StringBuilder firstBlankString = new StringBuilder();
                    // 其他空格形成的字符串
                    StringBuilder otherBlankString = new StringBuilder();
                    for(int _i=0; _i<firstBlankCount; _i++){
                        firstBlankString.append(' ');
                    }
                    for(int _i=0; _i<otherBlankCount; _i++){
                        otherBlankString.append(' ');
                    }
                    StringBuilder temp = new StringBuilder(currentLineList.get(0) + firstBlankString);
                    for (int _i=1; _i<currentLineList.size()-1; _i++){
                        temp.append(currentLineList.get(_i)).append(otherBlankString);
                    }
                    temp.append(currentLineList.get(currentLineList.size()-1));
                    re.add(String.valueOf(temp));
                }
                // 清空历史
                currentLineList.clear();
                currentLineChars=0;
                i--;
            }else {
                currentLineList.add(words[i]);
                currentLineChars+=words[i].length();
            }
        }
        if (currentLineChars!=0){
            StringBuilder temp = new StringBuilder(currentLineList.get(0));
            for (int i=1; i<currentLineList.size(); i++){
                temp.append(" ").append(currentLineList.get(i));
            }

            int count=maxWidth-temp.length();
            for(int i=0; i<count; i++){
//                System.out.println(count);
                temp.append(" ");
            }
            re.add(String.valueOf(temp));
        }
        return re;
    }

    public static void main(String[] args){
        fullJustify_68 f = new fullJustify_68();
        for(String inner:f.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16)){
            System.out.println(inner);
        }
    }
}
