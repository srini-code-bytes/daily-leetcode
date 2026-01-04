/*
LeetCode: 217 - Contains Duplicate
Difficulty: Easy
Category: Existence Check
Date: 01-04-2026

Problem Summary:
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true
Explanation:
The element 1 occurs at the indices 0 and 3.

Example 2:
Input: nums = [1,2,3,4]
Output: false
Explanation:
All elements are distinct.

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

Constraints:
1 <= nums.length <= 105
-109 <= nums[i] <= 109
------------------------------------------------------------
Approach 1: Brute Force
- Idea:
  Compare every pair of elements to check if any two values are equal.
- Time Complexity:
  O(n²) — nested loops compare all unique pairs.
- Space Complexity:
  O(1) — no extra data structures used.

------------------------------------------------------------
Approach 2: Frequency Counting (HashMap)
- Idea:
  Count the frequency of each number and check if any value occurs more than once.
- Time Complexity:
  O(n) — one pass to build the frequency map, one pass to inspect counts.
- Space Complexity:
  O(n) — map may store all elements in the worst case.
------------------------------------------------------------
Approach 3: Optimized (HashSet)
- Idea:
  Track seen elements and return immediately when a duplicate is encountered.
- Time Complexity:
  O(n) — single pass with constant-time lookups.
- Space Complexity:
  O(n) — set stores seen elements.
------------------------------------------------------------
Key Insight:
When only existence matters and indices or exact frequencies are irrelevant, tracking seen elements allows early detection of duplicates.

Edge Cases:
- All elements are unique
- Duplicate appears early in the array
- Negative numbers
*/

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        /* BRUTE FORCE - HASHMAP Approach
        Map<Integer, Integer> hMap = new HashMap<>();
        for (int n : nums) {
            hMap.put(n, hMap.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : hMap.entrySet()) {
            if (entry.getValue() >= 2) {
                return true;
            }
        }
        return false;
        */

        /* OPTIMIZED - HashSet Approach */
        Set<Integer> hSet = new HashSet<>();
        for(int n : nums){
            if(hSet.contains(n)){
                return true;
            }
            hSet.add(n);
        }
        return false;
    }
}

public class LC217_ContainsDuplicate {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 4, 4, 4, 5};
        boolean result = solution.containsDuplicate(nums);
        System.out.println(result); // Output: false
    }
}