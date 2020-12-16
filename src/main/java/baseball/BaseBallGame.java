package baseball;

import baseball.domain.BaseBallRepository;
import baseball.domain.ScoreBoard;
import baseball.service.ComputerService;
import baseball.service.UserService;
import baseball.view.GameDiplay;

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
        ScoreBoard scoreBoard = ScoreBoard.newScoreBoard();
        BaseBallRepository computerBalls = ComputerService.initComputerBalls();
        while (!scoreBoard.isThreeStrike()) {
            BaseBallRepository userBalls = UserService.makeUserBalls();
            scoreBoard.compare(computerBalls, userBalls);
            GameDiplay.printResult(scoreBoard.getGameResult());
        }
    }
}
