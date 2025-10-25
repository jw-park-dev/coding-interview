/*
 * [문제 링크]
 * https://school.programmers.co.kr/learn/courses/30/lessons/181854?language=java
 */

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int n) {
        int len = arr.length;
  
        if (len % 2 == 1) {
            for (int i = 0; i < len; i += 2) {
                arr[i] += n;
            }
        }
        else {
            for (int i = 1; i < len; i += 2) {
                arr[i] += n;
            }
        }
        
        return arr;
    }
}
