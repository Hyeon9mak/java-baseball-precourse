package baseball.service;

import baseball.domain.BaseBall;
import baseball.domain.BaseBallRepository;
import java.util.ArrayList;
import java.util.List;

public class ComputerService {

    private static final int THREE_BALL = 3;

    public static BaseBallRepository initComputerBalls() {
        return BaseBallRepository.newBaseBallRepository(initRandomBaseBalls());
    }

    private static List<BaseBall> initRandomBaseBalls() {
        List<BaseBall> baseBalls = new ArrayList<>();
        while (baseBalls.size() < THREE_BALL) {
            insertBaseBall(baseBalls, BaseBall.newRandomBaseBall());
        }
        return new ArrayList<>(baseBalls);
    }

    private static void insertBaseBall(List<BaseBall> baseBalls, BaseBall ball) {
        if (!baseBalls.stream().anyMatch(baseBall -> baseBall.getNumber() == ball.getNumber())) {
            baseBalls.add(ball);
        }
    }
}
