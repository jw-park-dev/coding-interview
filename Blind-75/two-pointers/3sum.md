## [15. 3Sum](https://leetcode.com/problems/3sum/)

#### 문제 요약

정수 배열 `nums`에서 합이 0이 되는 서로 다른 세 숫자의 조합(Triplet)을, 중복 없이 모두 찾아 리스트로 반환.

#### 조건

- 세 숫자의 인덱스는 서로 달라야 함.
- 동일한 숫자 구성의 조합(순서만 다른 경우 포함)이 결과에 중복해서 들어가면 안 됨.
- 배열의 정렬(`Arrays.sort`)이 선행되어야 함.

---

#### 핵심 아이디어

배열을 정렬한 후, 첫 번째 숫자를 고정(`i`)하고 나머지 두 숫자를 투 포인터(`left`, `right`)로 조절하여 합이 0이 되는 조합을 찾음.

---

### 해설

1. **변수 선언 및 정렬**: 결과 리스트와 포인터 변수들을 미리 선언하고, 로직 적용을 위해 배열을 오름차순으로 정렬.
2. **첫 번째 숫자 순회**: `i`는 고정된 첫 번째 숫자임. 세 개의 숫자를 선택해야 하므로, `i`는 끝에서 세 번째 자리(`nums.length - 2`)까지만 순회하면 충분함.
3. **중복된 `i` 건너뛰기**: 정렬된 상태이므로, 이전 숫자와 동일한 값이면 이미 그 숫자를 기준으로 가능한 모든 조합을 검사한 셈이므로 건너뜀(`continue`).
4. **투 포인터 설정 및 탐색**: `i` 바로 다음을 `left`, 배열 끝을 `right`로 두고 두 포인터가 만날 때까지 반복.
5. **포인터 이동 로직**: 세 수의 합(`sum`)을 계산하여, 0보다 작으면 값을 키우기 위해 `left`를 우측 이동, 0보다 크면 값을 줄이기 위해 `right`를 좌측 이동.
6. **정답 처리**: 합이 0인 경우 결과 리스트에 추가.
7. **내부 중복 건너뛰기**: 정답을 찾은 상황에서, `left`나 `right`가 가리키는 다음 숫자가 현재와 같다면 또 같은 정답이 만들어지므로, 값이 달라질 때까지 포인터를 이동시켜 중복을 제거.
8. **탐색 재개**: 중복을 모두 건너뛴 후, 새로운 조합을 찾기 위해 `left`와 `right`를 한 칸씩 더 이동.

---

### 풀이: Two Pointers

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 1.
        int left, right, currentSum;
        int len = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        // 2.
        for (int i = 0; i < len - 2; i++) {
            // 3.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 4.
            left = i + 1;
            right = len - 1;
            while (left < right) {
                currentSum = nums[i] + nums[left] + nums[right];
                // 5.
                if (currentSum < 0)
                    left += 1;
                else if (currentSum > 0)
                    right -= 1;
                else {
                    // 6.
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 7.
                    while (left < right && nums[left] == nums[left + 1])
                        left += 1;
                    while (left < right && nums[right] == nums[right - 1])
                        right -= 1;

                    // 8.
                    left += 1;
                    right -= 1;
                }
            }
        }
        return list;
    }
}
```

---

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        // 1. 변수 초기화 및 정렬
        // left, right: 투 포인터 인덱스
        // currentSum: 현재 세 수의 합을 저장할 변수
        // len: 반복문 조건 최적화를 위해 배열 길이 미리 저장
        // list: 정답(Triplet)들을 담을 결과 리스트
        // Arrays.sort: 투 포인터 알고리즘을 사용하기 위해 배열을 오름차순으로 정렬 (필수 과정)
        int left, right, currentSum;
        int len = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        // 2. 첫 번째 숫자(i) 고정 및 순회
        // 3개의 숫자(i, left, right)를 선택해야 하므로, 기준이 되는 i는 
        // 뒤에 최소 2개의 숫자가 남아있어야 함. 따라서 전체 길이에서 2를 뺀 지점까지만 순회.
        for (int i = 0; i < len - 2; i++) {
            
            // 3. 기준 숫자(i)의 중복 제거
            // 정렬된 상태이므로, 현재 숫자(nums[i])가 바로 앞 숫자(nums[i-1])와 같다면
            // 이미 앞선 루프에서 해당 숫자를 기준으로 모든 조합을 찾은 상태임.
            // 중복된 결과(List)가 생성되는 것을 막기 위해 건너뜀(continue).
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 4. 투 포인터 위치 초기화
            // left: 기준 숫자(i)의 바로 다음 칸 (작은 값 후보)
            // right: 배열의 맨 끝 칸 (큰 값 후보)
            left = i + 1;
            right = len - 1;
            
            // 두 포인터가 서로 교차하기 전까지 반복
            while (left < right) {
                // 세 수의 합 계산
                currentSum = nums[i] + nums[left] + nums[right];
                
                // 5. 합의 결과에 따른 포인터 이동
                // 합이 0보다 작으면: 값을 키워야 하므로 작은 쪽(left)을 우측으로 이동
                if (currentSum < 0)
                    left += 1;
                // 합이 0보다 크면: 값을 줄여야 하므로 큰 쪽(right)을 좌측으로 이동
                else if (currentSum > 0)
                    right -= 1;
                // 합이 0인 경우 (정답 발견)
                else {
                    // 6. 결과 저장
                    // 현재 찾은 세 개의 숫자 조합을 리스트로 묶어 결과 리스트(list)에 추가
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 7. 내부 포인터 값의 중복 제거
                    // 정답을 찾은 후, left나 right의 다음 숫자가 현재 숫자와 동일하다면
                    // 똑같은 조합이 중복 저장될 수 있음.
                    // 값이 달라질 때까지 포인터를 이동시켜 중복을 건너뜀.
                    // (IndexOutOfBounds 방지를 위해 left < right 조건 필수 포함)
                    while (left < right && nums[left] == nums[left + 1])
                        left += 1;
                    while (left < right && nums[right] == nums[right - 1])
                        right -= 1;

                    // 8. 다음 탐색을 위한 이동
                    // 중복을 모두 제거했다면, 새로운 조합을 찾기 위해
                    // left와 right를 동시에 한 칸씩 안쪽으로 좁힘.
                    left += 1;
                    right -= 1;
                }
            }
        }
        return list;
    }
}
```

