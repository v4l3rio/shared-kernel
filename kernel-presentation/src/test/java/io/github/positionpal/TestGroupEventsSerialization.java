package io.github.positionpal;

import com.positionpal.AddedMemberToGroup;
import com.positionpal.RemovedMemberToGroup;
import com.positionpal.GroupCreated;
import com.positionpal.GroupDeleted;
import com.positionpal.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestGroupEventsSerialization {

    private static final String GROUP_ID = "group123";

    private AvroSerializer avroSerializer;
    private User testUser;

    @BeforeEach
    void setUp() {
        avroSerializer = new AvroSerializer();
        testUser = User.newBuilder()
                .setId("randomId")
                .setEmail("random@email.it")
                .setName("Test")
                .setRole("user")
                .setSurname("User")
                .build();
    }

    @Test
    void testSerializeAndDeserializeAddedMemberToGroup() throws IOException {
        final AddedMemberToGroup event = AddedMemberToGroup.newBuilder()
                .setGroupId(GROUP_ID)
                .setAddedMember(testUser)
                .build();
        final byte[] serializedData = avroSerializer.serializeAddedMemberToGroup(event);
        final AddedMemberToGroup deserializedEvent = avroSerializer.deserializeAddedMemberToGroup(serializedData);
        assertEquals(event.getGroupId(), deserializedEvent.getGroupId());
        assertEquals(event.getAddedMember(), deserializedEvent.getAddedMember());
    }

    @Test
    void testSerializeAndDeserializeRemovedMemberToGroup() throws IOException {
        final RemovedMemberToGroup event = RemovedMemberToGroup.newBuilder()
                .setGroupId(GROUP_ID)
                .setRemovedMember(testUser)
                .build();
        final byte[] serializedData = avroSerializer.serializeRemovedMemberToGroup(event);
        final RemovedMemberToGroup deserializedEvent = avroSerializer.deserializeRemovedMemberToGroup(serializedData);
        assertEquals(event.getGroupId(), deserializedEvent.getGroupId());
        assertEquals(event.getRemovedMember(), deserializedEvent.getRemovedMember());
    }

    @Test
    void testSerializeAndDeserializeGroupCreated() throws IOException {
        final GroupCreated event = GroupCreated.newBuilder()
                .setGroupId(GROUP_ID)
                .setCreatedBy(testUser)
                .build();
        final byte[] serializedData = avroSerializer.serializeGroupCreated(event);
        final GroupCreated deserializedEvent = avroSerializer.deserializeGroupCreated(serializedData);
        assertEquals(event.getGroupId(), deserializedEvent.getGroupId());
        assertEquals(event.getCreatedBy(), deserializedEvent.getCreatedBy());
    }

    @Test
    void testSerializeAndDeserializeGroupDeleted() throws IOException {
        final GroupDeleted event = GroupDeleted.newBuilder()
                .setGroupId(GROUP_ID)
                .build();
        final byte[] serializedData = avroSerializer.serializeGroupDeleted(event);
        final GroupDeleted deserializedEvent = avroSerializer.deserializeGroupDeleted(serializedData);
        assertEquals(event.getGroupId(), deserializedEvent.getGroupId());
    }
}
