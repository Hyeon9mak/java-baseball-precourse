package baseball;

import baseball.domain.BaseBallRepository;
import baseball.domain.ScoreBoard;
import baseball.service.ComputerService;
import baseball.service.UserService;
import baseball.view.GameDisplay;
import baseball.view.UserInput;

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
            gameKey = getGameContinue();
        }
    }

    private String getGameContinue() {
        String gameContinue = UserInput.getInputContinue();
        validateGameContinue(gameContinue);
        return gameContinue;
    }

    private void validateGameContinue(String gameContinue) {
        if (!gameContinue.equals(GAME_CONTINUE) && gameContinue.equals(GAME_END)) {
            throw new IllegalArgumentException("\"1\" 또는 \"2\" 만 입력 할 수 있습니다.");
        }
    }

    private void runningGame() {
        ScoreBoard scoreBoard = ScoreBoard.newScoreBoard();
        BaseBallRepository computerBalls = ComputerService.initComputerBalls();
        while (!scoreBoard.isThreeStrike()) {
            BaseBallRepository userBalls = UserService.makeUserBalls();
            scoreBoard.compare(computerBalls, userBalls);
            GameDisplay.printResult(scoreBoard.getGameResult());
        }
        GameDisplay.printGameOver();
    }
}
