package top150;

import java.util.ArrayList;

public class WordDictionary_211 {
    public WordDictionary_211[] array;
    public boolean isFinal;
    public WordDictionary_211() {
        array = new WordDictionary_211[26];
    }

    public void addWord(String word) {
        WordDictionary_211 wordDictionary = this;
        for (int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if (wordDictionary.array[c-'a']==null){
                WordDictionary_211 temp = new WordDictionary_211();
                wordDictionary.array[c-'a'] = temp;
                wordDictionary = temp;
            }else {
                wordDictionary = wordDictionary.array[c-'a'];
            }
        }
        wordDictionary.isFinal=true;
    }

    public boolean search(String word) {
        ArrayList<WordDictionary_211> arrayList = new ArrayList<>();
        arrayList.add(this);
        for (int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if (c=='.'){
                ArrayList<WordDictionary_211> tempList = new ArrayList<>();
                for (int j=0; j<arrayList.size(); j++){
                    for (int k=0; k<26; k++){
                        if (arrayList.get(j).array[k]!=null){
                            tempList.add(arrayList.get(j).array[k]);
                        }
                    }
                }
                arrayList=tempList;
            }else {
                boolean canFind = false;
                ArrayList<WordDictionary_211> tempList = new ArrayList<>();
                for (int j=0; j< arrayList.size(); j++){
                    if (arrayList.get(j).array[c-'a']!=null){
                        tempList.add(arrayList.get(j).array[c-'a']);
                        canFind=true;
                    }
                }
                arrayList=tempList;
                if (!canFind){
                    return false;
                }
            }
        }
        boolean res=false;
        for (int i=0; i<arrayList.size();i++){
            if (arrayList.get(i).isFinal){
                res=true;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args){
        WordDictionary_211 w = new WordDictionary_211();
        w.addWord("at");
        w.addWord("and");
        w.addWord("an");
        w.addWord("add");
        w.addWord("bat");
        System.out.println(w.search(".at"));
    }
}
