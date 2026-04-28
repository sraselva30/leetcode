class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        // Frequency map for target string t
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE;
        int counter = t.length(); // Characters needed to form a valid window

        while (end < s.length()) {
            char c1 = s.charAt(end);
            if (map[c1] > 0) {
                counter--;
            }
            map[c1]--;
            end++;

            // When window is valid, try to shrink from the left
            while (counter == 0) {
                if (end - start < minLen) {
                    minLen = end - start;
                    minStart = start;
                }

                char c2 = s.charAt(start);
                map[c2]++;
                if (map[c2] > 0) {
                    counter++;
                }
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
