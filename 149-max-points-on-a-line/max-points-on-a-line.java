class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;
        int max = 0;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int currentMax = 0;
            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                
                // Simplify slope using GCD to avoid precision issues with double
                int gcd = gcd(dx, dy);
                String slope = (dx / gcd) + "_" + (dy / gcd);
                
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                currentMax = Math.max(currentMax, map.get(slope));
            }
            max = Math.max(max, currentMax + 1);
        }
        return max;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
