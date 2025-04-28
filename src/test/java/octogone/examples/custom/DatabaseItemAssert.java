package octogone.examples.custom;

import octogone.models.DatabaseItem;
import org.assertj.core.api.AbstractAssert;

import java.util.UUID;

public class DatabaseItemAssert extends AbstractAssert<DatabaseItemAssert, DatabaseItem> {
        public DatabaseItemAssert(DatabaseItem actual) {
            super(actual, DatabaseItemAssert.class);
        }

        public static DatabaseItemAssert assertThat(DatabaseItem actual) {
            return new DatabaseItemAssert(actual);
        }

        public DatabaseItemAssert hasId(UUID expectedId) {
            isNotNull();

            if (!actual.id().equals(expectedId)) {
                failWithMessage("Expected DatabaseItem's name to be <%s> but was <%s>", expectedId, actual.id());
            }

            return this;
        }

        public DatabaseItemAssert hasName(String expectedName) {
            isNotNull();

            if (!actual.name().equals(expectedName)) {
                failWithMessage("Expected DatabaseItem's name to be <%s> but was <%s>", expectedName, actual.name());
            }

            return this;
        }
}
