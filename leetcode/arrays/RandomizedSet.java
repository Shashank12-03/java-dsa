package arrays;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;


public class RandomizedSet {

    HashSet<Integer> set;
    int size=0;
    Random random = new Random();

    public RandomizedSet() {
        set= new HashSet<>();
    }
    
    public boolean insert(int val) {
        if(set.contains(val)){
            return false;
        }
        set.add(val);
        size++;
        return false;
    }
    
    public boolean remove(int val) {
        if (set.contains(val)) {
            set.remove(val);
            size--;
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        List<Integer> valuesList = new ArrayList<>(set.values());

        // Use Random to get a random index from the list
        int randomIndex = random.nextInt(valuesList.size());

        // Return the value at the random index
        return valuesList.get(randomIndex);
    }
}
