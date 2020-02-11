# java-monster-race

코드스쿼드 백엔드 자바 학습 프로젝트 1

## 구현하기

- lucas의 요구사항 문서를 참고해서 구현한다.
- 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.

## PR 보내는 법

- 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
- 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

- [텍스트와 이미지로 살펴보는 코드스쿼드의 온라인 코드 리뷰 과정](https://github.com/code-squad/codesquad-docs/blob/master/codereview/README.md)
- [동영상으로 살펴보는 코드스쿼드의 온라인 코드 리뷰 과정](https://youtu.be/a5c9ku-_fok)

---

# STEP1

1. 몬스터의 확장성을 위해 Monster라는 클래스를 생성
2. 몬스터 레이스를 수행할 Race라는 클래스를 생성
3. Race 수행시 입력을 받아야 하므로 Scanner를 추가하였고, 이를 닫아주는 부분을 terminateGame이라는 메소드에 추가하였습니다.
4. Game을 준비하는 과정 구현(1): 몬스터의 수를 입력받는 메소드를 만들었습니다. 잘못된 입력이 들어오면, 예외처리가 필요하여 종료 코드를 주어 종료되도록 terminateGame 메소드를 수정하였습니다.
5. Game을 준비하는 과정 구현(2): 시도할 횟수를 입력받는 메소드를 만들었습니다. inputMonsterCount와 마찬가지로 예외처리를 해주었습니다.
6. Monster 클래스에 이동 거리를 저장할 int형 변수 moveCount를 private 접근제어자로 생성하였습니다.
7. Monster들을 저장할 배열인 monsters를 Race 클래스에 선언하였습니다. 그리고, 이를 입력받은 수 만큼 배열을 생성하고, 이를 채우도록 하였습니다.
8. Race를 시작할 startGame 메소드를 생성하였습니다.
9. 게임을 시작하면, 입력한 시도횟수 만큼 random값을 만들어서 Monster의 이동 거리를 추가할 것인지 결정하는 randomAttempt 메소드를 생성하고, moveCount가 private 선언이 되어있기 때문에 이를 컨트롤 할 수 있게 하는  plusMoveCount 메소드를 생성하였습니다.
10. 게임을 종료하면 결과를 출력하는 endGame 메소드를 추가하고, monsters 배열에 있는 Monster들의 각각의 이동거리를 출력하는 printMonstersMovingDistance 메소드를 추가하였습니다. Monster별로 이동거리를 출력해주기 위해 showMovingDistance라는 메소드를 Monster 클래스에 추가해주었습니다.
11. Arrays.fill은 한 객체로만 채워주어서 제가 원하는 결과가 나오지 않아 fillMonsterIntoMonsters라는 메소드를 직접 만들어주었습니다.

# STEP2

## 요구사항 분석

- [x] depth를 최대 1단계로 줄이기
- [x] else 문 사용하지 않기
- [x] 메소드의 크기가 10라인을 넘지 않도록 하기
- [x] 메소드가 한 번에 한 가지 일만 하도록 만들기
- [x] 자바 코딩 컨벤션을 지키면서 만들기

1. STEP1 에서 요구받았던 에러발생 시 종료되지 않고, 다시 입력받도록 하는 기능을 추가하였습니다.

# STEP3

## 요구사항 분석

1. 인터페이스 등을 이용해 프로그램을 개선한다.
2. 각 몬스터에 이름과 종류를 부여할 수 있다. 전진하는 몬스터를 출력할 때 몬스터 이름과 종류를 같이 출력한다.
3. 몬스터의 종류는 달리기, 비행, 에스퍼 중 하나의 값을 가진다.
4. 몬스터의 이름과 종류는 쉼표(,)를 기준으로 구분한다.
5. 몬스터의 이동은 타입에 따라 달라진다. 달리기: 랜덤값이 4이상인 경우 1칸 이동, 비행: 랜덤값이 6이상인 경우 3칸 이동, 에스퍼: 랜덤값이 9인 경우 무작위 숫자 (0 < x < 100) 만큼 전진
6. 몬스터 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

## 구현단계

1. 처음 구현하려고 했던 것은 추상클래스, 인터페이스를 이용해서 보다 객체지향적으로 짜는 것이었는데, 짜다 보니 코드 작성하는 것이 너무 불편해져서 hard reset을 하고 다시 작성
2. 몬스터의 Type은 짜보니 Interface로 분리하기 보다는, Enum을 이용하는 편이 더 좋을 것 같아서 Enum Class로 작성하였습니다.
3. 몬스터가 이름과 타입을 가질 수 있도록 하고, 이를 표시하는 것을 toString을 오버라이딩해서 보여주는 것이 좋을 것 같아 `showMovingDistance` 메소드를 refactoring 하였습니다.
4. 하드코딩된 문자열을 상수로 변경하였습니다.
5. STEP2의 요구사항이었던 메소드를 하나로 리팩토링 하였습니다.
6. 문자열 상수를 Enum으로 추출하였습니다.
7. STEP2의 조언이었던 forEach를 사용해보았습니다.
8. Monster의 이름과 타입을 입력받는 부분을 만들었습니다.
9. Monster의 타입에 따라 Move를 하는 경우를 다르게 구성하였습니다.
10. STEP3 요구사항인 누가 우승했는지를 알려주는 기능을 추가하였습니다. stream.forEach를 활용해보았습니다.
11. Dan의 리뷰에 따라 endGame이라는 메소드 명이 결과를 print하는 역할과 맞지 않는 것 같아 메소드명을 변경하였습니다.
12. Monster move count가 로직상 보이면 가독성 안좋을 것 같아서 Enum에서 가져올 수 있도록 하였습니다.
13. 제출하려고 보니까 객체지향을 적용하라고 하셔서 Movable이라는 Interface를 정의하였습니다. 객체지향적이진 않은 것 같습니다. 좀 더 생각 필요...
14. MonsterType에 정의했던 메소드를 Enum 클래스가 추상 클래스임을 이용하여 추상 메서드를 사용하는 방식으로 변경해보았습니다.
15. rankMap을 생성자에서 생성하도록 코드를 수정하였습니다.
16. Race 클래스의 책임이 분명해지도록 클래스명을 리팩토링 하였습니다.
17. Game 클래스의 인스턴스 변수를 private로 접근 제어자를 설정해주었습니다. (왜 빼먹었지...)
18. 소스가 있는 패키지의 위치를 이동하였습니다.
19. Game Class에서 입력받는 부분을 Input Class로 분리하였습니다.
20. Game Class에서 출력하는 부분을 Printer Class로 분리하였습니다.
21. 숫자를 입력받는 부분의 예외 처리 메시지를 에러 메시지를 보여주도록 수정하였습니다.
22. 몬스터의 이름과 타입을 입력받는 부분의 에러처리를 추가하였습니다.
23. Jack의 코드를 보고 안내 메시지가 불친절 한 것 같아서, 친절하게 수정했습니다.
24. 초기화 이후 변경되지 않는 인스턴스 변수는 final로 변경해주었습니다.

# STEP4

## 요구사항 분석

### 기능 요구사항

1. 몬스터 데이터 입력부를 분리한다.
2. 입력받은 몬스터 데이터를 monster.txt 에 저장한다.
3. 몬스터 데이터에 대한 입력 / 수정 / 삭제를 구현한다.

### 프로그래밍 요구사항

1. JUnit을 활용한 단위 테스트 코드를 추가한다.
2. 파일 입출력을 이용해서 데이터를 저장한다.

## 구현단계

1. SecureRandom 클래스를 제거했습니다.
2. Menu 선택을 해야해서 Enum을 사용한 메뉴선택 방식을 사용하고자 했습니다.
3. 메뉴 선택기능을 추가하였습니다.
4. Input Output 을 담당하는 부분을 io 패키지로 이동하였습니다.
5. Monster에 관련된 부분을 monster 패키지로 이동하였습니다.
6. Monster를 관리해줄 Monster Manager를 추가하였습니다.
7. MonsterManager에 메뉴 선택 기능을 추가하였습니다.
8. MonsterManager에 메뉴 선택 후 분기 부분을 추가하였습니다.
9. Step3의 변경사항을 머지하였습니다.
10. Step3의 코멘트된 사항이었던 랭크를 매기는 클래스를 따로 분리하여 ScoreBoard라는 클래스를 생성해주었습니다.
11. 위의 변경사항에 더하여 Game이 정말 Game의 역할만 수행할 수 있도록 Monster를 관리하는 InGameMonsterManager를 추가하였습니다.
12. Step3의 코멘트된 사항이었던 ENUM에 한글을 사용한 내용을 수정하였습니다. (Solar 코드를 베껴왔습니다! 😅)
13. Step3의 코멘트된 사항이었던 `StringJoiner` 에 대해 학습하고 사용해보았습니다.
    - 코드가 조금 더 보기 명확해진 것 같습니다. 더 좋은 방법이 있을까요?
14. Step3의 코멘트된 사항이었던 `String.join()` 을 사용하여 리팩토링하여 봅시다.를 학습하고 사용해보았습니다.
15. 보다 명확한 의미를 주기 위하여 rank를 매길 때 사용하는 list의 변수명을 변경해주었습니다. winners -> sameDistanceMonsters
16. 몬스터 관리 메뉴에 메소드를 추가하였습니다. 대강의 구현을 예상해보고 하드코딩을 하였습니다. (테스트 코드가 필요한 이유!)
