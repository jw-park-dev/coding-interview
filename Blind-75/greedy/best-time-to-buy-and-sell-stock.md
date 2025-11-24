## [121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

### 문제 요약

주어진 주식 가격 배열 `prices`에서 가장 싸게 사서 가장 비싸게 팔았을 때의 최대 이익을 반환.

### 조건

- 배열 `prices`의 길이는 1 이상.
- 매수(`left`)는 반드시 매도(`right`)보다 시간적으로 앞서야 함.
- 이익을 낼 수 없는 경우 0을 반환.

---

### 핵심 아이디어

**투 포인터(Two Pointers)** 를 사용하여 `left`는 "현재까지 발견한 최저가 시점(매수)", `right`는 "판매 시점(매도)"을 가리키며 윈도우를 슬라이딩하는 방식.

---

### 해설

1. left는 주식을 사는 시점(매수 인덱스), right는 파는 시점(매도 인덱스), currentMaxProfit은 현재까지 발견한 최대 이익을 저장하기 위해 변수들을 초기화.
2. 매도 시점을 나타내는 포인터 right가 배열의 끝(prices.length)에 도달할 때까지 윈도우를 오른쪽으로 이동하며 반복 수행.
3. 현재 매수 시점의 가격(prices[left])보다 매도 시점의 가격(prices[right])이 더 높은지(수익이 나는지) 확인.
4. 수익이 발생한다면 현재 차익(profit)을 계산하고, 기존에 저장된 currentMaxProfit과 비교하여 더 큰 값으로 갱신.
5. 만약 매수 가격이 매도 가격보다 더 비싸거나 같다면(else), 현재의 right 위치가 더 싸게 살 수 있는 새로운 기회이므로 left 포인터를 right 위치로 바로 이동시킴(점프).
6. 다음 날의 가격을 확인하고 윈도우를 확장하기 위해 right 포인터를 오른쪽으로 한 칸 전진.

---

### 풀이: Two Pointers (Sliding Window)

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int maxProfit(int[] prices) {
        // 1.
        int left = 0;
        int right = 1;
        int currentMaxProfit = 0;

        // 2.
        while (r < prices.length) {
            // 3.
            if (prices[left] < prices[right]) {
                // 4.
                int profit = prices[right] - prices[left];
                currentMaxProfit = Math.max(currentMaxProfit, profit);
            }
            // 5.
            else {
                left = right;
            }
            // 6.
            right++;
        }
        return currentMaxProfit;
    }
}

```
복잡도 분석
* 시간 복잡도: r 포인터가 배열을 한 번만 순회하므로 $O(N)$.
* 공간 복잡도: 변수 3개(l, r, maxP)만 사용하므로 $O(1)$.

---
```java
class Solution {
    public int maxProfit(int[] prices) {
        // 1. 변수 초기화
        // left: 매수 시점 인덱스 (현재까지 발견한 가장 싼 가격의 위치)
        // right: 매도 시점 인덱스 (미래의 가격을 탐색하는 위치)
        // currentMaxProfit: 계산된 최대 이익을 저장할 변수
        int left = 0;
        int right = 1;
        int currentMaxProfit = 0;

        // 2. 슬라이딩 윈도우 (Sliding Window)
        // 매도 시점(right)이 배열의 끝까지 도달할 때까지 반복
        while (right < prices.length) {
            // 3. 수익 발생 여부 확인
            // 매수 가격(left)보다 매도 가격(right)이 더 높다면, 이익이 발생하는 구간임.
            if (prices[left] < prices[right]) {
                // 4. 이익 계산 및 최대 이익 갱신
                // 현재 구간의 이익(prices[right] - prices[left])을 계산하고
                // 기존의 최대 이익(currentMaxProfit)보다 크다면 값을 갱신.
                int profit = prices[right] - prices[left];
                currentMaxProfit = Math.max(currentMaxProfit, profit);
            }
            // 5. 더 낮은 가격 발견 (윈도우 시작점 이동)
            // 매수 가격(left)이 매도 가격(right)보다 크거나 같다면,
            // 현재 right 위치의 가격이 더 싸다는 의미이므로 매수 시점(left)을 right 위치로 점프(이동).
            // 즉, 지금까지의 구간은 버리고 right부터 다시 새로운 윈도우 시작.
            else {
                left = right;
            }
            // 6. 윈도우 확장
            // 다음 날의 주가를 확인하고 비교하기 위해 매도 시점(right)을 오른쪽으로 한 칸 이동.
            right++;
        }
        return currentMaxProfit;
    }
}
```
---
### 풀이: Greedy

```java
class Solution {
    public int maxProfit(int[] prices) {
        // 1. minPrice는 어떤 가격이 들어오더라도 바로 갱신될 수 있도록 int 자료형이 가질 수 있는
        // 가장 큰 값(Integer.MAX_VALUE)으로 초기화. maxProfit은 이익이 없는 경우를 대비해 0으로 초기화.
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        // 2. prices 배열의 모든 가격을 순회.
        for (int price : prices) {
            // 3. "더 싸게 살 수 있는 기회인가?" 를 판단. 현재 가격(price)이 지금까지 기록된 최저가(minPrice)보다 낮다면
            // 최저가를 현재 가격으로 갱신. (이때는 파는 것이 불가능하므로 이익 계산은 건너뜀).
            if (price < minPrice) {
                minPrice = price;
            }
            // 4. "지금 팔면 이득인가?" 를 판단. 현재 가격이 최저가보다 높다면, 오늘 팔았을 때의 이익(currentProfit)을 계산.
            // 이 값이 지금까지의 maxProfit보다 크다면 최대 이익을 갱신.
            else {
                int currentProfit = price - minPrice;
                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                }
            }
        }
        return maxProfit;
    }
}
```
