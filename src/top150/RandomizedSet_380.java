package top150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet_380 {
    private ArrayList<Integer> content;
    private HashMap<Integer, Integer> index;
    private int fakeRandomId;
    Random random;
    public RandomizedSet_380() {
        this.content = new ArrayList<>();
        this.index = new HashMap<>();
        this.fakeRandomId = 0;
    }

    public boolean insert(int val) {
        if (index.containsKey(val)){
            return false;
        }else {
            content.add(val);
            index.put(val, content.size()-1);
            return true;
        }
    }

    public boolean remove(int val) {
        if(index.containsKey(val)){
            content.set(index.get(val),content.get(content.size()-1));
            index.put(content.get(content.size()-1),index.get(val));
            content.remove(content.size()-1);
            index.remove(val);
            return true;
        }else {
            return false;
        }
    }

    public int getRandom() {
        int randomIndex = random.nextInt(content.size());
        return content.get(randomIndex);
    }

    public static void main(String[] args){
        RandomizedSet_380 r = new RandomizedSet_380();
        r.insert(1);
        r.insert(10);
        r.remove(20);
        r.insert(30);
        r.remove(1);
        System.out.println(r.getRandom());
    }
}
