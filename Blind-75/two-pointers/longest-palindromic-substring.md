## [5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring)

### 문제 요약
주어진 문자열 s의 부분 문자열(Substring) 중에서, 앞으로 읽으나 뒤로 읽으나 똑같은 가장 긴 팰린드롬(Palindrome)을 찾아 반환.

#### 조건
- 문자열 s의 길이는 1 이상 1000 이하.
- 입력된 s의 길이가 2 미만(1개)이면 그 자체로 팰린드롬이므로 즉시 반환 가능.

---

### 해설

1. startIdx와 currentMaxLen은 클래스 멤버 변수로 선언하여, 모든 메서드에서 공유하고 갱신된 값을 유지할 수 있도록 함.
2. 입력 문자열 s의 길이가 1인 경우(혹은 빈 문자열), 더 이상 검사할 필요 없이 그 자체가 팰린드롬이므로 바로 반환.
3. 문자열의 처음부터 끝까지 순회하며 extendPalindrome을 호출함. 이때 짝수 길이(i, i+1)와 홀수 길이(i, i+2)의 팰린드롬을 각각 확인하기 위해 두 번 호출.
4. extendPalindrome 내부의 while 반복문은 투 포인터(leftIdx, RightIdx)가 문자열 범위 내에 있고, 가리키는 문자가 서로 같을 때까지 범위를 양쪽으로 확장.
5. 반복문이 종료되었다는 것은 현재 포인터가 가리키는 문자가 서로 다르거나 범위를 벗어났다는 의미임. 따라서 직전까지 유효했던 팰린드롬의 길이는 <br>
   (RightIdx - 1) - (leftIdx + 1) + 1, 정리하면 RightIdx - leftIdx - 1이 됨. 이 길이가 기존 currentMaxLen보다 크다면 갱신을 시작.
6. leftIdx는 현재 유효하지 않은(범위를 벗어난) 위치에 있으므로, 유효한 팰린드롬의 시작 위치를 저장하기 위해 startIdx에 leftIdx + 1을 저장. <br>
   동시에 최대 길이 currentMaxLen도 현재 구한 길이로 업데이트.
7. 최종적으로 갱신된 startIdx부터 currentMaxLen만큼의 길이를 가진 부분 문자열을 잘라서(substring) 반환.

---

### 풀이: Two Pointers (Expand Around Center)

```java
class Solution {
// 1.
int startIdx = 0;
int currentMaxLen = 0;

    public void expandAroundCenter(String s, int leftIdx, int RightIdx) {
        // 4.
        while (leftIdx >= 0 && RightIdx < s.length() && s.charAt(leftIdx) == s.charAt(RightIdx)) {
            leftIdx--;
            RightIdx++;
        }
        // 5.
        if (currentMaxLen < (RightIdx-1) - (leftIdx+1) + 1) {
            // 6.
            startIdx = leftIdx + 1;
            currentMaxLen = (RightIdx-1) - (leftIdx+1) + 1;
        }
    }

    public String longestPalindrome(String s) {
        int inputLen = s.length();
        // 2.
        if (inputLen == 1) {
            return s;
        }
        // 3.
        for (int i = 0; i < inputLen - 1; i++) {
            expandAroundCenter(s, i, i + 1);
            expandAroundCenter(s, i, i + 2);
        }
        // 7.
        return s.substring(startIdx, startIdx + currentMaxLen);
    }
}
```

#### 복잡도 분석

- 시간 복잡도: 문자열의 길이 N에 대해 각 인덱스마다 확장을 시도하므로 최악의 경우 O(N²).
- 공간 복잡도: 별도의 추가 메모리 할당 없이 몇 개의 변수만 사용하므로 O(1).

---

```java
class Solution {
// 마지막에 최장 팰린들롬을 잘라서(substring) 반환해야 하는데, 어디서부터 잘라야 할지 위치를 기억해두는 역할.
int startIdx = 0;  // 지금까지 발견한 가장 긴 팰린드롬의 시작 인덱스

int currentMaxLen = 0;  // 현재까지의 팰린들롬 중 최대 길이

    public void expandAroundCenter(String s, int leftIdx, int RightIdx) {
        // (투 포인터가 유효한 범위 내에 있고) (양쪽 끝 문자가 일치하는 하는 경우)
        while (leftIdx >= 0 && RightIdx < s.length() && s.charAt(leftIdx) == s.charAt(RightIdx)) {
            // 현재의 부분 문자열을 좌우로 한칸 씩 확장
            leftIdx--;
            RightIdx++;
        }

        // while문을 타지 않았다는건(=if문에 도달했다는건), 현재 leftIdx~RightIdx 범위의 부분 문자열은
        // 유효하지 않은 범위이거나 팰린들롬이 아니라는 의미이므로(유효한 팰린들롬은 현재 부분 문자열이
        // 확장 되기 직전에 leftIdx+1 ~ RightIdx-1 범위의 부분 문자열이다)
        // 현재 유효성을 검증 중인 부분 문자열에서 팰린들롬인 부분의 길이는 (RightIdx-1) - (leftIdx+1) + 1
        // 즉 RightIdx - leftIdx -1이다.

        // curMaxLen: 기존 최대 길이
        // RightIdx - leftIdx - 1: 현재의 부분 문자열의 길이 
        // 현재까지 탐색한 최대 길이의 팰린들롬(currentMaxLen)보다, 현재 유효성을 검증 중인 부분 문자열에서
        // 팰린들롬인 부분의 길이가 더 길다면 
        if (currentMaxLen < (RightIdx-1) - (leftIdx+1) + 1) {
            // while 문이 끝났다는 건(=if 문 내부로 들어왔다는건) 현재 leftIdx~leftIdx 범위의 부분문자열까지만
            // 팰린들롬이고, 그 이상 좌우로 확장하면 팰린들롬이 아니거나 유효한 범위를 넘어섰다는 의미이므로
            // 현재의 startIdx를 시작 인덱스로 하는 팰린들롬에 대한 탐색은 멈춰야 하며, leftIdx~leftIdx 범위의
            // 부분문자열에서 시작 인덱스에 해당하는 leftIdx의 그 다음 인덱스를 시작 인덱스로
            // 하는 새로운 부분 문자열에 대한 팰린들롬 탐색을 진행하기 위해, startIdx = leftIdx + 1;를 수행.  
            startIdx = leftIdx + 1;
            // 현재까지 탐색한 최대 길이의 팰린들롬(currentMaxLen)보다, 현재 유효성을 검증 중인 부분 문자열에서
            // 팰린들롬인 부분의 길이가 더 기니까
            // currentMaxLen를 현재 길이로 갱신.
            currentMaxLen = (RightIdx-1) - (leftIdx+1) + 1;
        }
    }

    public String longestPalindrome(String s) {
        int inputLen = s.length();

        // 입력값인 문자열의 길이가 1이면 팰린들롬을 판별할 필요없이 현재 문자열이 팰린들롬인 최장 부분 문자열이므로
        if (inputLen == 1) {
            return s;  // 입력값 자체를 바로 반환
        }

        // 우측으로 한 칸씩 이동하며 투 포인터 조사
        for (int i = 0; i < inputLen - 1; i++) {
            // 길이가 짝수인, 길이 2부터 시작해서 좌우로 확장해나가는, 부분 문자열의 팰린들롬 여부를 판단하는 투 포인터.
            expandAroundCenter(s, i, i + 1);
            // 길이가 홀수인, 길이 3부터 시작해서 좌우로 확장해나가는, 부분 문자열의 팰린들롬 여부를 판단하는 투 포인터.
            expandAroundCenter(s, i, i + 2);
        }
        // 팰린들롬인 최장 부분 문자열의 시작 인덱스부터 그 길이 -1까지의 부분을 답으로 반환.
        return s.substring(startIdx, startIdx + currentMaxLen);
    }
}
```
