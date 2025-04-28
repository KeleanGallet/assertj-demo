package octogone.examples.soft;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SoftAssertionTest {
    @Test
    @DisplayName("Should softly assert values.")
    @Disabled // To remove before screenshot
    void testSoftAssertionClassicAssertion() {
        var softAssertions = new SoftAssertions();

        softAssertions.assertThat(1).isEqualTo(2);
        softAssertions.assertThat(1).isEqualTo(1);
        softAssertions.assertThat(1).isEqualTo(3);
        softAssertions.assertAll();
    }
}
