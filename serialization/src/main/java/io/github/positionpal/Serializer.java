package io.github.positionpal;

import com.positionpal.Group;
import com.positionpal.User;

import java.io.IOException;

/**
 * Interface for serializing and deserializing User and Group objects.
 */
public interface Serializer {

    /**
     * Serializes a User object into a byte array.
     *
     * @param user the User object to serialize
     * @return a byte array representing the serialized User
     * @throws IOException if an I/O error occurs during serialization
     */
    byte[] serializeUser(User user) throws IOException;

    /**
     * Serializes a Group object into a byte array.
     *
     * @param group the Group object to serialize
     * @return a byte array representing the serialized Group
     * @throws IOException if an I/O error occurs during serialization
     */
    byte[] serializeGroup(Group group) throws IOException;

    /**
     * Deserializes a byte array into a User object.
     *
     * @param data the byte array to deserialize
     * @return the deserialized User object
     * @throws IOException if an I/O error occurs during deserialization
     */
    User deserializeUser(byte[] data) throws IOException;

    /**
     * Deserializes a byte array into a Group object.
     *
     * @param data the byte array to deserialize
     * @return the deserialized Group object
     * @throws IOException if an I/O error occurs during deserialization
     */
    Group deserializeGroup(byte[] data) throws IOException;
}
