package baseball.view;

import java.util.Scanner;

public class UserInput {

    private static final String REQUEST_INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String REQUEST_INPUT_CONTINUE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static String getInputNumbers() {
        System.out.print(REQUEST_INPUT_NUMBERS_MESSAGE);
        return scanner.nextLine();
    }

    public static String getInputContinue() {
        System.out.println(REQUEST_INPUT_CONTINUE_MESSAGE);
        return scanner.nextLine();
    }
}
