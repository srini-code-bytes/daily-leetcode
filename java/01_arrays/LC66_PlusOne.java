/*
LeetCode: 66 - Plus One
Difficulty: Easy
Category: Array / Math (Carry Propagation)
Date: 01-01-2026

Problem Summary:
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

Example 1:
Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].

Example 2:
Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].

Example 3:
Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].

Constraints:
1 <= digits.length <= 100
0 <= digits[i] <= 9
digits does not contain any leading 0's.

Approach 1: Optimized
- Idea:
1. Start from the last index
- Because addition always starts from the right
2. Add 1
- That’s literally the problem
3. If digit becomes 10
- Set it to 0
- Carry continues left
4. If digit is NOT 10
- Return immediately
- No more carry → we’re done
5. If loop finishes
- It means all digits were 9
- Create new array with leading 1

Time complexity is O(n).
Space complexity is O(1) auxiliary space in the average case, and O(n) in the worst case due to creating a new array when all digits are 9.

Key Insight:
Addition propagates carry from right to left; once a digit is not 9, the process stops early.


Edge Cases:
- All digits are 9 → requires creating a new array
- Carry propagates through multiple digits (e.g., [8,9,9])
- Single digit input

*/

class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;

            if (digits[i] == 10) {
                digits[i] = 0;
            } else {
                return digits;
            }
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;

    }
}
