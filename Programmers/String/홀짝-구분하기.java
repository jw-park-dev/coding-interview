/*
 * [문제 링크]
 * https://school.programmers.co.kr/learn/courses/30/lessons/181944
 * [비고]
 * System.in: "표준 입력 스트림"을 뜻하며, 특별한 설정이 없으면 키보드(터미널) 입력을 의미하며 
 * Scanner가 어디로부터 데이터를 읽어올지 알려주는 인자(argument)
 * nextInt(): 사용자가 입력한 값을 정수(int)로 읽어들임. 사용자가 값을 입력 후, Enter를 쳐야 값을 반환. 
 * System.out.printf("%d~", 변수명) : printf()는 서식 지정자(Format Specifier)를 사용할 때 사용.
 */

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n % 2 == 0) {
            System.out.printf("%d is even", n);
        }
        else {
            System.out.printf("%d is odd", n);
        }
    }
