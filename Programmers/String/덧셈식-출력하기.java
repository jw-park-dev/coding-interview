/*
 * [문제 링크]
 * https://school.programmers.co.kr/learn/courses/30/lessons/181947?language=java
 * [비고]
 * "" 내부에 서식 문자열이 들어가야.
 */

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = a + b;
        System.out.printf("%d + %d = %d", a, b, c);
    }
}
