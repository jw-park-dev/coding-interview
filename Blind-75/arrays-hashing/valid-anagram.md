* 문제 링크: https://leetcode.com/problems/valid-anagram/description
* 날짜: 2025-11-02(o)
* 자료구조: Array
* 문제 요약: 두 문자열 s와 t가 애너그램이면 true를, 아니면 false를 반환.
* 풀이 요약: 애너그램이 되기 위한 조건은 1.길이가 같다. 2.문자열을 구성하는 문자의 구성이 같다.
  * (1) s와 t의 길이가 같은지 확인.
  * (2) String형인 s와 t를 문자 배열로 변환해서 알파벳순으로 정렬. 
  * (3) 정렬된 s와 t가 애너그램이면, 인덱스가 같으면 값도 같아야되므로 for문으로 한 문자씩 비교.
### 정렬(Sorting) 
```java
import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);

        // for문을 사용한 직접 비교보다는 Arrays.equals() 사용을 권장.
        // for (int i = 0; i < sArr.length; i++) {
            // if (sArr[i] != tArr[i]) {
                // return false;
            // }
        // }
        // return true;
    }
}
```
* 시간 복잡도: s와 t에 대한 toCharArray()는 O(N), Java의 Arrays.sort() (Dual-Pivot Quicksort)는 평균 O(NlogN),
  <br> sArr, tArr에 대한 for문 순회도 O(N), arr는 26 상수이므로 순회 시 O(1). 시간 복잡도는 O(NlogN).
* 공간 복잡도: sArr, tArr은 O(N), Arrays.sort()는 정렬 시 재귀 스택 공간 등으로 O(log N)을 사용할 수 있으므로
  <br> 공간 복잡도는 O(N).
  <br>
---
* 풀이 요약: 문제의 제약 조건 '알파벳 소문자로만 구성(s and t consist of lowercase English letters)'
* 각각의 문자(c)에 대해, c - 'a' 연산을 통해 반환되는 정수값(0 ~ 25)은 arr의 인덱스(0 ~ 25)에 매핑되며 <br>
  인덱스 0 ~ 25는 알파벳 소문자 'a' ~ 'z'에 순서대로 대응됨. arr[i]의 값은 c가 해당 문자 배열에서 몇 번 나왔는지를 의미.     
  * (1) s와 t의 길이가 같은지 확인.
  * (2) 먼저 문자열 s를 구성하는 각각의 문자 - 'a'에 대응되는 값을 +1 처리.
  * (4) t에 대해서는 -1 처리.
  * (5) sArr와 tArr가 애너그램이라면, arr의 모든 값은 0일 수 밖에 없으며, 하나라도 0이 아니면 애너그램이 아님. 
### 빈도수 배열(Frequency Array)
```java
class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] arr = new int[26];
    
        for (int i =0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a'] += 1;
        }

        for (int i =0; i < t.length(); i++) {
            arr[t.charAt(i) - 'a'] -= 1;
        }

        // 배열에 후위 연산자 사용 고려.
         // for (int i = 0; i < s.length(); i++) {
        //     arr[s.charAt(i) - 'a']++;
        //     arr[t.charAt(i) - 'a']--;
        // }

        for (int n : arr) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }
}

```
* 시간 복잡도: s와 t에 대한 for문 순회는 O(N), arr는 26 상수이므로 순회 시 O(1). 시간 복잡도는 O(N).
* 공간 복잡도: O(N) 공간을 사용하는 sArr, tArr을 사용하지 않았으므로, int[26] 배열만 상수로 계산되어 O(1).

---
* Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
  *  int[26] 배열 방식이 아닌 유니코드 전체를 처리(예: 해시맵 사용)할 수 있는지 묻는 의도.
---
### 유니코드(Unicode)
* 전 세계의 모든 문자를 컴퓨터에서 일관되게 표현하고 다룰 수 있도록 설계된 국제 표준 문자 규약.
* 과거에는 ASCII(영문 중심) 코드처럼 지역이나 언어별로 다른 문자 코드를 사용했으나, 유니코드는 이 모든 문자에 고유한 숫자(코드 포인트)를 부여.
  * 'a' (U+0061), '가' (U+AC00), '😂' (U+1F602) 등 이모지, 고대 문자, 한글, 한자, 특수 기호 등을 모두 포함.
---
### getOrDefault 메서드
1. 사용 가능 자료형
* java.util.Map 인터페이스를 구현하는 모든 자료형에서 사용 가능.
  * HashMap, LinkedHashMap, TreeMap, ConcurrentHashMap 등

2. 설명 및 구조
* V getOrDefault(Object key, V defaultValue)
  * key: 조회하려는 키.
  * defaultValue: 해당 키가 맵에 존재하지 않을 경우 반환될 기본값.
* 맵(Map)에서 특정 키(key)에 해당하는 값(value)을 조회하려 할 때 사용.
* 키가 존재하면: 해당 키의 값을 반환함.
* 키가 존재하지 않으면: null을 반환하는 대신, 메서드의 두 번째 인자로 전달된 '기본값(defaultValue)'을 반환.

3. 활용
* 맵을 이용해 빈도수(frequency)를 계산하거나, null 값 처리를 간결하게 하고 싶을 때 사용.
* getOrDefault를 사용하면, 키의 존재 여부를 containsKey 등으로 먼저 확인하고 분기 처리(if-else)하는 코드를 단 한 줄로 줄일 수 있음.


4. 사용 시 주의점
* getOrDefault는 키가 없을 때 기본값을 반환할 뿐, 해당 키와 기본값을 맵에 삽입(put)하지 않음.
* 조회 후 값이 없으면 맵에 기본값을 삽입까지 해야 한다면 putIfAbsent 또는 computeIfAbsent 메서드를 고려해야 함.

5. 예시 코드 
* 문자열에 포함된 각 알파벳의 개수를 세는 예시.

```java
import java.util.Map;
import java.util.HashMap;

class Example {
    public static void main(String[] args) {
        String s = "apple";
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            // c 키가 있으면: 기존 값을 가져옴 (예: 'p'가 두 번째 나올 때 1을 가져옴)
            // c 키가 없으면: 기본값 0을 가져옴 (예: 'a'가 처음 나올 때 0을 가져옴)
            int count = freqMap.getOrDefault(c, 0);
            
            // 가져온 값에 1을 더해 맵에 다시 넣음
            freqMap.put(c, count + 1);
        }

        // 예시값 "apple" 실행 후 freqMap 상태:
        // {a=1, p=2, l=1, e=1}

        // 'p' 조회 (키가 존재)
        System.out.println(freqMap.getOrDefault('p', 0)); // 출력: 2

        // 'z' 조회 (키가 존재하지 않음)
        System.out.println(freqMap.getOrDefault('z', 0)); // 출력: 0 (기본값)

        // 'z' 조회 후 맵 상태 (주의: 'z'는 추가되지 않음)
        System.out.println(freqMap); // 출력: {a=1, p=2, l=1, e=1}
    }
}
```
---
### char - 'a'
* char는 내부적으로 숫자(유니코드 또는 ASCII 값)로 처리됨.
* c - 'a' 연산은 '해당 문자가 'a'로부터 몇 번째 떨어져 있는지'를 계산하는 것임.
* 알파벳 소문자 'a'부터 'z'까지는 유니코드 테이블에서 연속된 숫자 값을 가짐.
* (ASCII 코드 기준 'a'는 97, 'b'는 98, 'c'는 99, ...)
* char - 'a'은 문자를 int[26] 배열의 인덱스(0~25)로 매핑하는 데 사용됨.
  * 'a'의 경우: 'a' - 'a' = 0
  * 'b'의 경우: 'b' - 'a' = 1 ...
  * 'z'의 경우: 'z' - 'a' = 25

---
### Arrays.equals( , ) 메서드
1. 설명
* 두 배열이 '같은지' 여부를 비교하여 boolean 값으로 반환.
* char[]와 같은 기본형(primitive type) 배열의 경우, 다음 두 조건을 모두 만족해야 true를 반환.
  * (1) 두 배열의 길이가 같다.
  * 같은 인덱스에 있는 모든 요소가 == 연산으로 비교했을 때 같다.

2. 구조 (기본형 배열 기준)
```java
public static boolean equals(char[] a, char[] a2)
```

* int[], double[], boolean[] 등 모든 기본형 타입에 대해 오버로딩(overloading)되어 있음.
* 객체 배열(Object[])용 equals 메서드도 존재.

3. 활용
* for 루프를 직접 작성하는 것보다 Arrays.equals()를 사용하는 것이 항상 권장됨.
  * 가독성: 코드가 훨씬 간결해지고, "두 배열을 비교한다"는 의도가 명확하게 드러남.
  * 표준성: Java에서 배열을 비교하는 표준적인(idiomatic) 방법.

4. 사용 시 주의 사항
* Null 처리: Arrays.equals(a, b)는 null 값 처리에 안전.
  * a와 b가 모두 null이면 true를 반환합니다.
  * 둘 중 하나만 null이면 false를 반환합니다.
  * (반면, 직접 for 루프를 작성하면 sArr.length 등에서 NullPointerException이 발생할 수 있음.)

5. 객체 배열 vs 기본형 배열:
* char[], int[] 등 기본형 배열은 == 연산자로 값을 비교.
* String[], Integer[] 등 객체 배열은 각 요소의 .equals() 메서드를 호출하여 비교.
* 다차원 배열: Arrays.equals()는 2차원 이상의 배열(예: int[][])을 '깊은(deep)' 비교하지 않는다. (배열의 참조 주소값만 비교)
* 다차원 배열의 내부 요소까지 모두 비교하려면 Arrays.deepEquals() 메서드를 사용해야 함함.
