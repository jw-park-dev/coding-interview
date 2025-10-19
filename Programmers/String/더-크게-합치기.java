/*
 * [문제 링크]
 * https://school.programmers.co.kr/learn/courses/30/lessons/181936?language=java
 * [비고]
 * Java에서 `+` 연산자는 피연산자 중 하나라도 `String` 타입이면 문자열 결합(concatenation) 연산자로 동작.
 * java 변수명은 camelCase로 작성.
 */


class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int aThenB = Integer.parseInt(a + "" + b);
        int bThenA = Integer.parseInt(b + "" + a);
        
        if (aThenB >= bThenA) {
            return aThenB;
        } 
        return bThenA;
    }
}
