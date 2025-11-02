/*
 * [문제 링크]: https://leetcode.com/problems/contains-duplicate/description
 * [날짜]: 2025-11-02(o)
 * [자료구조]: HashSet
 * [문제 요약]: 정수 배열(nums)에 같은 값을 가지는 원소가 2개 이상 존재하면 true를 반환하고, 없으면 false를 반환.
 * [문법]: 이미 존재하는 원소를 HashSet에 add할 경우, false를 반환하는 add의 문법적 특징을 활용.
 */

import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.add(n)) {
                return true;
            }
        }
        return false;
    }
}
