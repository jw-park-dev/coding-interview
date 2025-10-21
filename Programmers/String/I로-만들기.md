## 1. 문제

* **문제 링크:** [[문제 URL](https://school.programmers.co.kr/learn/courses/30/lessons/181834?language=java)]
* **난이도:** [Level 0]
* **유형:** [StringBuilder/char/char[]]

## 2. 풀이

```java
class Solution {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();
        char[] arr = myString.toCharArray();
        
        for (char c : arr) {
            if (c - 'a' < 12) {
                sb.append('l');
            }
            else {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
```

## 3. 문법
### `c - 'a'` (char의 산술 연산)

* **설명**: Java에서 `char` 타입은 **문자**인 동시에 **숫자(정수)** 값을 가짐 (내부적으로는 16비트 UTF-16 코드 유닛).
* **특징**:
    * `char`는 `'a'`, `'b'`처럼 문자로 표현되지만, 실제로는 `97`, `98` (ASCII/Unicode 값) 같은 정수 값을 저장함.
    * `char` 타입에 산술 연산자(`+`, `-`, `*`, `/`)를 사용하면, `char`는 자동으로 `int` 타입으로 승격(promotion)되어 **숫자 연산**을 수행함.
* **`c - 'a'`의 의미**:
    * `c`의 정수 값에서 `'a'`의 정수 값을 뺌.
    * 알파벳 소문자('a'~'z')는 ASCII/Unicode 테이블에서 연속적인 숫자 값을 가짐.
        * `'a'` = 97
        * `'b'` = 98
        * ...
        * `'l'` = 108
        * `'m'` = 109
    * `c - 'a'`는 `c`가 알파벳 'a'로부터 몇 번째 떨어져 있는지를 계산함.
        * `'a' - 'a'` = 0
        * `'b' - 'a'` = 1
        * `'l' - 'a'` = 11
        * `'m' - 'a'` = 12
* **코드 분석 (`if (c - 'a' < 12)`)**:
    * `c - 'a'`가 12보다 작다는 것은, `c`가 'a'부터 'l'까지의 문자(`'a'`, `'b'`, ..., `'k'`, `'l'`) 중 하나라는 의미.
    * 즉, "c가 'm'보다 앞에 있는 소문자 알파벳인가?"를 숫자로 판별하는 것. (물론 `c < 'm'`과 동일한 검사임)

---

### `char` (자료형)

* **설명**: Java의 8가지 **기본 자료형(primitive type)** 중 하나로, **단일 문자**를 저장하기 위해 사용됨.
* **리터럴(Literal) 표기**:
    * **작은따옴표(`' '`)**로 감싸서 표현함. (e.g., `'a'`, `'1'`, `'%'`)
    * (참고) `String`은 **큰따옴표(`" "`)**로 감싸며, 0개 이상의 문자 *집합*(객체)임.
* **크기**: 2바이트 (16비트).
* **표현**: **UTF-16** 유니코드 문자. (전 세계의 다양한 문자를 표현 가능)
* **핵심 특징 (숫자)**:
    * `char`는 본질적으로 **부호 없는(unsigned) 정수형**.
    * 문자에 해당하는 유니코드 코드 포인트(숫자) 값을 저장함.
    * `char c = 65;` (숫자 65) -> `c`를 출력하면 'A'가 나옴 (ASCII/Unicode 65 = 'A').
* **사용처**:
    * `String.charAt(index)`의 반환값으로 사용.
    * `String.toCharArray()`로 변환된 `char[]` 배열에서 각 문자를 다룰 때.
    * 문자의 아스키/유니코드 값을 이용한 산술/비교 연산이 필요할 때.
