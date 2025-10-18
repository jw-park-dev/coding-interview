## 1. 정보

* **문제 링크:** [[문제 URL](https://github.com/jw-park-dev/coding-interview/blob/main/Programmers/Math/n%EC%9D%98-%EB%B0%B0%EC%88%98.java)]
* **난이도:** [Level 0]
* **유형:** [Math]


## 2. 접근

* x가 y의 배수가 되기 위한 조건: x를 y로 나눴을 때의 나머지가 0.


## 3. 풀이

```java
class Solution {
    public int solution(int num, int n) {
        if (num % n == 0) {
            return 1;
        }
        return 0;
    }
}
```


## 4. 학습


### `int[] ans = {};` vs `int[] ans = new int[n];`


#### `int[] ans = {};`

* **설명**: 크기(length)가 0인 `int` 배열을 생성하고 초기화함. `new int[0]`과 동일.
* **특징**: 배열 객체는 생성되지만, 원소를 담을 공간은 없음.
* **사용처**:
    * 메서드의 반환 타입이 배열(`int[]`)인데, 반환할 결과가 없는 경우 (null 대신).
    * 컬렉션(e.g., `List`)을 배열로 변환할 때, 크기가 0인 배열을 인자로 넘겨주면 JVM이 알아서 적절한 크기의 새 배열을 만들어 반환해 줌 (최근 Java 버전에서는 권장).
        ```java
        List<Integer> list = ...;
        Integer[] arr = list.toArray(new Integer[0]);
        // 또는 Integer[] arr = list.toArray(Integer[]::new);
        ```


#### `int[] ans = new int[n];`

* **설명**: 크기(length)가 `n`인 `int` 배열을 생성.
* **특징**:
    * `n`개의 공간이 할당됨.
    * `int` 타입의 **기본값인 0**으로 모든 인덱스(`0` ~ `n-1`)가 자동 초기화됨.
* **사용처**:
    * 코딩 테스트에서 정답을 담을 배열의 크기를 미리 알 때 (e.g., 입력 `n`개에 대해 `n`개의 결과가 나올 때).
    * DP 테이블(`dp[]`) 등을 만들 때.


#### 차이 요약

* **핵심 차이**: **배열의 크기(length)**.
* `{}`: `ans.length` == `0`.
* `new int[n]`: `ans.length` == `n`.


---


### `Arrays.copyOf()` vs `Arrays.copyOfRange()`


#### `Arrays.copyOf()`

* **설명**: 원본 배열의 **처음(0번 인덱스)부터** 지정된 길이(length)만큼 복사하여 **새 배열**을 반환.
* **문법**: `T[] Arrays.copyOf(T[] original, int newLength)`
* **파라미터**:
    * `T[] original`: 복사할 원본 배열 (e.g., `int[]`, `String[]`...).
    * `int newLength`: 복사본 배열의 **길이**.
* **반환값**: `T[]` (새로 생성된 배열).
* **특징**:
    * `newLength`가 원본보다 짧으면: 앞에서부터 `newLength`만큼만 복사 (잘림).
    * `newLength`가 원본보다 길면: 원본 내용을 다 복사하고, 나머지 공간은 타입 기본값(int는 0, 객체는 null)으로 채움.
* **Typical 구조 예시**:
    ```java
    // 원본 배열의 앞 3개만 복사
    int[] original = {1, 2, 3, 4, 5};
    int[] copy = Arrays.copyOf(original, 3); // copy는 [1, 2, 3]

    // 원본 배열을 크기 7로 확장 (나머지는 0으로 채움)
    int[] expanded = Arrays.copyOf(original, 7); // expanded는 [1, 2, 3, 4, 5, 0, 0]
    ```
* **사용처**: 배열의 크기를 변경(확장/축소)하거나, 배열의 앞부분만 필요할 때.


#### `Arrays.copyOfRange()`

* **설명**: 원본 배열의 지정된 범위(range)를 복사하여 **새 배열**을 반환.
* **문법**: `T[] Arrays.copyOfRange(T[] original, int from, int to)`
* **파라미터**:
    * `T[] original`: 복사할 원본 배열.
    * `int from`: 복사 시작 인덱스 (포함, inclusive).
    * `int to`: 복사 끝 인덱스 (미포함, exclusive).
* **반환값**: `T[]` (새로 생성된 배열).
* **특징**:
    * 복사될 새 배열의 길이는 `to - from`이 됨.
    * 범위가 원본을 벗어나도 에러 대신 기본값으로 채워짐.
* **Typical 구조 예시**:
    ```java
    // 원본 배열의 인덱스 1부터 4 전까지 (즉, 1, 2, 3 인덱스) 복사
    int[] original = {1, 2, 3, 4, 5};
    int[] subArray = Arrays.copyOfRange(original, 1, 4); // subArray는 [2, 3, 4]
    ```
* **사용처**: 배열의 중간 부분(sub-array)이 필요할 때. (e.g., 퀵 정렬 등 분할 정복).


#### 차이 요약

* `copyOf`: **0번 인덱스부터** `newLength` **길이**만큼 복사.
* `copyOfRange`: **`from` 인덱스부터** `to` **인덱스 전까지** 복사.
* `Arrays.copyOf(arr, N)`은 `Arrays.copyOfRange(arr, 0, N)`과 사실상 동일.


---


### `int[]` 인덱스 값 할당


#### `int[]` 표기법

* "int 배열", Integer array, "정수 배열"


#### 특정 `int[]`의 인덱스 값을 다른 `int[]` 인덱스에 대입

* **설명**: 배열은 인덱스를 통해 각 원소에 접근 가능. `[인덱스]`를 사용해 값을 읽고, 대입 연산자(`=`)를 사용해 값을 씀.
* **Typical 구조 예시**:
    ```java
    int[] sourceArray = {10, 20, 30};
    int[] destinationArray = new int[5]; // [0, 0, 0, 0, 0]

    // sourceArray의 1번 인덱스 값(20)을
    // destinationArray의 3번 인덱스에 할당
    destinationArray[3] = sourceArray[1];

    // 결과: destinationArray는 [0, 0, 0, 20, 0]
    ```
