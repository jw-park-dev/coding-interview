/*
 * [문제 링크]
 * https://school.programmers.co.kr/learn/courses/30/lessons/181919
 */

import java.util.ArrayList;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        // while문을 돌기 전에 n을 추가해야 됨에 유의.
        list.add(n);
        
        while(n != 1) {
            if (n % 2 == 0) {
                n /= 2;
                list.add(n);
            }
            else {
                n = (3 * n + 1);
                list.add(n);
            }
        }
        
        // ArrayList를 int[]로 변환
        int len = list.size();
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = list.get(i);
        }
        
        return ans;
    }
}
