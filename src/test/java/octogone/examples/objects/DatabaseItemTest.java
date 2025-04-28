package octogone.examples.objects;

import octogone.models.DatabaseItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DatabaseItemTest {
    @Test
    @DisplayName("Should compare two objects by values. (Classic assertion)")
    void testCompareObjectsClassicAssertion() {
        var uuid = UUID.randomUUID();
        var item1 = new DatabaseItem(uuid, "Test");
        var item2 = new DatabaseItem(uuid, "Test");

        assertEquals(item1.id(), item2.id());
        assertEquals(item1.name(), item2.name());
    }

    @Test
    @DisplayName("Should compare two objects by values. (AssertJ)")
    void testCompareObjectsAssertJ() {
        var uuid = UUID.randomUUID();
        var item1 = new DatabaseItem(uuid, "Test");
        var item2 = new DatabaseItem(uuid, "Test");

        assertThat(item1).usingRecursiveComparison().isEqualTo(item2);
    }

    @Test
    @DisplayName("Should compare two objects without a field. (Classic assertion)")
    void testCompareObjectsOmittingFieldClassicAssertion() {
        var item1 = new DatabaseItem(UUID.randomUUID(), "Test");
        var item2 = new DatabaseItem(UUID.randomUUID(), "Test");

        assertEquals(item1.name(), item2.name());
    }

    @Test
    @DisplayName("Should compare two objects without a field. (AssertJ)")
    void testCompareObjectsOmittingFieldAssertJ() {
        var item1 = new DatabaseItem(UUID.randomUUID(), "Test");
        var item2 = new DatabaseItem(UUID.randomUUID(), "Test");

        assertThat(item1).usingRecursiveComparison().ignoringFields("id").isEqualTo(item2);
    }

    @Test
    @DisplayName("Should compare two objects without a class of fields. (AssertJ)")
    void testCompareObjectsOmittingClassFieldAssertJ() {
        var item1 = new DatabaseItem(UUID.randomUUID(), "Test");
        var item2 = new DatabaseItem(UUID.randomUUID(), "Test");

        assertThat(item1).usingRecursiveComparison().ignoringFieldsOfTypes(UUID.class).isEqualTo(item2);
    }

    @Test
    @DisplayName("Should verify all fields are not null. (Classic assertion)")
    void testVerifyAllFieldsNotNullClassicAssertion() {
        var item = new DatabaseItem(UUID.randomUUID(), "Test");

        assertNotNull(item);
        assertNotNull(item.id());
        assertNotNull(item.name());
    }

    @Test
    @DisplayName("Should verify all fields are not null. (AssertJ)")
    void testVerifyAllFieldsNotNullAssertJ() {
        var item = new DatabaseItem(UUID.randomUUID(), "Test");

        assertThat(item).isNotNull()
                .usingRecursiveAssertion()
                .allFieldsSatisfy(Objects::nonNull);
    }
}
