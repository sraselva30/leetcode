class Solution {
    public double myPow(double x, int n) {
        // Use a long to handle the edge case where n = Integer.MIN_VALUE
        long N = n;
        
        // If the exponent is negative, compute (1/x)^|n|
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        double result = 1.0;
        double currentProduct = x;
        
        // Iterative Binary Exponentiation
        while (N > 0) {
            // If N is odd, multiply result by currentProduct
            if (N % 2 == 1) {
                result *= currentProduct;
            }
            // Square the base and halve the exponent
            currentProduct *= currentProduct;
            N /= 2;
        }
        
        return result;
    }
}

