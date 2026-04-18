import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // 1. Convert string to char array and sort it
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            
            // 2. Use the sorted string as the key
            String key = String.valueOf(ca);
            
            // 3. Add the original string to the corresponding list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        
        // 4. Return all grouped lists
        return new ArrayList<>(map.values());
    }
}
