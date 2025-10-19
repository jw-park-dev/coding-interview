/*
 * [문제 링크]
 * https://school.programmers.co.kr/learn/courses/30/lessons/181935
 * [비고]
 * 모든 원소들이 곱해지는 prod의 초깃값을 0이 아닌 1로 설정해야 함에 유의.
 */

class Solution {
    public int solution(int[] num_list) {
        int prod = 1;
        int sum = 0;
        
        for (int n : num_list) {
            prod *= n;
        }
        
        for (int n : num_list) {
            sum += n;
        }
        
        sum = sum * sum;
        
        if (prod < sum) {
            return 1;
        }
        
        return 0;
    }
}
