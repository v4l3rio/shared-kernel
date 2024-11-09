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

public class TestGroupEventsSerialization {

    private AvroSerializer avroSerializer;
    private User testUser;

    @BeforeEach
    public void setUp() {
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
    public void testSerializeAndDeserializeAddedMemberToGroup() throws IOException {
        AddedMemberToGroup event = AddedMemberToGroup.newBuilder()
                .setGroupId("group123")
                .setAddedMember(testUser)
                .build();

        byte[] serializedData = avroSerializer.serializeAddedMemberToGroup(event);
        AddedMemberToGroup deserializedEvent = avroSerializer.deserializeAddedMemberToGroup(serializedData);

        assertEquals(event.getGroupId(), deserializedEvent.getGroupId());
        assertEquals(event.getAddedMember(), deserializedEvent.getAddedMember());
    }

    @Test
    public void testSerializeAndDeserializeRemovedMemberToGroup() throws IOException {
        RemovedMemberToGroup event = RemovedMemberToGroup.newBuilder()
                .setGroupId("group123")
                .setRemovedMember(testUser)
                .build();

        byte[] serializedData = avroSerializer.serializeRemovedMemberToGroup(event);
        RemovedMemberToGroup deserializedEvent = avroSerializer.deserializeRemovedMemberToGroup(serializedData);

        assertEquals(event.getGroupId(), deserializedEvent.getGroupId());
        assertEquals(event.getRemovedMember(), deserializedEvent.getRemovedMember());
    }

    @Test
    public void testSerializeAndDeserializeGroupCreated() throws IOException {
        GroupCreated event = GroupCreated.newBuilder()
                .setGroupId("group123")
                .setCreatedBy(testUser)
                .build();

        byte[] serializedData = avroSerializer.serializeGroupCreated(event);
        GroupCreated deserializedEvent = avroSerializer.deserializeGroupCreated(serializedData);

        assertEquals(event.getGroupId(), deserializedEvent.getGroupId());
        assertEquals(event.getCreatedBy(), deserializedEvent.getCreatedBy());
    }

    @Test
    public void testSerializeAndDeserializeGroupDeleted() throws IOException {
        GroupDeleted event = GroupDeleted.newBuilder()
                .setGroupId("group123")
                .build();

        byte[] serializedData = avroSerializer.serializeGroupDeleted(event);
        GroupDeleted deserializedEvent = avroSerializer.deserializeGroupDeleted(serializedData);

        assertEquals(event.getGroupId(), deserializedEvent.getGroupId());
    }
}