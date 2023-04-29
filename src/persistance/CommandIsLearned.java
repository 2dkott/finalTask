package src.persistance;

public class CommandIsLearned extends Exception{
    public CommandIsLearned(String command) {
        super(String.format("Питомец уже знает эту команду '%s'", command));
    }
}
