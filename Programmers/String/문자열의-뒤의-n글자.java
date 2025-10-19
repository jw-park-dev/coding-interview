/*
 * [문제 링크]
 * https://school.programmers.co.kr/learn/courses/30/lessons/181910
 * [비고]
 * 문자열의 뒤의 n 글자 : 전체 문자열의 길이 - n
 */

class Solution {
    public String solution(String my_string, int n) {
        return my_string.substring(my_string.length() - n);
    }
}
