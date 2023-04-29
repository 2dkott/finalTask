package src.persistance;

public class CommandIsNotLearned extends Exception{
    public CommandIsNotLearned(String command) {
        super(String.format("Питомец не знает этой команды '%s'", command));
    }
}
