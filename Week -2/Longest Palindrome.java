/*Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.*/

class Solution {
    public int longestPalindrome(String s) {
        
        int[] lowercase = new int[26];
        int[] upercase =  new int[26];
        for(int i =0; i<s.length(); i++){
            char c= s.charAt(i);
            if(c-'a' >= 0){
                lowercase[c-'a']++;
            }else{
                upercase[c-'A']++;
            }
        }
        
        int ans = 0;
        boolean isfirstodd = false;
        
        for(int i=0; i<26; i++){
            if(lowercase[i]%2 == 0){
                ans+= lowercase[i];
            }else{
                if(isfirstodd == false){
                    ans+= lowercase[i];
                    isfirstodd = true;
                }else
                    ans+= lowercase[i]-1;
            }
        }
        
        for(int i=0; i<26; i++){
            if(upercase[i]%2 == 0){
                ans+= upercase[i];
            }else{
                if(isfirstodd == false){
                    ans+= upercase[i];
                    isfirstodd = true;
                }else
                    ans+= upercase[i]-1;
            }
        }
        
        
        return ans;
    }
}