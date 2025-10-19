/*
 * [문제 링크]
 * https://school.programmers.co.kr/learn/courses/30/lessons/181936?language=java
 */

class Solution {
    public int solution(int number, int n, int m) {
        if ((number % n == 0) && (number % m == 0)) {
            return 1;
        }
        return 0;
    }
}
