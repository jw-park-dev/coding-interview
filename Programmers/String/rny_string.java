/*
 * [문제 링크]
 * https://school.programmers.co.kr/learn/courses/30/lessons/181863
 */

class Solution {
    public String solution(String rny_string) {
        StringBuilder sb = new StringBuilder();
        char[] arr = rny_string.toCharArray();
        for (char c : arr) {
            if (c == 'm') {
                sb.append("rn");
            }
            else {
                sb.append(c);
            }
        }
        
        return String.valueOf(sb);
    }
}
