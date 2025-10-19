## 1. 문제

* **문제 링크:** [[문제 URL](https://school.programmers.co.kr/learn/courses/30/lessons/181907)]
* **난이도:** [Level 0]
* **유형:** [String]

## 2. 풀이

```java
class Solution {
    public String solution(String my_string, int n) {
        return my_string.substring(0, n);
    }
}
```

## 3. 학습
### `String.substring()`

* **설명**: `String` 객체의 특정 부분(sub-string)을 추출하여 **새로운 `String` 객체**로 반환함. 원본 문자열은 변경되지 않음(immutable).
* **오버로드 (Overloads)**: 2가지 형태가 존재.

---

#### `String substring(int beginIndex)`

* **설명**: 지정된 `beginIndex` (시작 인덱스, **포함**) 부터 문자열의 **끝까지** 잘라낸 새 문자열을 반환. substring의 string이 String이 아님에 주의.
* **파라미터**:
    * `int beginIndex`: 추출할 시작 위치 인덱스 (0부터 시작).
* **반환값**: `String` (새로 생성된 부분 문자열).
* **Typical 구조 예시**:
    ```java
    String str = "hello world";
    // 인덱스 6 ('w') 부터 끝까지 추출
    String sub1 = str.substring(6); // sub1은 "world"
    ```

---

#### `String substring(int beginIndex, int endIndex)`

* **설명**: `beginIndex` (시작 인덱스, **포함**) 부터 `endIndex` (끝 인덱스, **미포함**) **전까지**의 부분 문자열을 반환.
* **파라미터**:
    * `int beginIndex`: 추출할 시작 위치 인덱스 (포함).
    * `int endIndex`: 추출할 끝 위치 인덱스 (**미포함**).
* **반환값**: `String` (새로 생성된 부분 문자열).
* **Typical 구조 예시**:
    ```java
    String str = "hello world";
    // 인덱스 0 ('h') 부터 인덱스 5 (' ') 전까지 (즉, 0~4 인덱스) 추출
    String sub2 = str.substring(0, 5); // sub2는 "hello"
    ```

---

#### 사용처 및 주의

* **사용처**:
    * 문자열의 앞, 뒤, 또는 중간 부분을 잘라내어 사용해야 할 때.
    * 특정 구분자를 기준으로 문자열을 자르기 전/후 부분을 임시로 다룰 때 (물론 `split()`이 더 적합할 수 있음).
* **주의**:
    * **불변성(Immutability)**: `substring()`은 **원본 문자열을 절대 변경하지 않음**. 항상 **새로운 `String` 객체**가 힙(Heap) 메모리에 생성되어 반환됨.
    * **인덱스 범위**: `endIndex`는 포함되지 않는다는 점을 항상 유의. (길이 = `endIndex - beginIndex`).
    * `IndexOutOfBoundsException`: `beginIndex`가 음수거나, `endIndex`가 문자열 길이보다 크거나, `beginIndex`가 `endIndex`보다 클 때 예외 발생.
