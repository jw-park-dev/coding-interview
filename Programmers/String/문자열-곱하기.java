/*
 * [문제 링크]
 * https://school.programmers.co.kr/learn/courses/30/lessons/181940
 * [비고]
 * String.repeat(int) : String을 int번 반복한 새 문자열을 반환.
 */

// StringBuilder를 이용한 풀이
class Solution {
    public String solution(String my_string, int k) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < k; i++) {
            ans.append(my_string);
        }
        return ans.toString();
    }
}

// String.repeat()을 이용한 풀이
class Solution {
    public String solution(String my_string, int k) {
        return my_string.repeat(k);
    }
}
