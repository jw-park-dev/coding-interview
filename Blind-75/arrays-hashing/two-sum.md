* 문제 링크: https://leetcode.com/problems/two-sum
* 날짜: 2025-11-02(x)
* 자료구조: HashMap
* 문제 요약: 정수 배열(nums)에서 합이 target이 되는 두 원소의 인덱스를 원소로 하는 정수 배열을 반환.
  * 조건: 1) 답은 하나만 존재. 2) 같은 원소를 두 번 사용하는 것은 안됨.
* 풀이 요약:
  * (1) HashMap을 생성하고, nums의 값(nums[i])을 key로, for문의 인덱스(i)를 value로 하는 Entry(키-값 쌍)를 모두 추가. 
  * (2) nums[i]와 더해서 target이 되는 값(difference)의 인덱스가, 우리가 찾아서 반환해야 하는 값이다.
  * (3) 해당 값이 현재 map에 존재하는 동시에, 문제에서 '같은 원소를 두 번 사용하는 것은 안된다'는 조건이 있으므로 <br>
        값이 difference인 원소의 인덱스가, for문의 현재 인덱스(i)와 다르다면
  * (4) 값이 difference인 원소의 인덱스와, for문의 현재 인덱스(i)를 정수 배열에 담아 반환하고
  * (5) 조건에서 '답은 하나만 존재'한다고 했으나, if문 안에만 return문이 존재하는 상태이므로, for문 바깥에 <br>
  return문을 작성하고, 반환형이 int[] 것을 감안해 빈 정수 배열을 반환.
* 핵심: 값(difference)을 찾아야 하므로, key를 값(nums[i])으로 value를 인덱스(i)로 설정하는게 포인트.
###
```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
           int difference = target - nums[i];
           if (map.containsKey(difference) && (map.get(difference) != i)) {
            return new int[]{map.get(difference), i};
           }  
        }
        return new int[0];
    }
}

```
