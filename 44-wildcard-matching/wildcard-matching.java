class Solution {
    public boolean isMatch(String s, String p) {
        int sPtr = 0, pPtr = 0, match = 0, starIdx = -1;            
        int sLen = s.length(), pLen = p.length();

        while (sPtr < sLen) {
            // 1. Characters match or pattern has '?'
            if (pPtr < pLen && (p.charAt(pPtr) == '?' || p.charAt(pPtr) == s.charAt(sPtr))) {
                sPtr++;
                pPtr++;
            } 
            // 2. Asterisk found: save state and try matching 0 characters first
            else if (pPtr < pLen && p.charAt(pPtr) == '*') {
                starIdx = pPtr;
                match = sPtr;
                pPtr++;
            } 
            // 3. Mismatch occurs: backtrack to the last '*'
            else if (starIdx != -1) {
                pPtr = starIdx + 1;
                match++;
                sPtr = match;
            } 
            // 4. No match possible
            else {
                return false;
            }
        }

        // Check if remaining pattern characters are all '*'
        while (pPtr < pLen && p.charAt(pPtr) == '*') {
            pPtr++;
        }

        return pPtr == pLen;
    }
}