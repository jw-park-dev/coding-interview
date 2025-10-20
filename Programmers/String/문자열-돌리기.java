/*
 * [문제 링크]
 * https://school.programmers.co.kr/learn/courses/30/lessons/181945?language=java
 */

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] arr = str.toCharArray();
        for (char c : arr) {
            System.out.println(c);
        }
    }
}
