/*
 * [문제 링크]
 * https://school.programmers.co.kr/learn/courses/30/lessons/181892?language=java
 *
 * [비고]
 * - Arrays 사용 시, java.util.Arrays import 필요.
 * - copyOfRange(arr, start, end)에서 start에 대응되는 값은 포함되고, end에 대응되는 값은 포함되지 않음에 주의.
 */

import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list, int n) {
        return Arrays.copyOfRange(num_list, n-1, num_list.length);
    }
}
