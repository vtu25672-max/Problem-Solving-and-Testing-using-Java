import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // Option 1: Sort the string to create the key
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            
            // If the key doesn't exist, create a new list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            
            // Add the original string to the corresponding group
            map.get(key).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}
