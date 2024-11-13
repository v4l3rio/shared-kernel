package io.github.positionpal;

/**
 * Interface representing an event where a group is deleted.
 */
public interface GroupDeleted {

    /**
     * Factory method to create an instance of GroupDeleted.
     *
     * @param groupId the ID of the group
     * @return a new instance of GroupDeleted
     */
    static GroupDeleted create(final String groupId) {
        return new GroupDeletedImpl(groupId);
    }

    /**
     * Gets the ID of the group.
     *
     * @return the group ID
     */
    String groupId();
}
