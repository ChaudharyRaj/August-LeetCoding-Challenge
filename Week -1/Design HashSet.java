/*Design a HashSet without using any built-in hash table libraries.

To be specific, your design should include these functions:

add(value): Insert a value into the HashSet. 
contains(value) : Return whether the value exists in the HashSet or not.
remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.

Example:

MyHashSet hashSet = new MyHashSet();
hashSet.add(1);         
hashSet.add(2);         
hashSet.contains(1);    // returns true
hashSet.contains(3);    // returns false (not found)
hashSet.add(2);          
hashSet.contains(2);    // returns true
hashSet.remove(2);          
hashSet.contains(2);    // returns false (already removed)

Note:

All values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashSet library.*/


class MyHashSet {
    
    private int numBucket = 15000;
    List<Integer>[] buckets;
    private int hashFunction(int key){
        return key%numBucket;
    }
    /** Initialize your data structure here. */
    
    public MyHashSet(){
        buckets =  new LinkedList[numBucket];
    }
    
    public void add(int key){
        
        int i = hashFunction(key);
        if(buckets[i] == null){
            buckets[i] = new LinkedList<>();
        }
        if(buckets[i].indexOf(key) == -1)
            buckets[i].add(key);
    }
    
    public void remove(int key){
        
        int i = hashFunction(key);
        if(buckets[i] ==  null) return;
        
        if(buckets[i].indexOf(key) != -1){
            buckets[i].remove(buckets[i].indexOf(key));
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key){
        
        int i = hashFunction(key);
        if(buckets[i] ==  null || buckets[i].indexOf(key) == -1) return false;
        return true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */