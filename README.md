## 생각나는 공통 요구사항

- 변수명이 list 같은 거 가능하면 쓰지 말자 -> carList -> cars
- 불필요한 로컬 변수를 사용하지 말자 
- 그렇다고 억지로 줄이지도 말자
- 각 단계별 요구사항이나 MVC, 디자인 패턴 이런 것도 중요하지만 최대한 심플하게 코딩해서 가독성을 높이고 쉽게 이해할 수 있는 코드를 짜는 게 가장 중요.

-------

## 공통 리뷰

- 필요하면 static을 잘 사용하자. 남발은 말고. 여력이 있다면 싱글톤에 대해 공부해 보기. 역시 남용하지 말자
- compostion over inheritance 라는 말이 있습니다. 3단계는 사실 상속 : 추상클래스를 만들거나 몬스터를 확장해서 새로운 몬스터를 만드는 걸 생각했는데 그냥 구성만으로도 해결이 되는군요. 저 키워드에 대해 검색해 보세요. 한국어는 아마 상속보다 구성일 듯.

- toString() 오버라이드를 해 보면 코드가 약간이라도 깔끔해지니 한번 활용해 보세요. System.out.println(monster.getResult()); 보다 System.out.println(monster) 도 괜찮은 거 같아요.
- 메소드는 한 번에 하나의 일을 하도록 고쳐보자. 
- 땡땡이 쓰니까 `monsters.forEach(Monster::moveIfConditionSatisfied);`  요렇게 표현할 수 있는데 엄청 깔끔하고 가독성 높아 보이네요.

-------

# 3단계 요구사항

## 기능 요구사항

- 객체 지향 프로그래밍을 지향(?) 해서 인터페이스 등을 이용해 프로그램을 개선한다.
- 각 몬스터에 이름과 종류를 부여할 수 있다. 전진하는 몬스터를 출력할 때 몬스터 이름과 종류를 같이 출력한다.
- 몬스터의 종류는 달리기, 비행, 에스퍼 중 하나의 값을 가진다.
- 몬스터의 이름과 종류는 쉼표(,)를 기준으로 구분한다.
- 몬스터의 이동은 타입에 따라 달라진다. 달리기: 랜덤값이 4이상인 경우 1칸 이동, 비행: 랜덤값이 6이상인 경우 3칸 이동, 에스퍼: 랜덤값이 9인 경우 무작위 숫자 (1 <= x < 100) 만큼 전진
- **몬스터 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.**

### 실행 결과

- 위 요구사항에 따라 3대의 몬스터가 5번 움직였을 경우 프로그램을 실행한 결과는 다음과 같다.

```txt
<신나는 몬스터 레이스>
몇 명의 몬스터가 경주하나요?
3

경주할 몬스터 이름과 종류를 입력하세요 (쉼표(,)를 기준으로 구분).
크롱, 달리기
포비, 비행
호눅스, 에스퍼

시도할 회수는 몇회인가요?
10

<경기 시작>

크롱 [달리기] : ----
포비 [비행] : ----------
호눅스 [에스퍼] : -------------------------------

축하합니다! 호눅스가 몬스터 레이스에서 우승했습니다.
코드복사
```
