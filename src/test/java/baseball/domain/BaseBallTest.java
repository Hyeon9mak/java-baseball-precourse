package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class BaseBallTest {
    @Test
    public void testCreate(){
        for(int i = 0; i < 1_000_000; i++) {
            BaseBall baseBall = BaseBall.newRandomBaseBall();
            assertThat(baseBall.getNumber()).isBetween(1, 9);
        }
    }

}
