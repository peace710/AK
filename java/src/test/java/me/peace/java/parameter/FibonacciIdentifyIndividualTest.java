package me.peace.java.parameter;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

/**
 * Identify Individual test cases
 *
 * In order to easily identify the individual test cases in a Parameterized test, you may provide a name using the @Parameters annotation. This name is allowed to contain placeholders that are replaced at runtime:
 *
 * {index}: the current parameter index
 * {0}, {1}, …: the first, second, and so on, parameter value. NOTE: single quotes ' should be escaped as two single quotes ''.
 */
@RunWith(Parameterized.class)
public class FibonacciIdentifyIndividualTest {
    @Parameterized.Parameters(name = "{index}: fib({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 }
        });
    }

    private int fInput;

    private int fExpected;

    public FibonacciIdentifyIndividualTest(int fInput, int fExpected) {
        this.fInput = fInput;
        this.fExpected = fExpected;
    }

    @Test
    public void test(){
        Assert.assertEquals(fExpected, Fibonacci.compute(fInput));
    }
}
