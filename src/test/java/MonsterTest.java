import domain.*;
import domain.monster.Flying;
import domain.monster.Psychic;
import domain.monster.Running;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class RandomRunner extends Random {

    public RandomRunner() {
        super();
    }

    @Override
    public int nextInt(int bound) {
        return 5;
    }
}

class RandomFlying extends Random {

    public RandomFlying() {
        super();
    }

    @Override
    public int nextInt(int bound) {
        return 7;
    }
}

class RandomPsychic extends Random {

    public RandomPsychic() {
        super();
    }

    @Override
    public int nextInt(int bound) {
        return 9;
    }
}


public class MonsterTest {

    String crong = "크롱";
    String jk = "JK";
    String honux = "호눅스";
    int tryCount = 10;

    Running running;
    Flying flier;
    Psychic psychic;

    RandomRunner randomRunner;
    RandomFlying randomFlying;
    RandomPsychic randomPsychic;

    Monsters monsters;

    @BeforeEach
    public void 몬스터_객체_생성() {
        running = new Running(crong);
        flier = new Flying(jk);
        psychic = new Psychic(honux);

        randomRunner = new RandomRunner();
        randomFlying = new RandomFlying();
        randomPsychic = new RandomPsychic();

        monsters = new Monsters();

    }

    @Test
    public void 몬스터_이름_체크() {
        assertEquals(crong, running.getName());
        assertEquals(jk, flier.getName());
        assertEquals(honux, psychic.getName());
    }


    @Test
    public void 게임_시도_횟수() {
        running.attempt(tryCount);
        flier.attempt(tryCount);
        psychic.attempt(tryCount);

        assertThat(running.getSteps().size()).isEqualTo(tryCount);
        assertThat(flier.getSteps().size()).isEqualTo(tryCount);
        assertThat(psychic.getSteps().size()).isEqualTo(tryCount);

    }

    @Test
    public void 달리기_랜덤_전진() {
        running.attempt(randomRunner, tryCount);
        running.forward();

        //10회 * 1step == 10;
        assertThat(running.getStep()).isEqualTo(10);
    }

    @Test
    public void 비행_랜덤_전진() {
        flier.attempt(randomFlying, tryCount);
        flier.forward();

        //10 * 3 (FlyingBonus)
        assertThat(flier.getStep()).isEqualTo(30);
    }

    @Test
    public void 에스퍼_랜덤_전진() {
        psychic.attempt(randomPsychic, tryCount);
        psychic.forward(randomPsychic);

        //10 * (9 + 1)
        assertThat(psychic.getStep()).isEqualTo(100);
    }

    @Test
    public void 우승한_몬스터_이름() {
        running.attempt(randomRunner, tryCount);
        running.forward();

        flier.attempt(randomFlying, tryCount);
        flier.forward();

        psychic.attempt(randomPsychic, tryCount);
        psychic.forward(randomPsychic);

        monsters.getMonsters().put(crong, running);
        monsters.getMonsters().put(jk, flier);
        monsters.getMonsters().put(honux, psychic);

        assertEquals(monsters.getWinner(), psychic.getName());
    }
}
