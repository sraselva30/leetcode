class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenE = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigit = true;
            } else if (c == '+' || c == '-') {
                // Sign can only appear at the start or immediately after an 'e'
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == 'e' || c == 'E') {
                // 'e' can only appear once, and only after at least one digit
                if (seenE || !seenDigit) {
                    return false;
                }
                seenE = true;
                seenDigit = false; // Reset to ensure digits follow 'e'
            } else if (c == '.') {
                // Dot can only appear once and cannot appear after 'e'
                if (seenDot || seenE) {
                    return false;
                }
                seenDot = true;
            } else {
                // Any other character is invalid
                return false;
            }
        }

        return seenDigit;
    }
}
