package io.github.positionpal.entities;

/**
 * A value object representing a group identifier.
 */
public interface GroupId {

    /**
     * @return the value of the group identifier.
     */
    String value();

    /**
     * Factory method to create an instance of GroupId.
     * @param value the value of the group identifier
     * @return a new instance of GroupId
     */
    static GroupId create(final String value) {
        return new GroupIdImpl(value);
    }
}
