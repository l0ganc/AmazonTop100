package Day2;

import java.util.*;

public class LC380InsertDeleteGetRandom {
    /**
     * Design a data structure that supports all following operations in average O(1) time.
     *
     * insert(val): Inserts an item val to the set if not already present.
     * remove(val): Removes an item val from the set if present.
     * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
     * Example:
     *
     * // Init an empty set.
     * RandomizedSet randomSet = new RandomizedSet();
     *
     * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
     * randomSet.insert(1);
     *
     * // Returns false as 2 does not exist in the set.
     * randomSet.remove(2);
     *
     * // Inserts 2 to the set, returns true. Set now contains [1,2].
     * randomSet.insert(2);
     *
     * // getRandom should return either 1 or 2 randomly.
     * randomSet.getRandom();
     *
     * // Removes 1 from the set, returns true. Set now contains [2].
     * randomSet.remove(1);
     *
     * // 2 was already in the set, so return false.
     * randomSet.insert(2);
     *
     * // Since 2 is the only number in the set, getRandom always return 2.
     * randomSet.getRandom();
     *
     */

    Map<Integer, Integer> map;   // key is the element, and value is the list's size
    List<Integer> list;  // store inserted value
    Random random;
    /** Initialize your data structure here. */
    public LC380InsertDeleteGetRandom() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        map.put(val, list.size());
        list.add(val);

        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);   // current index of that need to remove value
        if (index < list.size() - 1) {
            int lastOne = list.get(list.size() - 1);   // this is  the last position's value
            list.set(index, lastOne);
            map.put(lastOne, index);
        }
        map.remove(val);
        list.remove(list.size() - 1);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        LC380InsertDeleteGetRandom obj = new LC380InsertDeleteGetRandom();
        System.out.println(obj.insert(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.insert(2));
        System.out.println(obj.remove(3));
        System.out.println(obj.remove(1));
        System.out.println(obj.insert(4));
        System.out.println(obj.insert(5));
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());

    }
}
