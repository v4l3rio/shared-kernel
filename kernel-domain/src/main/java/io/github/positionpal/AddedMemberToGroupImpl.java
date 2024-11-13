package io.github.positionpal;

/**
 * Implementation of the AddedMemberToGroup interface.
 * This class represents an event where a member is added to a group.
 *
 * @param groupId the ID of the group
 * @param addedMember the user who was added to the group
 */
public record AddedMemberToGroupImpl(String groupId, User addedMember) implements AddedMemberToGroup { }
