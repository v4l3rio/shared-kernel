package io.github.positionpal;

/**
 * Represents a message with a specific type and associated data.
 */
public class Message {
    private final MessageType type;
    private final byte[] data;

    /**
     * Constructs a new Message with the specified type and data.
     *
     * @param type the type of the message
     * @param data the data of the message
     */
    public Message(MessageType type, byte[] data) {
        this.type = type;
        this.data = data;
    }

    /**
     * Returns the type of the message.
     *
     * @return the type of the message
     */
    public MessageType getType() {
        return type;
    }

    /**
     * Returns the data of the message.
     *
     * @return the data of the message
     */
    public byte[] getData() {
        return data;
    }
}