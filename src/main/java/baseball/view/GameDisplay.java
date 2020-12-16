package baseball.view;

public class GameDisplay {

    private static final String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printResult(String result) {
        System.out.println(result);
    }

    public static void printGameOver() {
        System.out.println(GAME_OVER_MESSAGE);
    }
}
