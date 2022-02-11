package normal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomizedSet {

	List<Integer> randList;

	/**
	 * Initialize your data structure here.
	 */
	public RandomizedSet() {
		randList = new ArrayList<>();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain the specified element.
	 */
	public boolean insert(int val) {
		if (randList.contains(val)) {
			return false;
		} else {
			return randList.add(val);
		}
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified element.
	 */
	public boolean remove(int val) {
		if(!randList.contains(val)){
			return false;
		}else {
			boolean remove = randList.remove(new Integer(val));
			return remove;
		}
	}

	/**
	 * Get a random element from the set.
	 */
	public int getRandom() {
		return randList.get(new Random().nextInt(randList.size()));
	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
class Test {
	public static void main(String[] args) {
		RandomizedSet obj = new RandomizedSet();
		System.out.println(obj.insert(1));
		System.out.println(obj.remove(2));
		System.out.println(obj.insert(2));
		System.out.println(obj.getRandom());
		System.out.println(obj.remove(1));
		System.out.println(obj.insert(2));
		System.out.println(obj.getRandom());
	}
}