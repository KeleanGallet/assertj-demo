package octogone.examples.custom;

import octogone.models.DatabaseItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static octogone.examples.custom.DatabaseItemAssert.assertThat;

class CustomAssertionTest {
    @Test
    @DisplayName("Should compare objects using custom AssertJ assertion.")
    void testCustomAssertion() {
        var uuid = UUID.randomUUID();
        var name = "Hello, World!";
        var item = new DatabaseItem(uuid, name);

        assertThat(item).hasId(uuid)
                .hasName(name);
    }
}
