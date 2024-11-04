package io.github.positionpal;

import com.positionpal.Group;
import com.positionpal.User;
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
 * A serializer class for serializing and deserializing User and Group objects using Avro.
 */
public class AvroSerializer {

    private static final Schema USER_SCHEMA = User.getClassSchema();
    private static final Schema GROUP_SCHEMA = Group.getClassSchema();

    /**
     * Serializes a User object into a byte array.
     *
     * @param user the User object to serialize
     * @return a byte array representing the serialized User
     * @throws IOException if an I/O error occurs during serialization
     */
    public byte[] serializeUser(User user) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Encoder encoder = EncoderFactory.get().binaryEncoder(outputStream, null);
        SpecificDatumWriter<User> writer = new SpecificDatumWriter<>(USER_SCHEMA);
        writer.write(user, encoder);
        encoder.flush();
        return outputStream.toByteArray();
    }

    /**
     * Serializes a Group object into a byte array.
     *
     * @param group the Group object to serialize
     * @return a byte array representing the serialized Group
     * @throws IOException if an I/O error occurs during serialization
     */
    public byte[] serializeGroup(Group group) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Encoder encoder = EncoderFactory.get().binaryEncoder(outputStream, null);
        SpecificDatumWriter<Group> writer = new SpecificDatumWriter<>(GROUP_SCHEMA);
        writer.write(group, encoder);
        encoder.flush();
        return outputStream.toByteArray();
    }

    /**
     * Deserializes a byte array into a User object.
     *
     * @param data the byte array to deserialize
     * @return the deserialized User object
     * @throws IOException if an I/O error occurs during deserialization
     */
    public User deserializeUser(byte[] data) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        Decoder decoder = DecoderFactory.get().binaryDecoder(inputStream, null);
        SpecificDatumReader<User> reader = new SpecificDatumReader<>(USER_SCHEMA);
        return reader.read(null, decoder);
    }

    /**
     * Deserializes a byte array into a Group object.
     *
     * @param data the byte array to deserialize
     * @return the deserialized Group object
     * @throws IOException if an I/O error occurs during deserialization
     */
    public Group deserializeGroup(byte[] data) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        Decoder decoder = DecoderFactory.get().binaryDecoder(inputStream, null);
        SpecificDatumReader<Group> reader = new SpecificDatumReader<>(GROUP_SCHEMA);
        return reader.read(null, decoder);
    }
}
