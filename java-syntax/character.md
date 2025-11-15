
---

- [Character.isLetterOrDigit](#characterisletterordigit)
- [Character.toLowerCase](#charactertolowercase)

---


## Character.isLetterOrDigit
* 관련 문제: [125. Valid Palindrome_1. 유효한 팰린드롬](https://github.com/jw-park-dev/coding-interview/blob/main/Blind-75/two-pointers/valid-palindrome.md)

**문자가 '문자(Letter)' 또는 '숫자(Digit)'인지 여부를 판별하는 메서드.**

#### 1. 구조 (Signature)

```java
public static boolean isLetterOrDigit(char ch)
public static boolean isLetterOrDigit(int codePoint)
```

#### 2. 파라미터 (Parameters)

- `char ch`: 판별할 단일 문자.
- `int codePoint`: 판별할 유니코드 코드 포인트(값).

#### 3. 반환값 (Return Value)

- 타입: `boolean`
- 반환값:
    - `true`: 전달된 문자가 문자(알파벳, 한글 등)이거나 10진수 숫자인 경우.
    - `false`: 공백, 줄바꿈, 특수 기호(, `!`, `#` 등)인 경우.

#### 4. 코딩테스트 활용

- 문자열에서 유효한 문자(영숫자)만 추출할 때.
- 팰린드롬(회문) 검사 시, 문장 부호나 공백을 무시하고 문자/숫자만 비교할 때. (예: "A man, a plan, a canal: Panama")
- 아이디나 비밀번호 유효성 검사의 일부로 사용될 수 있음.

#### 5. 주의사항

- 이름 그대로 `isLetter()`와 `isDigit()`를 합친 것과 같음. 둘 중 하나이기만 하면 `true` 반환.
- 유니코드(Unicode)를 기준으로 판단함. 따라서 'a'~'z', 'A'~'Z', '0'~'9' 뿐만 아니라 한글(`'가'`), 한자 등 다른 언어 문자도 `true`로 인식.
- `int codePoint` 버전은 2바이트 `char`로 표현할 수 없는 유니코드 문자(Supplementary Characters, 예: 일부 이모지)까지 처리 가능.

---

### Character.toLowerCase
* 문제: [125. Valid Palindrome_1. 유효한 팰린드롬](https://github.com/jw-park-dev/coding-interview/blob/main/Blind-75/two-pointers/valid-palindrome.md)
  
**문자를 소문자로 변환하는 메서드.**

#### 1. 구조 (Signature)

```java
public static char toLowerCase(char ch)
public static int toLowerCase(int codePoint)
```

#### 2. 파라미터 (Parameters)

- `char ch`: 변환할 단일 문자.
- `int codePoint`: 변환할 유니코드 코드 포인트(값).

#### 3. 반환값 (Return Value)

- `char` 버전 (반환 타입: `char`):
    - 해당 문자가 대문자이면: 소문자로 변환된 `char` 반환.
    - 그 외(이미 소문자, 숫자, 특수문자 등)이면: 원래 `char` 값 그대로 반환.
- `int` 버전 (반환 타입: `int`):
    - 변환된 소문자의 코드 포인트(값) 반환. (대상이 아니면 원래 코드 포인트)

#### 4. 코딩테스트 활용

- 대소문자를 구분하지 않는(case-insensitive) 비교가 필요할 때.
- 팰린드롬(회문) 검사 시, 모든 문자를 소문자(또는 대문자)로 통일하여 비교할 때.
- 문자열 내 단어 빈도수 계산 시, "Apple"과 "apple"을 동일한 단어로 취급해야 할 때.

#### 5. 주의사항

- 원본 문자를 변경하는 것이 아니라, 변환된 *새로운* 문자를 '반환'하는 메서드.
- 문자열(`String`) 전체를 변환할 때는 `string.toLowerCase()`를 사용하는 것이 훨씬 효율적. 이 메서드는 `char` 단위로 처리 시 사용.
- 유니코드 기반으로 동작하므로, 영문 알파벳 외의 다른 언어 문자도 소문자 개념이 있다면 변환을 시도.
- **한글 등 대소문자 구분이 없는 문자의 경우**:
    - `'A'`는 `'a'`로 변환됨.
    - `'가'`, `'!`, `'7'` 등 대소문자 구분이 없는 문자는 아무 변환 없이 **원래 문자 그대로 반환**됨. (예: `Character.toLowerCase('가')` -> `'가'`)
 

