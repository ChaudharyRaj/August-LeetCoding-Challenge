/*Design an Iterator class, which has:

A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
A function next() that returns the next combination of length combinationLength in lexicographical order.
A function hasNext() that returns True if and only if there exists a next combination.
 

Example:

CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

iterator.next(); // returns "ab"
iterator.hasNext(); // returns true
iterator.next(); // returns "ac"
iterator.hasNext(); // returns true
iterator.next(); // returns "bc"
iterator.hasNext(); // returns false
 

Constraints:

1 <= combinationLength <= characters.length <= 15
There will be at most 10^4 function calls per test.
It's guaranteed that all calls of the function next are valid.*/

class CombinationIterator {
    List<String> memory = new ArrayList<>();
    String characters;
    public CombinationIterator(String characters, int combinationLength) {
        this.characters = characters;
        helper(combinationLength,new StringBuilder());
    }
    private void helper(int len,StringBuilder sb) {
        if(len==0) {
            memory.add(sb.toString());
            return ;
        }
        
        for(char c: characters.toCharArray()) {
            
            if(sb.length()==0 || (sb.charAt(sb.length()-1) < c)) {
                StringBuilder temp = new StringBuilder(sb);
                temp.append(c);
                helper(len-1,temp);
            }
            
        }
    }
    public String next() {
        if(memory.size()>0) {
          String response = memory.get(0);
          memory.remove(0);
         return response;
        } else {
            return "";
        }
    }
    
    public boolean hasNext() {
        return memory.size()>0;
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */