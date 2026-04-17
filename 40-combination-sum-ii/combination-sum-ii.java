import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort to handle duplicates easily
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) return; // Base case: exceeded the target
        else if (remain == 0) {
            result.add(new ArrayList<>(tempList)); // Found a valid combination
        } else {
            for (int i = start; i < nums.length; i++) {
                // Skip duplicates: if the current number is the same as the previous one
                // and it's not the first element in this recursion level
                if (i > start && nums[i] == nums[i - 1]) continue;
                
                tempList.add(nums[i]);
                // i + 1 because we can't reuse the same element
                backtrack(result, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1); // Backtrack
            }
        }
    }
}