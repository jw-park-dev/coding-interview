/*
 * [문제 링크]
 * https://school.programmers.co.kr/learn/courses/30/lessons/181841
 */

class Solution {
    public String solution(String[] str_list, String ex) {
        String ans = "";
        for (String s : str_list) {
            if (!s.contains(ex)) {
                ans += s;
            }
        }
        return ans;
    }
}
