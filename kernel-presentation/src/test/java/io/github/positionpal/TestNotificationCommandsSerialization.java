package io.github.positionpal;

import io.github.positionpal.commands.PushNotificationCommand;
import io.github.positionpal.entities.GroupId;
import io.github.positionpal.entities.NotificationMessage;
import io.github.positionpal.entities.UserId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestNotificationCommandsSerialization {

    private final AvroSerializer serializer = new AvroSerializer();

    @Test
    void testSerializeAndDeserializePushNotificationCommand() {
        final PushNotificationCommand originalCommand = PushNotificationCommand.of(
                GroupId.create("group123"),
                UserId.create("testUser"),
                NotificationMessage.create("A sample title", "A sample very very long message")
        );
        assertDoesNotThrow(() -> {
            final byte[] serializedData = serializer.serializePushNotificationCommand(originalCommand);
            final var deserializedCommand = serializer.deserializePushNotificationCommand(serializedData);
            assertEquals(originalCommand, deserializedCommand);
        });
    }
}
