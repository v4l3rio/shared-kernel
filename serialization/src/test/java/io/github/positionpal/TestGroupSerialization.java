package io.github.positionpal;

import com.positionpal.Group;
import com.positionpal.User;
import io.github.positionpal.AvroSerializer;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestGroupSerialization {

    @Test
    public void testGroupSerialization() {

        User user = User.newBuilder()
                .setId("random")
                .setEmail("random@email.it")
                .setName("Test")
                .setRole("user")
                .setSurname("User")
                .build();

        AvroSerializer serializer = new AvroSerializer();

        Group groupToSerialize = Group.newBuilder()
                .setId("groupId")
                .setName("testGroup")
                .setCreatedBy(user)
                .setMembers(List.of(user))
                .build();


        Group deserializedGroup = null;
        try {
            byte[] serializedGroup = serializer.serializeGroup(groupToSerialize);
            deserializedGroup = serializer.deserializeGroup(serializedGroup);
        } catch (IOException e) {
            fail();
        }

        assertEquals(groupToSerialize, deserializedGroup);
    }

}
