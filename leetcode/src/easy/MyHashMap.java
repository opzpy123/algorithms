package easy;

import java.util.Arrays;

public class MyHashMap {
	public static void main(String[] args) {
		MyHashMap myHashMap = new MyHashMap();
		myHashMap.get(250005);

	}
	private boolean[] key;
	private int[] value;

	/**
	 * Initialize your data structure here.
	 */
	public MyHashMap() {
		key = new boolean[1000001];
		value = new int[1000001];
	}

	/**
	 * value will always be non-negative.
	 */
	public void put(int key, int value) {
		this.key[key] = true;
		this.value[key] = value;
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
	 */
	public int get(int key) {
		if(this.key[key]) {
			return this.value[key];
		}else {
			return -1;
		}
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping for the key
	 */
	public void remove(int key) {
		this.key[key]=false;
		this.value[key]=-1;
	}
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */