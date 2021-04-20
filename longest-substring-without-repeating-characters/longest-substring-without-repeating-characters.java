public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), maxLength = 0;
        Map<Character, Integer> map = new HashMap<>(); 
        
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j))+1);
            }
            maxLength = Math.max(maxLength, j - i + 1);
            map.put(s.charAt(j), j);
        }
        
        return maxLength;
    }
}