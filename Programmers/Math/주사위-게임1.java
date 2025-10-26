/*
 * [문제 링크]
 * https://school.programmers.co.kr/learn/courses/30/lessons/181839
 * [비고]
 * Math.abs(a - b);
 * (int) (Math.pow(a, 2) + Math.pow(b, 2));
 */

class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        if ((a % 2 == 1) && (b % 2 == 1)) {
            return a * a + b * b;
        }
        else if (((a % 2 == 1) && (b % 2 == 0)) ||((a % 2 == 0) && (b % 2 == 1))) {
            return 2 * (a + b);
        }
        else {
            return a > b ? (a - b) : - (a - b);
        }
    }
}
