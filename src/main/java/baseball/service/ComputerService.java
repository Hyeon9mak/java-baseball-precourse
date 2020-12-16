package baseball.service;

import baseball.domain.BaseBall;
import baseball.domain.BaseBallRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComputerService {

    private static final int THREE_BALL = 3;

    public static BaseBallRepository initComputerBalls() {
        return BaseBallRepository.newBaseBallRepository(initRandomBaseBalls());
    }

    private static List<BaseBall> initRandomBaseBalls() {
        Set<BaseBall> baseBalls = new HashSet<>();
        while (baseBalls.size() < THREE_BALL) {
            baseBalls.add(BaseBall.newRandomBaseBall());
        }
        return new ArrayList<>(baseBalls);
    }
}
