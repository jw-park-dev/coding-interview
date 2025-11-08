* 문제 링크: https://leetcode.com/problems/group-anagrams
* 날짜: 2025-11-08(x)
* 자료구조: 
* 문제 요약: String[]가 주어졌을 때, anagram끼리 묶은 String[]를 원소로 하는 List를 반환.  
* 풀이 요약: 
  * (1) 정수 배열을 키로, 키인 정수배열과 같은 애너그램들을 원소로 가지는 List를 값으로 할 HashMap 생성.
  * (2) 모든 각각의 문자열(s)들을 정수 배열(intArr)로 나타낸 다음
  * (3) 각각의 정수 배열을 map의 키로 하는 List가 존재하지 않으면, 해당 정수 배열을 키(k)로 하는<br>
  빈 List를 생성한 다음, 현재의 정수 배열에 대응되는 문자열(s)을 키(k)로 하는 List에 추가하고
  * (4) 해당 정수 배열을 키로 하는 List가 이미 존재하면, map에 아무것도 안한 후에, <br>
  현재의 정수 배열과 키 값이 같은 List에 현재의 문자열(s)를 원소로 추가.
### 정수 배열(int[]) 활용 
```java
import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        
        for (String s: strs) {
            int[] intArr = new int[26];
            for (char c: s.toCharArray()) {
                intArr[c - 'a'] += 1;
            }
            String k = Arrays.toString(intArr);
            map.putIfAbsent(k, new ArrayList<>());
            map.get(k).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}

```
```java
import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // String (k): 애너그램 별 그룹을 식별하는 map의 유일키(문자열 구성).
        // List<String> (v): 특정 유일키(k)와 애너그램 관계인 문자열들의 묶음.
        Map<String, List<String>> map = new HashMap<>();
        
        // 파라미터로 주어진 모든 문자열(strs)들 각각(s)에 대해서
        for (String s: strs) {
            // 알파벳 구성을 저장할 26칸짜리 정수 배열을 생성하고
            int[] intArr = new int[26];
            // 각 문자(c)를 'a'와 빼기 연산(c - 'a')을 하여 0~25 범위의 고유한 인덱스(정수)로 변환
            for (char c: s.toCharArray()) {
                // s에서 특정 문자가 나올 때마다, 해당 문자에 대응되는 intArr의 값이 +1이됨.
                intArr[c - 'a'] += 1;
            }
            // 배열은 내용이 같아도 메모리 주소가 다르면 서로 다른 키로 인식되므로
            // 배열을 문자열로 변환해서 map의 키(k)로 삼는다.
            String k = Arrays.toString(intArr);
            // k와 동일한 문자열 구성이 map에 아직 없을 때만, k를 키로 하는 빈 List를
            // 값으로 put하고, 이미 있으면 아무것도 하지 않는다.
            map.putIfAbsent(k, new ArrayList<>());
            // 현재 s의 문자열 구성인 k를 키로 하는 리스트를 가져와서 s를 List의 원소로 추가한다.
            map.get(k).add(s);
        }
        // map의 값들(List<String>)을 map.values()로 가져와서
        // 반환형이 List<List<String>>이므로 ArrayList로 감싸서 반환.
        return new ArrayList<>(map.values());
    }
}
```
* 시간 복잡도: 바깥쪽 for문은 배열(strs)의 모든 문자열의 개수만큼 순회. (N = strs 배열의 길이, 즉 문자열의 총 개수) <br>
  내부 for문은 각 문자열 s의 모든 문자를 순회하며 알파벳 개수 배열(intArr)을 채움. (K = strs 배열 내 문자열의 최대 길이) <br>
  O(N * K) : N개의 문자열을 하나씩 확인하고(O(N)), 각 문자열마다 최대 K개의 문자를 확인(O(K))
  
* 공간 복잡도: map은 strs 배열의 모든 문자열(N개)을 저장하고, N개의 문자열에 포함된 모든 문자의 총합에 비례하는 공간이 필요.<br>
K를 문자열의 최대 길이라고 할 때, 맵의 값(Value)으로 저장되는 모든 문자열 리스트는 총 O(N * K)의 공간을 차지하므로, O(N * K).
---
핵심 아이디어
* 문자열 배열의 구성을 유일한 키(k)로 변환하여 HashMap을 사용. <br>
  예를 들어 eat -> a:1, e:1, t:1의 경우, 'a:1, e:1, t:1'라는 구성을 가진 단어들은 모두 같은 그룹임. <br>
  e.g. tea -> a:1, e:1, t:1, bat -> a:1, b:1, t:1.  이 '알파벳 구성' 자체를 HashMap의 키(k)로 사용.


  
추가 설명
* s = "eat" 라면, intArr 배열은 \[1, 0, 0, 0, 1, ... , 1, ...]\ 상태가 됨. (a=1, e=1, t=1))
* 문자열 구성: Arrays.toString()을 사용해 count 배열을 "\[1, 0, 0, 0, 1, ... , 1, ...]\" 과 같은 문자열(String)로 변환. <br>
이 문자열 키는 '알파벳 구성'이 같으면 항상 동일함. (즉, "eat", "tea", "ate"는 모두 같은 문자열 key를 갖게 됨.

---
### Arrays.sort() 활용 
```java
class Solution {
    /**
     * 문자열 배열을 받아 애너그램 단위로 그룹화.
     * 핵심 아이디어: 애너그램 관계인 문자열들은 구성하는 알파벳이 같으므로,
     * 정렬했을 때 항상 동일한 문자열이 됨.
     * 자료구조: HashMap을 사용하여 그룹핑.
     * - Key: 각 문자열을 정렬한 결과 (예: "aet")
     * - Value: 정렬 전의 원본 문자열들을 담는 리스트 (예: ["eat", "tea", "ate"])
     * 로직: 입력 배열의 모든 문자열을 순회하며 정렬된 형태를 key로 하여 HashMap에 저장.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // 애너그램 그룹을 저장할 HashMap 생성.
        Map<String, List<String>> map = new HashMap<>();

        // 입력된 모든 문자열을 순회.
        for (String s : strs) {
            // 문자열을 정렬하기 위해 char 배열로 변환.
            char[] charArr = s.toCharArray();
            
            // char 배열을 알파벳 순서로 정렬.
            // 이 정렬된 결과가 애너그램 그룹을 구별하는 기준이 됨.
            Arrays.sort(charArr);
            
            // 정렬된 char 배열을 다시 String으로 변환하여 Map의 Key로 사용.
            String key = new String(charArr);

            // 이 Key에 해당하는 그룹(List)이 이미 Map에 있는지 확인.
            if (map.containsKey(key)) {
                // 이미 해당 Key의 그룹이 존재하면, 기존 리스트를 가져와 현재 문자열을 추가.
                List<String> list = map.get(key);
                list.add(s);
            } else {
                // 해당 Key의 그룹이 처음 발견된 경우, 새로운 리스트를 생성.
                List<String> newList = new ArrayList<>();
                // 새 리스트에 현재 문자열을 첫 번째 원소로 추가.
                newList.add(s);
                // 새로운 Key와 리스트를 Map에 저장.
                map.put(key, newList);
            }
        }

        // 그룹핑이 완료된 Map에서 Value들(각 애너그램 그룹 리스트)만 추출하여 최종 결과로 반환.
        return new ArrayList<>(map.values());
    }
}
```
