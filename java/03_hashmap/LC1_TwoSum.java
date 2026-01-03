/*
LeetCode: 1 - Two Sum
Difficulty: Easy
Category: Array / Complement Lookup using HashMap
Date: 01-03-2026

Problem Summary:
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]

Constraints:
2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?

Approach 1: Brute Force
- Idea:
1. Loop through the array with index i
2. For each i, loop through the remaining array with index j
3. Check if nums[i] + nums[j] == target
4. If match, return new int[]{i, j}
5. If no match after all pairs, return new int[2] (maybe zeros).

Time complexity: O(n^2)
Space Complexity: O(1)

I think the time complexity is O(n^2) since for every element we're comparing it to every other element after it. The space complexity is O(1) because we're just returning an array of 2 indices (no big data structures).

Approach 2: Optimized
- Idea:
1. Create a hash map to store numbers and their indices.
2. Loop through the array with index i.
3. For each number, calculate its complement (target - nums[i]).
4. If the complement exists in the hash map, return the indices.
5. Otherwise, add the current number and its index to the hash map.
6. If no solution is found, return an array of size 2.

Time complexity: O(n)
Space complexity: O(n)

We only loop through the array once, and the hash map allows constant time lookups and inserts.
The space complexity is O(n) because we may store every number in the array in the worst case.

Key Insight:
For each number, if its complement has already been seen, the solution can be found immediately.
Two Sum is solved by storing previously seen values with their indices so the complement can be found in constant time.

Edge Cases:
- Array with exactly one valid pair
- Negative numbers
- Target equals sum of two identical values at different indices
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {

        /* BRUTE FORCE O(n²)
        // Loop through all elements with index i
        for (int i = 0; i < nums.length; i++) {
            // Loop through remaining elements with index j
            for (int j = i + 1; j < nums.length; j++) {
                // Check if the current pair sums up to the target
                if (nums[i] + nums[j] == target) {
                    // Return the indices as required by the problem statement
                    return new int[]{i, j};
                    }
                }
            }
            // If no pair found, return an array of size 2 (default values)
            return new int[2];
        }
         */

        /* OPTIMIZED - HASH MAP & COMPLEMENT */
        // Create a hash map to store numbers and their indices
        Map<Integer, Integer> map = new HashMap<>();
        // Loop through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement for the current number
            int complement = target - nums[i];
            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                // If found, return the indices as required
                return new int[]{map.get(complement), i};
            }
            // Otherwise, add the current number and its index to the map
            map.put(nums[i], i);
        }
        // If no pair found, return an array of size 2 (default values)
        return new int[2];
    }
}