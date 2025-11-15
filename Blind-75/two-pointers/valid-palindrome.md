
---
* 출처: [125. Valid Palindrome_1. 유효한 팰린드롬](https://leetcode.com/problems/valid-palindrome/description/)
---
* **문제 요약:** 주어진 String이 Palindrome이면 true, 아니면 false를 반환.
  * **조건:** 문제에서 s가 Palindrome이기 위한 조건은, 1) s를 구성하는 모든 영문자는 소문자로 변환한 상태에서 <br>
              2) 영문 소문자와 숫자인 경우를 제외한 나머지들(공백 등)은 Palindrome인지 판별하는 대상에서 제외하고 <br>
              s와 s의 역순값을 비교했을 때 같으면 s는 Palindrome이다. 
---
### 해설
1. s가 유효한 Palindrome인지 판별하는 반복문의 종료 조건은 left와 right가 같은 인덱스를 가리키는(서로 겹치는) 순간.
2. 현재 left가 가리키는 문자가 숫자나 영문자가 아니면, 비교 대상으로 유효한 문자가 아니므로, 유효한 비교 대상인 문자를 가리키기 위해 다음 문자로 이동.
3. 현재 left와 right가 가리키는 각각의 문자가 비교 대상으로 유효한 경우
4. 대문자일 수 있으므로 소문자로 변환해서 비교했을 때 서로 다르다면, 한 쌍만 값이 서로 달라도 Palindrome이 아니므로 false를 반환하고 (Palindrome이 아닐 조건)
5. 같다면 현재까지 s는 Palindrome일 가능성이 있으므로 각각 중앙으로 한칸 씩 이동시켜서 left < right일 때까지 확인 과정을 반복.
6. s의 모든 유효한 문자에 대한 비교를 맞췄으므로 s는 Palindrome.
---
### 풀이: Two Pointers
```java

public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        // 1.
        while (left < right) {
            // 2.
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            } else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            } else {  // 3. 
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {  // 4.
                    return false;
                }
                // 5.
                left++;
                right--;
            }
        }
   
        return true;  // 6. 
    }

```
* 시간 복잡도: 두 포인터(left, right)는 문자열을 최대 한 번만 순회하므로 O(N).
* 공간 복잡도: left와 right라는 두 개의 정수형 변수만 사용하고, 필요한 메모리 공간이 입력 크기와 상관없이 일정하므로, O(1).
---

####  메모
* Q: left와 right 포인터가 비대칭적인(서로 다른) 횟수만큼 건너뛰게 되어도 로직에 문제가 없는 이유?
* A: 이 문제는 '인덱스 대칭'이 아닌 '유효 문자 순서 대칭'을 검사하는 것이기 때문. 왼쪽에서 유효 문자를 찾기 위해 1칸을 건너뛰고<br>
     오른쪽에서 찾기 위해 3칸을 건너뛴 상태에서 두 문자를 비교해도 상관이 없다.
* [Character.isLetterOrDigit() .toLowerCase()](https://github.com/jw-park-dev/coding-interview/blob/main/java-syntax/character.md)
