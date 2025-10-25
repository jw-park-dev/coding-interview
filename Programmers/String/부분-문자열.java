/*
 * [문제 링크]
 * https://school.programmers.co.kr/learn/courses/30/lessons/181842
 */

class Solution {
    public int solution(String str1, String str2) {
        if(str2.contains(str1)) {
            return 1;
        }
        return 0;
    }
}
