package io.github.positionpal;

import com.positionpal.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class TestUserSerialization {
    @Test
    public void testUserSerialization() {
        User toSerialize = User.newBuilder()
                .setId("random")
                .setEmail("random@email.it")
                .setPassword("password")
                .setName("Test")
                .setRole("user")
                .setSurname("User")
                .build();

        AvroSerializer serializer = new AvroSerializer();
        User deserializedObject = null;
        try {
            byte[] serializedObject = serializer.serializeUser(toSerialize);
            deserializedObject = serializer.deserializeUser(serializedObject);
        } catch (IOException e) {
            fail();
        }
        assertEquals(toSerialize, deserializedObject);
    }
}
