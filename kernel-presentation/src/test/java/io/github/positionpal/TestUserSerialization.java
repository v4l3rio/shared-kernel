package io.github.positionpal;

import com.positionpal.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class TestUserSerialization {
    @Test
    void testUserSerialization() {
        final User toSerialize = User.newBuilder()
                .setId("random")
                .setEmail("random@email.it")
                .setName("Test")
                .setRole("user")
                .setSurname("User")
                .build();
        final AvroSerializer serializer = new AvroSerializer();
        User deserializedObject = null;
        try {
            final byte[] serializedObject = serializer.serializeUser(toSerialize);
            deserializedObject = serializer.deserializeUser(serializedObject);
        } catch (IOException e) {
            fail();
        }
        assertEquals(toSerialize, deserializedObject);
    }
}
