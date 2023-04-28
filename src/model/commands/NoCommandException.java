package src.model.commands;


public class NoCommandException extends Exception {
    public NoCommandException(String commandText) {
        super(String.format("'%s' команда не предуслрвленна", commandText));
    }
}
