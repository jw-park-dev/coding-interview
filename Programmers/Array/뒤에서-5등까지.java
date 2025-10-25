/*
 * [문제 링크]
 * https://school.programmers.co.kr/learn/courses/30/lessons/181853?language=java
 */

import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        Arrays.sort(num_list);
        return Arrays.copyOfRange(num_list, 0, 5);
    }
}
