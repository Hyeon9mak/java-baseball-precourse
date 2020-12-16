package baseball.service;

import baseball.domain.BaseBall;
import baseball.domain.BaseBallRepository;
import baseball.view.UserInput;
import java.util.HashSet;
import java.util.Set;

public class UserService {

    private static final String COMMA = ",";

    public static BaseBallRepository makeUserBalls() {
        return BaseBallRepository.newBaseBallRepository(convertUserBalls(UserInput.getInputNumbers()));
    }

    private static Set<BaseBall> convertUserBalls(String inputNumbers) {
        Set<BaseBall> baseBalls = new HashSet<>();
        for(String number : inputNumbers.split(COMMA)){
            baseBalls.add(BaseBall.newUserBaseBall(number));
        }
        return baseBalls;
    }
}
