# 몬스터 레이스 1단계 구현하기

  ## 기능 요구사항

  - 초간단 몬스터 경주 게임을 구현한다.
  - 주어진 횟수 동안 n마리의 몬스터는 전진 또는 멈출 수 있다.
  - 사용자는 몇 마리의 몬스터로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
  - 전진하는 조건은 0에서 9까지 random값 중 4이상이면 전진한다.
  - 몬스터의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

  ## 프로그래밍 요구사항

  - 메소드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.
  - 들여쓰기는 가능하면 2단계 이내로 구현한다. 예를 들어 이중 루프 안에 if문을 사용한다면 3단계이다.

  ## 실행 결과

  - 위 요구사항에 따라 3대의 몬스터가 5번 움직였을 경우 프로그램을 실행한 결과의 예시는 다음과 같다.

  ```
  <스릴만점 건전한 몬스터 경주>
  몬스터는 모두 몇 마리인가요?
  3
  시도할 회수는 몇 회 인가요?
  10
  
  <실행 결과>
  ---
  -----------
  ------
  ```
