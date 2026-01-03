/*
LeetCode: 961 - N-Repeated Element in Size 2N Array
Difficulty: Easy
Category: Array / Pigeonhole Principle
Date: 01-02-2026

Problem Summary:
An array of size 2n contains n+1 unique elements.
Exactly one element appears n times.
Return that element.

------------------------------------------------------------

Approach 1: Frequency Counting (HashMap)
- Idea: Count occurrences of each element
- Time Complexity: O(n)
- Space Complexity: O(n)

Approach 2: Optimized (Pigeonhole Principle)
- Idea: The repeated element must appear within distance ≤ 2
- Time Complexity: O(n)
- Space Complexity: O(1)

Key Insight:
Because one element appears n times in a 2n array, it must repeat within adjacent or one-gap positions.

Edge Cases:
- Repeated element at the end of the array
- Repeated element appears non-adjacently
*/

class Solution {
    public int repeatedNTimes(int[] nums) {

        /* Frequency Counting using HashMap (fallback solution) */

        /*
        int numsLength = nums.length;
        Map<Integer, Integer> hMap = new HashMap<>();

        for (int n : nums) {
            hMap.put(n, hMap.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : hMap.entrySet()) {
            if (entry.getValue() == numsLength / 2) {
                return entry.getKey();
            }
        }
        return -1;
        */

        /* Optimized - Pigeonhole Principle */

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == nums[i + 1] || nums[i] == nums[i + 2]) {
                return nums[i];
            }
        }

        return nums[nums.length - 1];
    }
}
