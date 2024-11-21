package io.github.positionpal.commands;

/**
 * A generic interface representing a command.
 */
public interface Command {

    /**
     * @return the type of the command.
     */
    CommandType type();
}
