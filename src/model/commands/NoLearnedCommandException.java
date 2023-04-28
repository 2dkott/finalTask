package src.model.commands;


public class NoLearnedCommandException extends Exception {

    public NoLearnedCommandException(String commandText) {
        super(String.format("'%s' команда eще не выучена", commandText));
    }
}
