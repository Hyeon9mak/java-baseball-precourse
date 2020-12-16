package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.service.ComputerService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ScoreBoardTest {

    @Test
    public void testCreate() {
        ScoreBoard scoreBoard = ScoreBoard.newScoreBoard();
        List<BaseBall> userBaseBalls = new ArrayList<>();
        userBaseBalls.add(BaseBall.newUserBaseBall("1"));
        userBaseBalls.add(BaseBall.newUserBaseBall("2"));
        userBaseBalls.add(BaseBall.newUserBaseBall("3"));
        scoreBoard.compare(ComputerService.initComputerBalls(),
            BaseBallRepository.newBaseBallRepository(userBaseBalls));
        assertThat(scoreBoard.getGameResult()).isNotNull();
        assertThat(scoreBoard.getGameResult()).isNotNull();
    }

}
