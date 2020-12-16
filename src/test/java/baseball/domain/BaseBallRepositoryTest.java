package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class BaseBallRepositoryTest {

    @Test
    public void testAddBall() {
        Set<BaseBall> computerBaseBalls = new HashSet<>();
        computerBaseBalls.add(BaseBall.newRandomBaseBall());
        computerBaseBalls.add(BaseBall.newRandomBaseBall());
        computerBaseBalls.add(BaseBall.newRandomBaseBall());
        BaseBallRepository repository = BaseBallRepository.newBaseBallRepository(computerBaseBalls);
        assertThat(repository.getBaseBalls().size()).isEqualTo(3);
    }

}
