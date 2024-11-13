package io.github.positionpal;

/**
 * Interface representing an event where a group is created.
 */
public interface GroupCreated {

    /**
     * Factory method to create an instance of GroupCreated.
     *
     * @param groupId the ID of the group
     * @param createdBy the user who created the group
     * @return a new instance of GroupCreated
     */
    static GroupCreated create(final String groupId, final User createdBy) {
        return new GroupCreatedImpl(groupId, createdBy);
    }

    /**
     * Gets the ID of the group.
     *
     * @return the group ID
     */
    String groupId();

    /**
     * Gets the user who created the group.
     *
     * @return the user who created the group
     */
    User createdBy();
}
