package baseball;

import org.junit.jupiter.api.Test;

public class BaseBallGameTest {

    @Test
    public void testCreate() {
        BaseBallGame baseBallGame = BaseBallGame.newBaseBallGame();
        baseBallGame.start();
    }


}
