package baseball;

import baseball.domain.BaseBall;
import baseball.domain.BaseBallRepository;
import java.util.HashSet;
import java.util.Set;

public class BaseBallGame {

    private static final String GAME_CONTINUE = "1";
    private static final String GAME_END = "2";
    private static final int THREE_BALL = 3;

    private BaseBallGame() {
    }

    public static BaseBallGame newBaseBallGame() {
        return new BaseBallGame();
    }

    public void start() {
        String gameKey = GAME_CONTINUE;
        while (gameKey == GAME_CONTINUE) {
            runningGame();
        }
    }

    private void runningGame() {
        BaseBallRepository baseBallRepository = BaseBallRepository
            .newBaseBallRepository(initRandomBaseBalls());
        
    }

    private Set<BaseBall> initRandomBaseBalls() {
        Set<BaseBall> baseBalls = new HashSet<>();
        while (baseBalls.size() < THREE_BALL) {
            baseBalls.add(BaseBall.newRandomBaseBall());
        }
        return baseBalls;
    }
}
