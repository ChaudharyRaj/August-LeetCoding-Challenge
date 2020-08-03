/*Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false

Constraints:

s consists only of printable ASCII characters.
*/

class Solution {
    public boolean isPalindrome(String s) {
        
        if(s.length() <= 1) return true;
        int l = 0;
        int r = s.length()-1;
        
        while(l<r){
            
            if(!isAlphanumeric(s.charAt(l))) l++;
            else if(!isAlphanumeric(s.charAt(r))) r--;
            
            else if(islowerCase(s.charAt(l)) != islowerCase(s.charAt(r))) return false;
            else{
                l++;
                r--;   
            }    
        }
        return true;
    }
    
    private boolean isAlphanumeric(char c){
        
        return(c>='a' && c <='z') || (c>= 'A' && c<= 'Z')|| (c >='0' && c<= '9');
    }
    
    private char islowerCase(char c){
        
        if(c>= 'a' && c<= 'z' || c >='0' && c<= '9') return c;
        return (char)((int)c+32);
    }
}