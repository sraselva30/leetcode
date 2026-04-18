import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        // 1. Create a list of numbers [1, 2, 3, ... n] 
        // and precompute factorials
        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
            numbers.add(i);
        }

        // 2. Adjust k to be 0-indexed
        k--;

        // 3. Determine each digit one by one
        for (int i = 1; i <= n; i++) {
            // Calculate how many permutations start with the same digit
            int index = k / factorial[n - i];
            
            // Append that digit to result and remove it from available numbers
            sb.append(numbers.get(index));
            numbers.remove(index);
            
            // Update k for the next position
            k %= factorial[n - i];
        }

        return sb.toString();
    }
}
