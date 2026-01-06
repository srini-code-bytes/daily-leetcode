/*
LeetCode: 169 - Majority Element
Difficulty: Easy
Category: arrays / voting-pattern
Date: 01-05-2026

Problem Summary:
Given an integer array, return the element that appears more than ⌊n / 2⌋ times.
It is guaranteed that such an element always exists.

------------------------------------------------------------

Approach 1: Brute Force
- Idea:
  For each element, count how many times it appears by scanning the entire array.
  If its count exceeds n / 2, return it.

- Time Complexity:
  O(n²)

- Space Complexity:
  O(1)

------------------------------------------------------------

Approach 2: Optimized (HashMap-based)
- Idea:
  Track the dominance of elements while traversing the array and return the one
  whose frequency clearly outweighs all others.

- Time Complexity:
  O(n)

- Space Complexity:
  O(n)

------------------------------------------------------------

Approach 3: Optimal (Boyer–Moore Voting)
- Idea:
  Use a candidate and counter where matching elements reinforce the candidate and
  non-matching elements cancel votes, ensuring the true majority remains.

- Time Complexity:
  O(n)

- Space Complexity:
  O(1)

------------------------------------------------------------

Key Insight:
A majority element appears more than half the time, so it cannot be fully canceled out by all other elements combined.

Edge Cases:
- Array of length 1
- Majority element scattered or consecutive
*/

// Brute Force
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count > n / 2) {
                return nums[i];
            }
        }
        return -1; // unreachable since majority always exists
    }
}

// HashMap (Optimized but Extra Space)

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if (freq.get(num) > n / 2) {
                return num;
            }
        }
        return -1;
    }
}

// Boyer–Moore Voting (Optimal)

class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}




