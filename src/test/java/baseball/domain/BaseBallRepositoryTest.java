package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.service.ComputerService;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class BaseBallRepositoryTest {

    @Test
    public void testAddBall() {
        Set<BaseBall> computerBaseBalls = new HashSet<>();
        BaseBallRepository repository = ComputerService.initComputerBalls();
        assertThat(repository.getBaseBalls().size()).isEqualTo(3);
    }

}
