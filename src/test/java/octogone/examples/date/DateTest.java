package octogone.examples.date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DateTest {
    @Test
    @DisplayName("Should test a local date time. (Classic assertion)")
    void shouldTestLocalDateTimeClassicAssertion() {
        var date = LocalDateTime.of(2025, 3, 28, 14, 30, 25);

        assertEquals(2025, date.getYear());
        assertEquals(3, date.getMonthValue());
        assertEquals(28, date.getDayOfMonth());
        assertEquals(14, date.getHour());
        assertEquals(30, date.getMinute());
        assertEquals(25, date.getSecond());
    }

    @Test
    @DisplayName("Should test a local date time. (AssertJ)")
    void shouldTestLocalDateTimeAssertJ() {
        var date = LocalDateTime.of(2025, 3, 28, 14, 30, 25);

        assertThat(date).hasYear(2025)
                .hasMonth(Month.MARCH)
                .hasDayOfMonth(28)
                .hasHour(14)
                .hasMinute(30)
                .hasSecond(25);
    }
}
