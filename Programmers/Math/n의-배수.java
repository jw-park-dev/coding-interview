/*
 * [문제 링크]
 * https://school.programmers.co.kr/learn/courses/30/lessons/181937
 * [접근]
 * - x가 y의 배수가 되기 위한 조건: x를 y로 나눴을 때의 나머지가 0.
 */

class Solution {
    public int solution(int num, int n) {
        if (num % n == 0) {
            return 1;
        }
        return 0;
    }
}
