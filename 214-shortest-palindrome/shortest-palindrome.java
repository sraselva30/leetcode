class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;

        // Combine s, a separator, and reversed s to use KMP lookup table
        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;
        
        // Compute KMP prefix function (failure function)
        int[] next = new int[combined.length()];
        for (int i = 1, j = 0; i < combined.length(); i++) {
            while (j > 0 && combined.charAt(i) != combined.charAt(j)) {
                j = next[j - 1];
            }
            if (combined.charAt(i) == combined.charAt(j)) {
                j++;
            }
            next[i] = j;
        }

        // The last value in 'next' array tells us the longest prefix of s 
        // that is also a suffix of rev (making it the longest palindrome prefix)
        int palindromeLen = next[combined.length() - 1];
        String suffixToAdd = s.substring(palindromeLen);
        
        return new StringBuilder(suffixToAdd).reverse().toString() + s;
    }
}
