package io.github.positionpal;

/**
 * Interface representing an event where a member is removed from a group.
 */
public interface RemovedMemberToGroup {

    /**
     * Factory method to create an instance of RemovedMemberToGroup.
     *
     * @param groupId the ID of the group
     * @param removedMember the user who was removed from the group
     * @return a new instance of RemovedMemberToGroup
     */
    static RemovedMemberToGroup create(final String groupId, final User removedMember) {
        return new RemovedMemberToGroupImpl(groupId, removedMember);
    }

    /**
     * Gets the ID of the group.
     *
     * @return the group ID
     */
    String groupId();

    /**
     * Gets the user who was removed from the group.
     *
     * @return the removed user
     */
    User removedMember();
}
