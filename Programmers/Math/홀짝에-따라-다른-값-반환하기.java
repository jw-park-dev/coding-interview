/*
 * [문제 링크]
 * https://school.programmers.co.kr/learn/courses/30/lessons/181935
 */

class Solution {
    public int solution(int n) {
        int ans = 0;
        if (n % 2 == 1) {
            for (int num = 1; num <= n; num++) {
                if (num % 2 == 1) {
                    ans += num;
                }
            }
            return ans;
        }
        else {
            for (int num = 1; num <= n; num++) {
                if (num % 2 == 0) {
                    ans += num * num;
                }
            }
            return ans;
        }
    }
}
