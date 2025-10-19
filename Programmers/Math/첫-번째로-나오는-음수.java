/*
 * [문제 링크]
 * https://school.programmers.co.kr/learn/courses/30/lessons/181896
 * [비고]
 * 복습 필요 여부: x
 */

class Solution {
    public int solution(int[] num_list) {
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] < 0) {
                return i;
            }
        }
        return -1;
    }
}
