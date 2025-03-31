package octogone.examples.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    @DisplayName("Should return the sum of two numbers. (Classic assertion)")
    void testAddWithClassicAssertion() {
        var expected = 2;
        var actual = 1 + 1;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should return the sum of two numbers. (AssertJ)")
    void testAddWithAssertJ() {
        var expected = 2;
        var actual = 1 + 1;

        assertThat(actual).isEqualTo(expected);
    }
}