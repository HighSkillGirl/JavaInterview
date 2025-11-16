package high.skill.girl.learns.algorithms.test.exception;

public class NotExpectedResultException extends RuntimeException {

    private final String algoName;
    private final int actual;
    private final int expected;

    public NotExpectedResultException(String algoName, int actual, int expected) {
        this.algoName = algoName;
        this.actual = actual;
        this.expected = expected;
    }

    @Override
    public String getMessage() {
        return String.format("Получен неожидаемый результат тестирования алгоритма %s: actual = %d, expected = %d", algoName, actual, expected);
    }
}
