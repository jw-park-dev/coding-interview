## 1. 정보

* **문제 링크:** [[문제 URL](https://school.programmers.co.kr/learn/courses/30/lessons/181888?language=java)]
* **난이도:** [Level 0]
* **유형:** [ArrayList/Array]

## 2. 풀이
### ArrayList를 이용한 풀이
```java
// ArrayList 사용 시, import 필요
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] num_list, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < num_list.length; i += n) {
            list.add(num_list[i]);
        }
        
        // for문으로 ArrayList를 int[]로 변환
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        
        // stream으로  ArrayList를 int[]로 변환
        // return       list.stream()
        //                  .mapToInt(Integer::intValue) (i -> i)로 대체 가능
        //                  .toArray();
        
        return ans;
    }
}
```
### 고정 크기 배열(int[])만 이용한 풀이
```java
class Solution {
    public int[] solution(int[] num_list, int n) {
        // 결과 배열의 크기를 미리 계산
        int size = (num_list.length + n - 1) / n;
        
        int[] ans = new int[size];
        
        int idx = 0; // ans 배열의 인덱스
        // n 간격으로 원소를 새 배열에 복사
        for (int i = 0; i < num_list.length; i += n) {
            ans[idx] = num_list[i];
            idx++;
        }
        
        return ans;
    }
}
```
## 3. 문법
### `ArrayList`

* **설명**: Java의 `Collection Framework`의 일부로, `List` 인터페이스를 구현한 클래스.
* **특징**:
    * **동적 배열(Dynamic Array)**: 내부적으로는 배열을 사용하지만, 크기가 고정된 일반 배열(`int[]`)과 달리, 공간이 부족하면 **자동으로 용량을 늘림**.
    * **제네릭(Generics) 기반**: `ArrayList<T>` 형태로 `<T>` 자리에 저장할 데이터의 타입을 지정함.
        * `ArrayList<Integer>`: `int` (정수)를 저장 (단, `int` 기본형 대신 래퍼(Wrapper) 클래스인 `Integer` 사용).
        * `ArrayList<String>`: 문자열 저장.
* **사용처**:
    * 코딩 테스트에서 **결과값의 개수를 미리 알 수 없을 때** 매우 유용함.
    * 데이터를 순차적으로 저장하고, 인덱스로 빠르게 접근(조회)해야 할 때.
* **주의**:
    * 중간에 데이터를 삽입(`add(index, element)`)하거나 삭제(`remove(index)`)하는 작업은, 뒤따라오는 원소들을 모두 한 칸씩 밀거나 당겨야 하므로 성능이 느림 (O(N)). (단순히 맨 뒤에 추가하는 것은 빠름, O(1))

---

### `ArrayList.add()`

* **설명**: `ArrayList`의 **맨 끝**에 새로운 원소(element)를 추가함.
* **문법**: `boolean add(E element)`
    * (리스트의 맨 뒤가 아닌 특정 인덱스에 삽입하는 `void add(int index, E element)`도 있지만, 코테에서는 주로 맨 뒤에 추가하는 이 문법을 사용)
* **파라미터**:
    * `E element`: 리스트에 추가할 원소. `ArrayList<T>`를 선언할 때 `<T>`에 지정한 타입의 값이어야 함. (e.g., `ArrayList<Integer>`에는 `Integer` 또는 `int` 값).
* **반환값**: `boolean`
    * 항상 `true`를 반환 (Collection 인터페이스 정의상 명시되어 있으나, `ArrayList`는 추가가 실패하는 경우가 거의 없으므로 코테에서는 이 반환값을 무시하고 사용).
* **Typical 구조 예시**:
    ```java
    // 1. Integer를 저장할 수 있는 ArrayList 생성
    List<Integer> answerList = new ArrayList<>();
    
    // 2. 맨 뒤에 값 추가
    answerList.add(10); // 리스트는 [10]
    answerList.add(20); // 리스트는 [10, 20]
    
    // 3. 조건에 맞으면 추가
    if (someCondition) {
        answerList.add(30);
    }
    ```

---

### `ArrayList.size()`

* **설명**: `ArrayList`에 현재 저장되어 있는 원소의 개수(크기)를 반환함.
* **문법**: `int size()`
* **파라미터**: 없음.
* **반환값**: `int` (리스트 안의 원소 개수).
* **Typical 구조 예시**:
    ```java
    List<Integer> list = new ArrayList<>();
    list.add(10);
    list.add(20);
    
    int count = list.size(); // count는 2
    
    // 배열의 .length와 유사하게 반복문 조건에 자주 사용됨
    for (int i = 0; i < list.size(); i++) {
        // list.get(i) ...
    }
    ```
* **주의**: `size()`는 현재 원소의 개수. `capacity()`는 내부 배열의 물리적인 총 용량 (코테에서는 거의 사용 안 함).

---

### `ArrayList.get()`

* **설명**: `ArrayList`에서 특정 인덱스(위치)에 저장되어 있는 원소(element)를 반환(조회)함.
* **문법**: `E get(int index)`
    * `E`: 리스트를 선언할 때 지정한 제네릭 타입 (e.g., `ArrayList<Integer>`면 `Integer`).
* **파라미터**:
    * `int index`: 가져올 원소의 위치. **0부터 시작**함.
* **반환값**: `E` (해당 `index` 위치의 원소)
    * `ArrayList<Integer>`에서 `get()`을 호출하면 `Integer` 객체를 반환. (필요시 `int`로 자동 언박싱됨)
* **구조 예시**:
    ```java
    List<String> list = new ArrayList<>();
    list.add("apple");  // 0번 인덱스
    list.add("banana"); // 1번 인덱스

    // 인덱스 0 (첫 번째) 원소 가져오기
    String fruit1 = list.get(0); // fruit1은 "apple"

    // 인덱스 1 (두 번째) 원소 가져오기
    String fruit2 = list.get(1); // fruit2은 "banana"

    // (활용) 반복문에서 리스트 순회
    for (int i = 0; i < list.size(); i++) {
        System.out.println(list.get(i));
    }
    ```
* **사용처**:
    * 리스트의 특정 위치에 있는 값을 읽어와야 할 때.
    * 배열(`arr[i]`)에서 인덱스를 사용해 값을 읽는 것과 동일한 역할을 함.
* **주의**:
    * **0-based 인덱싱**: 인덱스는 `0`부터 `(리스트 크기 - 1)`까지임.
    * `IndexOutOfBoundsException`: `index`가 음수거나 `(리스트 크기 - 1)`보다 크면 런타임 예외 발생.
---

### `List<Integer>`를 `int[]`로 변환 (stream 활용)

#### (1) `.stream()`

* **설명**: `list` (자료형: `List<Integer>`)를 stream으로 변환.
* **스트림(Stream)**: 컬렉션(List, Set 등)의 원소들을 하나씩 순회하면서 처리할 수 있도록 해주는 데이터 처리 파이프라인.
* **반환값**: `Stream<Integer>` ( `Integer` 객체들이 흘러다니는 파이프라인)

#### (2) `.mapToInt(Integer::intValue)`

* **설명**: 스트림의 각 원소를 **매핑(mapping)**(변환)하여 `IntStream`을 반환함.
* **`.mapToInt(...)`**:
    * 스트림의 원소(`Stream<T>`)를 받아 `int` 값으로 변환(`IntStream`)해주는 중간 연산.
* **`Integer::intValue` (메서드 레퍼런스)**:
    * `mapToInt`는 "각 원소를 `int`로 어떻게 바꿀지" 방법을 요구함.
    * `Integer::intValue`는 "스트림을 통과하는 `Integer` 객체 각각에 대해 `.intValue()` 메서드를 호출해서 `int` 기본형으로 바꿔라"는 의미.
* **(참고) `i -> i`**:
    * `i -> i.intValue()` (람다 표현식)와 동일함.
    * 심지어 `i -> i` (오토 언박싱)로 써도 동일하게 동작함.
    * `Stream<Integer>` (래퍼 클래스 스트림)을 `IntStream` (기본형 `int` 스트림)으로 변환하는 과정.
* **반환값**: `IntStream` (`int` 값들이 흘러다니는 파이프라인)

#### (3) `.toArray()`

* **설명**: 스트림(`IntStream`)의 모든 원소들을 모아서 **배열**로 만듦.
* **문법**: `int[] toArray()` (`IntStream`에서 호출 시)
* **파라미터**: 없음.
* **반환값**: `int[]` (`int` 기본형 배열).
