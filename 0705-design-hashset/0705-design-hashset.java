class MyHashSet {
    private boolean[] set;

    // Constructor initializes array for all possible keys
    public MyHashSet() {
        set = new boolean[1000001]; // keys range from 0 to 10^6
    }

    // Add key
    public void add(int key) {
        set[key] = true;
    }

    // Remove key
    public void remove(int key) {
        set[key] = false;
    }

    // Check if key exists
    public boolean contains(int key) {
        return set[key];
    }
}
