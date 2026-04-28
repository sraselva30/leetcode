class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        
        // Split buildings into start and end points
        // Use negative height for start to sort them before end points if x is same
        for (int[] b : buildings) {
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }

        // Sort by x-coordinate, then by height
        Collections.sort(heights, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        // Max-heap to keep track of current building heights
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.offer(0); // Base ground height
        int prevMaxHeight = 0;

        for (int[] h : heights) {
            if (h[1] < 0) {
                pq.offer(-h[1]); // New building starts
            } else {
                pq.remove(h[1]); // Building ends
            }

            int currentMaxHeight = pq.peek();
            if (currentMaxHeight != prevMaxHeight) {
                result.add(Arrays.asList(h[0], currentMaxHeight));
                prevMaxHeight = currentMaxHeight;
            }
        }

        return result;
    }
}
