/*
 * [문제 링크]
 * https://school.programmers.co.kr/learn/courses/30/lessons/181946
 * [비고]
 * System.out.print(String 변수) : 서식 지정자를 사용하지 않을 때는 print()를 사용.
 */

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.print(a+b);
        // String ans = a + b;
        // System.out.printf("%s", ans);
    }
}
