package io.github.positionpal;

import com.positionpal.GroupCreated;
import com.positionpal.GroupDeleted;
import com.positionpal.User;
import com.positionpal.AddedMemberToGroup;
import com.positionpal.RemovedMemberToGroup;

import java.io.IOException;

/**
 * Interface for serializing and deserializing User and Group-related events using Avro.
 * Provides methods to convert User, Group, and Group-related event objects
 * (e.g., adding/removing members, creating/deleting groups) to byte arrays and back.
 * Implementations of this interface allow for efficient, binary serialization for transport or storage.
 */
public interface EventSerializer {

    /**
     * Serializes a User object into a byte array.
     *
     * @param user the User object to serialize
     * @return a byte array representing the serialized User object
     * @throws IOException if an I/O error occurs during serialization
     */
    byte[] serializeUser(User user) throws IOException;

    /**
     * Deserializes a byte array into a User object.
     *
     * @param data the byte array to deserialize
     * @return the deserialized User object
     * @throws IOException if an I/O error occurs during deserialization
     */
    User deserializeUser(byte[] data) throws IOException;

    /**
     * Serializes an AddedMemberToGroup event object into a byte array.
     *
     * @param event the AddedMemberToGroup event object to serialize
     * @return a byte array representing the serialized AddedMemberToGroup event
     * @throws IOException if an I/O error occurs during serialization
     */
    byte[] serializeAddedMemberToGroup(AddedMemberToGroup event) throws IOException;

    /**
     * Deserializes a byte array into an AddedMemberToGroup event object.
     *
     * @param data the byte array to deserialize
     * @return the deserialized AddedMemberToGroup event object
     * @throws IOException if an I/O error occurs during deserialization
     */
    AddedMemberToGroup deserializeAddedMemberToGroup(byte[] data) throws IOException;

    /**
     * Serializes a RemovedMemberToGroup event object into a byte array.
     *
     * @param event the RemovedMemberToGroup event object to serialize
     * @return a byte array representing the serialized RemovedMemberToGroup event
     * @throws IOException if an I/O error occurs during serialization
     */
    byte[] serializeRemovedMemberToGroup(RemovedMemberToGroup event) throws IOException;

    /**
     * Deserializes a byte array into a RemovedMemberToGroup event object.
     *
     * @param data the byte array to deserialize
     * @return the deserialized RemovedMemberToGroup event object
     * @throws IOException if an I/O error occurs during deserialization
     */
    RemovedMemberToGroup deserializeRemovedMemberToGroup(byte[] data) throws IOException;

    /**
     * Serializes a GroupCreated event object into a byte array.
     *
     * @param event the GroupCreated event object to serialize
     * @return a byte array representing the serialized GroupCreated event
     * @throws IOException if an I/O error occurs during serialization
     */
    byte[] serializeGroupCreated(GroupCreated event) throws IOException;

    /**
     * Deserializes a byte array into a GroupCreated event object.
     *
     * @param data the byte array to deserialize
     * @return the deserialized GroupCreated event object
     * @throws IOException if an I/O error occurs during deserialization
     */
    GroupCreated deserializeGroupCreated(byte[] data) throws IOException;

    /**
     * Serializes a GroupDeleted event object into a byte array.
     *
     * @param event the GroupDeleted event object to serialize
     * @return a byte array representing the serialized GroupDeleted event
     * @throws IOException if an I/O error occurs during serialization
     */
    byte[] serializeGroupDeleted(GroupDeleted event) throws IOException;

    /**
     * Deserializes a byte array into a GroupDeleted event object.
     *
     * @param data the byte array to deserialize
     * @return the deserialized GroupDeleted event object
     * @throws IOException if an I/O error occurs during deserialization
     */
    GroupDeleted deserializeGroupDeleted(byte[] data) throws IOException;
}
