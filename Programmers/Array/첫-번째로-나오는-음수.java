/*
 * [문제 링크]
 * https://school.programmers.co.kr/learn/courses/30/lessons/181896
 * [비고]
 * int arr.length : 배열의 길이 반환. length에 () 없음에 유의.
 */

class Solution {
    public int solution(int[] num_list) {
        int ans = 0;
        
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] < 0) {
                return i;
            }
        }
        return -1;
    }
}
