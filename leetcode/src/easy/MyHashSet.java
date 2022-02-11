package easy;

class MyHashSet {
	public static void main(String[] args) {
		MyHashSet myHashSet = new MyHashSet();
		myHashSet.add(1);
		myHashSet.add(2);
		myHashSet.contains(1);
		myHashSet.contains(3);
		myHashSet.add(2);
		myHashSet.contains(2);
		myHashSet.remove(2);
		myHashSet.contains(2);
	}
	boolean[] hashSet ;
	/** Initialize your data structure here. */
	public MyHashSet() {
		hashSet= new boolean[1000001];
	}

	public void add(int key) {
		hashSet[key]=true;
	}

	public void remove(int key) {
		hashSet[key]=false;
	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		return hashSet[key];
	}
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */