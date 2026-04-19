class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';

            // Append the binary digit (0 or 1)
            sb.append(sum % 2);
            // Calculate new carry (1 if sum is 2 or 3, otherwise 0)
            carry = sum / 2;
        }

        // Reverse the builder since we appended digits from right to left
        return sb.reverse().toString();
    }
}
