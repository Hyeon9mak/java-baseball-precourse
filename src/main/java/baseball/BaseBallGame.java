package baseball;

import baseball.domain.BaseBall;
import baseball.domain.BaseBallRepository;
import baseball.view.UserInput;
import java.util.HashSet;
import java.util.Set;

public class BaseBallGame {

    private static final String GAME_CONTINUE = "1";
    private static final String GAME_END = "2";
    private static final int THREE_BALL = 3;
    private static final String COMMA = ",";

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
        BaseBallRepository computerBalls = BaseBallRepository
            .newBaseBallRepository(initRandomBaseBalls());
        BaseBallRepository userBalls = BaseBallRepository
            .newBaseBallRepository(convertUserBalls(UserInput.getInputNumbers()));
    }

    private Set<BaseBall> convertUserBalls(String inputNumbers) {
        Set<BaseBall> baseBalls = new HashSet<>();
        for(String number : inputNumbers.split(COMMA)){
            baseBalls.add(BaseBall.newUserBaseBall(number));
        }
        return baseBalls;
    }

    private Set<BaseBall> initRandomBaseBalls() {
        Set<BaseBall> baseBalls = new HashSet<>();
        while (baseBalls.size() < THREE_BALL) {
            baseBalls.add(BaseBall.newRandomBaseBall());
        }
        return baseBalls;
    }
}
