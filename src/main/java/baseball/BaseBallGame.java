package baseball;

import baseball.domain.BaseBallRepository;
import baseball.service.ComputerService;
import baseball.service.UserService;

public class BaseBallGame {

    private static final String GAME_CONTINUE = "1";
    private static final String GAME_END = "2";

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
        BaseBallRepository computerBalls = ComputerService.initComputerBalls();
        BaseBallRepository userBalls = UserService.makeUserBalls();


    }
}
