### [1. Two Sum](https://leetcode.com/problems/two-sum/description/)

---

### 문제 요약
정수 배열 `nums`와 정수 `target`이 주어졌을 때, 더해서 `target`이 되는 두 숫자의 인덱스를 찾아서 정수 배열 형태로 반환.

#### 조건
1. 정확히 하나의 솔루션만 존재한다고 가정.
2. 같은 요소를 두 번 사용할 수 없음 (자신의 인덱스와 매칭된 인덱스가 같으면 안 됨).

---

### 해설

※ 핵심: 값(difference)을 찾아야 하므로, key를 입력값인 int[] nums의 원소(nums[i])로, value를 nums의 인덱스 (i)로 설정.

1. 숫자 값(Key)을 통해 인덱스(Value)를 빠르게 조회(`O(1)`)하기 위해 HashMap을 생성.
2. 배열 `nums`를 한 번 순회하며 모든 숫자와 그에 해당하는 인덱스를 맵에 저장.
3. 다시 배열을 순회하며, 현재 숫자(`nums[i]`)와 더했을 때 `target`이 되는 값(`difference`)을 계산.
4. 맵에 `difference` 키가 존재하는지 확인하고, 동시에 그 키의 값이 현재 인덱스 `i`와 다른지 확인 (자기 자신을 중복 사용 방지).
5. 조건이 맞다면, 맵에서 찾은 인덱스와 현재 인덱스 `i`를 배열에 담아 반환.
6. 문제 조건상 반드시 답이 존재하지만, 컴파일 에러 방지를 위해 빈 배열 반환 코드 작성.

---

### 풀이: Hash Table

```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();  // 1.
        
        for (int i = 0; i < nums.length; i++) {  // 2.
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {  // 3.
           int difference = target - nums[i];
           if (map.containsKey(difference) && (map.get(difference) != i)) {  // 4.
             return new int[]{map.get(difference), i};  // 5.
           }  
        }
        return new int[0];  // 6.
    }
}
```

- **시간 복잡도:** 배열을 두 번 순회하고(`2 * N`), 해시맵의 조회 및 삽입 시간은 평균적으로 $O(1)$이므로, 전체 시간 복잡도는 $O(N)$.
- **공간 복잡도:** 최악의 경우 배열의 모든 요소를 해시맵에 저장해야 하므로 $O(N)$.

---

### **문법: `HashMap`**

**1. `put(K key, V value)`**: 이미 동일한 키가 존재하면 기존 값을 덮어씀.

**2. `get(Object key)`**: 키가 없으면 `null` 반환.

```java
// nums = [2, 7, 11, 15], target = 9 라고 가정
Map<Integer, Integer> map = new HashMap<>();

// 1. 데이터 저장 (값 -> 인덱스)
map.put(2, 0); 
map.put(7, 1);
// map 상태: {2=0, 7=1, ...}

// 2. 키 존재 확인 (target - nums[0] = 9 - 2 = 7)
boolean exists = map.containsKey(7); // true 반환

// 3. 값 가져오기
int index = map.get(7); // 1 반환
```
