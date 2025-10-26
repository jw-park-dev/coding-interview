/*
 * [문제 링크]
 * https://school.programmers.co.kr/learn/courses/30/lessons/181870
 * [비고]
 * list.toArray(new String[0]); return list (x)
 */

import java.util.List;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] strArr) {
        List<String> list = new ArrayList<>();
        for (String s : strArr) {
            if (!s.contains("ad")) {
                list.add(s);
            }
        }
        
        String[] ans = list.toArray(new String[0]);
        // String[] ans = new String[list.size()];
        return ans;
    }
}
