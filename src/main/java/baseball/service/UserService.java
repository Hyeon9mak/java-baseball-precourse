package baseball.service;

import baseball.domain.BaseBall;
import baseball.domain.BaseBallRepository;
import baseball.view.UserInput;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private static final String COMMA = ",";

    public static BaseBallRepository makeUserBalls() {
        return BaseBallRepository
            .newBaseBallRepository(convertUserBalls(UserInput.getInputNumbers()));
    }

    private static List<BaseBall> convertUserBalls(String inputNumbers) {
        List<BaseBall> baseBalls = new ArrayList<>();
        for (String number : inputNumbers.split(COMMA)) {
            baseBalls.add(BaseBall.newUserBaseBall(number));
        }
        return baseBalls;
    }
}
