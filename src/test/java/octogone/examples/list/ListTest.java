package octogone.examples.list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ListTest {
    @Test
    @DisplayName("Should compare two lists. (Classic assertion)")
    void testCompareListClassicAssertion() {
        var list1 = java.util.List.of(1, 2, 3);
        var list2 = java.util.List.of(1, 2, 3);

        assertEquals(list1, list2);
    }

    @Test
    @DisplayName("Should compare two lists. (AssertJ)")
    void testCompareListAssertJ() {
        var list1 = java.util.List.of(1, 2, 3);
        var list2 = java.util.List.of(1, 2, 3);

        assertThat(list1).isEqualTo(list2);
    }

    @Test
    @DisplayName("Should compare two int lists with any order. (Classic assertion)")
    void testCompareListWithAnyOrderClassicAssertion() {
        var list1 = java.util.List.of(1, 2, 3);
        var list2 = java.util.List.of(3, 2, 1);

        assertEquals(list1.stream().sorted().toList(), list2.stream().sorted().toList());
    }

    @Test
    @DisplayName("Should compare two lists with any order. (Classic assertion)")
    void testCompareListWithAnyOrderNotIntClassicAssertion() {
        var list1 = java.util.List.of("World", "Hello", "Test");
        var list2 = java.util.List.of("Test", "Hello", "World");

        assertEquals(list1.size(), list2.size());
        var copy = new ArrayList<>(List.copyOf(list2));
        for (var value : list1) {
            assertTrue(copy.contains(value));
            assertTrue(copy.remove(value));
        }
    }

    @Test
    @DisplayName("Should compare two lists with any order. (AssertJ)")
    void testCompareListWithAnyOrderAssertJ() {
        var list1 = java.util.List.of("World", "Hello", "Test");
        var list2 = java.util.List.of("Test", "Hello", "World");

        assertThat(list1).containsExactlyInAnyOrderElementsOf(list2);
    }

    @Test
    @DisplayName("Should verify every element of a list is positive. (Classic assertion)")
    void testAssertEveryElementClassicAssertion() {
        var list = java.util.List.of(1, 2, 3);

        assertFalse(list.isEmpty());
        for (var value : list) {
            assertTrue(value > 0);
        }
    }

    @Test
    @DisplayName("Should verify every element of a list is positive. (AssertJ)")
    void testAssertEveryElementAssertJ() {
        var list = java.util.List.of(1, 2, 3);

        assertThat(list).isNotEmpty()
                .allMatch(value -> value > 0);
    }
}
