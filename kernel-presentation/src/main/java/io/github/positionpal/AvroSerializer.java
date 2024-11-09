package io.github.positionpal;

import com.positionpal.*;
import org.apache.avro.Schema;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.io.DecoderFactory;

import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * A serializer class for serializing and deserializing User and Group events using Avro.
 */
public class AvroSerializer implements EventSerializer {

    private static final Schema USER_SCHEMA = User.getClassSchema();
    private static final Schema ADD_MEMBER_EVENT = AddedMemberToGroup.getClassSchema();
    private static final Schema REMOVE_MEMBER_EVENT = RemovedMemberToGroup.getClassSchema();
    private static final Schema GROUP_CREATED_EVENT = GroupCreated.getClassSchema();
    private static final Schema GROUP_DELETED_EVENT = GroupDeleted.getClassSchema();

    /**
     * Generic method to serialize an Avro object into a byte array.
     *
     * @param object the Avro object to serialize
     * @param schema the schema of the Avro object
     * @return a byte array representing the serialized object
     * @throws IOException if an I/O error occurs during serialization
     */
    private <T> byte[] serialize(T object, Schema schema) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Encoder encoder = EncoderFactory.get().binaryEncoder(outputStream, null);
        SpecificDatumWriter<T> writer = new SpecificDatumWriter<>(schema);
        writer.write(object, encoder);
        encoder.flush();
        return outputStream.toByteArray();
    }

    /**
     * Generic method to deserialize a byte array into an Avro object.
     *
     * @param data the byte array to deserialize
     * @param schema the schema of the Avro object
     * @return the deserialized Avro object
     * @throws IOException if an I/O error occurs during deserialization
     */
    private <T> T deserialize(byte[] data, Schema schema) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        Decoder decoder = DecoderFactory.get().binaryDecoder(inputStream, null);
        SpecificDatumReader<T> reader = new SpecificDatumReader<>(schema);
        return reader.read(null, decoder);
    }

    /**
     * Serializes a User object into a byte array using the Avro schema for User.
     *
     * @param user the User object to serialize
     * @return a byte array representing the serialized User object
     * @throws IOException if an I/O error occurs during serialization
     */
    @Override
    public byte[] serializeUser(User user) throws IOException {
        return serialize(user, USER_SCHEMA);
    }

    /**
     * Deserializes a byte array into a User object using the Avro schema for User.
     *
     * @param data the byte array to deserialize
     * @return the deserialized User object
     * @throws IOException if an I/O error occurs during deserialization
     */
    @Override
    public User deserializeUser(byte[] data) throws IOException {
        return deserialize(data, USER_SCHEMA);
    }

    /**
     * Serializes an AddedMemberToGroup event into a byte array using its Avro schema.
     *
     * @param event the AddedMemberToGroup event to serialize
     * @return a byte array representing the serialized AddedMemberToGroup event
     * @throws IOException if an I/O error occurs during serialization
     */
    @Override
    public byte[] serializeAddedMemberToGroup(AddedMemberToGroup event) throws IOException {
        return serialize(event, ADD_MEMBER_EVENT);
    }

    /**
     * Deserializes a byte array into an AddedMemberToGroup event object using its Avro schema.
     *
     * @param data the byte array to deserialize
     * @return the deserialized AddedMemberToGroup event
     * @throws IOException if an I/O error occurs during deserialization
     */
    @Override
    public AddedMemberToGroup deserializeAddedMemberToGroup(byte[] data) throws IOException {
        return deserialize(data, ADD_MEMBER_EVENT);
    }

    /**
     * Serializes a RemovedMemberToGroup event into a byte array using its Avro schema.
     *
     * @param event the RemovedMemberToGroup event to serialize
     * @return a byte array representing the serialized RemovedMemberToGroup event
     * @throws IOException if an I/O error occurs during serialization
     */
    @Override
    public byte[] serializeRemovedMemberToGroup(RemovedMemberToGroup event) throws IOException {
        return serialize(event, REMOVE_MEMBER_EVENT);
    }

    /**
     * Deserializes a byte array into a RemovedMemberToGroup event object using its Avro schema.
     *
     * @param data the byte array to deserialize
     * @return the deserialized RemovedMemberToGroup event
     * @throws IOException if an I/O error occurs during deserialization
     */
    @Override
    public RemovedMemberToGroup deserializeRemovedMemberToGroup(byte[] data) throws IOException {
        return deserialize(data, REMOVE_MEMBER_EVENT);
    }

    /**
     * Serializes a GroupCreated event into a byte array using its Avro schema.
     *
     * @param event the GroupCreated event to serialize
     * @return a byte array representing the serialized GroupCreated event
     * @throws IOException if an I/O error occurs during serialization
     */
    @Override
    public byte[] serializeGroupCreated(GroupCreated event) throws IOException {
        return serialize(event, GROUP_CREATED_EVENT);
    }

    /**
     * Deserializes a byte array into a GroupCreated event object using its Avro schema.
     *
     * @param data the byte array to deserialize
     * @return the deserialized GroupCreated event
     * @throws IOException if an I/O error occurs during deserialization
     */
    @Override
    public GroupCreated deserializeGroupCreated(byte[] data) throws IOException {
        return deserialize(data, GROUP_CREATED_EVENT);
    }

    /**
     * Serializes a GroupDeleted event into a byte array using its Avro schema.
     *
     * @param event the GroupDeleted event to serialize
     * @return a byte array representing the serialized GroupDeleted event
     * @throws IOException if an I/O error occurs during serialization
     */
    @Override
    public byte[] serializeGroupDeleted(GroupDeleted event) throws IOException {
        return serialize(event, GROUP_DELETED_EVENT);
    }

    /**
     * Deserializes a byte array into a GroupDeleted event object using its Avro schema.
     *
     * @param data the byte array to deserialize
     * @return the deserialized GroupDeleted event
     * @throws IOException if an I/O error occurs during deserialization
     */
    @Override
    public GroupDeleted deserializeGroupDeleted(byte[] data) throws IOException {
        return deserialize(data, GROUP_DELETED_EVENT);
    }
}
