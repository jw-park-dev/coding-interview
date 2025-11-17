
* 관련 문제: [217. Contains Duplicate](https://leetcode.com/problems/contains-duplicate/description/)

---
## HashSet.add()

* 중복 포함 지정된 요소가 세트에 존재하지 않는 경우 해당 요소를 추가하는 메서드.

#### 1. 구조 (Signature)
```Java
public boolean add(E e)
```

#### 2. 파라미터 (Parameters)
* E e: 세트에 추가할 요소. (선언 시 지정한 제네릭 타입)

#### 3. 반환값 (Return Value)
* 타입: boolean
* 반환값:
  * true: 세트에 해당 요소가 없어서 성공적으로 추가된 경우.
  * false: 세트에 이미 해당 요소가 존재하여 추가되지 않은 경우 (중복).

#### 4. 코딩테스트 활용
* 중복 검사 및 필터링: if (!set.add(n)) 패턴을 사용하면, 요소를 추가함과 동시에 중복 여부를 확인 가능.
* 고유값 개수 파악: 배열의 모든 요소를 Set에 넣은 뒤 set.size()를 호출하여 서로 다른 요소가 몇 개인지 계산할 때.
* 방문 처리: BFS/DFS 그래프 탐색 문제에서 이미 방문한 좌표나 노드를 기록하여 재방문을 방지할 때.

#### 5. 주의사항
* 내부적으로 HashMap의 키(Key)를 사용하여 구현되어 있음.
* 저장 순서를 보장하지 않음. 입력 순서 유지가 필요하다면 LinkedHashSet을, 정렬이 필요하다면 TreeSet을 사용해야 함.
