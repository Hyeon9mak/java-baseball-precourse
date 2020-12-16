package baseball.domain;

import java.util.Set;

public class BaseBallRepository {

    private static final int BASEBALLS_SIZE = 3;

    private final Set<BaseBall> baseBalls;

    private BaseBallRepository(Set<BaseBall> baseBalls) {
        validateSize(baseBalls);
        this.baseBalls = baseBalls;
    }

    public static BaseBallRepository newBaseBallRepository(Set<BaseBall> baseBalls) {
        return new BaseBallRepository(baseBalls);
    }

    public Set<BaseBall> getBaseBalls(){
        return baseBalls;
    }

    private void validateSize(Set<BaseBall> baseBalls) {
        if (baseBalls.size() != BASEBALLS_SIZE) {
            throw new IllegalArgumentException("입력된 정수 값이 3개가 아니거나 중복된 정수가 존재합니다.");
        }
    }
}
