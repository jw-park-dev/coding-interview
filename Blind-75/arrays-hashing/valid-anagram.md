* 문제 링크: https://leetcode.com/problems/valid-anagram/description
* 날짜: 2025-11-02(o)
* 자료구조: Array
* 문제 요약: 두 문자열 s와 t가 애너그램이면 true를, 아니면 false를 반환.
 

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

        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] != tArr[i]) {
                return false;
            }
        }
        return true;
    }
}
```

---
* Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
  *  int[26] 배열 방식이 아닌 유니코드 전체를 처리(예: 해시맵 사용)할 수 있는지 묻는 의도.
---
##### 유니코드(Unicode)
* 전 세계의 모든 문자를 컴퓨터에서 일관되게 표현하고 다룰 수 있도록 설계된 국제 표준 문자 규약.
* 과거에는 ASCII(영문 중심) 코드처럼 지역이나 언어별로 다른 문자 코드를 사용했으나, 유니코드는 이 모든 문자에 고유한 숫자(코드 포인트)를 부여.
  * 'a' (U+0061), '가' (U+AC00), '😂' (U+1F602) 등 이모지, 고대 문자, 한글, 한자, 특수 기호 등을 모두 포함.
---
##### getOrDefault 메서드
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

