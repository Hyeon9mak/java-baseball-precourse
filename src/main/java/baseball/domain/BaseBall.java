package baseball.domain;

import utils.RandomUtils;

public class BaseBall {

    private static final int MINIMUM_NUMBER_RANGE = 1;
    private static final int MAXIMUM_NUMBER_RANGE = 9;

    private final int number;

    private BaseBall(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    public static BaseBall newRandomBaseBall() {
        return new BaseBall(RandomUtils.nextInt(MINIMUM_NUMBER_RANGE, MAXIMUM_NUMBER_RANGE));
    }

    public static BaseBall newUserBaseBall(String inputNumber) {
        return new BaseBall(validateInteger(inputNumber));
    }

    public int getNumber() {
        return number;
    }

    private void validateNumberRange(int number) {
        if (number < MINIMUM_NUMBER_RANGE || MAXIMUM_NUMBER_RANGE < number) {
            throw new IllegalArgumentException("입력 가능한 정수 범위는 1~9 입니다.");
        }
    }

    private static int validateInteger(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수가 아닌 값이 입력 되었습니다.");
        }
    }
}
