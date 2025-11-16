package high.skill.girl.learns.algorithms.test.tasks;

import high.skill.girl.learns.algorithms.tasks.StonesAndJewelryYandex;
import high.skill.girl.learns.algorithms.test.exception.NotExpectedResultException;

import java.io.*;

public class StonesAndJewelryYandexTest {

    private static final TestCaseModel[] testCases = new TestCaseModel[]
            {
                new TestCaseModel("a", "a", 1),
                new TestCaseModel("a", "A", 0),
                new TestCaseModel("ab", "ac", 1),
                new TestCaseModel("ab", "abc", 2),
                new TestCaseModel("a", "a0", 1),
                new TestCaseModel("a", "-a", 1)
            };

    public static void main(String[] args) throws IOException {

        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        try {
            for (int i = 0; i < testCases.length; i++) {
                TestCaseModel testCase = getTestCaseByIndex(i);
                String testInput = testCase.comparedString[0] + "\n" + testCase.comparedString[1] + "\n";
                ByteArrayInputStream testIn = new ByteArrayInputStream(testInput.getBytes());
                System.setIn(testIn);

                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                PrintStream testOut = new PrintStream(outputStream);
                System.setOut(testOut);

                StonesAndJewelryYandex.main(new String[]{});
                String output = outputStream.toString().trim();
                int actual = Integer.parseInt(output);

                System.setIn(originalIn);
                System.setOut(originalOut);

                if (actual != testCase.expectedResult) {
                    throw new NotExpectedResultException(StonesAndJewelryYandex.class.getSimpleName(), actual, testCase.expectedResult);
                }
            }
        } catch (NotExpectedResultException e) {
            System.out.println(e.getMessage());
        }

    }

    private static TestCaseModel getTestCaseByIndex(int index) {
        return testCases[index];
    }

    private static class TestCaseModel {
        String[] comparedString;
        int expectedResult;

        public TestCaseModel(String jewelry, String stones, int expectedResult) {
            this.comparedString = new String[]{jewelry, stones};
            this.expectedResult = expectedResult;
        }
    }
}