/*
 * [문제 링크]
 * https://school.programmers.co.kr/learn/courses/30/lessons/181933?language=java
 * [비고]
 * boolean 값은 true, false로 비교.
 */

class Solution {
    public int solution(int a, int b, boolean flag) {
        if (flag == true) {
            return a + b;
        }
        else {
            return a - b;
        }
    }
}
