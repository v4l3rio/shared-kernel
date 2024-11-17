package io.github.positionpal;

/**
 * Interface representing an event where a member is added to a group.
 */
public interface AddedMemberToGroup extends Event {

    /**
     * Factory method to create an instance of AddedMemberToGroup.
     *
     * @param groupId the ID of the group
     * @param addedMember the user who was added to the group
     * @return a new instance of AddedMemberToGroup
     */
    static AddedMemberToGroup create(final String groupId, final User addedMember) {
        return new AddedMemberToGroupImpl(groupId, addedMember);
    }

    /**
     * Gets the ID of the group.
     *
     * @return the group ID
     */
    String groupId();

    /**
     * Gets the user who was added to the group.
     *
     * @return the added member
     */
    User addedMember();
}
