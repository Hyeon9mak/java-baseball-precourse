package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseBallRepository {

    private static final int BASEBALLS_SIZE = 3;

    private final List<BaseBall> baseBalls;

    private BaseBallRepository(List<BaseBall> baseBalls) {
        validateDuplicate(baseBalls);
        validateSize(baseBalls);
        this.baseBalls = baseBalls;
    }

    public static BaseBallRepository newBaseBallRepository(List<BaseBall> baseBalls) {
        return new BaseBallRepository(baseBalls);
    }

    public List<BaseBall> getBaseBalls() {
        return baseBalls;
    }

    private void validateDuplicate(List<BaseBall> baseBalls) {
        Set<Integer> setBaseBalls = new HashSet<>();
        baseBalls.stream().forEach(baseBall -> setBaseBalls.add(baseBall.getNumber()));
        if (baseBalls.size() != setBaseBalls.size()) {
            throw new IllegalArgumentException("중복된 정수가 존재합니다.");
        }
    }

    private void validateSize(List<BaseBall> baseBalls) {
        if (baseBalls.size() != BASEBALLS_SIZE) {
            throw new IllegalArgumentException("입력된 정수 값이 3개가 아닙니다.");
        }
    }
}
