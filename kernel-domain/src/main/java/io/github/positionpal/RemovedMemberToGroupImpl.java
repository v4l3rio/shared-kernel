package io.github.positionpal;

/**
 * Implementation of the RemovedMemberToGroup interface.
 * This class represents an event where a member is removed from a group.
 *
 * @param groupId the ID of the group
 * @param removedMember the user who was removed from the group
 */
public record RemovedMemberToGroupImpl(String groupId, User removedMember) implements RemovedMemberToGroup { }
