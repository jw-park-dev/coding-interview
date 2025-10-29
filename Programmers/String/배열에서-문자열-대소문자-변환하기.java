/*
 * [문제 링크]
 * https://school.programmers.co.kr/learn/courses/30/lessons/181875
 */

class Solution {
    public String[] solution(String[] strArr) {
        int len = strArr.length;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 1) {
                strArr[i] = strArr[i].toUpperCase();
            }
            else {
                strArr[i] = strArr[i].toLowerCase();
            }
        }
        return strArr;
    }
}
