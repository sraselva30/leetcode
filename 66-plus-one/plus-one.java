class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Iterate from the last digit to the first
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits; // No carry needed further, return early
            }
            
            // If the digit is 9, it becomes 0
            digits[i] = 0;
        }
        
        // If we reach here, it means all digits were 9 (e.g., 999 -> 1000)
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}
