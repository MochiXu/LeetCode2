package top150;

import java.util.ArrayList;
import java.util.HashMap;

public class Trie_208 {
    public Trie_208[] list;
    public boolean end;
    public Trie_208() {
        list = new Trie_208[26];
    }

    public void insert(String word) {
        Trie_208 node = this;
        for (int i=0; i<word.length(); i++){
            int index = word.charAt(i)-'a';
            if (node.list[index]==null){
                node.list[index]=new Trie_208();
            }
            node=node.list[index];
        }
        node.end=true;
    }

    public boolean search(String word) {
        Trie_208 node = this;
        for (int i=0; i<word.length(); i++){
            int index = word.charAt(i)-'a';
            if (node.list[index]==null){
                return false;
            }
            node=node.list[index];
        }
        return node.end;
    }

    public boolean startsWith(String prefix) {
        Trie_208 node = this;
        for (int i=0; i<prefix.length(); i++){
            int index = prefix.charAt(i)-'a';
            if (node.list[index]==null){
                return false;
            }
            node=node.list[index];
        }
        return true;
    }
}
