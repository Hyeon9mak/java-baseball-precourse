package baseball.domain;

public class ScoreBoard {

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String WHITE_SPACE = " ";
    private static final int EMPTY = 0;
    private static final int INITIAL = 0;
    private static final int THREE_STRIKE = 3;
    private static final int COUNT_OF_BALLS = 3;
    private int ball = 0;
    private int strike = 0;

    private ScoreBoard() {
    }

    public static ScoreBoard newScoreBoard() {
        return new ScoreBoard();
    }

    public boolean isThreeStrike() {
        return strike == THREE_STRIKE;
    }

    public void compare(BaseBallRepository computerBalls, BaseBallRepository userBalls) {
        initialStrikeBall();
        for (int i = 0; i < COUNT_OF_BALLS; i++) {
            updateScoreBoard(computerBalls, computerBalls.getBaseBalls().get(i),
                userBalls.getBaseBalls().get(i));
        }
    }

    public String getGameResult() {
        StringBuilder stringBuilder = new StringBuilder();
        makeBallResult(stringBuilder);
        makeStrikeResult(stringBuilder);
        if (stringBuilder.length() == EMPTY) {
            stringBuilder.append(NOTHING);
        }
        return stringBuilder.toString();
    }

    private void updateScoreBoard(BaseBallRepository computerBalls, BaseBall computerBall,
        BaseBall userBall) {
        if (isStrike(computerBall, userBall)) {
            strike++;
            return;
        }
        if (isBall(computerBalls, userBall)) {
            ball++;
        }
    }

    private void initialStrikeBall() {
        strike = INITIAL;
        ball = INITIAL;
    }

    private boolean isStrike(BaseBall computerBall, BaseBall userBall) {
        return computerBall.getNumber() == userBall.getNumber();
    }

    private boolean isBall(BaseBallRepository computerBalls, BaseBall baseBall) {
        return computerBalls.getBaseBalls().stream()
            .anyMatch(computerball -> computerball.getNumber() == baseBall.getNumber());
    }

    private void makeBallResult(StringBuilder stringBuilder) {
        if (ball > 0) {
            stringBuilder.append(ball);
            stringBuilder.append(BALL);
            stringBuilder.append(WHITE_SPACE);
        }
    }

    private void makeStrikeResult(StringBuilder stringBuilder) {
        if (strike > 0) {
            stringBuilder.append(strike);
            stringBuilder.append(STRIKE);
        }
    }
}
