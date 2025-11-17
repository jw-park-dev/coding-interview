* 출처: [217. Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)
---
* **문제 요약:** 주어진 정수형 배열에 동일한 원소가 최소 2개 이상 존재하면 true, 아니면 false를 반환.
* **접근 방식:** 이미 존재하는 원소를 set에 add하려고 하면 false를 반환하는 특성으로 원소의 중복을 판별.
---
### 풀이
```java

public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            if (!set.add(n)) {
                return true;
            }
        }

        return false;
        
    }

```
* 시간 복잡도: for 루프는 배열의 모든 요소를 한 번씩 확인하므로 최대 n번 반복, O(N).
* 공간 복잡도: 입력 배열에 중복이 하나도 없다면, 배열의 모든 요소(n개)가 HashSet에 저장되므로, O(N).
---

####  메모
* 관련 문법: [HashSet.add()](https://github.com/jw-park-dev/coding-interview/blob/main/java-syntax/hashset.md)
